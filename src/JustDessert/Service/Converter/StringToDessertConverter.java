package JustDessert.Service.Converter;

import JustDessert.Service.IDessertService;
import JustDessert.entity.Dessert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToDessertConverter implements Converter<String, Dessert> {
    @Autowired
    IDessertService dessertService;



    @Override
    public Dessert convert(String s) {
        try
        {
            int id = Integer.parseInt(s);
            Dessert fetchedDessert = dessertService.getDessertByID(id);
            return fetchedDessert;
        } catch (NumberFormatException e) {
            return  null;
        }
    }
}
