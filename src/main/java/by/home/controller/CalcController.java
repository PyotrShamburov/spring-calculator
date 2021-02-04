package by.home.controller;

import by.home.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class CalcController {

    @Autowired
    private CalcService calcService;


    @GetMapping(path = "/calc")
    public String calc(){
        return "calculator";
    }

    @PostMapping(path = "/calc")
    public String doCalc(double num1, double num2, String sign, Model model){
        model.addAttribute("result", calcService.doCalc(num1, num2, sign));
        return "calculator";


    }
}
