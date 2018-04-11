package com.ygy.controller;

import com.ygy.dao.CommentDao;
import com.ygy.dao.EssayDao;
import com.ygy.dao.RedisDao;
import com.ygy.model.Comment;
import com.ygy.model.Essay;
import com.ygy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author ygy
 * @date 2018/4/9
 * 点赞功能
 */
@RestController

public class HitController {
    @Autowired
    EssayDao dao;
    @Autowired
    CommentDao commentDao;
    @Autowired
    private RedisDao redisDao;
    @RequestMapping(value = "/hit/addhit",method = RequestMethod.POST)
    public  void addHit(int eid, Model model,@ModelAttribute(value = "Comment") Comment comment, HttpServletResponse response){
        if (comment.getCommname()!=null){
            redisDao.addhit(eid,comment.getCommname());
        }

        try {
            response.sendRedirect("/essay/select1"+"?&eid="+eid);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
