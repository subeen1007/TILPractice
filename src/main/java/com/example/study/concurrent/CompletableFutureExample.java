package com.example.study.concurrent;

import java.util.Map;
import java.util.concurrent.*;

public class CompletableFutureExample {
    //CompletableFuture 사용예
    public static void main(String[] args) {
        //첫번쨰 Runnable 인터페이스 정의
        Runnable mainTask = () -> {
            try{
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Main Task : " + Thread.currentThread().getName());
        };

        //두번째 Runnable 인터페이스 정의
        Runnable subTask = ()-> System.out.println("Next Task : " + Thread.currentThread().getName());

        //ExecutorService를 정의
        ExecutorService exeService = Executors.newFixedThreadPool(2);
        CompletableFuture.runAsync(mainTask,exeService).thenRun(subTask);
        CompletableFuture.runAsync(mainTask,exeService).thenRun(subTask);
        CompletableFuture.runAsync(mainTask,exeService).thenRun(subTask);
        CompletableFuture.runAsync(mainTask,exeService).thenRun(subTask);

    }

    //비동기 처리 API
    public Future<Integer> calculatePriceAsync(Map condition){
        CompletableFuture<Integer> future = new CompletableFuture<>();
        //스레들르 생성하고 실행할 작업을 CompletableFuture에 등록
        new Thread( () -> {
            int price = calculatePrice(condition);
            //처리상태에 대한 레퍼런스를 등록
            future.complete(price);
        }).start();
        return future;
    }

    private int calculatePrice(Map condition) {
        return 0;
    }
}
