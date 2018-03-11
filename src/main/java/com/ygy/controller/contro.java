package com.ygy.controller;

import com.ygy.dao.testDao;
import com.ygy.model.T1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class contro {
@Autowired
    private testDao dao;
@RequestMapping(value = "/select",method = RequestMethod.POST)
    public T1 select(int id){
    T1 t1=dao.select(id);
    return t1;
}
@RequestMapping("/add")
    public void add(T1 t1){
    this.dao.add(t1);
}
@RequestMapping("/delete")
    public void delete(int id){
    this.dao.delete(id);
}
@RequestMapping("/update")
    public void update(T1 t1){
    this.dao.update(t1);
}
}
