package com.go2going.careful;

import java.util.HashSet;
import java.util.Set;

/**
 * 结论：set是使用的对象的hash，而person对象hash使用的是三个属性，所以将其放到set中之后，改变对象的属性，那原有set中的hash不会改变，但是删除的时候就找不到这个hash了
 */
public class ModifySetEle {
    static class Person {
        private String name;
        private String pwd;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public int hashCode() {
            return "".hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", pwd='" + pwd + '\'' +
                    ", age=" + age +
                    '}';
        }

        public Person(String name, String pwd, Integer age) {
            this.name = name;
            this.pwd = pwd;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Set<Person> set = new HashSet<Person>();
        Person p1 = new Person("唐僧", "pwd1", 25);
        Person p2 = new Person("孙悟空", "pwd2", 26);
        Person p3 = new Person("猪八戒", "pwd3", 27);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println("总共有:" + set.size() + " 个元素!"); //结果：总共有:3 个元素!
        p3.setAge(2); //修改p3的年龄,此时p3元素对应的hashcode值发生改变

        set.remove(p3); //此时remove不掉，造成内存泄漏

        set.add(p3); //重新添加，居然添加成功
        System.out.println("总共有:" + set.size() + " 个元素!"); //结果：总共有:4 个元素!
        for (Person person : set) {
            System.out.println(person);
        }
    }
}
