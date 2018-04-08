package com.ygy.controller;


import com.ygy.dao.EssayDao;
import com.ygy.dao.UserDao;
import com.ygy.model.Essay;
import com.ygy.model.User;
import javafx.scene.input.MouseDragEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author ygy
 * 用户注册，登陆
 */
@Controller
public class InforCtrl {
    @Autowired
    private UserDao dao;
    @Autowired
    private EssayDao essayDao;

    @RequestMapping(value = "/admin/login",method= RequestMethod.POST)
    public String login(@ModelAttribute("user1") User user, Model model) {
        boolean result = this.dao.login(user);
        if (result) {
            this.dao.updateStatus(user);
            model.addAttribute("result", 1);
            return "index";
        } else {
            model.addAttribute("result", 0);
            return "index";
        }
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public String update(@RequestParam String username, @RequestParam String newpass) {
        User user = new User();
        user.setPassword(newpass);
        user.setName(username);
        boolean result = this.dao.updateUser(user);
        if (result) {
            return "main";
        } else {
            return "main0";
        }
    }

    @RequestMapping(value = "/login")
    public String index(Model model,Principal principal){
        Essay essay=this.essayDao.findById(1);
        model.addAttribute("e1",essay);
//     model.addAttribute("name",principal.getName());
        return "index";
    }

}
