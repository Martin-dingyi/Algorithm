package PracticeByMyself.class05_图;

import java.util.*;

/**
 * @author Martin
 * @date 2025/1/15 13:40
 * @description <a href="https://leetcode.cn/problems/course-schedule-ii/">...</a>
 * 可以通过该题理解拓扑排序做的事情
 * 思路1：使用DFS版本的拓扑排序
 */

public class pb03_课程表2 {

    public static void main(String[] args) {

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = mapperPrerequisitesToGraph(numCourses, prerequisites);
        List<Integer> topologicalSortingResult = new ArrayList<>();
        int[] visited = new int[numCourses];

        for (int i = 0; i < graph.length; i++) {
            boolean circle = topologicalSorting_dfs(graph, i, visited, topologicalSortingResult);
            if (circle) {
                return new int[]{};
            }
        }

        int[] courseSort = new int[topologicalSortingResult.size()];
        for (int i = 0; i < topologicalSortingResult.size(); i++) {
            courseSort[i] = topologicalSortingResult.get(i);
        }
        return courseSort;
    }

    // DFS版本的拓扑排序，如果存在环就返回true，否则返回false。topologicalSortingResult保存拓扑排序的结果，
    private static boolean topologicalSorting_dfs(List<Integer>[] graph, int curNode,
                                                  int[] visited, List<Integer> topologicalSortingResult) {
        if (visited[curNode] == 1) {
            return true;
        }
        if (visited[curNode] == 2) {
            return false;
        }

        visited[curNode] = 1;
        for (int i = 0; i < graph[curNode].size(); i++) {
            boolean circle = topologicalSorting_dfs(graph, graph[curNode].get(i), visited, topologicalSortingResult);
            if (circle) {
                return true;
            }
        }
        topologicalSortingResult.add(curNode);
        visited[curNode] = 2;

        return false;
    }

    private static int[] topologicalSorting_bfs(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = mapperPrerequisitesToGraph(numCourses, prerequisites);
        int[] inDegrees = new int[numCourses];
        initInDegreeInfo(inDegrees, graph);
        boolean[] visited = new boolean[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> topologicalSortingResult = new ArrayList<>();

        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                visited[i] = true;
                queue.offer(i);
                topologicalSortingResult.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer curNode = queue.poll();
                for (int j = 0; j < graph[curNode].size(); j++) {
                    int toNode = graph[curNode].get(j);
                    if (--inDegrees[toNode] == 0) {
                        if (!visited[toNode]) {
                            visited[toNode] = true;
                            queue.add(toNode);
                            topologicalSortingResult.add(toNode);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return new int[]{};
            }
        }

        int[] result = new int[numCourses];
        Collections.reverse(topologicalSortingResult);
        for (int i = 0; i < topologicalSortingResult.size(); i++) {
            result[i] = topologicalSortingResult.get(i);
        }

        return result;
    }

    // 初始化入度
    private static void initInDegreeInfo(int[] inDegrees, List<Integer>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                int toNode = graph[i].get(j);
                inDegrees[toNode]++;
            }
        }
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


}
