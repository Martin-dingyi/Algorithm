package PracticeByZuo.Array.SlidingWindow;


import java.util.*;

// 最小覆盖子串
// 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串
// 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
// 测试链接 : https://leetcode.cn/problems/minimum-window-substring/
public class Code03_MinimumWindowSubstring {
    public static String minWindow(String source, String target) {
        int ansLen = Integer.MAX_VALUE;
        HashMap<Character, Integer> targetMap = new HashMap<>();
        int dept = target.length();
        int start = -1;
        for (int i = 0; i < target.length(); i++) {
            targetMap.put(target.charAt(i), targetMap.getOrDefault(target.charAt(i), 0) - 1);
        }

        for (int left = 0, right = 0; right < source.length(); right++) {
            char curChar = source.charAt(right);
            if (targetMap.containsKey(curChar) && targetMap.get(curChar) < 0) {
                dept--;
            }
            targetMap.put(curChar, targetMap.getOrDefault(curChar, 0) + 1);
            if (dept == 0) {
                while (targetMap.get(source.charAt(left)) > 0) {
                    targetMap.put(source.charAt(left), targetMap.get(source.charAt(left)) - 1);
                    left++;
                }
                if (right - left + 1 < ansLen) {
                    start = left;
                    ansLen = right - left + 1;
                }
            }
        }
        return start == -1 ? "" : source.substring(start, start + ansLen);
    }

    public static boolean isBelong(String source, HashMap<Character, Integer> targetMap) {
        HashMap<Character, Integer> tempMap = new HashMap<>(targetMap);
        for (int i = 0; i < source.length(); i++) {
            char curChar = source.charAt(i);
            if (tempMap.containsKey(curChar)) {
                int count = tempMap.get(curChar);
                tempMap.put(curChar, count - 1);
                if (count - 1 == 0) {
                    tempMap.remove(curChar);
                }
            }
        }
        return tempMap.isEmpty();
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));

//        HashMap<Character, Integer> targetMap = new HashMap<>();
//        for (int i = 0; i < t.length(); i++) {
//            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
//        }
//        System.out.println(isBelong(s, targetMap));
    }
}
