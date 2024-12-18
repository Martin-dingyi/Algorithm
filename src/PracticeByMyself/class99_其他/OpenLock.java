package PracticeByMyself.class99_其他;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

/**
 * @author mdy
 * @date 2024-11-18 11:09
 * @description
 */


public class OpenLock {

    public static void main(String[] args) {
        String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        int steps = openLock(deadends, target);
        System.out.println(steps);
    }


    public static int openLock(String[] deadends, String target) {
        int steps = 0;
        Queue<String> queue = new ArrayDeque<>();
        HashSet<String> deadStrSet = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visitedStr = new HashSet<>();
        queue.offer("0000");
        visitedStr.add("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curStr = queue.poll();

                if (target.equals(curStr)) {
                    return steps;
                }
                if (deadStrSet.contains(curStr)) {
                    continue;
                }
                offerNextStr(curStr, queue, visitedStr);
            }
            steps++;
        }

        return -1;
    }

    private static void offerNextStr(String curStr, Queue<String> queue, HashSet<String> visitedStr) {
        for (int i = 0; i < 4; i++) {
            char[] charArr = curStr.toCharArray();
            charArr[i] = (char) ((charArr[i] - 48 + 1) % 10 + 48);
            String newStr = new String(charArr);
            if (!visitedStr.contains(newStr)) {
                queue.offer(newStr);
                visitedStr.add(newStr);
            }
        }

        for (int i = 0; i < 4; i++) {
            char[] charArr = curStr.toCharArray();
            charArr[i] = (char) ((charArr[i] - 48  -1 + 10) % 10 + 48);
            String newStr = new String(charArr);
            if (!visitedStr.contains(newStr)) {
                queue.offer(newStr);
                visitedStr.add(newStr);
            }
        }
    }
}
