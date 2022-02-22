package com.example.study.streamDesignPattern.strategy;

import com.example.study.streamDesignPattern.builder.User;
import com.example.study.streamDesignPattern.strategy.EmailProvider;

public class MakeMoreFriendsEmailProvider implements EmailProvider {
    @Override
    public String getEmail(User user) {
        return "'Make More Friends' email for " + user.getName();
    }
}
