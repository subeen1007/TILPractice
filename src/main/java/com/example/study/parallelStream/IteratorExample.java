package com.example.study.parallelStream;

import java.util.Iterator;
import java.util.List;

public class IteratorExample {
    //Iterator 예시
    public static void main(String[] args) {
        List<HelloPerson> personList = HelloPerson.getSampleDate();

        Iterator<HelloPerson> peopleIterator = personList.iterator();

        while (peopleIterator.hasNext()){
            HelloPerson person = peopleIterator.next();
            System.out.println(person);
        }
    }
}
