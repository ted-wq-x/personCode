package com.go2going.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_773<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/2/11 0011 12:41
 */
public class LeetCode_773 {

    /**
     *
     * https://www.youtube.com/watch?v=ABSjW0p3wsM
     * 参考在discuss中的解
     * 每次移动都包含0，只能和上下左右进行交换，BFS
     *
     * @param board
     * @return
     */
    public int slidingPuzzle(int[][] board) {

        String target = "123450";

        StringBuilder sb = new StringBuilder();

        int length = board.length;
        int height = board[0].length;


        //将参数数组转换成字符串
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                sb.append(board[i][j]);
            }
        }
        String str = sb.toString();

        //避免queue重复，防止重复急速
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        set.add(str);
        queue.offer(str);

        //移动的四个方向，上下左右
        int[] move = {-3, 3, -1, 1};

        int ret = 0;

        while (!queue.isEmpty()) {


            //不能使用i++，因为每次遍历的size都会重新计算
            for (int i = queue.size(); i >0 ; --i) {
                String poll = queue.poll();

                if (poll.equals(target)) {
                    return ret;
                }

                //0的位置
                int index0 = poll.indexOf("0");

                for (int j = 0; j < 4; j++) {
                    int i1 = index0 + move[j];
                    //避免非法的交换,两行数组交界处也是非法的
                    if (i1 > 5 || i1 < 0 || (index0 == 2 && i1 == 3) || (index0 == 3 && i1 == 2)) {
                        continue;
                    }

                    //位置交换
                    char[] chars = poll.toCharArray();
                    char l = chars[index0];
                    chars[index0] = chars[i1];
                    chars[i1] = l;


                    String s = String.valueOf(chars);
                    //如果未包含该元素
                    if (set.add(s)) {
                        queue.offer(s);
                    }
                }
            }
            //每一次queue弹出当前所有的数，进行一次模拟，所以当相等返回时ret，就是最小的值
            ret++;
        }

        return -1;
    }


    public static void main(String[] args) {
        LeetCode_773 leetCode_773 = new LeetCode_773();
        System.out.println(leetCode_773.slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}}));

    }
}
