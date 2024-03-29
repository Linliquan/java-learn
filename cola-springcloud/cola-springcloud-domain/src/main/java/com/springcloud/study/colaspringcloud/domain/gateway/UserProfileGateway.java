package com.springcloud.study.colaspringcloud.domain.gateway;

import com.springcloud.study.colaspringcloud.domain.user.UserProfile;

/**
 * UserProfileGateway
 *
 * @author Frank Zhang
 * @date 2020-07-02 12:16 PM
 */
public interface UserProfileGateway {
    public void create(UserProfile userProfile);
    public void update(UserProfile userProfile);
    public UserProfile getByUserId(String userId);
}
