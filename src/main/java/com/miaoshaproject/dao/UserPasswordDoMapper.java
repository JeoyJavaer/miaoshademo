package com.miaoshaproject.dao;

import com.miaoshaproject.dataobject.UserPasswordDo;

public interface UserPasswordDoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Thu Mar 07 16:29:21 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Thu Mar 07 16:29:21 CST 2019
     */
    int insert(UserPasswordDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Thu Mar 07 16:29:21 CST 2019
     */
    int insertSelective(UserPasswordDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Thu Mar 07 16:29:21 CST 2019
     */
    UserPasswordDo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Thu Mar 07 16:29:21 CST 2019
     */
    int updateByPrimaryKeySelective(UserPasswordDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Thu Mar 07 16:29:21 CST 2019
     */
    int updateByPrimaryKey(UserPasswordDo record);
}