package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/27 15:06
 * @description <a href="https://leetcode.cn/problems/restore-ip-addresses/">...</a>
 * 有效的ip地址中每部分都不能包含前导0，且每部分数字长度范围必须在[1,3]中，每部分的数字必须在[0, 255]范围内，只能有4个部分
 */

public class pb19_复原IP地址 {

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("101023"));
    }

    static List<String> ans;
    public static List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        traverse(s, 0, 0, new int[4]);
        return ans;
    }

    static void traverse(String s, int startIndex, int segIndex, int[] segments) {
        if (startIndex >= s.length()) {
            if (segIndex == 4) {
                StringBuilder sb = new StringBuilder();
                for (int segment : segments) {
                    sb.append(segment).append(".");
                }
                ans.add(sb.deleteCharAt(sb.length() - 1).toString());
            }
            return;
        }
        if (segIndex > 3) {
            return;
        }

        int curNum = 0;
        for (int i = startIndex; i < startIndex + 3 && i < s.length(); i++) {
            if (i != startIndex && s.charAt(startIndex) == '0') {
                return;
            }
            curNum = curNum * 10 + s.charAt(i) - '0';
            if (curNum > 255) {
                return;
            }
            segments[segIndex] = curNum;
            traverse(s, i + 1, segIndex + 1, segments);
        }
    }

}
