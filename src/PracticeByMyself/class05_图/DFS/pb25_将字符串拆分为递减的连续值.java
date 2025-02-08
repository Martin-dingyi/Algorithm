package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/28 19:25
 * @description <a href="https://leetcode.cn/problems/splitting-a-string-into-descending-consecutive-values/description/">...</a>
 */

public class pb25_将字符串拆分为递减的连续值 {

    public static void main(String[] args) {
        System.out.println(splitString("64424509442147483647"));
    }

    public static boolean splitString(String s) {
        return findSplit(s, 0, new ArrayList<>());
    }

    static boolean findSplit(String s, int begin, List<Long> path) {
        if (begin == s.length()) {
            return path.size() > 1;
        }

        for (int i = begin; i < s.length(); i++) {
            String str = s.substring(begin, i + 1);
            int leadingZeroCount = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    leadingZeroCount++;
                } else {
                    break;
                }
            }
            if (str.length() - leadingZeroCount > (s.length() + 1) / 2) {
                // 剪枝逻辑，如果当前截取的子串长度大于 s 的一半，那么没必要继续截取了，肯定不可能只差一
                // 同时可以避免溢出 long 的最大值的问题
                continue;
            }


            Long curNum = Long.parseLong(str);
            if (!path.isEmpty()) {
                if (path.get(path.size() - 1) - curNum != 1) continue;
            }
            path.add(curNum);
            if (findSplit(s, i + 1, path)) {
                return true;
            }
            path.remove(path.size() - 1);
        }

        return false;
    }
}
