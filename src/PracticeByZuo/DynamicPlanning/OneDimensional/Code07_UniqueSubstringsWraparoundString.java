package PracticeByZuo.DynamicPlanning.OneDimensional;

import java.util.HashMap;

// 题目：给定一个字符串s，在给定一个环绕字符串...zabcd..xyza..，找出s中的数个子串，要求该字符串
// 也是环绕字符串的子串且唯一。
// 测试链接 : https://leetcode.cn/problems/unique-substrings-in-wraparound-string/
public class Code07_UniqueSubstringsWraparoundString {

    public static int findSubstringInWraproundString(String str) {
        char[] s = str.toCharArray();
        int[] matchCountOfStartByAlphabet = new int[26];
        int ans;
        for (int charIndex = 0; charIndex < s.length;) {
            ans = 1;
            // 查询以i位置字母为开头的，满足条件的子串数量
            for (int cur = charIndex, next = cur + 1; next < s.length; cur++, next++) {
                if ((s[next] - s[cur] == 1) || (s[cur] == 'z' && s[next] == 'a')) {
                    ans++;
                } else {
                    break;
                }
            }
            // 将遍历过的位置对应的匹配字符串个数添加到dp表中
            while (ans != 0) {
                matchCountOfStartByAlphabet[s[charIndex] - 'a'] = Math.max(ans--, matchCountOfStartByAlphabet[s[charIndex++] - 'a']);
            }
        }
        // 去掉重复字符串（根据不同位置的相同首字母来确定重复字符串在哪被多记录，相同首字母谁对应dp表中的值越大，就取谁）
        ans = 0;
        for (int value : matchCountOfStartByAlphabet) {
            ans += value;
        }
        return ans;
    }

    public static int comparator(String str) {
        char[] s = str.toCharArray();
        int ans;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            if (!map.containsKey(s[i])) {
                map.put(s[i], 1);
            }
            ans = 1;
            for (int j = i, k = j + 1; k < s.length; j++, k++) {
                if ((s[k] - s[j] == 1) || (s[j] == 'z' && s[k] == 'a')) {
                    ans++;
                } else {
                    break;
                }
            }
            map.put(s[i], Math.max(map.get(s[i]), ans));
        }
        ans = 0;
        for (char c : map.keySet()) {
            ans += map.get(c);
        }
        return ans;
    }

    // 最好的例子：
    // 1.ababc 有重复的字符串
    // 2.abcda 能清楚看到被重复计算的部分
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            // 生成随机字符串
            int n = (int) (Math.random() * 4 + 1);
            char[] chars = new char[n];
            for (int j = 0; j < chars.length; j++) {
                // 97-122 a~z
                chars[j] = (char) (Math.random() * 26 + 97);
            }
            String random_s = new String(chars);
            if (findSubstringInWraproundString(random_s) != comparator(random_s)) {
                System.out.println(random_s);
                System.out.println("出错");
                break;
            }
        }
        System.out.println("======================执行结束==================");

        String s = "qrbn";
        System.out.println(findSubstringInWraproundString(s));
        System.out.println(comparator(s));
    }
}
