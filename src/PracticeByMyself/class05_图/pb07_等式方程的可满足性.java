package PracticeByMyself.class05_图;

/**
 * @author Martin
 * @date 2025/1/18 13:14
 * @description <a href="https://leetcode.cn/problems/satisfiability-of-equality-equations/">...</a>
 * 思路1：使用并查集将所有字母按照“==”号进行分类，然后再去判断"!="是否和当前分类冲突
 */

public class pb07_等式方程的可满足性 {

    public static void main(String[] args) {
        System.out.println('a' - 97);
    }

    public static boolean equationsPossible(String[] equations) {
        UnionFindSet unionFindSet = new UnionFindSet(26);

        for (String equation : equations) {
            // 0位置和3位置放字母
            char[] equationChars = equation.toCharArray();
            if (equationChars[1] == '=') {
                unionFindSet.union(equationChars[0] - 97, equationChars[3] - 97);
            }
        }

        for (String equation : equations) {
            char[] equationChars = equation.toCharArray();
            if (equationChars[1] == '!' && unionFindSet.isConnected(equationChars[0] - 97, equationChars[3] - 97)) {
                return false;
            }
        }

        return true;
    }

    private static class UnionFindSet {
        // 记录连通分量
        private int count;
        // 记录各个结点的父节点，节点 x 的父节点是 parent[x]
        private final int[] parent;

        // 构造函数，n 为图的节点总数
        public UnionFindSet(int n) {
            // 一开始互不连通
            this.count = n;
            // 父节点指针初始指向自己
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        // 将两棵树联合
        public void union(int p, int q) {
            parent[find(q)] = find(p);
            count--;
        }

        // 返回某个节点 x 的根节点，并进行路径压缩
        private int find(int x) {
            // 根节点的 parent[x] == x
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        // 检查两个节点是否连通
        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        // 返回当前的连通分量个数
        public int count() {
            return count;
        }
    }
}
