package com.springcloud.study.colaspringcloud.command;

import com.alibaba.cola.dto.Response;
import com.springcloud.study.colaspringcloud.convertor.UserProfileConvertor;
import com.springcloud.study.colaspringcloud.domain.gateway.UserProfileGateway;
import com.springcloud.study.colaspringcloud.domain.user.UserProfile;
import com.springcloud.study.colaspringcloud.dto.UserProfileUpdateCmd;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserProfileUpdateCmdExe{

    @Resource
    private UserProfileGateway userProfileGateway;

    public Response execute(UserProfileUpdateCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileGateway.update(userProfile);
        return Response.buildSuccess();
    }
}