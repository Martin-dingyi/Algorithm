/**
 * @author mdy
 * @date 2024-12-18 13:43
 * @description
 */
public class 这里抄数组交换代码 {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void swapTwoDimension(int[][] arr, int aRow, int aCol, int bRow, int bCol) {
        int temp = arr[aRow][aCol];
        arr[aRow][aCol] = arr[bRow][bCol];
        arr[bRow][bCol] = temp;
    }

    // 通过一维数组的索引访问二维数组的元素
    static int get(int[][] grid, int index) {
        int n = grid[0].length;
        int i = index / n, j = index % n;
        return grid[i][j];
    }

    // 通过一维数组的索引修改二维数组的元素
    static void set(int[][] grid, int index, int val) {
        int n = grid[0].length;
        int i = index / n, j = index % n;
        grid[i][j] = val;
    }
}
