package PracticeByMyself.class05_图.BFS;

import java.util.*;

/**
 * @author Martin
 * @date 2025/2/8 16:24
 * @description <a href="https://leetcode.cn/problems/minimum-genetic-mutation/description/">...</a>
 */

public class pb08_最小基因变化 {

    public static void main(String[] args) {
        String start = "AACCGGTT", end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        System.out.println(minMutation(start, end, bank)); // 1
    }

    public static int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> limit = new HashSet<>();
        for (String string : bank) {
            limit.add(string);
        }

        int step = 0;
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        visited.add(startGene);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curNode = queue.poll();
                if (Objects.equals(curNode, endGene)) {
                    return step;
                }
                List<String> neighbors = getNeighbors(curNode, limit);
                for (String neighbor : neighbors) {
                    if (visited.add(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
            step++;
        }

        return -1;
    }

    private static List<String> getNeighbors(String curNode, HashSet<String> bank) {
        List<String> res = new ArrayList<>();
        char[] seq = {'A', 'C', 'G', 'T'};
        char[] chars = curNode.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            for (char c : seq) {
                if (temp != c) {
                    chars[i] = c;
                    String newStr = new String(chars);
                    if (bank.contains(newStr)) {
                        res.add(newStr);
                    }

                }
                chars[i] = temp;
            }
        }

        return res;
    }

}
