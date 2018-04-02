package com.ygy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ygy.dao.CommentDao;
import com.ygy.dao.EssayDao;
import com.ygy.model.Comment;
import com.ygy.model.Essay;
import com.ygy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 散文的增，删，改，查
 *
 * @author ygy
 */
@Controller
public class EssayCtrl {
    @Autowired
    private EssayDao dao;
    @Autowired
    private CommentDao commentDao;

    @RequestMapping(value = "/essay/select", method = RequestMethod.GET)
    public String selectTitle(Model model, String title) {
        Essay essay = this.dao.SelectTitle(title);
        model.addAttribute("essay2", essay.getTitle());
        model.addAttribute("essay1", essay.getText());
        return "ygy";
    }

    /**
     * markDown添加博客
     * @param essay
     * @return
     */
    @RequestMapping(value = "/essay/add", method = RequestMethod.POST)
    public String addEssayByMarkD(@ModelAttribute(value = "Essay") Essay essay) {
        this.dao.addText(essay);
        return "enter";
    }

    /**
     * 添加博客
     */

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String addEssay(@ModelAttribute(value = "Essay") Essay essay) {
        return "enter";
    }

    @RequestMapping(value = "/essay/ale", method = RequestMethod.GET)
    public String allEssay(Model model) {
        List<Essay> list = this.dao.SelectAllEssay();
        model.addAttribute("list", list);
        return "ygy";
    }

    @RequestMapping(value = "/essay/bypage", method = RequestMethod.GET)
    public String findByPage(@RequestParam(required = true, defaultValue = "1") Integer page, HttpServletRequest request, Model model) {
        PageHelper.startPage(page, 3);
        List<Essay> essayList = this.dao.findByPage();
        PageInfo<Essay> p = new PageInfo<Essay>(essayList);
        model.addAttribute("http", "bypage?");
        model.addAttribute("p", p);
        model.addAttribute("essayList", essayList);
        return "blog";
    }

    @RequestMapping("/essay/select1")
    public String selectById(int eid, Model model,@ModelAttribute(value = "Comment") Comment comment,@ModelAttribute("User") User user) {
        Essay essay = this.dao.findById(eid);
        List<Map<String,String>> comment1List=this.commentDao.selectByeid(eid);
        model.addAttribute("comment1List",comment1List);
        model.addAttribute("essay", essay);
        return "markDown";
    }

    @RequestMapping(value = "/essay/cate", method = RequestMethod.GET)
    public String findByCateName(String cateName, @RequestParam(required = true, defaultValue = "1") Integer page, HttpServletRequest request, Model model) {
        PageHelper.startPage(page, 1);
        List<Essay> essayList = this.dao.findByCateName(cateName);
        PageInfo<Essay> p = new PageInfo<Essay>(essayList);
        model.addAttribute("input", cateName);
        model.addAttribute("http", "cate?cateName=");
        model.addAttribute("p", p);
        model.addAttribute("essayList", essayList);
        return "blog";
    }


    @RequestMapping("/essay/dim")
    public String login(@Valid Essay essay, BindingResult result, Model model, @RequestParam(required = true, defaultValue = "1") Integer page) {
        if (result.hasErrors()) {
            List<ObjectError> error = result.getAllErrors();
            for (ObjectError e : error) {
                System.out.println(e);
            }
            return null;
        }
        PageHelper.startPage(page, 1);
        List<Essay> essayList = this.dao.findByDim(essay.getTitle());
        PageInfo<Essay> p = new PageInfo<Essay>(essayList);
        model.addAttribute("input", essay.getTitle());
        model.addAttribute("http", "dim?title=");
        model.addAttribute("p", p);
        model.addAttribute("essayList", essayList);
        return "blog";
    }

    @RequestMapping("/test")
    public String test(Model model) {
        Essay essay = this.dao.findById(10);
        model.addAttribute("essay", essay);
        return "markDown";
    }

}
