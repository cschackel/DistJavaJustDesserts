package JustDessert.Service;

import JustDessert.DAO.IDessertDAO;
import JustDessert.entity.Dessert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Collection;
@Service
public class DessertService implements IDessertService {


    @Autowired
    private IDessertDAO dessertDAO;

    @Autowired
    private IImageFileService imageFileService;

    @Transactional
    @Override
    public Collection<Dessert> getDesserts() {
        return dessertDAO.getDesserts();
    }

    @Transactional
    @Override
    public void addDessert(Dessert newDessert, MultipartFile file, String applicationPath) {
        if(file==null)
        {
            newDessert.setImageName(newDessert.getCategory().getImageName());
        }
        else
        {
            String filename = imageFileService.saveFile(
                    file,
                    applicationPath);

            if (filename != null) {
                newDessert.setImageName(filename);
            }
            else
            {
                newDessert.setImageName(newDessert.getCategory().getImageName());
            }
        }
        dessertDAO.addDessert(newDessert);
    }

    @Transactional
    @Override
    public Dessert getDessertByID(int ID) {
        return dessertDAO.getDessertByID(ID);
    }

    @Transactional
    @Override
    public Dessert getDessertByIDEager(int ID) {
        return dessertDAO.getDessertByIDEager(ID);
    }

    @Override
    @Transactional
    public Collection<Dessert> getDessertsByName(String s) {
        return dessertDAO.getDessertsByName(s);
    }
}
