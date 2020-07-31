package com.springcloud.study.colaspringcloud.dto;

import com.springcloud.study.colaspringcloud.dto.clientobject.UserProfileCO;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserProfileUpdateCmd extends CommonCommand {

    @NotNull
    private UserProfileCO userProfileCO;
}
