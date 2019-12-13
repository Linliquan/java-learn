package com.briup.apps.cms.dao;

import com.briup.apps.cms.bean.BaseUserRole;
import com.briup.apps.cms.bean.BaseUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseUserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Tue Nov 19 14:59:41 CST 2019
     */
    long countByExample(BaseUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Tue Nov 19 14:59:41 CST 2019
     */
    int deleteByExample(BaseUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Tue Nov 19 14:59:41 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Tue Nov 19 14:59:41 CST 2019
     */
    int insert(BaseUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Tue Nov 19 14:59:41 CST 2019
     */
    int insertSelective(BaseUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Tue Nov 19 14:59:41 CST 2019
     */
    List<BaseUserRole> selectByExample(BaseUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Tue Nov 19 14:59:41 CST 2019
     */
    BaseUserRole selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Tue Nov 19 14:59:41 CST 2019
     */
    int updateByExampleSelective(@Param("record") BaseUserRole record, @Param("example") BaseUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Tue Nov 19 14:59:41 CST 2019
     */
    int updateByExample(@Param("record") BaseUserRole record, @Param("example") BaseUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Tue Nov 19 14:59:41 CST 2019
     */
    int updateByPrimaryKeySelective(BaseUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_user_role
     *
     * @mbg.generated Tue Nov 19 14:59:41 CST 2019
     */
    int updateByPrimaryKey(BaseUserRole record);
}