package PracticeByMyself.class01_数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author mdy
 * @date 2024-12-07 16:33
 * @description <a href="https://leetcode.cn/problems/group-anagrams/">...</a>
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
            List<String> tempList = hashMap.putIfAbsent(sortedStr, new ArrayList<>(List.of(str)));
            if (tempList != null) {
                tempList.add(str);
            }
        }

        return new ArrayList<>(hashMap.values());
    }
}
