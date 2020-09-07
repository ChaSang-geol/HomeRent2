package contract;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContractController {
    @GetMapping("/")
    public String list(){
        return "contracts";
    }

    @GetMapping("/contracts")
    public String contracts(){
        return "contracts";
    }
}
