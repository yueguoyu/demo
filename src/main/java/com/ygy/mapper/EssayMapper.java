package com.ygy.mapper;

import com.ygy.model.Essay;
import com.ygy.model.EssayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;

public interface EssayMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    int countByExample(EssayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    int deleteByExample(EssayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    int deleteByPrimaryKey(Integer eid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    int insert(Essay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    int insertSelective(Essay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    List<Essay> selectByExample(EssayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    Essay selectByPrimaryKey(Integer eid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    int updateByExampleSelective(@Param("record") Essay record, @Param("example") EssayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    int updateByExample(@Param("record") Essay record, @Param("example") EssayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    int updateByPrimaryKeySelective(Essay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table essay
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    int updateByPrimaryKey(Essay record);

    /**
     * 根据标题查询
     * @param title
     * @return Essay
     *
     */
    Essay selectTitle(String title);
    /**
     * 查询全部
     * @param
     * @return LIst<Essay>
     *
     */
    List<Essay> selectAllEssay();
    /**
     * 分页查找
     * @param
     * @return LIst<Essay>
     *
     */
    List<Essay> findByPage();

    /**
     * 通过文章id查询
     * @param eid
     * @return Essay
     */
    Essay findById(int eid);

    /**
     * 类型查询
     * @param cateName
     * @return Essay
     */
   List<Essay> findByCateName(String  cateName);

    /**
     * 标题模糊查询
     * @param title
     * @return
     */
   List<Essay> findByDim(String title);
    /**
     * 获取文章的点赞数
     * @param eid
     * @return hite
     */
    int findHitByeid(int eid);

    /**
     * 获取文章的所有题目
     * @return String
     */
    List<String> findAllTitle();
}