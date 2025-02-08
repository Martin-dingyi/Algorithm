package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/28 18:07
 * @description <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/">...</a>
 */

public class pb21_电话号码的字母组合 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static List<String> ans;
    static HashMap<Integer, char[]> numToChars = new HashMap<>();
    public static List<String> letterCombinations(String digits) {
        if (digits.isBlank()) {
            return new ArrayList<>();
        }

        if (numToChars.isEmpty()) {
            char c = 'a';
            for (int i = 2; i <= 9; i++) {
                char[] curChars;
                if (i == 7 || i == 9) {
                    curChars = new char[4];
                    for (int j = 0; j < 4; j++) {
                        curChars[j] = c++;
                    }
                } else  {
                    curChars = new char[3];
                    for (int j = 0; j < 3; j++) {
                        curChars[j] = c++;
                    }
                }
                numToChars.put(i, curChars);
            }
        }
        ans = new ArrayList<>();
        // digits转成nums
        int[] nums = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            nums[i] = digits.charAt(i) - '0';
        }
        traverse(nums, 0, new StringBuilder());
        return ans;
    }

    static void traverse(int[] nums, int index, StringBuilder path) {
        if (index == nums.length) {
            if (path.length() > 0) ans.add(path.toString());
            return;
        }

        char[] curChars = numToChars.get(nums[index]);
        for (char curChar : curChars) {
            path.append(curChar);
            traverse(nums, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }

    }
}
