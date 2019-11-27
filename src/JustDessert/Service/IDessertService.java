package JustDessert.Service;

import JustDessert.entity.Dessert;

import java.util.Collection;

public interface IDessertService {
    Collection<Dessert> getDesserts();

    void addDessert(Dessert newDessert);

    Dessert getDessertByID(int ID);

    Dessert getDessertByIDEager(int ID);
}
