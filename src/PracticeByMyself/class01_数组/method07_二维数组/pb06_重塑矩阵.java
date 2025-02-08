package PracticeByMyself.class01_数组.method07_二维数组;

import java.util.Arrays;

/**
 * @author mdy
 * @date 2024-12-12 22:48
 * @description <a href="https://leetcode.cn/problems/reshape-the-matrix/">...</a>
 * 思路：本题引入重要的二维数组转一维的技巧
 */

public class pb06_重塑矩阵 {

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        System.out.println(Arrays.deepToString(matrixReshape(mat, 1, 4)));
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        int matSize = m * n, reshapeSize = r * c;
        if (matSize != reshapeSize) {
            return mat;
        }

        int[][] reshapedMat = new int[r][c];
        int index = 0;
        while (index < matSize) {
            reshapedMat[index / c][index % c] = mat[index / n][index % n];
            index++;
        }

        return reshapedMat;
    }

}
