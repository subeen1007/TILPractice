package com.example.study.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args){
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6);
        int a =intList.stream().filter(i -> i > 3).mapToInt(j->j*2).sum();//.collect(Collectors.toList());
//        System.out.println(a);

        int res = intList.stream().collect(Collectors.summingInt(Integer::intValue));
//        System.out.println(res);

        //5.8.2 리듀스 연산의 이해
        //메소드 참조로 정의
        int sum3 = intList.stream().reduce(0,Integer::sum);
//        System.out.println(sum3);

        //람다표현식으로 정의
        int sum4 = intList.stream().reduce(0, (x,y)-> x+y);
//        System.out.println(sum4);

        //람다표현식 + 병렬처리
        int sum5 = intList.stream().parallel().reduce(0, Integer::sum);
//        System.out.println(sum5);

        int sum6 = intList.stream().reduce(0, StreamExample::debugArguments);
    }

    public static int debugArguments(int x, int y) {
        System.out.printf("x = %s, y= %s, sum = %s\n", x, y, x + y);
        return x + y;
    }
}
