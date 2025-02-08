package PracticeByMyself.class04_二叉树;

import com.sun.source.tree.Tree;
import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/5 15:03
 * @description <a href="https://leetcode.cn/problems/most-frequent-subtree-sum/">...</a>
 */

public class pb34_出现次数最多的子树元素和 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.deserializeTree("5,2,-3");
        System.out.println(Arrays.toString(findFrequentTreeSum(root)));
    }


    public static int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        maxFrequent = 0;
        getFrequentTreeSum(root, hashMap);
        List<Integer> list = new LinkedList<>();
        for (Integer treeSum : hashMap.keySet()) {
            if (hashMap.get(treeSum) == maxFrequent) {
                list.add(treeSum);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    static int maxFrequent;
    // 定义：获得左右子树的元素和，将自己root和添加进map，返回自己的元素和
    static int getFrequentTreeSum(TreeNode root, HashMap<Integer, Integer> hashMap) {
        if (root == null) {
            return 0;
        }

        int leftSum = getFrequentTreeSum(root.left, hashMap);
        int rightSum = getFrequentTreeSum(root.right, hashMap);

        int rootSum = leftSum + rightSum + root.val;
        hashMap.put(rootSum, hashMap.getOrDefault(rootSum, 0) + 1);
        maxFrequent = Math.max(hashMap.get(rootSum), maxFrequent);
        return rootSum;
    }
}
