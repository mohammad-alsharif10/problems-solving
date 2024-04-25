package com.problems.solving.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {

    public static String predictPartyVictory(String senate) {
        Queue<Integer> d = new LinkedList<>();
        Queue<Integer> r = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                r.add(i);
            } else {
                d.add(i);
            }
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            Integer d1 = d.poll();
            Integer r1 = r.poll();
            if (d1 < r1) {
                d.add(d1+senate.length());
            } else {
                r.add(r1+senate.length());
            }
        }
        if (d.size() > r.size()) {
            return "Dire";
        }else {
            return "Radiant";
        }
    }

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RDD"));
    }
}
