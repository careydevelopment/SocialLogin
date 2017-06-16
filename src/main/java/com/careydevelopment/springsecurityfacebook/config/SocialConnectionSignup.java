package com.careydevelopment.springsecurityfacebook.config;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

@Service
public class SocialConnectionSignup implements ConnectionSignUp {

//    @Autowired
//    private UserRepository userRepository;

    @Override
    public String execute(Connection<?> connection) {
//        System.out.println("signup === ");
//        final User user = new User();
//        user.setUsername(connection.getDisplayName());
//        user.setPassword(randomAlphabetic(8));
//        userRepository.save(user);
//        return user.getUsername();
        return "user";
    }

}
