package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_492<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/7 0007 14:01
 */
public class LeetCode_492 {

    /**
     * 479中的方法，isFactorable方法的变体
     * @param area
     * @return
     */
    public int[] constructRectangle(int area) {

        long mid = (long) Math.sqrt(area);

        long l = mid, r = mid, t = l * r;

        while (t != area) {

            if (t < area) {
                r++;
            } else {
                l--;
            }

            t = l * r;
        }

        return new int[]{(int) r, (int) l};
    }

    public int[] constructRectangle1(int area) {
        int w = (int)Math.sqrt(area);
        while( area%w != 0 ) w--;
        return new int[]{ area/w, w };
    }
}
