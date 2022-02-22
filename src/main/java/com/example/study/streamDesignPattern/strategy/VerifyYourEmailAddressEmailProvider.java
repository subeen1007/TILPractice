package com.example.study.streamDesignPattern.strategy;

import com.example.study.streamDesignPattern.builder.User;

public class VerifyYourEmailAddressEmailProvider implements EmailProvider{

    @Override
    public String getEmail(User user) {
        return "'Verify Your Email Address' email for " + user.getName();
    }
}
