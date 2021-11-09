package com.example.study.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/** 스레드로 6개의 로또번호를 비동기로 동시에 중복 없이 만들고 오름차순으로 출력하는 프로그램 */
public class ThreadMain {
    // 로또번호 개수 상수로 설정
    private static final int LOTTO_NUMBERS = 6;

    public static void main(String[] args) throws InterruptedException {

        // 스레드들이 공용으로 사용 할 객체
        List<Integer> lottoNumberList = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(LOTTO_NUMBERS);

        System.out.println("making numbers ...");

        // 6개의 스레드를 만들고 실행
        for (int i = 0; i < LOTTO_NUMBERS; i++) {
            Thread lottoNumberMaker = new LottoNumberMaker(lottoNumberList, countDownLatch);
            lottoNumberMaker.start();
        }

        // 메인 스레드를 6개의 스레드가 종료되기까지 대기시킴
        countDownLatch.await();

        System.out.println("--------------\nresult numbers");

        lottoNumberList.stream()
                .sorted()
                .forEach(System.out::println);

    }
}
