package springxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springxml.beans.Category;

public class SpringApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("logEx3.xml");

        Category cat1 = context.getBean("categoryBean",Category.class);

        cat1.logInfo("Info Alert");
        cat1.logWarning("Warning Alert");
        cat1.logError("Error Alert");
    }
}
