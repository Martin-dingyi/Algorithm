package PracticeByMyself.class05_图.DFS;

import java.util.*;

/**
 * @author Martin
 * @date 2025/1/29 21:12
 * @description <a href="https://leetcode.cn/problems/reconstruct-itinerary/description/">...</a>
 * 思路1：回溯
 * 思路2：求解欧拉回路
 */

public class pb34_重新安排行程 {

    public static void main(String[] args) {
        String[][] tickets = {
                {"JFK", "SFO"},
                {"JFK", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "JFK"},
                {"ATL", "SFO"}
        };

        // 将二维字符串数组转换为List<List<String>>
        List<List<String>> ticketList = new ArrayList<>();
        for (String[] ticket : tickets) {
            ticketList.add(new ArrayList<>(Arrays.asList(ticket)));
        }
        System.out.println(findItinerary(ticketList));
    }

    static List<String> ans;
    static Map<String, PriorityQueue<String>> graph;
    public static List<String> findItinerary(List<List<String>> tickets) {
        ans = null;
        graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String ticketBegin = ticket.get(0);
            String ticketEnd = ticket.get(1);
            if (!graph.containsKey(ticketBegin)) {
                graph.put(ticketBegin, new PriorityQueue<>());
            }
            graph.get(ticketBegin).add(ticketEnd);
        }

        List<String> path = new ArrayList<>();
        path.add("JFK");
        traverse(tickets.size() + 1, "JFK", path);
        return ans;
    }

    static void traverse(int n, String begin, List<String> path) {
        if (ans != null) return;

        if (path.size() == n) {
            ans = new ArrayList<>(path);
            return;
        }
        if (!graph.containsKey(begin)) {
            return;
        }

        HashSet<String> endSet = new HashSet<>();
        PriorityQueue<String> endPoints = graph.get(begin);
        int size = endPoints.size();
        for (int i = 0; i < size; i++) {
            String ticketEnd = endPoints.peek();
            if (endSet.add(ticketEnd)) {
                endPoints.poll();
                path.add(ticketEnd);
                traverse(n, ticketEnd, path);
                path.remove(path.size() - 1);
                endPoints.add(ticketEnd);
            } else {
                List<String> temp = new LinkedList<>();
                while (endPoints.peek() != null && endPoints.peek().equals(ticketEnd)) {
                    temp.add(endPoints.poll());
                }
                if (endPoints.peek() != null) {
                    ticketEnd = endPoints.poll();
                    endPoints.addAll(temp);
                    path.add(ticketEnd);
                    traverse(n, ticketEnd, path);
                    path.remove(path.size() - 1);
                    endPoints.add(ticketEnd);
                } else {
                    endPoints.addAll(temp);
                }
            }
        }
    }


}
