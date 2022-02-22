package com.example.study.parallelStream;

import java.util.List;
import java.util.Spliterator;

public class SpliteratorExample {
    //Spliterator 사용예
    public static void main(String[] args) {
        List<HelloPerson> personList = HelloPerson.getSampleDate();

        //Spliterator 객체 생성
        Spliterator<HelloPerson> spliterator = personList.spliterator();

        //순차 처리한다
//        spliterator.forEachRemaining((person) -> System.out.println(person));

//        personList.parallelStream().forEach((person) -> System.out.println(person));
    }

    //Spliterator에 포함된 데이터의 개수 예측
    public static void printSize(String name, Spliterator<HelloPerson> spliterator){
        System.out.printf("Estimated Size : (%s) : %s\n", name, spliterator.estimateSize());
    }

    //Spliterator에 데이터를 출력한다
    public static void printSpliterator(Spliterator<HelloPerson> spliterator){
        spliterator.forEachRemaining((person) -> System.out.printf("안녕~~ %s\n", person));
    }

    public static void main1(String[] args) {
        List<HelloPerson> personList = HelloPerson.getSampleDate();

        Spliterator<HelloPerson> spliterator1 = personList.spliterator();

        printSize("split1", spliterator1);
        //spliterator1을 분리한다
        Spliterator<HelloPerson> spliterator2 = spliterator1.trySplit();

        System.out.println("첫 번쨰 split 후 ");
        printSize("spilt1", spliterator1);
        printSize("spilt2", spliterator2);

        //spliterator1을 다시 분리한다
        Spliterator<HelloPerson> spliterator3 = spliterator1.trySplit();

        System.out.println("두 번쨰 split 후 ");
        printSize("spilt1", spliterator1);
        printSize("spilt2", spliterator2);
        printSize("spilt3", spliterator3);

        System.out.println("split1 출력~~~");
        printSpliterator(spliterator1);
        System.out.println("split2 출력~~~");
        printSpliterator(spliterator2);
        System.out.println("split3 출력~~~");
        printSpliterator(spliterator3);
    }
}


