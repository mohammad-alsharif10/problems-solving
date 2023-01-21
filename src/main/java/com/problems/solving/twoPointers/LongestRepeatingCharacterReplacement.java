package com.problems.solving.twoPointers;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int left = 0, right = 0;

        int maxLen = 0, mostFreq = 0;

        while (right < s.length()) {
            // start acquiring
            char key = arr[right];
            map.put(key, map.getOrDefault(key, 0) + 1);
            mostFreq = Math.max(mostFreq, map.get(key));

            boolean canBeReplaced =( (right - left + 1) - mostFreq)>k;

            // release from the left
            if (canBeReplaced) {
                map.put(arr[left], map.get(arr[left]) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }

    public static String replace(String s, int position, char replacement) {
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.setCharAt(position, replacement);
        return stringBuilder.toString();
    }

    public static int longestCommon(int[] positions) {
        return (positions[1] - positions[0]) + 1;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4));
    }
}
