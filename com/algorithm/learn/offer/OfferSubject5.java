package com.algorithm.learn.offer;

public class OfferSubject5 {

    /**
     * 请实现一个函数，将一个字符串s中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * <p>
     * 0≤len(s)≤1000 。保证字符串中的字符为大写英文字母、小写英文字母和空格中的一种。
     */
    public static void main(String... args) {
        String result = replaceSpace(new StringBuffer("We Are Happy"));
        System.out.println(result);
    }

    public static String replaceSpace(StringBuffer str) {
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");

        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }

    /**
     * TODO: fix it
     *
     * @param s
     * @return
     */
    public static String replaceSpaceV2(String s) {
        // write code here
        if (s == null || s.isEmpty()) {
            return s;
        }
        int emptyCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                emptyCount = emptyCount + 3;
            } else {
                emptyCount++;
            }
        }
        char[] charArr = new char[emptyCount];
        int p1 = s.length() - 1;
        int p2 = emptyCount - 1;
        while (p1 >= 0 && p2 > p1) {
            char c = s.charAt(p1--);
            if (c == ' ') {
                charArr[p2--] = '0';
                charArr[p2--] = '2';
                charArr[p2--] = '%';
            } else {
                charArr[p2--] = c;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : charArr) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
