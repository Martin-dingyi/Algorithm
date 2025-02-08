package PracticeByMyself.class05_图.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Martin
 * @date 2025/2/8 16:41
 * @description <a href="https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/description/">...</a>
 */

public class pb09_迷宫中离入口最近的出口 {

    public static void main(String[] args) {

    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int step = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curNode = queue.poll();
                assert curNode != null;
                if (step != 0 && (curNode[0] == m - 1 || curNode[1] == n - 1 || curNode[0] == 0 || curNode[1] == 0)) {
                    return step;
                }
                List<int[]> neighbors = getNeighbors(maze, curNode);
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

    private List<int[]> getNeighbors(char[][] maze, int[] curNode) {
        int m = maze.length, n = maze[0].length;
        List<int[]> res = new ArrayList<>();
        int x = curNode[0], y = curNode[1];
        if (x + 1 < m && maze[x + 1][y] != '+') res.add(new int[]{x + 1, y});
        if (x - 1 >= 0&& maze[x - 1][y] != '+') res.add(new int[]{x - 1, y});
        if (y + 1 < n && maze[x][y + 1] != '+') res.add(new int[]{x, y + 1});
        if (y - 1 >= 0&& maze[x][y - 1] != '+') res.add(new int[]{x, y - 1});
        return res;
    }

}
