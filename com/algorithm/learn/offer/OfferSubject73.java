package com.algorithm.learn.offer;

public class OfferSubject73 {

    /**
     * @param args
     */
    public static void main(String... args) {
        String s = "nowcoder. a am I";
        String result = reverseWords(s);
        System.out.println(result); // Output: "I am a nowcoder."
    }

    //    public static String ReverseSentence(String str) {
//        char[] chars = str.toCharArray();
//        int right = str.length() - 1;
//        int left = right - 1;
//    }


    /**
     * 以先将整个句子翻转，然后再对每个单词进行翻转，即可得到正确的句子顺序
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        // Step 1: Reverse the whole string
        char[] charArray = s.toCharArray();
        reverse(charArray, 0, charArray.length - 1);

        // Step 2: Reverse each word
        int start = 0;
        for (int end = 0; end < charArray.length; end++) {
            if (charArray[end] == ' ') {
                reverse(charArray, start, end - 1);
                start = end + 1;
            }
        }
        // Reverse the last word
        reverse(charArray, start, charArray.length - 1);

        return new String(charArray);
    }

    private static void reverse(char[] charArray, int start, int end) {
        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }
}
