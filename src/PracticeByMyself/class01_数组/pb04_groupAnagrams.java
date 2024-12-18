package PracticeByMyself.class01_数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author mdy
 * @date 2024-12-07 16:33
 * @description <a href="https://leetcode.cn/problems/group-anagrams/">...</a>
 * 思路1：用哈希表判断两个字符串是不是Anagram
 * 思路2：给字符串排序再比较来判断是不是Anagram
 */
public class pb04_groupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            List<String> stringList = hashMap.computeIfAbsent(sortedStr, k -> new ArrayList<>());
            stringList.add(str);
        }

        return new ArrayList<>(hashMap.values());
    }
}
