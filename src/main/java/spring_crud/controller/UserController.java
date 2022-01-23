package spring_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring_crud.model.User;
import spring_crud.service.UserService;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView showAllUsers() {
        List<User> users = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("allUsers", users);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.showUser(id));
        return "show";
    }

    @GetMapping("/new")
    public String addUser(@ModelAttribute("addUser") User user) {
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("addUser") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "new";
        }
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.showUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") int id) {
        if(bindingResult.hasErrors()){
            return "/edit";
        }
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}