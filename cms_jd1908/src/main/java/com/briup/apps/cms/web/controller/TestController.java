package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.Test;
import com.briup.apps.cms.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: cms_jd1908
 * @description: 测试控制器
 * @author: charles
 * @create: 2019-11-11 16:32
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITestService testService;

    @GetMapping(value = "findAll")
    public List<Test> findAll(){
        return testService.findAll();
    }

    @GetMapping("hello")
    public String sayHello(){
        return "hello world!";
    }

    @PostMapping(value = "saveOrUpdate")
    public String saveOrUpdate(Test test){
        testService.saveOrUpdate(test);
        return "更新成功";
    }
}
