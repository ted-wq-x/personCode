package com.go2going.lambda;

@FunctionalInterface
public interface Converter<F,T> {

    T convert(F f);

}
