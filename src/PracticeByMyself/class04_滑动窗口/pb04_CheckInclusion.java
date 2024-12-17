package PracticeByMyself.class04_滑动窗口;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author mdy
 * @date 2024-12-17 17:50
 * @description <a href="https://leetcode.cn/problems/permutation-in-string/">...</a>
 */
public class pb04_CheckInclusion {

    public static void main(String[] args) {
        String s1 = "r";
        String s2 = "pilmtnzraxj";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {

        // 1.简单思路，列出s1所有排列组合，再从s2找是否存在子串
        // 2.思路2：利用哈希表记录s1各个字符出现的次数，在记录s2滑动窗口中各个字符出现的次数
        // 如果对得上，就表示存在。
        // 3.思路3：给s1排序，再给s2的滑动窗口中的字符串排序，比较是否相同即可
        // 4.思路4：思路2换数组实现
        int length1 = s1.length();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        String sortedStr1 = new String(chars1);

        int left = 0, right = 0;

        while (right < s2.length()) {
            if (right - left + 1 != length1) {
                right++;
                continue;
            }

            char[] tempChars = s2.substring(left, right + 1).toCharArray();
            Arrays.sort(tempChars);
            String tempStr = new String(tempChars);
            if (sortedStr1.equals(tempStr)) {
                return true;
            }

            left++;
        }

        return false;
    }

    private static boolean isCharCountMapEqual(HashMap<Character, Integer> source, HashMap<Character, Integer> target) {
        for (Character c : source.keySet()) {
            if (!target.containsKey(c) || !Objects.equals(source.get(c), target.get(c))) {
                return false;
            }
        }
        return true;
    }

}
