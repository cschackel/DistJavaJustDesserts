package JustDessert.DAO;

import JustDessert.entity.Dessert;

import java.util.Collection;

public interface IDessertDAO {
    Collection<Dessert> getDesserts();

    void addDessert(Dessert newDessert);

    Dessert getDessertByID(int ID);

    Dessert getDessertByIDEager(int id);
}
