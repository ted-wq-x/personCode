package com.go2going;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author BlueT
 * 2017/10/8 17:59
 */
public class Main {

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


    public static char findTheDifference(String s, String t) {
        char c = 0;
        for (int i = 0; i < s.length(); ++i) {
            c ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            c ^= t.charAt(i);
        }

        return c;
    }

    public static boolean isSame(String s1, String s2) {
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        char[] chars1 = s2.toCharArray();
        Arrays.sort(chars1);
        return Arrays.toString(chars).equals(Arrays.toString(chars1));
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

    public static int[] random() {
        Random random = new Random();
        int size = random.nextInt(30);
        int[] retunrArray = new int[size];


        for (int i = 0; i < size; i++) {
            retunrArray[i] = random.nextInt(200);
        }

        return retunrArray;
    }

    /**
     * 从小到大,数组合并
     *
     * @param array1
     * @param array2
     * @return
     */
    public static int[] compare(int[] array1, int[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;

        int size = length1 + length2;
        int[] returnArray = new int[size];


        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < size; i++) {
            if (index2 < length2 && index1 < length1) {
                if (array1[index1] >= array2[index2]) {
                    returnArray[i] = array2[index2++];
                } else {
                    returnArray[i] = array1[index1++];
                }
            } else if (index1 < length1) {
                returnArray[i] = array1[index1++];
            } else if (index2 < length2) {
                returnArray[i] = array2[index2++];
            }
        }


        return returnArray;
    }
}
