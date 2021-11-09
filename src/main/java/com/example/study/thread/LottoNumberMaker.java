package com.example.study.thread;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class LottoNumberMaker extends Thread {
    private final List<Integer> lottoNumberList;
    private final CountDownLatch countDownLatch;

    // 생성자로 공용 객체들을 받아준다
    public LottoNumberMaker(List<Integer> lottoNumberList, CountDownLatch countDownLatch) {
        this.lottoNumberList = lottoNumberList;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        int number;

        // 생성한 번호가 중복이 아닐 때 까지 생성
        do {
            number = new Random().nextInt(45) + 1;
            System.out.println(this.getName() + " make a number " + number);
        } while (lottoNumberList.contains(number));

        // 리스트에 번호를 추가하고 스레드가 종료되기 전에 카운트 다운
        lottoNumberList.add(number);
        countDownLatch.countDown();
    }
}
