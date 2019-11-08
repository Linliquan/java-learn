package com.spring.springbootconfig.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class User {
    private int id;
    private String name;
    @Autowired
    private Group group;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


}
