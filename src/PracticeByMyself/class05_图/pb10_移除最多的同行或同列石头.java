package PracticeByMyself.class05_图;

import java.util.HashMap;

/**
 * @author Martin
 * @date 2025/1/18 14:49
 * @description <a href="https://leetcode.cn/problems/most-stones-removed-with-same-row-or-column/">...</a>
 * 思路1：一个连通分量，必然可以通过裁减结点到只剩下一个结点，就跟剪线一样，这个结论要记住。
 */

public class pb10_移除最多的同行或同列石头 {

    public static void main(String[] args) {
//        int[][] stones = {
//                {0, 0},
//                {0, 1},
//                {1, 0},
//                {1, 2},
//                {2, 1},
//                {2, 2}
//        };

        int[][] stones = {
                {0, 1},
                {1, 0},
                {1, 1}
        };

        System.out.println(removeStones(stones));
    }

    public static int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFindSet unionFindSet = new UnionFindSet(n);
        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = stones[i][0], y = stones[i][1];

            if (row.containsKey(x)) {
                unionFindSet.union(i, row.get(x));
            } else {
                row.put(x, i);
            }
            if (col.containsKey(y)) {
                unionFindSet.union(i, col.get(y));
            } else {
                col.put(y, i);
            }
        }

        return n - unionFindSet.count;
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

        public boolean inConnected(int p, int q) {
            return find(p) == find(q);
        }
    }
}
