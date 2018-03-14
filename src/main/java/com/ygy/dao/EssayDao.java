package com.ygy.dao;

import com.ygy.model.Essay;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author ygy
 * @date 2018/2/7
 */
public interface EssayDao {
    /**
     * select by title
     * @param title
     * @return
     */
    Essay SelectTitle(String title);

    /**
     * 添加文章
     * @param essay
     * @return
     */
    int addText(Essay essay);

    /**
     * 修改文章
     * @param essay
     * @return
     */
    int updateText(Essay essay);

    /**
     * 删除文章
     * @param eid
     * @return
     */
    int delete(int eid);

    /**
     * 查询全部文章
     * @return list
     */
    List<Essay> SelectAllEssay();

    /**
     * 分页查找
     * @return
     */
    List<Essay> findByPage();

    /**
     * 通过文章id查询
     * @param eid
     * @return
     */
    Essay findById(int eid);

    /**
     * 通过文章类型查找
     * @param cateName
     * @return
     */
    List<Essay> findByCateName(String cateName);

    /**
     * 通过标题模糊查询
     * @param title
     * @return
     */
    List<Essay> findByDim(String title);

}
