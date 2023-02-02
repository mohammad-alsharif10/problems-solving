package com.problems.solving.arraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        int seqLength = 0;
        int temLength = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        for (int number : nums) {
            int prevNumber = number - 1;
            if (!set.contains(prevNumber)) {
                temLength = 0;
                while (set.contains(number + temLength)) {
                    temLength = temLength + 1;
                }
                seqLength = Math.max(seqLength, temLength);
            }
        }
        return seqLength;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
