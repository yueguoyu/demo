package com.ygy.mapper;

import com.ygy.model.User;
import com.ygy.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author ygy
 * @date 2018/2/5
 */
public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    int countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    int deleteByPrimaryKey(Integer userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    User selectByPrimaryKey(Integer userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Thu Feb 01 13:09:43 CST 2018
     */
    int updateByPrimaryKey(User record);
    int selectByNamePass(User user);
    int updatePass(User user);
    int updateStatus(User user);
}