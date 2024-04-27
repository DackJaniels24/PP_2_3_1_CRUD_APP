package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.userDAO.UserDaoImpl;

@Controller
@RequestMapping (value = "/")
public class UsersController {
    @Autowired
    UserDaoImpl userDao = new UserDaoImpl();

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userDao.index());
        return "index";
    }

    @GetMapping("/id")
    public String show(@RequestParam(value = "id", required = false, defaultValue = "1") int id, Model model) {
        model.addAttribute("user", userDao.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        userDao.save(user);
        return "redirect:/";
    }

    @GetMapping("/remove")
    public String removeUser(@RequestParam("id") int id) {
        userDao.remove(id);
        return "redirect:/";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam(value = "id", required = false, defaultValue = "1") int id, Model model) {
        model.addAttribute("user", userDao.show(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam("id") int id) {
        userDao.update(id, user);
        return "redirect:/";
    }
}
