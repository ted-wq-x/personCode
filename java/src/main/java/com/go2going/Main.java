package com.go2going;


import java.util.Arrays;
import java.util.Random;

/**
 * @author BlueT
 * 2017/10/8 17:59
 */
public class Main {


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
        System.out.println(findTheDifference("ajkc", "akjhe"));

        System.out.println(0);
        //        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

//        System.out.println(Arrays.toString(compare(IntStream.of(random()).sorted().toArray(), IntStream.of(random()).sorted().toArray())));

//        Unsafe unsafe = Unsafe.getUnsafe();
    }

    public static int[] random(){
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
     * @param array1
     * @param array2
     * @return
     */
    public static int[] compare(int[] array1, int[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;

        int size = length1 + length2;
        int[] returnArray = new int[size];


        int index1=0;
        int index2 = 0;
        for (int i = 0; i <size ; i++) {
            if (index2 < length2 && index1 < length1) {
                if (array1[index1] >= array2[index2]) {
                    returnArray[i] = array2[index2++];
                } else  {
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
