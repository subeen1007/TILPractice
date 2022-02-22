package com.example.study.streamDesignPattern.strategy;

import com.example.study.streamDesignPattern.builder.User;

import java.util.Arrays;
import java.util.List;

public class Stretegy {
    public static void main(String[] args) {
        User user1 = User.builder(1,"Alice")
                .with(builder -> {
                    builder.emailAddr = "alice@gmail.com";
                    builder.isVerified = false;
                    builder.friendsUserIds = Arrays.asList(201,202,203,204,206,207);
                }).build();
        User user2 = User.builder(2,"Bob")
                .with(builder -> {
                    builder.emailAddr = "bob@gmail.com";
                    builder.isVerified = true;
                    builder.friendsUserIds = Arrays.asList(201,202);
                }).build();
        List<User> users = Arrays.asList(user1, user2);

        EmailSender emailSender = new EmailSender();
        EmailProvider verifyYourEmailAddressEmailProvider = new VerifyYourEmailAddressEmailProvider();
        EmailProvider makeMoreFriendsEmailProvider = new MakeMoreFriendsEmailProvider();

        emailSender.setEmailProvider(verifyYourEmailAddressEmailProvider);
        users.stream()
                .filter(user->!user.isVerified())
                .forEach(emailSender::sendEmail);

        System.out.println(user1);
        emailSender.setEmailProvider(makeMoreFriendsEmailProvider);
        users.stream()
                .filter(User::isVerified)
                .filter(user->user.getFriendsUserIds().size()<=5)
                .forEach(emailSender::sendEmail);

        emailSender.setEmailProvider(user->"'Play With Friends' email for "+ user.getName());
        users.stream()
                .filter(User::isVerified)
                .filter(user -> user.getFriendsUserIds().size()>5)
                .forEach(emailSender::sendEmail);
    }
}
