package com.ygy.controller;


import com.ygy.dao.EssayDao;
import com.ygy.model.Essay;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class BackIndexController {
    @Autowired
    private EssayDao dao;
    @RequestMapping("/")
    public String index(Model model){
        Essay essay=this.dao.findById(1);
        model.addAttribute("e1",essay);
        return "index";
    }
}
