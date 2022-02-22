package com.example.study.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PeriodTaskExample {
    //일정 시간 간격으로 스레드를 실행하는 예
    public static void main(String[] args) {
        //ScheduledExecutorService객체 생성
        ScheduledExecutorService exeService = Executors.newScheduledThreadPool(2);
        //1초 후 실행, 종료 후 반복실행X
        exeService.schedule(new MyTask("Delayed 1"), 1, TimeUnit.SECONDS);
        //3초 후 실행, 종료 후 1초 대기 후 반복실행
        exeService.scheduleWithFixedDelay(new MyTask("Delayed 1"), 3, 1, TimeUnit.SECONDS);
        //3초 후 실행, 1초 주기로 반복실행
        exeService.scheduleAtFixedRate(new MyTask("Rate 1"), 3,1,TimeUnit.SECONDS);
    }
}
