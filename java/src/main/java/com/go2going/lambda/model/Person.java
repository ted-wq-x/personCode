package com.go2going.lambda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.function.Function;

@Data
@Builder
@AllArgsConstructor
public class Person {

    private String name="wq";

    private Integer age;

    public String print(Function<Person,String> f){

       return f.apply(this);
    }
}
