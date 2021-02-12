package by.home.controller;

import by.home.service.CalcService;
import by.home.storage.HistoryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(path = "/calc/history")
public class HistoryController {
    @Autowired
    private CalcService calcService;

    @GetMapping
    public ModelAndView showOperations(ModelAndView modelAndView){
        modelAndView.setViewName("history");
        modelAndView.addObject("list",calcService.getHistory());
        return modelAndView;
    }
}
