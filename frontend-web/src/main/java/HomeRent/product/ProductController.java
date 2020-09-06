package HomeRent.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
    @GetMapping("/products")
    public String list(){
        return "products";
    }

    @RequestMapping(value = "/test_a", method = RequestMethod.GET)
    public String test_a(Model model) {
        //
        model.addAttribute("eventName", "FIFA 2018");
        //
        return "test_a";
    }

}
