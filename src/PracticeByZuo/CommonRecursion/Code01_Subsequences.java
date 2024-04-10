package PracticeByZuo.CommonRecursion;

import java.util.ArrayList;
import java.util.Arrays;

// 字符串的全部子序列
// 子序列本身是可以有重复的，只是这个题目要求去重

public class Code01_Subsequences {
    public static String[] getSub(String str) {
        char[] s = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        f(s, 0, new StringBuilder(), list);
//        cycleMethod(s, list);
        String[] strings = new String[list.size()];
        int i = 0;
        for (String string : list) {
            strings[i++] = string;
        }
        return strings;
    }

    // 所有子字符串都有一个特征，原字符串每个位置的字符要么选中，要么不被选中。利用递归处理这两种可能性
    // 递归函数作用：自己不进path，然后去处理后面的字符；自己进path，再去处理一次后面的字符
    // 注意：这个实现没有去重
    public static void f(char[] s, int index, StringBuilder sb, ArrayList<String> list) {
        // 终止条件：index为s的最后一个字符
        if (index == s.length) {
            list.add(sb.toString());
        } else {
            // 不被选中时
            f(s, index + 1, sb, list);
            // 被选中时
            sb.append(s[index]);
            f(s, index + 1, sb, list);
            // 删除sb中的字符防止干扰
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // 另一种理解方式：一个位置的字符对应的，从该位置到结尾的子字符串，是由下一个位置的子字符串决定的。
    // 这种理解方式没有可能性，所以用循环即可。
    // 注意：这个实现没有去重，用dp表可以去重
    public static void cycleMethod(char[] s, ArrayList<String> list) {
        StringBuilder sb = new StringBuilder();
        list.add("");
        for (int i = s.length - 1; i >= 0; i--) {
            ArrayList<String> tempList = new ArrayList<>();
            for (String string : list) {
                sb.append(s[i]).append(string);
                tempList.add(sb.toString());
                sb.delete(0, sb.length());
            }
            list.addAll(tempList);
        }
    }

    public static void main(String[] args) {
        String str = "babc";
        System.out.println();
        System.out.println(Arrays.toString(getSub(str)));
    }
}
