package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_479<br>
 * 描述：挺难的
 *
 * @author wangqiang
 * 创建时间：  2017/12/6 0006 20:42
 */
public class LeetCode_479 {
    public int largestPalindrome(int n) {
        // if input is 1 then max is 9
        if(n == 1){
            return 9;
        }

        // if n = 3 then upperBound = 999 and lowerBound = 99
        int upperBound = (int) Math.pow(10, n) - 1, lowerBound = upperBound / 10;
        long maxNumber = (long) upperBound * (long) upperBound;

        // represents the first half of the maximum assumed palindrom.
        // e.g. if n = 3 then maxNumber = 999 x 999 = 998001 so firstHalf = 998
        int firstHalf = (int)(maxNumber / (long) Math.pow(10, n));

        boolean palindromFound = false;
        long palindrom = 0;

        while (!palindromFound) {
            // creates maximum assumed palindrom
            // e.g. if n = 3 first time the maximum assumed palindrom will be 998 899
            palindrom = createPalindrom(firstHalf);

            // here i and palindrom/i forms the two factor of assumed palindrom
            for (long i = upperBound; upperBound > lowerBound; i--) {
                // if n= 3 none of the factor of palindrom  can be more than 999 or less than square root of assumed palindrom
                if (palindrom / i > maxNumber || i * i < palindrom) {
                    break;
                }

                // if two factors found, where both of them are n-digits,
                if (palindrom % i == 0) {
                    palindromFound = true;
                    break;
                }
            }

            firstHalf--;
        }

        return (int) (palindrom % 1337);
    }

    private long createPalindrom(long num) {
        String str = num + new StringBuilder().append(num).reverse().toString();
        return Long.parseLong(str);
    }


    public int largestPalindrome1(int n) {
        if (n == 1)
            return 9;
        long max = (long)Math.pow(10, n)-1;
        long min = max/10+1;
        long t = 0;
        for (long num = max - 1; num >= min; num--) {
            t = makePalindrome(num);
            if (isFactorable(t, max, min)) {
                return (int)(t % 1337);
            }
        }
        return -1;
    }


    /**
     * 很棒的思路
     * 构造回文数,98->9889,sum每次*10+余数（从高位到低位），进行累积
     * @param num
     * @return
     */
    private long makePalindrome(long num) {
        long res = num;
        while (num > 0) {
            //98*10+98%10=988
            //988*10+9%10=9889
            res = res * 10 + num % 10;
            num /= 10;//从高位往低位取值,
        }
        return res;
    }

    /**
     * 判断构建的回文数是否符合条件
     * @param num
     * @param max
     * @param min
     * @return
     */
    public boolean isFactorable(long num, long max, long min) {
        //判断数字num，是否能由两个数字相乘得到
        //回文数开根号
        long mid = (long)Math.sqrt(num);

        //是否超出范围
        if (mid > max || mid < min)
            return false;

        long low = mid, high = mid, t = low * high;

        //如果开出来的是整数，那直接返回true
        while (t != num) {

            //在mid中间往两边取值
            if (t < num) {
                //同时判断是否越界
                if (++high > max)
                    return false;
            } else {
                //同时判断是否越界
                if (--low < min)
                    return false;
            }
            t = low * high;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_479 leetCode_479 = new LeetCode_479();
//        leetCode_479.largestPalindrome(2);
//        System.out.println(leetCode_479.makePalindrome(98));
        System.out.println(leetCode_479.isFactorable(98,100,0));
    }
}
