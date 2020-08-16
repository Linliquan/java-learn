package com.springcloud.study.colaspringcloud.domain;

import com.springcloud.study.colaspringcloud.domain.user.UserProfile;

public class DomainFactory {

    public static UserProfile getUserProfile(){
        return new UserProfile();
    }

}
