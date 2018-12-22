package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class LeetCode_406 {
    /**
     * 26ms
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {

        TreeSet<Person> set = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                int i = p2.tall - p1.tall;
                if (i == 0) {
                    return p1.preIndex - p2.preIndex;
                }
                return i;
            }
        });

        for (int[] person : people) {
            set.add(new Person(person[0], person[1]));
        }

        List<int[]> ans=new ArrayList<>();
        for (Person person : set) {
            int preIndex = person.preIndex;
            if (preIndex == 0) {
                ans.add( person.toArray());
            }
            for (int i = 0; i < ans.size(); i++) {
                if (preIndex == 0) {
                    ans.add(i, person.toArray());
                    break;
                }
                preIndex--;
            }
        }
        int length = people.length;

        int[][] ints = new int[length][2];
        for (int i = 0; i < ints.length; i++) {
            ints[i]=ans.get(i);
        }

        return ints;
    }

    class Person{
        int tall;
        int preIndex;

        public Person(int tall, int preIndex) {
            this.tall = tall;
            this.preIndex = preIndex;
        }

        public int[] toArray(){
            return new int[]{tall,preIndex};
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (tall != person.tall) return false;
            return preIndex == person.preIndex;
        }

        @Override
        public int hashCode() {
            int result = tall;
            result = 31 * result + preIndex;
            return result;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "tall=" + tall +
                    ", preIndex=" + preIndex +
                    '}';
        }
    }
}
