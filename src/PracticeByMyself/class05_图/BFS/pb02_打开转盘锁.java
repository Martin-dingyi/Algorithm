package PracticeByMyself.class05_图.BFS;

import java.util.*;

/**
 * @author Martin
 * @date 2025/2/7 23:55
 * @description <a href="https://leetcode.cn/problems/open-the-lock/description/">...</a>
 * 思路1：bfs。可用双向广搜优化
 */

public class pb02_打开转盘锁 {

    public static void main(String[] args) {
        System.out.println((int) '0');
        System.out.println(Arrays.toString(getNeighbors("0000")));
    }

    static Set<String> visited;
    public static int openLock(String[] deadends, String target) {
        Set<String> limitSet = new HashSet<>(List.of(deadends));
        visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int ans = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                String curNode = queue.poll();
                assert curNode != null;
                if (limitSet.contains(curNode)) continue;
                if (curNode.equals(target)) return ans;

                String[] neighbors = getNeighbors(curNode);
                for (String neighbor : neighbors) {
                    if (limitSet.contains(neighbor)) continue;
                    if (visited.add(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }

        }

        return -1;
    }

    private static String[] getNeighbors(String curNode) {
        String[] neighbors = new String[8];
        int index = 0;
        char[] chars = curNode.toCharArray();
        for (int i = 0; i < 4; i++) {
            StringBuilder sb = new StringBuilder(curNode);
            int num = Integer.parseInt(String.valueOf(chars[i]));
            int replaceNum = (num + 1) % 10;
            sb.replace(i, i + 1, String.valueOf(replaceNum));
            neighbors[index++] = sb.toString();
            replaceNum = (num - 1 + 10) % 10;
            sb.replace(i, i + 1, String.valueOf(replaceNum));
            neighbors[index++] = sb.toString();
        }
        return neighbors;
    }


}
