package plant.flashcards.ui;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {

    @GetMapping("/home")
    public String home(@RequestParam(value="name", required=false, defaultValue="Friend") String name, Model model) {
        model.addAttribute("name", name);
        return "home" ;
    }

}
