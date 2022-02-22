package com.example.study.parallelStream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class HelloPerson {
    private String firstName;
    private String lastName;
    private String country;

    public static List<HelloPerson> getSampleDate(){
        List<HelloPerson> person = new ArrayList<HelloPerson>();

        person.add(new HelloPerson("윤기", "장", "대한민국"));
        person.add(new HelloPerson("해라", "장", "미국"));
        person.add(new HelloPerson("해윤", "정", "중국"));
        person.add(new HelloPerson("애리", "노", "일본"));
        person.add(new HelloPerson("크롱", "장", "남극"));

        return person;
    }
}
