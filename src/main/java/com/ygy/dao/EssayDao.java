package com.ygy.dao;

import com.ygy.model.Essay;

import java.util.List;

/**
 * @author ygy
 * @date 2018/2/7
 */
public interface EssayDao {
    public Essay SelectTitle(String title);
    public int addText(Essay essay);
    public int updateText(Essay essay);
    public int delete(int eid);
    public List<Essay> SelectAllEssay();
}
