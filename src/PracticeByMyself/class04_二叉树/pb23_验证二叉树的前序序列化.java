package PracticeByMyself.class04_二叉树;

import common.utils.TreeUtils;

import java.util.Arrays;

/**
 * @author Martin
 * @date 2025/1/2 10:14
 * @description <a href="https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/">...</a>
 * 思路1：如果该位置的根节点不为null，那么它的左右结点必须存在
 * 思路2：待优化，尽量不使用全局变量。可以用list代替String[]，也可以让返回值带有index
 */

public class pb23_验证二叉树的前序序列化 {

    public static void main(String[] args) {
        String s1 = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        String s2 = "1,#";
        System.out.println(isValidSerialization(s1)); // true
        System.out.println(isValidSerialization(s2)); // false
    }

    static int index;
    public static boolean isValidSerialization(String preorder) {
        index = 0;
        String[] preorders = preorder.split(",");
        return isValidSerialization(preorders) && index == preorders.length;
    }

    // 递归函数定义：给当前结点在String[]找一个值对应，如果找不到返回false
    // 只要进这个函数，在String数组中就必须有一个对应的值，否则就是不存在
    public static boolean isValidSerialization(String[] preorderCharArray) {
        if (index >= preorderCharArray.length) {
            return false;
        }
        if (!preorderCharArray[index++].equals("#")) {
            return isValidSerialization(preorderCharArray) &&
                    isValidSerialization(preorderCharArray);
        } else {
            return true;
        }
    }

}
