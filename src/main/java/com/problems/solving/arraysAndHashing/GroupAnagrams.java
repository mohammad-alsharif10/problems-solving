package com.problems.solving.arraysAndHashing;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        Arrays.stream(strs).parallel().forEach(s -> {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            if (!map.containsKey(sorted)) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sorted, list);
            } else {
                List<String> strings = map.get(sorted);
                strings.add(s);
                map.put(sorted, strings);
            }
        });
        return map.values().parallelStream().toList();
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
