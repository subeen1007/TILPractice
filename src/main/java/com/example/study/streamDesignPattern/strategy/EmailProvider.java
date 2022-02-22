package com.example.study.streamDesignPattern.strategy;

import com.example.study.streamDesignPattern.builder.User;

public interface EmailProvider {
    String getEmail(User user);
}
