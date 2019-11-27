package JustDessert.Service;

import JustDessert.DAO.IDessertDAO;
import JustDessert.entity.Dessert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
@Service
public class DessertService implements IDessertService {


    @Autowired
    private IDessertDAO dessertDAO;

    @Transactional
    @Override
    public Collection<Dessert> getDesserts() {
        return dessertDAO.getDesserts();
    }

    @Transactional
    @Override
    public void addDessert(Dessert newDessert) {
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
}
