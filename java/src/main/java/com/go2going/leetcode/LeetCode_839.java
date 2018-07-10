package com.go2going.leetcode;

/**
 * hard
 */
public class LeetCode_839 {
    public static void main(String[] args) {
        LeetCode_839 leetCode_839 = new LeetCode_839();
        System.out.println(leetCode_839.numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}));
    }

    /**
     * union find
     * 只需要判断连个值是否只有两个字符不相等
     * lambda 2886ms
     * for 266ms
     *
     * @param A
     * @return
     */
    public int numSimilarGroups(String[] A) {

        int length = A.length;
        int a = A[0].length();
        UF uf = new UF(length);
        //双重for循环判断是否相似，是则union
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {

                int count = 0;
                for (int x = 0; x < a; x++) {
                    //优化
                    if (A[i].charAt(x) != A[j].charAt(x)&& ++count>2) {
                        break;
                    }
                }
                if (count == 0 || count == 2) {
                    uf.union(i, j);
                }

            }
        }
      /*  IntStream.range(0, length)
                .forEach(i ->
                        IntStream.range(i + 1, length)
                                .filter(j -> {
                                            // 判断是否是相似的
                                            long count = IntStream.range(0, a).filter(x ->
                                                    A[i].charAt(x) != A[j].charAt(x)
                                            ).count();
                                            return count == 2 || count == 0;
                                        }

                                )
                                .forEach(j ->
                                        uf.union(i, j)
                                )
                );*/

        return uf.findGroups();
    }

    class UF {

        /**
         * 秩，树的高度，值越小越好
         */
        private int[] rank;

        private int[] parent;

        public UF(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            this.rank = new int[n];
        }

        /**
         * 就是合并时永远把矮树作为高树的子树。
         *
         * @param x
         * @param y
         */
        public void union(int x, int y) {
            int i = find(x);
            int j = find(y);
            if (i == j) {
                return;
            }
            //保证秩小
            if (rank[i] > rank[j]) {
                //树合并，将小的树交给大的
                parent[j] = i;
            } else {
                parent[i] = j;
            }
            //注意只有根节点高度相同时需要更新height，因为两棵树高度不相等时矮的那棵至少比高的矮一层。
            //合并时都是以顶点开始，find方法就能看出
            if (rank[i] == rank[j]) {
                //因为上面的if等于时，是将i树+到j树上
                rank[j] += 1;
            }

        }


        /**
         * 查找根节点（得自己好好理解，联系初始化）
         *
         * @param x
         * @return
         */
        private int find(int x) {
            while (x != parent[x]) {
                x = parent[x];
            }
            return x;
        }

        /**
         * 查找森林的个数
         *
         * @return
         */
        private int findGroups() {
            int val = 0;
            for (int i = 0; i < parent.length; i++) {
                if (i == parent[i]) {
                    val++;
                }
            }
            return val;
        }
    }


}
