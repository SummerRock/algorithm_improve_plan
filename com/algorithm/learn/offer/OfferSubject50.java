package com.algorithm.learn.offer;

import java.util.HashMap;
import java.util.Map;

public class OfferSubject50 {

    /**
     * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。字符串只包含 ASCII 码字符。
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "leetcode";
        int index = firstUniqChar(str);
        System.out.println("First unique character index: " + index);
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        // 统计每个字符出现的次数
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // 找到第一个只出现一次的字符
        for (int i = 0; i < s.length(); i++) {
            if (charCountMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1; // 没有找到只出现一次的字符
    }
}
