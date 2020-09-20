package HomeRent.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @RequestMapping(value = "/users/login", method = RequestMethod.GET)
    public String login(Model model) {

        model.addAttribute("title", "Home Project");

        return "login";
    }

    @RequestMapping(value = "/users/list", method = RequestMethod.GET)
    public String userList(Model model) {

        model.addAttribute("title", "Home Project");

        return "users";
    }

    @GetMapping("/roles")
    public String rolesPage() {
        return "roles";
    }

    @GetMapping("/users")
    public String users() {
        return "users";
    }

    // 로그인을 처리하는 부분
//    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
//    public String usersLogin(Model model) {
//
//        model.addAttribute("email", "");
//        model.addAttribute("password", "");
//
//        return "login";
//    }
}
