package com.go2going.leetcode;

public class LeetCode_869 {
  /*  private static Map<Integer,Integer[][]> temp = new TreeMap<>();
    static {
        int max = (int) Math.pow(10,9);
        int index = 1;
        while (index <= max) {
            temp.put(index,toArray(index));
            index=index<<1;
        }

    }
*/
    private static Integer[][] toArray(int num) {
        Integer[][] ans = new Integer[10][1];
        while (num != 0) {
            int i = num % 10;
            Integer integer = ans[i][0];
            if (integer == null) {
                integer = 0;
            }
            ans[i][0]=integer+1;
            num /= 10;
        }
        return ans;
    }

    private static boolean equals(Integer[][] a1, Integer[][] a2) {
        for (int i = 0; i < 9; i++) {
            Integer i1 = a1[i][0];
            Integer i2 = a2[i][0];
            if (i1 == null && i2 == null) {
                continue;
            }
            if (i1==null|i2==null||!i1.equals(i2)) {
                return false;
            }
        }
        return true;
    }

    public boolean reorderedPowerOf2(int N) {
        int length = (N + "").length();
        Integer[][] eq = toArray(N);
        for (int i = 0; i < 31; i++) {
            int val = 1 << i;
            int length1 = (val + "").length();
            if (length1 > length) {
                break;
            } else if (length1 == length) {
                if (equals(eq, toArray(val))) {
                    return true;
                }
            }

        }
      /*  for (Map.Entry<Integer, Integer[][]> entry : temp.entrySet()) {
            Integer integer = entry.getKey();
            int length1 = (integer + "").length();
            if (length1 > length) {
                break;
            } else if (length1 == length) {
                if (equals(eq, entry.getValue())) {
                    return true;
                }
            }
        }*/

        return false;

    }

    public static void main(String[] args) {
        LeetCode_869 leetCode_869 = new LeetCode_869();
        System.out.println(leetCode_869.reorderedPowerOf2(1));
    }
}
