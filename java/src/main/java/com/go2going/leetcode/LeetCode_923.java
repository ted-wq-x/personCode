package com.go2going.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode_923 {
    private static int PP = 1_000_000_007;


    public static void main(String[] args) {
       int[] a= new int[]{18,73,19,19,55,88,6,34,21,75
        };
        System.out.println(new LeetCode_923().threeSumMulti(a, 58));
    }

    /**
     * 56.31%
     * @param A
     * @param target
     * @return
     */
    public int threeSumMulti(int[] A, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            Integer integer = map.get(i);
            if (integer == null) {
                integer = 0;
            }
            integer++;
            map.put(i, integer);
        }


        Set<Integer> set = map.keySet();

        Integer[] ints = new Integer[set.size()];
        set.toArray(ints);
        Set<Tm> temp=new HashSet<>();

        int length = ints.length;
        Arrays.sort(ints);
        for (int i = 0; i < length ; i++) {
            int t1 = target - ints[i];
            if (t1 < 0 || t1 < ints[i]) {
                break;
            }
            for (int j = i ; j < length ; j++) {
                int t2 = t1 - ints[j];
                if (t2 < 0 || t2 < ints[j]) {
                    break;
                }
                if (ints[j] == t2) {
                    temp.add(new Tm(ints[i], ints[j], ints[j]));
                }
                for (int k = j ; k < length; k++) {
                    if (t2 == ints[k]) {
                        temp.add(new Tm(ints[i], ints[j], ints[k]));
                        break;
                    } else if (ints[k] > t2) {
                        break;
                    }
                }
            }
        }

        long res = 0;
        for (Tm t : temp) {
            int i = t.i;
            int j = t.j;
            int k = t.k;
            if (i == j && j == k) {
                Integer n = map.get(i);
                res += (long)(n - 2) * (long)(n - 1) *(long) n / 6;
                continue;
            }

            if (i == j) {
                Integer count = map.get(i);
                res+=(long)(count) * (long)(count - 1)/2* (long)map.get(k);
                continue;
            }

            if (j == k) {
                Integer count = map.get(j);
                res+=(long)(count) * (long)(count - 1)/2*(long) map.get(i);
                continue;
            }

            res += (long) map.get(i) * (long)map.get(j) * (long)map.get(k);

        }

        return (int)(res%PP);
    }


    /**
     * fuck 范围条件没用上
     * @param A
     * @param target
     * @return
     */
    public int threeSumMulti2(int[] A, int target) {
        long[] c = new long[101];
        for (int a : A) c[a]++;
        long res = 0;
        for (int i = 0; i <= 100; i++)
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0) continue;
                if (i == j && j == k)
                    res += c[i] * (c[i] - 1) * (c[i] - 2) / 6;
                else if (i == j && j != k)
                    res += c[i] * (c[i] - 1) / 2 * c[k];
                else if (j < k)
                    res += c[i] * c[j] * c[k];
            }
        return (int)(res % (1e9 + 7));
    }

    class Tm{
        int i;
        int j;
        int k;

        public Tm(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Tm tm = (Tm) o;

            if (i != tm.i) return false;
            if (j != tm.j) return false;
            return k == tm.k;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            result = 31 * result + k;
            return result;
        }
    }


}
