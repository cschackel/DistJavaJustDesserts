package JustDessert.Service;

import JustDessert.entity.Dessert;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

public interface IDessertService {
    Collection<Dessert> getDesserts();

    void addDessert(Dessert newDessert, MultipartFile file, String applicationPath);

    Dessert getDessertByID(int ID);

    Dessert getDessertByIDEager(int ID);

    Collection<Dessert> getDessertsByName(String s);

    void deleteDessertByID(int ID);
}
