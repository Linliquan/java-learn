package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.utils.CustomerException;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void saveOrUpdate(Category category) throws CustomerException;

    void deleteById(long id) throws CustomerException;

    void batchDelete(long [] ids) throws CustomerException;
}
