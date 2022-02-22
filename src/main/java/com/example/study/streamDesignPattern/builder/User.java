package com.example.study.streamDesignPattern.builder;

import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;

@ToString
public class User {
    private int id;
    private String name;
    private String emailAddr;
    private boolean isVerified;
    private LocalDateTime createAt;
    private List<Integer> friendUserIds;

    public User(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.emailAddr = builder.emailAddr;
        this.isVerified = builder.isVerified;
    }

    public static Builder builder(int id, String name){
        return new Builder(id,name);
    }

    public static class Builder{
        private int id;
        private String name;
        public String emailAddr;
        public boolean isVerified;
        public LocalDateTime createAt;
        public List<Integer> friendUserIds;

        //stream 함수 사용
        public Builder with(Consumer<Builder> consumer){
            consumer.accept(this);
            return this;
        }

        private Builder(int id, String name){
            this.id = id;
            this.name = name;
        }
        public Builder emailAddr(String emailAddr){
            this.emailAddr = emailAddr;
            return this;
        }
        public Builder isVerified(boolean isVerified){
            this.isVerified = isVerified;
            return this;
        }

        public User build(){
            return new User(this);
        }


    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public List<Integer> getFriendUserIds() {
        return friendUserIds;
    }
}
