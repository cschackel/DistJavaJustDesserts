import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "SearchServlet",
urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;



        try
        {
            String searchterm = request.getParameter("searchTerm");

            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String path = getServletContext().getRealPath(DatabaseUtils.DATABASE_PATH);


            conn = DriverManager.getConnection(DatabaseUtils.DRIVER_NAME+path,DatabaseUtils.USERNAME,DatabaseUtils.PASSWORD);


            StringBuilder sql = new StringBuilder();

            sql.append("select DessertID, DessertName, categoryID, Description, Rating, DiscerningFeatures from Desserts where LOWER(DessertName) like ?");

            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1,"%"+searchterm.toLowerCase()+"%");

            rset = pstmt.executeQuery();

            StringBuilder output = new StringBuilder();

            output.append("<html><body>");

            while(rset.next())
            {
                output.append("<ul>");

                output.append("<li>ID: ");
                output.append(rset.getInt("DessertID"));
                output.append("</li>");

                output.append("<li>Name: ");
                output.append(rset.getString("DessertName"));
                output.append("</li>");

                output.append("<li>Description: ");
                output.append(rset.getString("Description"));
                output.append("</li>");

                output.append("<li>Discerning Features: ");
                output.append(rset.getString("DiscerningFeatures"));
                output.append("</li>");

                output.append("<li>Category ID: ");
                output.append(rset.getInt("CategoryID"));
                output.append("</li>");

                output.append("<li>Rating: ");
                output.append(rset.getFloat("Rating"));
                output.append("</li>");

                output.append("</ul>");
            }

            output.append("</body></html>");

            response.getWriter().print(output.toString());
        }
        catch(SQLException | ClassNotFoundException ex)
        {
            response.getWriter().print(ex.getMessage() + ex.getStackTrace());

        }
        finally {
            DatabaseUtils.closeAll(conn,pstmt,rset);
        }
    }
}
