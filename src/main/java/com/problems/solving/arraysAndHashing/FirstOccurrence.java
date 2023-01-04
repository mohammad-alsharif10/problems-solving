package com.problems.solving.arraysAndHashing;

public class FirstOccurrence {

    public static int strStr(String haystack, String needle) {
        int result = -1;
        int outerIndex = 0;
        int innerIndex = 0;

        while (outerIndex < haystack.length()) {
            if (haystack.charAt(outerIndex) != needle.charAt(innerIndex)) {
                ++outerIndex;
            } else {

                int subLength = needle.length() - 1;
                if (outerIndex + subLength >= haystack.length()) {
                    break;
                }
                boolean match = true;
                int x = 1;
                for (int i = outerIndex + 1; i <= outerIndex + subLength; i++) {
                    char outer = haystack.charAt(i);
                    char inner = needle.charAt(x);
                    if (outer!=inner) {
                        match = false;
                        break;
                    }
                    ++x;
                }
                if (match) {
                    result = outerIndex;
                    break;
                } else {
                    ++outerIndex;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(strStr("xsssadbutsade", "sade"));
        System.out.println(strStr("mississippi", "issip"));
    }
}
