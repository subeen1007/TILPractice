package com.example.study.concurrent;

import java.util.concurrent.Executor;

public class ExecutorExample implements Executor {

    @Override
    public void execute(Runnable command) {
        command.run();
    }

    public static void main(String[] args) {
        Executor executor = new ExecutorExample();
        executor.execute(()->System.out.println("hihi"));
    }
}
