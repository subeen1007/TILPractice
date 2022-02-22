package com.example.study.parallelStream;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class InsideParalleStream {
    //병렬 스트림  API 사용 예
    public static void main1(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        //스레드 개수 2개로 설정
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");

        System.out.printf("####Thread Pool Size : %s\n", ForkJoinPool.getCommonPoolParallelism());
        //스트림 내부의 스레드 값을 구함
        intList.parallelStream().forEach(value -> {
            //현재 스레드의 이름을 구함
            String threadName = Thread.currentThread().getName();

            //스레드 이름과 데이터값을 출력
            LocalDateTime currentTime = LocalDateTime.now();
            System.out.printf(currentTime.format(formatter) +
                    " -> Thread Name : %s, Stream Value : %s\n", threadName, value
                    );

            //시간확인을 위해 2초간 sleep
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        //별도의 스레드 풀 생성
        ForkJoinPool customPool = new ForkJoinPool(2);
        customPool.submit(()-> {
            System.out.printf("####Thread Pool Size : %s\n", customPool.getParallelism());

            //스트림 내부의 스레드 값을 구함
            intList.parallelStream().forEach(value -> {
                //현재 스레드의 이름을 구함
                String threadName = Thread.currentThread().getName();

                //스레드 이름과 데이터값을 출력
                LocalDateTime currentTime = LocalDateTime.now();
                System.out.printf(currentTime.format(formatter) +
                        " -> Thread Name : %s, Stream Value : %s\n", threadName, value
                );

                //시간확인을 위해 2초간 sleep
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }).get();
    }
}
