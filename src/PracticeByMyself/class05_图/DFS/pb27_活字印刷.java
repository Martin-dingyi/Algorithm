package PracticeByMyself.class05_图.DFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Martin
 * @date 2025/1/29 17:56
 * @description <a href="https://leetcode.cn/problems/letter-tile-possibilities/description/">...</a>
 * 思路1：排列的过程中保存组合
 */

public class pb27_活字印刷 {

    public static void main(String[] args) {
        System.out.println();
    }


    static Set<String> subSet;
    static boolean[] used;
    public static int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        subSet = new HashSet<>();
        used = new boolean[tiles.length()];
        traverse(chars, new StringBuilder());
        return subSet.size();
    }

    static void traverse(char[] chars, StringBuilder path) {
        if (path.length() == chars.length) {
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }

            path.append(chars[i]);
            used[i] = true;
            subSet.add(path.toString());
            traverse(chars, path);
            used[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }

}
