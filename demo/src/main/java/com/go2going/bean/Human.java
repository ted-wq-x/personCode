package com.go2going.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Human<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/11 0011 17:00
 */
@Component
@Lazy(value = false)
public class Human {

    public Human() {
        name = "wq";
    }

    public static String name;

    private Human human;

    private static class HolderHuman {
        private static final Human human = new Human();
    }

    public Human getHuman() {
        return HolderHuman.human;
    }
}
