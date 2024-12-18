/**
 * @author mdy
 * @date 2024-12-17 14:58
 * @description
 */
public class rememberThis {

    public static void main(String[] args) {
        String s = "This is a simple";
        System.out.println(reverse(s));
    }

    public static String reverse(String s) {
        String[] strs;
        strs = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(reverseCase(strs[i]));
            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    private static String reverseCase(String s) {
        char[] chars = s.toCharArray();
        char[] res = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
//                res[i] = (char) (chars[i] + 32);
                res[i] = Character.toLowerCase(chars[i]);
            } else {
//                res[i] = (char) (chars[i] - 32);
                res[i] = Character.toUpperCase(chars[i]);
            }
        }

        return new String(res);
    }
}
