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


@RestController
@RequestMapping("/comm")
public class contro {
@Autowired
    private CommentDao dao;
@RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addComment(Comment comment){
    dao.addComment(comment);
    System.out.println(comment.getCommtext());
}
@RequestMapping("/scomm")
    public  void sComm(Model model){

}
}
