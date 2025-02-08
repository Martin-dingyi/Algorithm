package PracticeByMyself.class05_图.DFS;

import java.util.HashSet;

/**
 * @author Martin
 * @date 2025/1/29 20:57
 * @description <a href="https://leetcode.cn/problems/fair-distribution-of-cookies/">...</a>
 * 思路1：这种题和上一题都是球盒模型中球选盒子的思维方式更好做。这题开阔了我的视野，不仅让我更加深刻理解回溯算法的本质，也让我
 * 知道还有另一种做决策的思维方式
 */

public class pb33_好题_公平分发饼干 {

    public static void main(String[] args) {

    }

    static int min;
    public static int distributeCookies(int[] cookies, int k) {
        min = Integer.MAX_VALUE;
        traverse(cookies, k, 0, new int[k], Integer.MIN_VALUE);
        return min;
    }

    static void traverse(int[] cookies, int k, int index, int[] value, int curMaxValue) {
        if (index == cookies.length) {
            min = Math.min(min, curMaxValue);
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            int curValue = value[i] + cookies[index];
            if (curValue >= min) continue;
            // 这里是球选盒子模型中剪枝的方法，目前不理解原理
            if (set.add(curValue)) {
                value[i] += cookies[index];
                traverse(cookies, k, index + 1, value, Math.max(curMaxValue, curValue));
                value[i] -= cookies[index];
            }
        }
    }
}
