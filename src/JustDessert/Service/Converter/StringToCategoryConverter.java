package JustDessert.Service.Converter;

import JustDessert.Service.ICategoryService;
import JustDessert.Service.IDessertService;
import JustDessert.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToCategoryConverter implements Converter<String, Category> {
    @Autowired
    ICategoryService categoryService;


    @Override
    public Category convert(String s) {
        try
        {
            int i = Integer.parseInt(s);
            return categoryService.getCategoryByID(i);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
