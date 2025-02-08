package PracticeByMyself.class05_图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Martin
 * @date 2025/1/15 17:16
 * @description <a href="https://leetcode.cn/problems/is-graph-bipartite/">...</a>
 * 思路1：BFS思路，每次遍历时都进行染色和判断，没有遍历过的结点按规则染色，遍历过的结点按规则判断是否合规
 * 思路2：DFS思路，每次遍历都进行染色，没遍历过的结点，先染色再遍历，已经遍历过则判断它的合法性
 */

public class pb04_判断二分图 {

    public static void main(String[] args) {

    }

    public static boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            if(!isBipartite_dfs(graph, i, 2, visited)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBipartite_bfs(int[][] graph, int s, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer curNode = queue.poll();
                Integer curColor = visited[curNode];
                for (int toNode : graph[curNode]) {
                    if (visited[toNode] == 0) {
                        visited[toNode] = curColor == 1 ? 2 : 1;
                        queue.offer(toNode);
                    } else if (visited[toNode] == curColor) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static boolean isBipartite_dfs(int[][] graph, int s, int preColor, int[] visited) {
        int curColor = preColor == 1 ? 2 : 1;

        visited[s] = curColor;
        for (int toNode : graph[s]) {
            if (visited[toNode] == 0) {
                if (!isBipartite_dfs(graph, toNode, curColor, visited)) {
                    return false;
                }
            } else if (visited[toNode] == curColor) {
                return false;
            }
        }

        return true;
    }
}
