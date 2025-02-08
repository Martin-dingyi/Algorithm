package PracticeByMyself.class05_图;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Martin
 * @date 2025/1/19 17:28
 * @description <a href="https://leetcode.cn/problems/path-with-minimum-effort/">...</a>
 * 思路1：利用DFS算法得到所有路径的最大值，然后取最小的那个；该思路行不通，时间复杂度太高！
 * 思路2：Dijkstra算法做
 */

public class pb13_最小体力消耗路径 {

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        System.out.println(minimumEffortPath(heights)); // 2
    }

    public static int minimumEffortPath(int[][] heights) {
        int row = heights.length, col = heights[0].length;
        int[][] distTo = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                distTo[i][j] = Integer.MAX_VALUE;
            }
        }
        distTo[0][0] = 0;
        Queue<State> pq = new PriorityQueue<>((a, b) -> (a.costFromStart - b.costFromStart));
        pq.offer(new State(0, 0, 0));

        while (!pq.isEmpty()) {
            State curNode = pq.poll();
            assert curNode != null;
            int curNodeX = curNode.x, curNodeY = curNode.y;
            int curNodeCost = curNode.costFromStart;

            int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int i = 0; i < 4; i++) {
                int nextNodeX = curNodeX + d[i][0], nextNodeY = curNodeY + d[i][1];
                if (nextNodeX < 0 || nextNodeY < 0 || nextNodeX >= row || nextNodeY >= col) {
                    continue;
                }

                int curHeight = heights[curNodeX][curNodeY];
                int nextHeight = heights[nextNodeX][nextNodeY];
                int nextCost = Math.max(Math.abs(nextHeight - curHeight), curNodeCost);
                if (nextCost < distTo[nextNodeX][nextNodeY]) {
                    distTo[nextNodeX][nextNodeY] = nextCost;
                    pq.offer(new State(nextNodeX, nextNodeY, nextCost));
                }
            }
        }

        return distTo[row - 1][col - 1];
    }

    private static class State {
        // 当前节点 ID
        int x, y;
        // 从起点 s 到当前节点的权重和
        int costFromStart;

        public State(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.costFromStart = weight;
        }
    }
}
