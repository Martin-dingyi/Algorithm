package MartinByZuo.前缀树;

import java.util.Arrays;

// 用静态数组实现前缀树，笔试常用
public class Code02_TrieTreeForExam {
    public static int MAX = 50001;
    public static int[][] Trie;
    public static int[] pass, end;
    public static int count;

    public static void Trie() {
        Trie = new int[MAX][26];
        pass = new int[MAX];
        end = new int[MAX];
        count = 0;
    }

    public void insert(String word) {
        int path;
        int cur = 0;
        pass[0]++;
        for (int i = 0; i < word.length(); i++) {
            path = word.charAt(i) - 'a';
            if (Trie[cur][path] == 0) {
                Trie[cur][path] = ++count;
            }
            cur = Trie[cur][path];
            pass[cur]++;
        }
        end[cur]++;
    }

    public int search(String word) {
        int path;
        int cur = 0;
        // 给予前缀树遍历目标字符串，一直找到最后一个字符所对应的结点
        for (int i = 0; i < word.length(); i++) {
            path = word.charAt(i) - 'a';
            if (Trie[cur][path] == 0) {
                return 0;
            }
            cur = Trie[cur][path];
        }
        return end[cur];
    }

    // 前缀搜索
    public int startsWith(String prefix) {
        int path;
        int cur = 0;
        // 给予前缀树遍历目标字符串，一直找到最后一个字符所对应的结点
        for (int i = 0; i < prefix.length(); i++) {
            path = prefix.charAt(i) - 'a';
            if (Trie[cur][path] == 0) {
                return 0;
            }
            cur = Trie[cur][path];
        }
        return pass[cur];
    }

    public void delete(String word) {
        if (search(word) > 0) {
            int path = 0;
            int cur = 0;
            pass[Trie[cur][path]]--;
            // 给予前缀树遍历目标字符串，一直找到最后一个字符所对应的结点
            for (int i = 0; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (--pass[Trie[cur][path]] == 0) {
                    Trie[cur][path] = 0;
                    return;
                }
                cur = Trie[cur][path];
            }
            end[cur]--;
        }
    }

    public static void clear() {
        for (int i = 0; i <= count; i++) {
            Arrays.fill(Trie[i], 0);
            end[i] = 0;
            pass[i] = 0;
        }
    }
}
