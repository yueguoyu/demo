package com.ygy.controller;


import com.ygy.dao.EssayDao;
import com.ygy.model.Essay;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BackIndexController {
    @Autowired
    private EssayDao dao;
    @RequestMapping("/")
    public String index(Model model){
        List<Essay> essayList=dao.sortByHit();
        model.addAttribute("e1",essayList.get(0));
        return "index";
    }
}
