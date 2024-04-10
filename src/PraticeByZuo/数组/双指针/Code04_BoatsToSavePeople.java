package ByMartinPratice.数组.双指针;


import java.util.Arrays;

// 救生艇
// 测试链接 : https://leetcode.cn/problems/boats-to-save-people/

// 技巧：相向双指针，数学证明是用贪心猜的，没证就过了。
public class Code04_BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        int minCount = 0;
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            minCount++;
            right--;
        }
        return minCount;
    }

    public static void main(String[] args) {
        int[] people = {3,2,2,1};
        System.out.println(numRescueBoats(people, 3));
    }
}
