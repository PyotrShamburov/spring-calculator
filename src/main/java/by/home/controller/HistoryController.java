package by.home.controller;

import by.home.storage.HistoryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class HistoryController {
    @Autowired
    private HistoryStorage storage;

    @GetMapping(path = "/calc/history")
    public String showOperations(Model model){
        model.addAttribute("list",storage.getHistory());

        return "history";
    }
}
