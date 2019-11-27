package springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {




    @RequestMapping("/")
    public String homePage()
    {
        return "home/index";
    }

    @RequestMapping("/displayCategory/{catID}")
    public String goToCat(@PathVariable String catID)
    {
        System.out.println(catID);
        return "home/index";
    }


}
