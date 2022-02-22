package com.example.study.streamDesignPattern.builder;

public class BuilderPattern {

public static void main(String[] args) {
        User user = User.builder(1, "Alice")
                .emailAddr("@gmail.com")
                .isVerified(true)
                .build();

        //Stream Consumer사용
        User user2 = User.builder(1, "Alice")
                .with(builder -> {
                    builder.emailAddr = "alice@gmail.com";
                    builder.isVerified = true;
                })
                .build();
        System.out.println(user2);
}
}

