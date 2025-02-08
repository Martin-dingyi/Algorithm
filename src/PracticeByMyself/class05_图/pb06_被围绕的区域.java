package PracticeByMyself.class05_图;

import java.util.Arrays;

/**
 * @author Martin
 * @date 2025/1/16 16:36
 * @description <a href="https://leetcode.cn/problems/surrounded-regions/">...</a>
 * 思路1：使用并查集将'O'分类，然后在遍历矩阵，将所有被分到内部的'O'转成‘X’
 */

public class pb06_被围绕的区域 {

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    public static void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        Union union = new Union(m * n + 1);
        // 将所有外部的O都用一个虚拟结点标识起来
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                union.union(m * n, i);
            }
            if (board[m - 1][i] == 'O') {
                union.union(m * n, (m - 1) * n + i);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                union.union(m * n, i * n);
            }
            if (board[i][n - 1] == 'O') {
                union.union(m * n, i * n + n - 1);
            }
        }

        // 方向数组 d 是上下左右搜索的常用手法
        int[][] d = new int[][]{{1,0}, {0,1}, {0,-1}, {-1,0}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0], y = j + d[k][1];
                        if (board[x][y] == 'O') {
                            union.union(i * n + j, x * n + y);
                        }
                    }

                }
            }
        }

        // 所有不被标记的O集合，都改成X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!union.connected(i * n + j, m * n)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static class Union {
        // 记录连通分量
        private int count;
        // 记录各个结点的父节点，节点 x 的父节点是 parent[x]
        private final int[] parent;

        // 构造函数，n 为图的节点总数
        public Union(int n) {
            // 一开始互不连通
            this.count = n;
            // 父节点指针初始指向自己
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        // 将两棵树联合
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;

            parent[rootQ] = rootP;
            count--;
        }

        // 返回某个节点 x 的根节点，并进行路径压缩
        private int find(int x) {
            // 根节点的 parent[x] == x
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        // 检查两个节点是否连通
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        // 返回当前的连通分量个数
        public int count() {
            return count;
        }
    }
}
