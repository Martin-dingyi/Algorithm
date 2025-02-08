package PracticeByMyself.class05_图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Martin
 * @date 2025/1/13 10:49
 * @description <a href="https://leetcode.cn/problems/course-schedule/description/">...</a>
 * 思路1：DFS思路，在遍历的过程遇到还在遍历的结点，就是存在环
 * 思路2：BFS思路，一个结点数不为零的有向图如果存在环，那么就不存在入度为0的结点
 */

public class pb02_课程表 {

    public static void main(String[] args) {
        int[][] prerequisites = {
                {0,1},
                {3,1},
                {1,3},
                {3,2}
        };
        System.out.println(canFinish(4, prerequisites)); // true
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = mapperPrerequisitesToGraph(numCourses, prerequisites);
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (isRing_bfs(numCourses, prerequisites)) {
                return false;
            }
        }
        return true;
    }

    // 将上课顺序映射成邻接表形式的图结构
    private static List<Integer>[] mapperPrerequisitesToGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]].add(prerequisite[1]);
        }

        return graph;
    }

    // dfs方式检测环
    static boolean isRing_dfs(List<Integer>[] graph, int curNode, int[] visited) {
        // 1表示curNode正在遍历，如果curNode正在dfs遍历时又被遍历到，说明存在环
        if (visited[curNode] == 1) {
            return true;
        }

        // 2表示这个结点已经结束遍历且不存在环，再遍历到它直接返回结果就行。
        if (visited[curNode] == 2) {
            return false;
        }
        visited[curNode] = 1;
        for (int i = 0; i < graph[curNode].size(); i++) {
            if (isRing_dfs(graph, graph[curNode].get(i), visited)) {
                return true;
            }
        }
        // 访问完所有邻居结点后，表示这个结点已经遍历完
        visited[curNode] = 2;
        return false;
    }

    // bfs方式检测环
    static boolean isRing_bfs(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = mapperPrerequisitesToGraph(numCourses, prerequisites);
        int[] inDegrees = new int[graph.length];
        boolean[] visited = new boolean[graph.length];
        initInDegreeInfo(inDegrees, graph);
        Queue<Integer> queue = new LinkedList<>();
        // 入度为0的结点先入队
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                visited[i] = true;
                queue.offer(i);
            }
        }

        // 每次循环将入度为0的结点排除，形成一个新的图，然后再更新新图的入度数组
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 将入度为0的结点弹出，然后更新新图结点的入度
                Integer curNode = queue.poll();
                for (int j = 0; j < graph[curNode].size(); j++) {
                    Integer toNode = graph[curNode].get(j);
                    // 接着将新图中入度为0的结点入队
                    if (--inDegrees[toNode] == 0) {
                        if (!visited[toNode]) {
                            visited[toNode] = true;
                            queue.offer(toNode);
                        }
                    }
                }
            }
        }

        // 如果最后的图为空，表示不存在环，否则存在
        for (boolean b : visited) {
            if (!b) {
                return true;
            }
        }
        return false;
    }

    private static void initInDegreeInfo(int[] inDegrees, List<Integer>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                int toNode = graph[i].get(j);
                inDegrees[toNode]++;
            }
        }
    }
}
