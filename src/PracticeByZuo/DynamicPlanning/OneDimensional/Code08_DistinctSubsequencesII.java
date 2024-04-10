package PracticeByZuo.DynamicPlanning.OneDimensional;

// 不同的子序列

// 测试链接 : https://leetcode.cn/problems/distinct-subsequences-ii/
public class Code08_DistinctSubsequencesII {
    public static int distinctSubseqII(String str) {
        int mod = 1000000007;
        char[] s = str.toCharArray();
        int sum = 0;
        // 记录以x为首字母时，最大子序列数有多少
        int[] countOfStartByAlphabet = new int[26];
        for (int i = s.length - 1; i >= 0; i--) {
            int newCount = (1 + sum - countOfStartByAlphabet[s[i] - 'a'] + mod) % mod;
            countOfStartByAlphabet[s[i] - 'a'] = (countOfStartByAlphabet[s[i] - 'a'] + newCount) % mod;
            sum = (sum + newCount) % mod;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s1 = "abc";  // 7
        String s2 = "aba";  // 6
        String s3 = "aaa";  // 3
        String s4 = "lee";  // 5
        String s5 = "abab"; // 11
        System.out.println(distinctSubseqII(s1));
        System.out.println(distinctSubseqII(s2));
        System.out.println(distinctSubseqII(s3));
        System.out.println(distinctSubseqII(s4));
        System.out.println(distinctSubseqII(s5));
    }

}
