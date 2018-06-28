package com.go2going.leetcode;

import java.util.*;

/**
 * https://www.youtube.com/watch?v=OFkLC30OxXM
 */
public class LeetCode_675 {

    private int hang;
    private int lie;

    /**
     * 最短路径问题（使用bfs算法计算）：按照树的高度排序，然后找到个点的最短路径，如果早不到最短路径，那么-1，结果就是最短路径和
     * <p>
     * BFS:time O(mn)
     * 总TIME：O(mn*mn)（最多有mn个树）
     * space:O(mn)
     * <p>
     * 初始位置：(0,0)
     * 0:不能走
     * 1：草地
     * >1:树
     * 砍树，后变为1
     * 砍树顺序：树的高度由低到高
     *
     * @param forest
     * @return
     */
    public int cutOffTree(List<List<Integer>> forest) {
        hang = forest.size();
        lie = forest.get(0).size();

        //树排序，默认是升序
        Map<Integer, Node> map = new TreeMap<>();
        for (int i = 0; i < forest.size(); i++) {
            List<Integer> list = forest.get(i);
            for (int j = 0; j < list.size(); j++) {
                Integer m = list.get(j);
                if (m > 1) {
                    map.put(m, new Node(i, j));
                }
            }
        }
        int x = 0, y = 0, steps = 0;

        Iterator<Map.Entry<Integer, Node>> iterator = map.entrySet().iterator();

        //获取到达每个树的最短路径
        while (iterator.hasNext()) {
            Map.Entry<Integer, Node> next = iterator.next();
            Node value = next.getValue();
            int i = value.x;
            int j = value.y;
            int step = BFS(x, y, i, j, forest);
            if (step == -1) {
                return -1;
            }
            //cut tree
            // forest.get(i).set(j, 1);
            steps += step;
            //更改当前位置
            x = i;
            y = j;
        }

        return steps;
    }

    /**
     * 左右下上
     */
    private static final int[][] helper = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 深度优先算法,二维数组最短路径
     * 0为障碍物
     *
     * @param x      起点
     * @param y      起点
     * @param i      终点
     * @param j      终点
     * @param forest
     * @return 最低步数
     */
    private int BFS(int x, int y, int i, int j, List<List<Integer>> forest) {

        int[][] visited = new int[hang][lie];

        //保存每一步，可以走的位置
        //因为是按照步数计算的，所以最新到达目标位置的，就是最短路径
        LinkedList<Node> q = new LinkedList<>();

        q.push(new Node(x, y));

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            //这一步可以遍历的位置，因为下面的代码也在push，没有这个判断就超过了
            while (size-- > 0) {
                Node pop = q.pop();
                int xx = pop.x;
                int yy = pop.y;
                if (xx == i && yy == j) {
                    return steps;
                }

                for (int i1 = 0; i1 < 4; i1++) {
                    int mx = xx + helper[i1][0];
                    int my = yy + helper[i1][1];
                    if (mx < 0 || my < 0 || mx >= hang || my >= lie || forest.get(mx).get(my) == 0 || visited[mx][my] == 1) {
                        continue;
                    }
                    visited[mx][my] = 1;
                    q.addLast(new Node(mx,my));
                }
            }
            steps++;
        }

        return -1;
    }

    class Node {

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
    }

    public static void main(String[] args) {
        LeetCode_675 leetCode_675 = new LeetCode_675();
        int i = leetCode_675.cutOffTree(new ArrayList<List<Integer>>() {
            {
                add(new ArrayList<>(Arrays.asList(1, 2, 3)));
                add(new ArrayList<>(Arrays.asList(0, 0, 4)));
                add(new ArrayList<>(Arrays.asList(7, 6, 5)));
            }
        });
        System.out.println(i);
    }
}
