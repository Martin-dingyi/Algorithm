package PracticeByMyself.class05_图;

/**
 * @author Martin
 * @date 2025/1/18 13:35
 * @description <a href="https://leetcode.cn/problems/number-of-provinces/">...</a>
 */

public class pb08_省份数量 {

    public static void main(String[] args) {
        int[][] graph = {
                {1,0,0},
                {0,1,0},
                {0,0,1}
        };
        System.out.println(findCircleNum_dfs(graph));
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFindSet unionFindSet = new UnionFindSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    unionFindSet.union(i, j);
                }
            }
        }
        return unionFindSet.count;
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

    public static int findCircleNum_dfs(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(isConnected, i, visited);
            }
        }

        return count;
    }

    static void dfs(int[][] graph, int s, boolean[] visited) {
        visited[s] = true;
        for (int i = 0; i < graph[s].length; i++) {
            if (graph[s][i] == 1 && !visited[i]) {
                dfs(graph, i, visited);
            }
        }
    }


}
