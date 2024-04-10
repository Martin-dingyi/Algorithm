package PracticeByZuo.CommonRecursion.Nested;

// 含有嵌套的字符串解码
// 测试链接 : https://leetcode.cn/problems/decode-string/
public class Code02_DecodeString {
    public static String decodeString(String s) {
        char[] str = s.toCharArray();
        int m = 1;
        index = 0;
        return getStr(str, m);
    }

    // 递归函数作用：根据m和index和index后面的字符串制作本地string，返回值为这个string
    // "3[a]2[bc]"
    public static int index;

    public static String getStr(char[] str, int m) {
        StringBuilder localStr = new StringBuilder();
        int localCharLen = 0;
        while (index < str.length && str[index] != ']') {
            if (str[index] >= '0' && str[index] <= '9') {
                // 得到完整的数字
                localCharLen = localCharLen * 10 + str[index++] - '0';
            } else if (str[index] == '[') {
                index++;
                localStr.append(getStr(str, localCharLen));
                localCharLen = 0;
            } else if ((str[index] >= 'a' && str[index] <= 'z') || (str[index] >= 'A' && str[index] <= 'Z')) {
                localStr.append(str[index++]);
            }
        }
        index++;
        String temp = localStr.toString();
        m = m == 0 ? 1 : m;
        for (int i = 0; i < m - 1; i++) {
            localStr.append(temp);
        }
        return localStr.toString();
    }

    public static void main(String[] args) {
        String str = "3[a]2[bc]";
        System.out.println(decodeString(str));
    }
}
