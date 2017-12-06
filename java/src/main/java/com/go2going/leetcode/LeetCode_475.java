package com.go2going.leetcode;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_475<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/6 0006 14:59
 */
public class LeetCode_475 {
    /**
     * 找出最小半径
     * @param houses
     * @param heaters 位置
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;

        for (int house : houses) {
            //返回值为插入位置x:-x-1
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1);
            }
            //房间能被覆盖的位置，左边和右边
            //index为插入位置，所以左边的需要-1
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

            //两个加温器之间的距离取最小值，result则取最大值（必须要全覆盖）
            result = Math.max(result, Math.min(dist1, dist2));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] c = new int[]{1, 4};
        System.out.println(Arrays.binarySearch(c, 2));
    }

}
