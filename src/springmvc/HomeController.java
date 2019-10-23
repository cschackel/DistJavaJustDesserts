package springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller
public class HomeController {




    @RequestMapping("/")
    public String homePage()
    {
        return "index";
    }

    @RequestMapping("/displayCategory/{catID}")
    public String goToCat(@PathVariable String catID)
    {
        System.out.println(catID);
        return "index";
    }


}
