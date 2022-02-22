package com.example.study.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * 병렬처리 코드 짜는 순서
 * 1. 스레드 풀 생성
 * 2. 해당 스레드 풀에 대해 submit/execute 메소드로 Callable 또는 Runnable 인터페이스를 등록 및 실행
 * 3. 2의 값을 Future또는 CompletableFuture값으로 받음
 * */
public class FutureExample {
    //제곱을 계산하는 Callable객체를 생성
    public Callable<Long> calSquare(long value){
        Callable<Long> callable = new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                Long returnValue = value * value;
                TimeUnit.SECONDS.sleep(1);
                System.out.println(value + "의 제곱근은 " + returnValue);
                return returnValue;
            }
        };
        return callable;
    }

    public void executeTest(){
        List<Long> sampleDataList = Arrays.asList(1L,2L,3L,4L,5L,6L);
        List<Future<Long>> futureList = new ArrayList<>();

        //스레드 풀 생성, 고정 스레드 풀 이용
        ExecutorService exeService = Executors.newFixedThreadPool(4);

        //Callable 객체 생성 후, 스레드 풀에 등록
        //등록된 스레드에 대해 Future 객체를 리턴받는다
        for(Long sampleValue : sampleDataList){
            Future<Long> future = exeService.submit(calSquare(sampleValue));
            futureList.add(future);
        }

        Long sumValue = 0L;

        //Future의 목록의 결과를 확인한다
        for(Future<Long> future : futureList){
            try{
                //결과를 읽어 들일때까지 대기한다
                //대기하는 동안, 스레드가 계산을 하고 값을 리턴한다.
                sumValue += future.get();
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("최종합계 : " + sumValue);

        exeService.shutdown();
    }

    public static void main(String[] args) {
        FutureExample futureExample = new FutureExample();
        futureExample.executeTest();
    }
}
