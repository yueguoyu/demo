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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author ygy
 * @date 2018/4/9
 * 点赞功能
 */
@Controller
@RequestMapping("/hit")
public class HitController {
    @Autowired
    EssayDao dao;
    @Autowired
    CommentDao commentDao;
    @Autowired
    private RedisDao redisDao;
    @RequestMapping(value = "/addhit",method = RequestMethod.GET)
    public @ResponseBody void addHit(int eid, Model model){
        redisDao.addhit(eid);
    }
}
