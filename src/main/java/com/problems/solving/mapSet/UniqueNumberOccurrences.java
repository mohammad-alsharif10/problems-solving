package com.problems.solving.mapSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
           set.add(entry.getValue());
        }
        return set.size() == map.size();
    }
}
