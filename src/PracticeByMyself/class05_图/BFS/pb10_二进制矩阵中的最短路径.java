package PracticeByMyself.class05_图.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Martin
 * @date 2025/2/8 16:57
 * @description <a href="https://leetcode.cn/problems/shortest-path-in-binary-matrix/description/">...</a>
 */

public class pb10_二进制矩阵中的最短路径 {

    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid)); // 2
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) {
            return -1;
        }
        int m = grid.length, n = grid[0].length;
        int step = 1;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curNode = queue.poll();
                assert curNode != null;
                if (curNode[0] == m - 1 && curNode[1] == n - 1) {
                    return  step;
                }
                List<int[]> neighbors = getNeighbors(curNode, grid);
                for (int[] neighbor : neighbors) {
                    int x = neighbor[0], y = neighbor[1];
                    if (visited[x][y]) continue;
                    visited[x][y] = true;
                    queue.offer(neighbor);
                }
            }
            step++;
        }
        return -1;
    }

    private static List<int[]> getNeighbors(int[] curNode, int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<int[]> res = new ArrayList<>();
        int x = curNode[0], y = curNode[1];
        if (x + 1 < m && grid[x + 1][y] != 1) res.add(new int[]{x + 1, y});
        if (x - 1 >= 0 && grid[x - 1][y] != 1) res.add(new int[]{x - 1, y});
        if (y + 1 < n && grid[x][y + 1] != 1) res.add(new int[]{x, y + 1});
        if (y - 1 >= 0 && grid[x][y - 1] != 1) res.add(new int[]{x, y - 1});
        if (x - 1 >= 0 && y + 1 < n && grid[x - 1][y + 1] != 1) res.add(new int[]{x - 1, y + 1});
        if (x + 1 < m && y + 1 < n && grid[x + 1][y + 1] != 1) res.add(new int[]{x + 1, y + 1});
        if (x + 1 < m && y - 1 >= 0 && grid[x + 1][y - 1] != 1)res.add(new int[]{x + 1, y - 1});
        if (x - 1 >= 0 && y - 1 >= 0 && grid[x - 1][y - 1] != 1) res.add(new int[]{x - 1, y - 1});
        return res;
    }

}
