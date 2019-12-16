package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.Test;

import java.util.List;

public interface ITestService {
    List<Test> findAll();

    void saveOrUpdate(Test test);

}
