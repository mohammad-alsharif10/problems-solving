package com.problems.solving.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s_t = new LinkedHashMap<>();
        Map<Character, Character> t_s = new LinkedHashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int index = 0; index < s.length(); index++) {
            s_t.put(s.charAt(index), t.charAt(index));
            t_s.put(t.charAt(index), s.charAt(index));
        }
        if (s_t.size() != t_s.size()) {
            return false;
        }
        String keys1 = new ArrayList<>(s_t.keySet()).stream().map(Object::toString).reduce((s1, s2) -> s1 + s2).get();
        String values1 = s_t.values().stream().map(Object::toString).collect(Collectors.joining());
        String keys2 = new ArrayList<>(t_s.keySet()).stream().map(Object::toString).reduce((s1, s2) -> s1 + s2).get();
        String values2 = t_s.values().stream().map(Object::toString).collect(Collectors.joining());
        return keys1.equals(values2) && keys2.equals(values1);
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("foo", "bar"));
    }
}
