package com.go2going.lambda.model;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;

import java.util.Random;
import java.util.function.Function;

public class Person {

    private static Random random = new Random();


    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.type = random.nextInt(10);
    }

    public Person(String name) {
        this.name = name;
        this.age = random.nextInt(100);
        this.type = random.nextInt(2);
    }
    public Person() {
    }

    private String name = "wq";

    private Integer age;

    private Integer type;

    public Integer getType() {
        return type;
    }

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
                ", type=" + type +
                '}';
    }
}
