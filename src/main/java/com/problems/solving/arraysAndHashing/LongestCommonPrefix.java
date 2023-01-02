package com.problems.solving.arraysAndHashing;

import java.util.concurrent.CompletableFuture;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1,0);
    }

    private static String longestCommonPrefix(String[] strs, int l, int r,int depth) {
        boolean firstLevel=true;
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            if (depth==0){
                CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> longestCommonPrefix(strs, l, mid,1));
                CompletableFuture<String> stringCompletableFuture1 = CompletableFuture.supplyAsync(() -> longestCommonPrefix(strs, mid + 1, r,1));
                CompletableFuture.allOf(stringCompletableFuture,stringCompletableFuture1).join();
                return commonPrefix(stringCompletableFuture.join(),stringCompletableFuture1.join());
            }else {
                String lcpLeft = longestCommonPrefix(strs, l, mid,1);
                String lcpRight = longestCommonPrefix(strs, mid + 1, r,1);
                return commonPrefix(lcpLeft, lcpRight);
            }

        }
    }

    static String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"leetcode", "leetcod", "leetco", "leetc", "leet", "lee", "le"}));
    }
}
