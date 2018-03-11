package com.ygy.controller;

import com.ygy.dao.EssayDao;
import com.ygy.model.Essay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 散文的增，删，改，查
 * @author ygy
 *
 */
@Controller
public class EssayCtrl {
    @Autowired
    private EssayDao dao;
    @RequestMapping(value = "/essay/select",method = RequestMethod.GET)
    public String selectTitle(Model model, String title){
       Essay essay= this.dao.SelectTitle(title);
       model.addAttribute("essay2",essay.getTitle());
       model.addAttribute("essay1",essay.getText());
       return "ygy";
    }
    @RequestMapping(value = "/essay/add",method = RequestMethod.POST)
    public String AddEssay(){
        return "main";
    }
    @RequestMapping(value = "/essay/ale",method = RequestMethod.GET)
    public String AllEssay(Model model){
        List<Essay> list= this.dao.SelectAllEssay();

        model.addAttribute("list",list);
        return "ygy";
    }
}
