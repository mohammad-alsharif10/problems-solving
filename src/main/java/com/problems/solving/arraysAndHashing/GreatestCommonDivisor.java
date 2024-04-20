package com.problems.solving.arraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreatestCommonDivisor {

//    public String gcdOfStrings(String str1, String str2) {
//
//    }


    public List<Boolean> kidsWithCandies(int[] candies, final int extraCandies) {
        List<Boolean> result = new ArrayList<Boolean>();
        final int asInt = Arrays.stream(candies).max().getAsInt();
        Arrays.stream(candies).forEach(c -> {
            if (c + extraCandies >= asInt) {
                result.add(true);
            } else {
                result.add(false);
            }
        });
        return result;
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int numberOfFlowers = 0;
        for (int i = 0; i < flowerbed.length; ) {
            int previous = i > 0 ? flowerbed[i - 1] : 0;
            int next = i < flowerbed.length - 1 ? flowerbed[i + 1] : 0;
            if (flowerbed[i] == 0) {
                if (previous == 0 && next == 0) {
                    numberOfFlowers++;
                    flowerbed[i] = 1;
                }
            }
            i = i + 1;
        }
        return numberOfFlowers >= n;
    }


    public static String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        s = s.trim();
        String word = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                word += s.charAt(i);
            } else if (s.charAt(i) == ' ') {
                words.add(word);
                word = "";
            }
            if (i == s.length() - 1) {
                words.add(word);
            }
        }
        String reversed = "";
        for (int i = words.size() - 1; i > -1; i--) {
            reversed += words.get(i);
            if (!words.get(i).equals("") && i != 0) {
                reversed += " ";
            }
        }
        return reversed;
    }

    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i' || c == 'A' || c == 'E' || c == 'O' || c == 'U' || c == 'I') {
            return true;
        }
        return false;
    }

    public static String removeVowels(String s) {
        char[] charArray = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (!isVowel(s.charAt(l))) {
                l++;
            }
            if (!isVowel(s.charAt(r))) {
                r--;
            }

            if (isVowel(s.charAt(l)) && isVowel(s.charAt(r))) {
                char temp = s.charAt(l);
                charArray[l] = s.charAt(r);
                charArray[r] = temp;
                l++;
                r--;
            }
        }
        return String.valueOf(charArray);
    }

    public static int compress(char[] chars) {
        List<Character> result = new ArrayList<>();
        char currentChar;
        int numberOfChars = 0;
        for (int i = 0; i < chars.length; i++) {
            if (numberOfChars == 0) {
                result.add(chars[i]);
                numberOfChars++;
            }
            if (numberOfChars > 0 && i + 1 < chars.length && chars[i] == chars[i + 1]) {
                numberOfChars++;
            }
            if (numberOfChars > 0 && (i + 1 == chars.length || chars[i] != chars[i + 1])) {
                if (numberOfChars > 1) {
                    char[] charArray = String.valueOf(numberOfChars).toCharArray();
                    for (int x = 0; x < charArray.length; x++) {
                        result.add(charArray[x]);
                    }
                }
                numberOfChars = 0;
            }
        }
        return result.size();
    }

    public static boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE, j = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
        for (int in = 0; in < nums.length; in++) {
            if (nums[in] <= i) {
                i = nums[in];
            } else if (nums[in] <= j) {
                j = nums[in];
            } else if (nums[in] <= y) {
                return true;
            }
        }
        return false;
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0||nums.length == 1) {
            return;
        }
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[zeroIndex];
                nums[zeroIndex++] = nums[i];
                nums[i] = temp;
            }
        }
        System.out.println("");
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int smallStringPointer=0;
        for (int i = 0; i < t.length(); i++) {
           if (s.charAt(smallStringPointer) == t.charAt(i)) {
              smallStringPointer++;
           }
           if (smallStringPointer == s.length()) {
               break;
           }
        }
        return smallStringPointer==s.length();
    }

    public static void main(String[] args) {

        System.out.println(isSubsequence("abc","ahbgdc"));
    }
}
