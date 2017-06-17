package com.careydevelopment.springsecuritysocial.util;

import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Component;

import com.careydevelopment.springsecuritysocial.entity.User;

@Component
public class UserHelper {
    
    /**
     * Instantiates a User object based on login
     * 
     * @param connection
     * @return user object
     */
    public User getUser(Connection<?> connection) {
        User user = null;

        //get the connection type
        ConnectionType type = ConnectionHelper.getConnectionType(connection);
        
        //create a user based on API type
        if (type.equals(ConnectionType.TWITTER)) {
            user = getTwitterUser(connection);
        } else if (type.equals(ConnectionType.FACEBOOK)) {
            user = getFacebookUser(connection);
        }
        
        return user;
    }
    
    
    /**
     * Handles users who've logged in via Twitter
     */
    private User getTwitterUser(Connection<?> connection) {
        User user = new User();
        Twitter twitterApi = (Twitter)connection.getApi();
        
        String name = twitterApi.userOperations().getUserProfile().getName();
        
        user.setName(name);
        
        return user;
    }
    
    
    /**
     * Handles users who've logged in via Facebook
     */
    private User getFacebookUser(Connection<?> connection) {
        User user = new User();
        Facebook facebookApi = (Facebook)connection.getApi();
        
        String name = facebookApi.userOperations().getUserProfile().getName();
        
        user.setName(name);
        
        return user;
    }
}