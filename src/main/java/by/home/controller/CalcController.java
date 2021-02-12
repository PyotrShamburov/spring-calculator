package by.home.controller;

import by.home.entity.Operation;
import by.home.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path = "/calc")
public class CalcController {

    @Autowired
    private CalcService calcService;


    @GetMapping
    public ModelAndView calc(ModelAndView modelAndView){
        modelAndView.setViewName("calculator");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView doCalc(@Valid Operation operation, BindingResult bindingResult, ModelAndView modelAndView){
        modelAndView.setViewName("calculator");
        if (bindingResult.hasErrors()) {
            Map<String, String> mapErrors = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                mapErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            modelAndView.addAllObjects(mapErrors);
        } else {
            String res = calcService.doCalc(operation.getNum1(),operation.getNum2(),operation.getOperator());
            modelAndView.addObject("res",res);
        }
        return modelAndView;
    }
}
