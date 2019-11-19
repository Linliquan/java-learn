package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.BaseRole;
import com.briup.apps.cms.bean.BaseUser;

import java.util.List;

/**
 * @program: cms_jd1911
 * @description: 用户拓展类
 * @author: charles
 * @create: 2019-11-15 15:08
 **/

public class BaseUserExtend extends BaseUser {
    public static final String STATUS_NORMAL="正常";
    public static final String STATUS_FORBIDDEN="禁用";

    private List<BaseRole> roles;

    public List<BaseRole> getRoles() {
        return roles;
    }

    public void setRoles(List<BaseRole> roles) {
        this.roles = roles;
    }
}
