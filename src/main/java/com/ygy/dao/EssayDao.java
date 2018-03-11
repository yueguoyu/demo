package com.ygy.dao;

import com.ygy.model.Essay;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author ygy
 * @date 2018/2/7
 */
public interface EssayDao {
    Essay SelectTitle(String title);

    int addText(Essay essay);

    int updateText(Essay essay);

    int delete(int eid);

    List<Essay> SelectAllEssay();

    List<Essay> findByPage();
    Essay findById(int eid);

}
