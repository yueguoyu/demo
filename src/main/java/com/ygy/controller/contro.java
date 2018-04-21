package com.ygy.controller;

import com.ygy.dao.CommentDao;
import com.ygy.dao.testDao;
import com.ygy.model.Comment;
import com.ygy.model.T1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping("/comm")
public class contro {
@Autowired
    private CommentDao dao;
@RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addComment(Comment comment,HttpServletResponse response){
    dao.addComment(comment);
    try {
        response.sendRedirect("/essay/select1"+"?&eid="+comment.getEid());
    } catch (IOException e) {
        e.printStackTrace();
    }
}
@RequestMapping("/scomm")
    public  void sComm(Model model){

}
}
