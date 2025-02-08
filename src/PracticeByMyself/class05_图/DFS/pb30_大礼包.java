package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/29 18:27
 * @description <a href="https://leetcode.cn/problems/shopping-offers/description/">...</a>
 * 思路1：每一步的决策：单买一件，所以有n种决策；也可以买任意一个大礼包，有m种决策，所以总共有m + n种决策；
 */

public class pb30_大礼包 {

    public static void main(String[] args) {

    }


    static int minPrice;
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        minPrice = Integer.MAX_VALUE;
        traverse(price, special, needs.stream().mapToInt(Integer::intValue).toArray(), 0);
        return minPrice;
    }

    static void traverse(List<Integer> price, List<List<Integer>> special, int[] needs, int cost) {
        if (cost >= minPrice) {
            return;
        }

        if (meetNeeds(needs)) {
            minPrice = cost;
            return;
        }

        for (int i = 0; i < price.size(); i++) {
            if (needs[i] == 0) {
                continue;
            }
            int curCost = needs[i] * price.get(i);
            int temp = needs[i];
            needs[i] = 0;
            traverse(price, special, needs, cost + curCost);
            needs[i] = temp;
        }

        for (int i = 0; i < special.size(); i++) {
            List<Integer> bag = special.get(i);
            for (int j = 0; j < price.size(); j++) {
                needs[j] -= bag.get(j);
            }
            if (!existLessThenZero(needs)) {
                traverse(price, special, needs, cost + bag.get(bag.size() - 1));
            }
            for (int j = 0; j < price.size(); j++) {
                needs[j] += bag.get(j);
            }
        }
    }

    private static boolean existLessThenZero(int[] needs) {
        for (Integer need : needs) {
            if (need < 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean meetNeeds(int[] needs) {
        for (Integer need : needs) {
            if (need != 0) {
                return false;
            }
        }
        return true;
    }

}
