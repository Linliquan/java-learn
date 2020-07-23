package com.springcloud.study.colaspringcloud.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.springcloud.study.colaspringcloud.dto.*;
import com.springcloud.study.colaspringcloud.dto.clientobject.UserProfileCO;


/**
 * UserProfileServiceI
 *
 * @author Frank Zhang
 * @date 2019-02-28 6:15 PM
 */
public interface UserProfileServiceI {
    public Response addUserProfile(UserProfileAddCmd cmd);
    public Response updateUserProfile(UserProfileUpdateCmd cmd);
    public Response refreshScore(RefreshScoreCmd cmd);
    public SingleResponse<UserProfileCO> getUserProfileBy(UserProfileGetQry qry);
    public MultiResponse<UserProfileCO>  listUserProfileBy(UserProfileListQry qry);
}
