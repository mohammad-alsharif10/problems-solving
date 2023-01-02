package com.problems.solving.arraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] res = null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            Integer oldValue = map.get(nums[index]);
            if (oldValue!=null&& nums[index]+nums[index]==target){
                return new int[]{oldValue,index};
            }
            map.put(nums[index], index);
            if (map.size() == 1) continue;
            int dif = target - nums[index];
            if (dif == 0) continue;
            Integer targetElement = map.get(dif);
            if (targetElement != null && targetElement != index) {
                res = new int[]{index, targetElement};
            }
        }
        if (map.size() == 1) {
            return new int[]{0, 1};
        }
        if (res == null) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer integer = entry.getKey();
                Integer integer2 = entry.getValue();
                int dif = target - integer;
                Integer targetElement = map.get(dif);
                if (targetElement != null && !targetElement.equals(integer2)) {
                    res = new int[]{integer2, targetElement};
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        twoSum(new int[]{3, 2, 3}, 6);
    }
}
