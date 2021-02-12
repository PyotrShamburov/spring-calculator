package by.home.controller;

import by.home.entity.User;
import by.home.service.CalcService;
import by.home.service.UserService;
import by.home.storage.HistoryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CalcService calcService;

    @GetMapping(path = "/auth")
    public ModelAndView getAuthPage(ModelAndView modelAndView) {
        modelAndView.setViewName("authorization");
        return modelAndView;
    }

    @GetMapping(path = "/reg")
    public ModelAndView getRegPage(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(path = "/auth")
    public ModelAndView doAuthorization(User user, HttpSession httpSession,
                                        ModelAndView modelAndView) {
        modelAndView.setViewName("authorization");
        User byLogin = userService.checkByLogin(user.getLogin());
        if (byLogin != null) {
            if (userService.passwordCheck(byLogin, user.getPassword())) {
                httpSession.setAttribute("isGuest", false);
                httpSession.setAttribute("isUser", true);
                modelAndView.setViewName("redirect:/");
            } else {
                modelAndView.addObject("answer", "Wrong password or login!");
            }
        } else {
            modelAndView.addObject("answer", "User with this login doesn't exist!");
        }
        return modelAndView;
    }

    @PostMapping(path = "/reg")
    public ModelAndView doRegistration(@Valid User user, BindingResult bindingResult,
                                       ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            modelAndView.addAllObjects(errors);
        } else {
            User byLogin = userService.checkByLogin(user.getLogin());
            if (byLogin == null) {
                userService.addToStorage(user);
                modelAndView.setViewName("redirect:/user/auth");
            } else {
                modelAndView.addObject("answer", "User with this login already exists!");
            }
        }
        return modelAndView;
    }

    @GetMapping(path = "/out")
    public ModelAndView logout(HttpSession httpSession, ModelAndView modelAndView) {
        calcService.clearHistory();
        httpSession.invalidate();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
