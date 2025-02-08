package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/29 18:18
 * @description <a href="https://leetcode.cn/problems/letter-case-permutation/description/">...</a>
 */

public class pb29_字母大小写全排列 {

    public static void main(String[] args) {
        String s1 = "a1b2";
        System.out.println(letterCasePermutation(s1));
    }

    static List<String> ans;
    public static List<String> letterCasePermutation(String s) {
        ans = new ArrayList<>();
        traverse(s.toCharArray(), 0, new StringBuilder());
        return ans;
    }

    static void traverse(char[] chars, int index, StringBuilder path) {
        if (index == chars.length) {
            ans.add(path.toString());
            return;
        }

        char curChar = chars[index];
        path.append(curChar);
        traverse(chars, index + 1, path);
        path.deleteCharAt(path.length() - 1);

        if (curChar >= 'a' && curChar <= 'z') {
            curChar = Character.toUpperCase(curChar);
            path.append(curChar);
            traverse(chars, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        } else if (curChar >= 'A' && curChar <= 'Z') {
            curChar = Character.toLowerCase(curChar);
            path.append(curChar);
            traverse(chars, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
