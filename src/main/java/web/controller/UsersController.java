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
    public String index(Model model){
        model.addAttribute("users", userDao.index());
        return "index";
    }
    @GetMapping(value = "/show")
    public String show(@RequestParam(value = "show", required = false, defaultValue = "1") Integer id, Model model) {
        model.addAttribute("users", userDao.show(id));
        return "show";
    }
    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user) {
        userDao.save(user);
        return "redirect:/";
    }

    @PostMapping(value = "/id")
    public String removeUser(@RequestParam(value ="id") int id) {
        userDao.remove(id);
        return "redirect:/";
    }
    @GetMapping(value = "/edit")
    public String edit(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("users", userDao.show(id));
        return "edit";
    }


    @PostMapping(value = "/edit")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam("id") int id) {
        userDao.update(id, user);
        return "redirect:/";
    }
//    User user = new User();
//    {
//        user.setId(1);
//        user.setName("Tom");
//        user.setLastName("Jones");
//        user.setAge(18);
//    }
//----------------------------------------------------


//    @GetMapping
//    public String allUsers(Model model) {
//       model.addAttribute("users", userDao.getUsersList());
//        return "users";
//    }


}
