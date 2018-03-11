package com.ygy.controller;

import com.ygy.dao.UserDao;
import com.ygy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.net.httpserver.HttpServerImpl;

import javax.servlet.http.HttpServletRequest;

@Controller
public class InforCtrl {
    @Autowired
    private UserDao dao;
    @GetMapping("/admin/login")
    public String login(@ModelAttribute("user1") User user, Model model){
    boolean result=this.dao.login(user);
    if (result){
        model.addAttribute("result",1);
        return "main";
    }
    else {
        model.addAttribute("result",0);
        return "main0";
    }
    }
    @RequestMapping(value = "/admin/update",method = RequestMethod.POST)
    public String update(@RequestParam String username, @RequestParam String newpass){
        User user=new User();
        user.setPassword(newpass);
        user.setName(username);
        boolean result=this.dao.UpdateUser(user);
        if (result){
            return "main";
        }else {
            return "main0";
        }
    }

}
