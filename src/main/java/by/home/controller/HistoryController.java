package by.home.controller;

import by.home.service.CalcService;
import by.home.storage.HistoryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path = "/")
public class HistoryController {
    @Autowired
    private CalcService calcService;

    @GetMapping(path = "/calc/history")
    public ModelAndView showOperations(HttpSession httpSession, ModelAndView modelAndView){
        modelAndView.setViewName("history");
        modelAndView.addObject("list",calcService.getHistory());
        return modelAndView;
    }
}
