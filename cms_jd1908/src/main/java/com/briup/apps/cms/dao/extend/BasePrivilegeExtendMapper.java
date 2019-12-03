package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.BasePrivilege;
import com.briup.apps.cms.vm.PrivilegeTree;

import java.util.List;

public interface BasePrivilegeExtendMapper {
    List<PrivilegeTree> selectAll();

    List<BasePrivilege> selectByParentId(long id);

    List<BasePrivilege> selectByRoleId(long id);

    List<BasePrivilege> selectByUserId(long id);
}
