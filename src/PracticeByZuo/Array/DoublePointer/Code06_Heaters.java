package PracticeByZuo.Array.DoublePointer;


import java.util.Arrays;

// 供暖器
// 测试链接 : https://leetcode.cn/problems/heaters/
// 不能用coveredHouse != n 作为终止条件，因为题目要求包含所有房屋，不是包含n个数量的房屋，可以有的房间被包含两次，但是有一个漏掉了。

// 这题用到的技巧是将数组排序，然后用贪心猜出的数学定理。
public class Code06_Heaters {
    public static int findRadius(int[] houses, int[] heaters) {
        int radius = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int index_heater = 0;
        for (int i = 0; i < houses.length; i++) {
            int minDistance = Math.abs(houses[i] - heaters[index_heater]);
            // 找到离i指向的房屋最近的取暖器，
            while (index_heater + 1 < heaters.length && Math.abs(houses[i] - heaters[index_heater + 1]) <= minDistance) {
                minDistance = Math.abs(houses[i] - heaters[++index_heater]);
                // 这里不用大于等于是因为，房屋位置一定是递增的，相等的位置还让heater指针往后移更有利于最大半径更小。
            }
            radius = Math.max(radius, minDistance);
        }
        return radius;
    }

    public static void main(String[] args) {
        int[] houses1 = {282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923};
        int[] heaters1 = {823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612};
        int[] houses2 = {1, 5};
        int[] heaters2 = {2};
        System.out.println(findRadius(houses1, heaters1)); // 161834419
        System.out.println(findRadius(houses2, heaters2)); // 3
    }
}
