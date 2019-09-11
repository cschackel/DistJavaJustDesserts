import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ListServlet",
urlPatterns = "/list")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;



        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String path = getServletContext().getRealPath(DatabaseUtils.DATABASE_PATH);


            conn = DriverManager.getConnection(DatabaseUtils.DRIVER_NAME+path,DatabaseUtils.USERNAME,DatabaseUtils.PASSWORD);

            stmt = conn.createStatement();

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT CategoryName FROM Categories ").append("order by CategoryName");

            rset = stmt.executeQuery(sql.toString());

            StringBuilder output = new StringBuilder();

            output.append("<html><body>Categories:<ul>");

            while(rset.next())
            {
                output.append("<li>");
                output.append(rset.getString(1));
                output.append("</li>");
            }

            output.append("</ul></body></html>");

            response.getWriter().print(output.toString());
        }
        catch(SQLException | ClassNotFoundException ex)
        {
            response.getWriter().print(ex.getMessage());

        }
        finally {
            DatabaseUtils.closeAll(conn,stmt,rset);
        }
    }
}
