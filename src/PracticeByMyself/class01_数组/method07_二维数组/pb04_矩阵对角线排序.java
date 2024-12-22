package PracticeByMyself.class01_数组.method07_二维数组;

import java.util.*;

/**
 * @author mdy
 * @date 2024-12-19 17:43
 * @description <a href="https://leetcode.cn/problems/sort-the-matrix-diagonally/">...</a>
 * 思路1：
 */
public class pb04_矩阵对角线排序 {

    public static void main(String[] args) {
        int[][] mat = {
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}
        };
        System.out.println(Arrays.deepToString(diagonalSort(mat)));
    }

    public static int[][] diagonalSort(int[][] mat) {
        // 处于同一个对角线上的数，横坐标减纵坐标的值相等
        HashMap<Integer, PriorityQueue<Integer>> diagonalNumMap = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (!diagonalNumMap.containsKey(i - j)) {
                    diagonalNumMap.put(i - j, new PriorityQueue<>());
                }
                diagonalNumMap.get(i - j).add(mat[i][j]);
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = diagonalNumMap.get(i - j).poll();
            }
        }

        return mat;
    }

}
