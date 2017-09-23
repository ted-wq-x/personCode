package com.go2going.lambda.model;

import lombok.Builder;
import lombok.Data;

import java.util.function.Function;

@Data
@Builder
public class Person {

    private String name="wq";

    public String print(Function<Person,String> f){

       return f.apply(this);
    }
}
