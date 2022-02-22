package com.example.study.streamDesignPattern.strategy;

import com.example.study.streamDesignPattern.builder.User;

public class EmailSender {
    private EmailProvider emailProvider;

    public EmailSender setEmailProvider(EmailProvider emailProvider){
        this.emailProvider = emailProvider;
        return this;
    }

    public void sendEmail(User user){
        String email = emailProvider.getEmail(user);
        System.out.println("Sending "+email);
    }
}
