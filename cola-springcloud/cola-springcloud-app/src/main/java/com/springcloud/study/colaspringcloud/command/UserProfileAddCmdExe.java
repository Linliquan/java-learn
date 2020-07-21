package com.springcloud.study.colaspringcloud.command;

import com.alibaba.cola.dto.Response;
import com.springcloud.study.colaspringcloud.convertor.UserProfileConvertor;
import com.springcloud.study.colaspringcloud.domain.gateway.UserProfileGateway;
import com.springcloud.study.colaspringcloud.domain.user.UserProfile;
import com.springcloud.study.colaspringcloud.dto.UserProfileAddCmd;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * UserProfileAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-02-28 6:25 PM
 */
@Component
public class UserProfileAddCmdExe{

    @Resource
    private UserProfileGateway userProfileGateway;

    public Response execute(UserProfileAddCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileGateway.create(userProfile);
        return Response.buildSuccess();
    }
}
