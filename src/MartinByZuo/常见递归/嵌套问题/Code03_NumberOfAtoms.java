package MartinByZuo.常见递归.嵌套问题;

import java.util.TreeMap;

// 题目：求化学式中原子的数量
// 测试链接 : https://leetcode.cn/problems/number-of-atoms/
public class Code03_NumberOfAtoms {

    // 原子式的首字母一定大写，后序字母一定小写
    public static String countOfAtoms(String formula) {
        index = 0;
        char[] s = formula.toCharArray();
        TreeMap<String, Integer> map = calBracketAtoms(s);
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            int num = map.get(key);
            if (num != 1) {
                sb.append(key).append(num);
            } else {
                sb.append(key);
            }
        }
        return sb.toString();
    }

    public static int index;

    // 递归函数作用：记录括号里化学式的原子数，返回这个记录
    public static TreeMap<String, Integer> calBracketAtoms(char[] s) {
        StringBuilder sb = new StringBuilder();
        TreeMap<String, Integer> map = new TreeMap<>();
        TreeMap<String, Integer> nextMap = null;
        int num = 0;
        while (index < s.length && s[index] != ')') {
            // 遇到大写字母是要将之前获得原子数据加入map的信号
            if ((s[index] <= 'Z' && s[index] >= 'A') || s[index] == '(') {
                fill(sb, map, nextMap, num);
                if (s[index] == '(') {
                    index++;
                    nextMap = calBracketAtoms(s);
                } else {
                    sb.append(s[index++]);
                }
                num = 0;
            } else if (s[index] <= 'z' && s[index] >= 'a') {
                sb.append(s[index++]);
            } else if (s[index] >= '0' && s[index] <= '9') {
                num = num * 10 + s[index++] - '0';
            }
        }
        index++;
        fill(sb, map, nextMap, num);
        return map;
    }

    public static void fill(StringBuilder sb, TreeMap<String, Integer> map, TreeMap<String, Integer> nextMap, int num) {
        num = num == 0 ? 1 : num;
        if (!sb.toString().isEmpty()) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + num);
            sb.delete(0, sb.length());
        } else if (nextMap != null) {
            // 将这个nextMap中的数据加到当前的map中去
            // 如果这个括号后面跟了数字n，则添加n次
            for (String key : nextMap.keySet()) {
                map.put(key, map.getOrDefault(key, 0) + nextMap.get(key) * num);
            }
        }
    }

    public static void main(String[] args) {
        String str1 = "((HHe28Be26He)9)34";
        String str2 = "Mg(OH)2";
        System.out.println(countOfAtoms(str1));
    }

}
