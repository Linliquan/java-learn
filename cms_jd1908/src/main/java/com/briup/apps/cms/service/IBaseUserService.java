package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.BaseUser;
import com.briup.apps.cms.bean.extend.BaseUserExtend;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.UserVM;

import java.util.List;

/**
 * @program: cms_jd1911
 * @description: 用户接口
 * @author: charles
 * @create: 2019-11-15 15:17
 **/

public interface IBaseUserService {
    
    /** 
     * @Description: 登录
     * @Param: [userVM] 
     * @return: void 
     * @Author: charles 
     * @Date: 2019-11-18 
     */
    BaseUser login(UserVM userVM) throws CustomerException;
    
    /**
     * @Description: 通过id查询
     * @Param: [id]
     * @return: com.briup.apps.cms.bean.extend.BaseUserExtend
     * @Author: charles
     * @Date: 2019-11-16
     */
    BaseUserExtend findById(long id);

    /**
     * @Description: 查询所有
     * @Param: []
     * @return: java.util.List<com.briup.apps.cms.bean.BaseUser>
     * @Author: charles
     * @Date: 2019-11-16
     */
    List<BaseUser> findAll();
    
    /** 
     * @Description: 级联查询所有
     * @Param: [] 
     * @return: java.util.List<com.briup.apps.cms.bean.extend.BaseUserExtend> 
     * @Author: charles 
     * @Date: 2019-11-17 
     */ 
    List<BaseUserExtend> cascadeRoleFindAll();

    /**
     * @Description:  保存或更新
     * @Param: [baseUser]
     * @return: void
     * @Author: charles
     * @Date: 2019-11-16
     */
    void saveOrUpdate(BaseUser baseUser) throws CustomerException;

    /** 
     * @Description: 更新状态
     * @Param: [status] 
     * @return: void 
     * @Author: charles 
     * @Date: 2019-11-16 
     */ 
    void changeStatus(long id, String status) throws CustomerException;
    
    /** 
     * @Description: 通过id删除
     * @Param: [id] 
     * @return: void 
     * @Author: charles 
     * @Date: 2019-11-17
     */ 
    void deleteById(long id) throws CustomerException;
    
    /** 
     * @Description: 设置角色
     * @Param: [id, roles] 
     * @return: void 
     * @Author: charles 
     * @Date: 2019-11-17 
     */ 
    void setRoles(long id, List<Long> roles);
}
