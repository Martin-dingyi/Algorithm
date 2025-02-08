package PracticeByMyself.class05_图;

import java.util.*;

/**
 * @author Martin
 * @date 2025/1/19 15:45
 * @description <a href="https://leetcode.cn/problems/min-cost-to-connect-all-points/description/">...</a>
 */

public class pb11_连接所有点的最小费用 {

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(minCostConnectPoints(points)); // 20
    }

    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // 计算出所有结点之间的曼哈顿距离，key中list，存储point在points中的地址下标
        // 使用优先级队列存储边及其距离
        PriorityQueue<Map.Entry<List<Integer>, Integer>> twoPointsToDistance = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );

        // 计算出所有结点之间的曼哈顿距离，key中list，存储point在points中的地址下标
        for (int i = 0; i < n; i++) {
            int[] pointA = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] pointB = points[j];
                List<Integer> twoPointIndexList = Arrays.asList(i, j);
                int distance = Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
                twoPointsToDistance.offer(Map.entry(twoPointIndexList, distance));
            }
        }

        // 使用Kruskal算法构建最小生成树
        UnionFindSet unionFindSet = new UnionFindSet(n);
        int mst = 0;
        while (unionFindSet.count != 1 || !twoPointsToDistance.isEmpty()) {
            Map.Entry<List<Integer>, Integer> listDoubleEntry = twoPointsToDistance.poll();
            assert listDoubleEntry != null;
            List<Integer> twoPointIndexList = listDoubleEntry.getKey();
            int pointAIndex = twoPointIndexList.get(0);
            int pointBIndex = twoPointIndexList.get(1);
            if (!unionFindSet.isConnected(pointAIndex, pointBIndex)) {
                mst += listDoubleEntry.getValue();
                unionFindSet.union(pointAIndex, pointBIndex);
            }
        }
        return mst;
    }

    private static class UnionFindSet {
        private final int[] parent;
        private int count;

        public UnionFindSet(int n) {
            parent = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            count = n;
        }

        public void union(int p, int q) {
            int rootP = find(p), rootQ = find(q);
            if (rootP != rootQ) {
                parent[rootP] = rootQ;
                count--;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }
}
