package PracticeByMyself.class05_图.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Martin
 * @date 2025/2/8 16:18
 * @description <a href="https://leetcode.cn/problems/jump-game-iii/">...</a>
 */

public class pb07_跳跃游戏 {

    public static void main(String[] args) {
        int[] arr = {4,2,3,0,3,1,2};
        System.out.println(canReach(arr, 5));
    }

    public static boolean canReach(int[] arr, int start) {
        // 起点是start，终点是0，利用bfs检测连通性
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] visited = new boolean[arr.length];
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curNode = queue.poll();
                if (arr[curNode] == 0) return true;
                int leftNeighbor = curNode + arr[curNode], rightNeighbor = curNode - arr[curNode];
                if (leftNeighbor >= 0 && leftNeighbor < arr.length && !visited[leftNeighbor]) {
                    visited[leftNeighbor] = true;
                    queue.offer(leftNeighbor);
                }
                if (rightNeighbor >= 0 && rightNeighbor < arr.length && !visited[rightNeighbor]) {
                    visited[rightNeighbor] = true;
                    queue.offer(rightNeighbor);
                }
            }
        }
        return false;
    }
}
