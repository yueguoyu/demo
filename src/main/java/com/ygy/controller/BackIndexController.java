package com.ygy.controller;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackIndexController {
    @RequestMapping("/")
    public String index(){
        return "ygy";
    }
}
