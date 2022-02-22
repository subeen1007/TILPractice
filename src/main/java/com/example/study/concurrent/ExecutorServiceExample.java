package com.example.study.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
    //ExecutorServiceExample 예시
    public static void main(String[] args) {
        ExecutorService execService = Executors.newFixedThreadPool(2);
        execService.execute(new MyTask("TODO 1"));
        execService.execute(new MyTask("TODO 2"));
        execService.execute(new MyTask("TODO 3"));
    }
}

class MyTask implements Runnable {
    private String id;

    @Override
    public void run() {
        for(int i=0; i<5; i++){
            System.out.println("Task ID : " + id  + ", running ... " + i);

            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public MyTask(String id) {
        this.id = id;
    }
}