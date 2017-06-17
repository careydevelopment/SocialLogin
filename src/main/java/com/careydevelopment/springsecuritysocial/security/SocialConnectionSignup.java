package com.careydevelopment.springsecuritysocial.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

import com.careydevelopment.springsecuritysocial.entity.User;
import com.careydevelopment.springsecuritysocial.util.UserHelper;

@Service
public class SocialConnectionSignup implements ConnectionSignUp {

    @Autowired
    UserHelper userHelper;

    /**
     * This is where you would create the user object and persist it
     */
    @Override
    public String execute(Connection<?> connection) {
        //create the user based on the API type (Facebook or Twiter)
        User user = userHelper.getUser(connection);
        
        //return the user name
        return user.getName();
    }

}
