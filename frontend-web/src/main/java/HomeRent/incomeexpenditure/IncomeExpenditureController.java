package HomeRent.incomeexpenditure;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IncomeExpenditureController {
    @GetMapping("/incomeexpenditures")
    public String IncomeExpenditure(){
        return "incomeexpenditures";
    }

}
