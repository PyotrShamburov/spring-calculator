package by.home.controller;

import by.home.entity.Operation;
import by.home.entity.dto.OperationDTO;
import by.home.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public ModelAndView calc(ModelAndView modelAndView) {
        modelAndView.addObject("newOperationDTO", new OperationDTO());
        modelAndView.setViewName("calculator");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView doCalc(@Valid @ModelAttribute("newOperationDTO") OperationDTO operationDTO, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("calculator");
        } else {
            Operation operation = new Operation();
            operation.setNum1(Double.parseDouble(operationDTO.getNum1()));
            operation.setNum2(Double.parseDouble(operationDTO.getNum2()));
            operation.setOperator(operationDTO.getOperator());
            String res = calcService.doCalc(operation.getNum1(), operation.getNum2(), operation.getOperator());
            modelAndView.addObject("res", res);
        }
        modelAndView.setViewName("calculator");
        return modelAndView;
    }
}
