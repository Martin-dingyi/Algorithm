package PracticeByMyself.class05_图.DFS;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Martin
 * @date 2025/1/28 19:55
 * @description <a href="https://leetcode.cn/problems/split-a-string-into-the-max-number-of-unique-substrings/">...</a>
 */

public class pb26_拆分字符串使唯一子字符串的数目最大 {

    public static void main(String[] args) {
        System.out.println(maxUniqueSplit("abaac")); // 4
    }

    static int maxCount;
    public static int maxUniqueSplit(String s) {
        maxCount = 0;
        traverse(s, 0, new HashSet<>());
        return maxCount;
    }

    static void traverse(String s, int begin, Set<String> path) {
        if (begin == s.length()) {
            maxCount = Math.max(maxCount, path.size());
            return;
        }

        for (int i = begin; i < s.length(); i++) {
           String subStr = s.substring(begin, i + 1);
            // 但凡有一个重复都需要剪枝，因为长度不可能超过将字符串全部打散成字符的长度
           if (path.add(subStr)) {
               traverse(s, i + 1, path);
               path.remove(subStr);
           }
        }
    }
}
