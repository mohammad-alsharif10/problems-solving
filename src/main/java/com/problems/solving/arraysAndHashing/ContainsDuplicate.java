package com.problems.solving.arraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public boolean containsDuplicateQuestion(int[] nums) {
        boolean containsDuplicate = false;
        Map<Integer, Integer> duplicates = new HashMap<>();
        for (int i : nums) {
            if (!duplicates.containsKey(i)) {
                duplicates.put(i, i);
            } else {
                containsDuplicate = true;
                break;
            }
        }
        return containsDuplicate;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean containsDuplicate = false;
        Map<Integer, Integer> duplicates = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            int i = nums[j];
            if (!duplicates.containsKey(i)) {
                duplicates.put(i, j);
            } else {
                if (Math.abs(duplicates.get(i) - j) <= k) {
                    containsDuplicate = true;
                    break;
                } else {
                    duplicates.put(i, j);
                }
            }
        }
        return containsDuplicate;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        boolean containsDuplicate = false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int arrayValue = nums[index];
            map.put(index, arrayValue);
            if (index == 0) {
                continue;
            }
            int mapKeyLowerValue = index - 1;
            for (int innerIndex = 0; innerIndex < indexDiff; innerIndex++) {
                Integer firstValue = map.get(index);
                Integer secondValue = map.get(mapKeyLowerValue);
                if (secondValue != null && Math.abs(secondValue - firstValue) <= valueDiff) {
                    containsDuplicate = true;
                    break;
                }
                mapKeyLowerValue--;
                if(mapKeyLowerValue<0){
                    break;
                }
            }
            if (containsDuplicate) break;
        }
        return containsDuplicate;
    }

    public static void main(String[] args) {
        containsNearbyAlmostDuplicate(new int[]{ 1,2,3,1},3,0);
    }
}



//Example 1:
//
//        Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
//        Output: true
//        Explanation: We can choose (i, j) = (0, 3).
//        We satisfy the three conditions:
//        i != j --> 0 != 3
//        abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
//        abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
//        Example 2:
//
//        Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
//        Output: false
//        Explanation: After trying all the possible pairs (i, j), we cannot satisfy the three conditions, so we return false.
