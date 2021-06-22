package controller;

import model.CheckEmail;
import model.User;
import model.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.IUserService;

import javax.validation.Valid;

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

@PostMapping("Create")
public String checkValidation (@Valid @ModelAttribute("user") UserFile userFile, BindingResult bindingResult){
    new CheckEmail().validate(userFile.getEmail(),bindingResult);
    if (bindingResult.hasFieldErrors()){
        return "user/create";
    }else {
        User user = new User();
        user.setId((long) (Math.random()*10000));
        user.setName(userFile.getName());
        user.setAge(userFile.getAge());
        user.setGender(userFile.getGender());
        user.setEmail(userFile.getEmail());
        userService.save(user);
        return "user/resul";
    }

}


}
