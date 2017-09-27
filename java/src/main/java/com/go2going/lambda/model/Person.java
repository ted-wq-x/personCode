package com.go2going.lambda.model;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;

import java.util.function.Function;

public class Person {

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    private String name = "wq";

    private Integer age;

    public String print(Function<Person, String> f) {

        return f.apply(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
