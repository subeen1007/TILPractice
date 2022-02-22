package com.example.study.concurrentCollection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ConcurrentCollectionExample {
    private BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    Runnable producer = () ->{
        try {
            TimeUnit.SECONDS.sleep(1);

            int num = ThreadLocalRandom.current().nextInt(0,100);
            queue.add(num);
            System.out.printf("생성한 항목 값 : %d, 큐 크기 : %d\n", num, queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    Runnable consumer = () -> {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.printf("소바한 항목값 : %d, 큐 크기 : %d\n", queue.take(), queue.size());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    public void getQueue(){
        System.out.println("@@큐 >> " + queue.size());
    }

    public void execute(int producersSize, int consumersSize){
        //생성자 스레드생성
        for(int i = 0; i<producersSize; i++){
            new Thread(producer, "생성자 "+ (i+1)).start();
        }

        //소비자 스레드 생성
        for (int i = 0; i<consumersSize; i++){
            new Thread(consumer, "소비자 "+(i+1)).start();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ConcurrentCollectionExample example = new ConcurrentCollectionExample();
        example.execute(7,9);
        Thread.sleep(5000L);
        example.getQueue();
    }
}
