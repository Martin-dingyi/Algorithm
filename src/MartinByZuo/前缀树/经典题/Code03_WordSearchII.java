package MartinByZuo.前缀树.经典题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 在二维字符数组中搜索可能的单词
// 给定一个m x n二维字符网格board和一个单词（字符串）列表words
// 返回所有二维网格上的单词。单词必须按照字母顺序，通过相邻的单元格内的字母构成
// 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格
// 同一个单元格内的字母在一个单词中不允许被重复使用
// 1 <= m, n <= 12
// 1 <= words.length <= 3 * 10^4
// 1 <= words[i].length <= 10
// 测试链接 : https://leetcode.cn/problems/word-search-ii/
public class Code03_WordSearchII {
    public static List<String> findWords(char[][] board, String[] words) {
        Trie(words);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                traverse(board, i, j, 0, ans);
            }
        }
        clear();
        return ans;
    }

    public static void traverse(char[][] board, int row, int col, int trieSerialNum, List<String> ans) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == 0) {
            return;
        }
        char temp = board[row][col];
        trieSerialNum = Trie[trieSerialNum][temp - 'a'];
        // 若前缀树路径中没有这个字母，说明该位置不合法
        if (trieSerialNum == 0) {
            return;
        }
        // 如果这个temp字母合法，判断带上这个字母是否是一个完整的word
        if (end[trieSerialNum] != null) {
            ans.add(end[trieSerialNum]);
            deletePass(end[trieSerialNum]);
            end[trieSerialNum] = null;
        }
        // 判断完这个位置后，继续向四周遍历验证。
        board[row][col] = 0;
        traverse(board, row + 1, col, trieSerialNum, ans);
        traverse(board, row - 1, col, trieSerialNum, ans);
        traverse(board, row, col + 1, trieSerialNum, ans);
        traverse(board, row, col - 1, trieSerialNum, ans);
        board[row][col] = temp;
    }

    public static int MAX = 10001;
    public static int[][] Trie = new int[MAX][26];
    public static int[] pass = new int[MAX];
    public static String[] end = new String[MAX];
    public static int count;

    public static void Trie(String[] words) {
        count = 0;
        for (String word : words) {
            insert(word);
        }
    }

    public static void insert(String word) {
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
        end[cur] = word;
    }

    public static void deletePass(String word) {
        int cur = 0;
        pass[0]--;
        // 给予前缀树遍历目标字符串，一直找到最后一个字符所对应的结点
        for (int i = 0; i < word.length(); i++) {
            int path = word.charAt(i) - 'a';
            if (--pass[Trie[cur][path]] == 0) {
                Trie[cur][path] = 0;
            }
            cur = Trie[cur][path];
        }
    }

    public static void clear() {
        for (int i = 0; i <= count; i++) {
            Arrays.fill(Trie[i], 0);
            pass[i] = 0;
            end[i] = null;
        }
    }

    public static void main(String[] args) {
//        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
//        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {{'a', 'a', 'a'}, {'a', 'a', 'a'}, {'a', 'a', 'a'}, {'a', 'a', 'a'}, {'a', 'a', 'a'}, {'a', 'a', 'a'}};
        String[] words = {"a", "aa"};
        System.out.println(Arrays.toString(findWords(board, words).toArray()));
    }
}
