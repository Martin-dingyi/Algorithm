package PracticeByZuo.PrefixTree;

// 用类描述实现前缀树。工业常用，笔试不常用。
// 测试链接 : https://leetcode.cn/problems/implement-trie-prefix-tree/description/

public class Code01_TrieTree {
    class Trie {
        TrieNode root;
        class TrieNode {
            public int pass;
            public int end;
            public TrieNode[] next;

            public TrieNode() {
                pass = 0;
                end = 0;
                // 代表26个可能的英文字母。如果字符串中可能有的字符太多，可以换成哈希表
                next = new TrieNode[26];
            }
        }

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                cur.pass++;
                int index = word.charAt(i) - 'a';
                if (cur.next[index] == null) {
                    cur.next[index] = new TrieNode();
                }
                cur = cur.next[index];
            }
            cur.pass++;
            cur.end++;
        }

        public int search(String word) {
            TrieNode cur = root;
            // 给予前缀树遍历目标字符串，一直找到最后一个字符所对应的结点
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (cur.next[index] == null) {
                    return 0;
                }
                cur = cur.next[index];
            }
            return cur.end;
        }

        // 前缀搜索
        public int startsWith(String prefix) {
            TrieNode cur = root;
            // 给予前缀树遍历目标字符串，一直找到最后一个字符所对应的结点
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (cur.next[index] == null) {
                    return 0;
                }
                cur = cur.next[index];
            }
            return cur.pass;
        }

        public void delete(String word) {
            if (search(word) > 0) {
                TrieNode cur = root;
                cur.pass--;
                // 给予前缀树遍历目标字符串，一直找到最后一个字符所对应的结点
                for (int i = 0; i < word.length(); i++) {
                    int index = word.charAt(i) - 'a';
                    if (--cur.next[index].pass == 0) {
                        cur.next[index] = null;
                        return;
                    }
                    cur = cur.next[index];
                }
                cur.end--;
            }
        }
    }
}
