package com.go2going.lambda;

import com.go2going.lambda.model.Teacher;

@FunctionalInterface
public interface PersonFactory<T extends Teacher> {
    T create(String name,Integer age);
}
