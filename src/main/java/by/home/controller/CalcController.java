package by.home.controller;

import by.home.entity.Operation;
import by.home.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class CalcController {

    @Autowired
    private CalcService calcService;


    @GetMapping(path = "/calc")
    public ModelAndView calc(ModelAndView modelAndView){
        modelAndView.setViewName("calculator");
        return modelAndView;
    }

    @PostMapping(path = "/calc")
    public ModelAndView doCalc(Operation operation, ModelAndView modelAndView){
        modelAndView.setViewName("calculator");
        String res = calcService.doCalc(operation.getNum1(),operation.getNum2(),operation.getOperator());
        modelAndView.addObject("res",res);
        return modelAndView;


    }
}
