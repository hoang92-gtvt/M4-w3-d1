package controller;

import model.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.IUserService;

@Controller
@RequestMapping("User/")
public class UserController {
@Autowired
    private IUserService userService;

@GetMapping("Create")
    public ModelAndView createForm(){
    ModelAndView modelAndView = new ModelAndView("user/create");
    modelAndView.addObject("user",new UserFile());
    return modelAndView;
}

}
