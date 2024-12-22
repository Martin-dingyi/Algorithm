package PracticeByMyself.class99_其他;

import java.util.Arrays;

/**
 * @author mdy
 * @date 2024-12-19 15:18
 * @description <a href="https://leetcode.cn/problems/reverse-words-in-a-string/">...</a>
 * 思路1：split分割，反转，再拼接
 * 思路2：转成char数组，先整体翻转一次，在局部翻转单词，这样可以节省空间。
 * 思路3：用一个新数组实现反转，这样最快。
 */
public class 翻转字符串 {
    public static void main(String[] args) {
        String s = " hello   world ";
        System.out.println(reverseWords(s));
        System.out.println(reverseWords3(s));
    }

    public static String reverseWords(String s) {
        s = removeExtraSpace(s);

        char[] chars = s.toCharArray();
        reverseChars(chars, 0, s.length() - 1);

        int beginIndex = 0;
        int index = 0;
        while (index <= chars.length) {
            while (index < chars.length && chars[index] != ' ') {
                index++;
            }
            reverseChars(chars, beginIndex, index - 1);
            beginIndex = ++index;
        }

        return new String(chars);
    }

    // 反转特定范围内的chars数组，左闭右闭
    private static void reverseChars(char[] chars, int begin, int end) {
        while (begin < end) {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }
    }

    private static String removeExtraSpace(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();

        int slow = 0, fast = 0;
        int spaceCnt = 0;

        while (fast < chars.length) {
            if (chars[fast] == ' ' && fast + 1 < chars.length && chars[fast + 1] == ' ') {
                fast++;
                spaceCnt++;
            } else {
                chars[slow++] = chars[fast++];
            }
        }

        return new String(chars).substring(0, s.length() - spaceCnt);
    }


    public static String reverseWords2(String s) {
        String[] strs = s.trim().split(" ");

        for (int i = 0; i < strs.length / 2; i++) {
            swap(strs, i, strs.length - i - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            if ("".equals(str)) {
                continue;
            }
            sb.append(str).append(" ");
        }
        return sb.toString().trim();
    }

    private static void swap(String[] strs, int i, int j) {
        String temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }

    // 榜1大哥的思路
    public static String reverseWords3(String s) {
        char[] initialArr = s.toCharArray();
        // 这个数组用于从前往后装单词
        char[] newArr = new char[initialArr.length + 1];
        int newArrIndex = 0;
        int i = initialArr.length - 1;
        while (i >= 0) {
            // 干掉多余的空格
            while (i >= 0 && initialArr[i] == ' ') {
                i--;
            }

            // 记住右边界的位置
            int right = i;
            // 从右往左，找到第一个空格
            while (i >= 0 && initialArr[i] != ' ') {
                i--;
            }

            // 找到单词开始处理
            for (int j = i + 1; j <= right; j++) {
                newArr[newArrIndex++] = initialArr[j];
                if(j == right) {
                    // 单词遍历完成，增加一个空格。
                    newArr[newArrIndex++] = ' ';
                }
            }

        }

        if (newArrIndex == 0) {
            return "";
        } else {
            return new String(newArr, 0, newArrIndex - 1);
        }

    }
}
