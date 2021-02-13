package by.home.controller;

import by.home.entity.User;
import by.home.entity.dto.UserDTO;
import by.home.service.CalcService;
import by.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CalcService calcService;

    @GetMapping(path = "/auth")
    public ModelAndView getAuthPage(ModelAndView modelAndView) {
        modelAndView.addObject("newUserDTO", new UserDTO());
        modelAndView.setViewName("authorization");
        return modelAndView;
    }

    @GetMapping(path = "/reg")
    public ModelAndView getRegPage(ModelAndView modelAndView) {
        modelAndView.addObject("newUser", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(path = "/auth")
    public ModelAndView doAuthorization(@Valid @ModelAttribute("newUserDTO") UserDTO userDTO, BindingResult bindingResult,
                                        HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.setViewName("authorization");
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("authorization");
        } else {
            User byLoginDTO = userService.checkByLogin(userDTO.getLogin());
            if (userService.passwordCheck(byLoginDTO, userDTO.getPassword())) {
                httpSession.setAttribute("isGuest", false);
                httpSession.setAttribute("isUser", true);
                modelAndView.setViewName("redirect:/");
            } else {
                modelAndView.addObject("answer", "Wrong password or login!");
            }
        }
        return modelAndView;
    }

    @PostMapping(path = "/reg")
    public ModelAndView doRegistration(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult,
                                       ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.addToStorage(user);
            modelAndView.setViewName("redirect:/user/auth");
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
