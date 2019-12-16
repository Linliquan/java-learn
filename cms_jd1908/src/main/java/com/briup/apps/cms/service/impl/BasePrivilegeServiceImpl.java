package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.BasePrivilege;
import com.briup.apps.cms.bean.BasePrivilegeExample;
import com.briup.apps.cms.dao.BasePrivilegeMapper;
import com.briup.apps.cms.dao.extend.BasePrivilegeExtendMapper;
import com.briup.apps.cms.service.IBasePrivilegeService;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.PrivilegeTree;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: cms_jd1911
 * @description: 权限控制实现类
 * @author: charles
 * @create: 2019-11-16 15:54
 **/
@Service
public class BasePrivilegeServiceImpl implements IBasePrivilegeService {
    @Resource
    private BasePrivilegeMapper basePrivilegeMapper;
    @Resource
    private BasePrivilegeExtendMapper basePrivilegeExtendMapper;

    @Override
    public List<BasePrivilege> findByUserId(long id) {
        return basePrivilegeExtendMapper.selectByUserId(id);
    }

    @Override
    public List<BasePrivilege> findAll() {
        return basePrivilegeMapper.selectByExample(new BasePrivilegeExample());
    }

    @Override
    public void saveOrUpdate(BasePrivilege privilege) throws CustomerException {
        if(privilege.getId()!=null){
            basePrivilegeMapper.updateByPrimaryKey(privilege);
        } else {
            basePrivilegeMapper.insert(privilege);
        }
    }

    @Override
    public List<BasePrivilege> findByParentId(Long parentId) {
        BasePrivilegeExample example = new BasePrivilegeExample();
        if(parentId == null){
            example.createCriteria().andParentIdIsNull();
        } else {
            example.createCriteria().andParentIdEqualTo(parentId);
        }
        return basePrivilegeMapper.selectByExample(example);
    }

    @Override
    public List<PrivilegeTree> findPrivilegeTree() {
        return basePrivilegeExtendMapper.selectAll();
    }
}
