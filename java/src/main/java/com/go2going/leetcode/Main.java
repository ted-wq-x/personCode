package com.go2going.leetcode;

import com.go2going.lambda.model.Person;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author BlueT
 * 2017/10/15 19:20
 */
public class Main {
    public static void main(String[] args) {


        int i = 2;
        int[] num = {1, 2, 3};

        swap(num, i--, 2);

        System.out.println(i);
    }

    private static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }


    public static void say(List<Person> list ){
        list.forEach(System.out::println);
    }

    public static String getUnicode(String str) {
        char[] cs = str.toCharArray();
        String result = "";
        for (char c : cs) {
            String s = Integer.toHexString(c);
            if (s.length() == 2) {
                s = "\\u00" + s;
            } else {
                s = "\\u" + s;
            }
            result += s;
        }
        return result;
    }


    public int longestUnivaluePath(TreeNode root) {
        int[] res = new int[1];

        if (root != null) {
            test(root, res);
        }
        return res[0];
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int test(TreeNode root, int[] res) {
        int l = root.left != null ? test(root.left, res) : 0;
        int r = root.right != null ? test(root.right, res) : 0;
        int left = root.left != null && root.left.val == root.val ? l + 1 : 0;
        int right = root.right != null && root.right.val == root.val ? r + 1 : 0;
        res[0] = Math.max(res[0], left + right);
        return Math.max(left, right);
    }
}
class Rectangle{
    public static void main(String[] args) {
        print(pp(5));
    }

    /**
     * N>0
     * 打印N*N正方形矩阵，矩阵中每个元素从0-9，从左上角开始，0为第一个数字，顺时针方向，直到中间为止
     * @param N
     * @return
     */
    public static int[][] pp(int N) {
        int[][] ans = new int[N][N];

        // 记录当前的位置
        int hIndex = 0, lIndex = 0;

        //边界
        int l = 0, r = N, up = 0, down = N;

        //方向
        String status = "right";

        for (int i = 0; i <= 9; i++) {
            ans[hIndex][lIndex] = i;
            if (i == 9) {
                i = -1;
            }
            if (status.equals("right")) {
                //    右--下
                if (lIndex + 1 >= r) {
                    status = "down";
                    hIndex++;
                    up++;
                } else {
                    lIndex++;
                }

            } else if (status.equals("left")) {
                //    左--上
                if (lIndex - 1 < l) {
                    status = "up";
                    hIndex--;
                    down--;
                } else {
                    lIndex--;
                }

            } else if (status.equals("up")) {
                //    上--右
                if (hIndex - 1 < up) {
                    status = "right";
                    lIndex++;
                    l++;
                } else {
                    hIndex--;
                }
            } else if (status.equals("down")) {
                // 下--左
                if (hIndex+1 >= down) {
                    status = "left";
                    lIndex--;
                    r--;
                } else {
                    hIndex++;
                }
            }


            if (l == r||down==up) {
                break;
            }


        }
        return ans;
    }

    private static void print(int[][] p) {
        for (int i = 0; i < p.length; i++) {
            System.out.println(Arrays.toString(p[i]));
        }
        System.out.println();
    }
}
