package com.semenov.Java_pre_project_3_1_1.controller;


import com.semenov.Java_pre_project_3_1_1.models.User;
import com.semenov.Java_pre_project_3_1_1.service.ServiceUserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {

    @Autowired
    private ServiceUserInterface serviceUserInterface;


    @GetMapping("/")
    public String printWelcome(ModelMap model) {
        model.addAttribute("allUsers", serviceUserInterface.getAllUsersList());
        return "index";
    }

    @PostMapping("/adduser")
    public String saveNewUser(
                              @RequestParam String userName,
                              @RequestParam (required = false) String userSurname,
                              @RequestParam (required = false) Integer age, ModelMap model) {
        User user = new User( userName, userSurname, age);

        model.addAttribute("user", user);
        serviceUserInterface.addUser(user);

        return "redirect:/";
    }

    @GetMapping("/adduser")
    public String savePage() {
        return "adduser";
    }


    @GetMapping("/deleteuser")
    public String deleteUser( @RequestParam Long id, ModelMap model) {;
        serviceUserInterface.deleteUser(id);
        return "redirect:/";
    }


    @PostMapping("/updateuser")
    public String updateUser( @RequestParam (required = true) Long id,
                              @RequestParam (required = false) String userName,
                              @RequestParam (required = false) String userSurname,
                              @RequestParam (required = false) Integer age, ModelMap model){
        User user = serviceUserInterface.getUserById(id);
        user.setUserName(userName);
        user.setUserSurname(userSurname);
        user.setAge(age);

        serviceUserInterface.updateUser(user);

        return "redirect:/";
    }

    @GetMapping("/updateuser")
    public String pageForUpdate( @RequestParam Long id, ModelMap model ) {

        model.addAttribute("userForUpdate", serviceUserInterface.getUserById(id));
        return "pageForUpdate";
    }

}