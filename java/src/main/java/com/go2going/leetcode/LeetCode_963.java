package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_963 {

    public static void main(String[] args) {
        LeetCode_963 leetCode_963 = new LeetCode_963();
        System.out.println(leetCode_963.minAreaFreeRect(Helper.StringToArray("[[0,1],[2,1],[1,1],[1,0],[2,0]]")));
    }

    /**
     * 27ms
     * 和这个解法思路一样，https://leetcode.com/problems/minimum-area-rectangle-ii/discuss/208361/JAVA-O(n2)-using-Map
     * 但是我在处理中心点和计算距离的时候计算方式不对导致
     *
     * @param points
     * @return
     */
    public double minAreaFreeRect(int[][] points) {
        int length = points.length;
        Map<Double, List<Side>> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int[] x = points[i];
                int[] y = points[j];
                Side e = new Side(x, y);
                List<Side> orDefault = map.getOrDefault(e.tan, new ArrayList<>());
                orDefault.add(e);
                map.put(e.tan, orDefault);
            }
        }
        double area = Double.MAX_VALUE;
        for (Map.Entry<Double, List<Side>> entry : map.entrySet()) {
            List<Side> value = entry.getValue();
            int size = value.size();
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    Side side = value.get(i);
                    Side side1 = value.get(j);
                    double length1 = side.length;
                    if (length1 == 0) {
                        continue;
                    }
                    double length2 = side1.length;
                    if (length1 != length2) {
                        continue;
                    }
                    int[] x = side.x;
                    int[] y = side.y;
                    int[] x1 = side1.x;
                    int[] y1 = side1.y;
                    double c = getLength2(x, x1);
                    double b = getLength2(y, x1);
                    double rectangle = isRectangle(x, y, x1, y1);
                    if (rectangle == -1) {
                        continue;
                    }
                    double p;
                    if (rectangle == c) {
                        p = b;
                    } else {
                        p = c;
                    }
                    if (p == 0) {
                        continue;
                    }
                    area = Math.min(Math.sqrt(p) * length1, area);
                }
            }
        }

        if (area == Double.MAX_VALUE) {
            return 0d;
        }
        return area;
    }

    /**
     * @param x
     * @param y
     * @param x1
     * @param y1
     * @return 对角线长度，-1表示不是矩形
     */
    private double isRectangle(int[] x, int[] y, int[] x1, int[] y1) {
        double centerX = (double)(x[0] + y[0] + x1[0] + y1[0]) / 4;
        double centerY =(double) (x[1] + y[1] + x1[1] + y1[1]) / 4;
        double[] center = {centerX, centerY};
        double length1 = getLength2(x, center);
        double length2 = getLength2(x, center);

        double length3 = getLength2(x1, center);
        double length4 = getLength2(y1, center);
        if (length1 != length2 || length2 != length3 || length3 != length4) {
            return -1;
        }
        return Math.max(getLength2(x,x1),getLength2(x,y1));
    }

    private double getLength2(int[] x, int[] y) {
        int abs = Math.abs(x[0] - y[0]);
        int abs1 = Math.abs(x[1] - y[1]);
        return Math.pow(abs, 2) + Math.pow(abs1, 2);
    }

    private double getLength2(int[] x, double[] y) {
        double abs= Math.abs(x[0] - y[0]);
        double abs1 = Math.abs(x[1] - y[1]);
        return Math.pow(abs, 2) + Math.pow(abs1, 2);
    }

    private class Side {
        int[] x;
        int[] y;
        double tan;
        double length;
        public Side(int[] x, int[] y) {
            this.x = x;
            this.y = y;
            int abs = x[0] - y[0];
            int abs1 = x[1] - y[1];

            if (abs == 0) {
                tan = -Math.PI / 2;
            } else if (abs1 == 0) {
                tan = -Math.PI / 2;
            } else {
                tan = (double) abs / abs1;
            }
            length = Math.sqrt(Math.pow(abs, 2) + Math.pow(abs1, 2));

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Side side = (Side) o;

            if (!Arrays.equals(x, side.x)) return false;
            return Arrays.equals(y, side.y);
        }

        @Override
        public int hashCode() {
            int result = Arrays.hashCode(x);
            result = 31 * result + Arrays.hashCode(y);
            return result;
        }


        @Override
        public String toString() {
            return "Side{" +
                    "x=" + Arrays.toString(x) +
                    ", y=" + Arrays.toString(y) +
                    ", tan=" + tan +
                    ", length=" + length +
                    '}';
        }
    }
}
