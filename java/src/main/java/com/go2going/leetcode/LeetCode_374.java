package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_374<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/1 0001 9:36
 */
public class LeetCode_374 extends GuessGame {

    public LeetCode_374(int num) {
        super(num);
    }

    public int guessNumber(int n) {

        int min = 1, max = n;

        while (min <= max) {
//            int mid = (min + max) / 2; 会超时,会超过integr的最大值，造成溢出，从而循环无法终止
            int mid = min+(max-min ) / 2;//不超时
            int guess = guess(mid);
            if (guess == 1) {
                min = mid + 1;

            } else if (guess == -1) {
                max = mid - 1;
            } else {
                return mid;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        LeetCode_374 game = new LeetCode_374(6);
        System.out.println(game.guessNumber(10));
    }
}

class GuessGame {

    private int num;

    public GuessGame(int num) {
        this.num = num;
    }

    public int guess(int n) {
        if (this.num == n) {
            return 0;
        } else if (this.num > n) {
            return -1;
        } else {
            return 1;
        }
    }

}
