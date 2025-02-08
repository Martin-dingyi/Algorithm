package PracticeByMyself.class01_数组.method04_二分查找;

/**
 * @author Martin
 * @date 2024/12/25 11:57
 * @description <a href="https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/">...</a>
 */

public class pb17_点名 {
    public static void main(String[] args) {

    }

    public static int takeAttendance(int[] records) {
        int lastRecord = 0;
        for (int record : records) {
            if (record != lastRecord) {
                return lastRecord;
            }
            lastRecord = record + 1;
        }
        return lastRecord;
    }
}
