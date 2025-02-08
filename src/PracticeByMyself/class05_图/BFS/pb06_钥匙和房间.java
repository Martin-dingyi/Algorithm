package PracticeByMyself.class05_图.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Martin
 * @date 2025/2/8 16:11
 * @description <a href="https://leetcode.cn/problems/keys-and-rooms/description/">...</a>
 */

public class pb06_钥匙和房间 {

    public static void main(String[] args) {

    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> neighbors = rooms.get(queue.poll());
                for (Integer neighbor : neighbors) {
                    if (visited[neighbor]) continue;
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        for (boolean b : visited) {
            if (!b) return false;
        }

        return true;
    }
}
