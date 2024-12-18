package PracticeByMyself.class04_滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author mdy
 * @date 2024-12-18 10:48
 * @description <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/">...</a>
 */
public class pb06_找出异位词 {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> needMap = new HashMap<>();

        for (char c : p.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        char[] chars = s.toCharArray();

        while (right < chars.length) {
            char curChar = chars[right];
            window.put(curChar, window.getOrDefault(curChar, 0) + 1);
            // 增大窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (needMap.containsKey(curChar)) {
                if (window.get(curChar).equals(needMap.get(curChar))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            if (right - left == p.length()) {
                char removeChar = chars[left];

                if (valid == needMap.size()) {
                    res.add(left);
                }

                if (needMap.containsKey(removeChar)) {
                    if (window.get(removeChar).equals(needMap.get(removeChar))) {
                        valid--;
                    }
                }
                window.put(removeChar, window.get(removeChar) - 1);
                left++;

            }
        }

        return res;
    }
}
