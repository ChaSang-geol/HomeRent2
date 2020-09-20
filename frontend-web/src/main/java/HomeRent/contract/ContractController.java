package HomeRent.contract;

import HomeRent.config.auth.dto.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class ContractController {
    //private final HttpSession httpSession ;


    @GetMapping("/contracts")
    public String list(){
        return "contracts";
    }

    @GetMapping("/contract-print/{id}")
    public String print(@PathVariable Long id, Model model){

        model.addAttribute("id", id);
        return "contract-print";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        // this attribute will be available in the view index.html as a thymeleaf variable
        model.addAttribute("title", "Home Project");
/*
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null){
            model.addAttribute("userName", user.getName());
        }

 */
        // this just means render index.html from static/ area
        return "index";
    }
}
