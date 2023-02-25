package com.problems.solving.arraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class SmallestPositive {

    public int solution(int[] A) {
        // Implement your solution here
        Set<Integer> set = new HashSet<>();
        for (Integer value : A) {
            if (value > 0) {
                set.add(value);
            }
        }
        int index = 0;
        while (index <= 100001) {
            if (!set.contains(index)) {
                return index;
            }
            index++;
        }
        return index;
    }
}
