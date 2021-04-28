package com.example.easyexcel.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserExcelModel implements Serializable {

    private String name;

    private Integer age;

    private String mobile;

    private String sex;


    public UserExcelModel(String name, Integer age, String mobile, String sex) {
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.sex = sex;
    }

    public UserExcelModel() {
    }
}
