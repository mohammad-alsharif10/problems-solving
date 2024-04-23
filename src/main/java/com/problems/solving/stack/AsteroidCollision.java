package com.problems.solving.stack;

import java.util.Stack;

public class AsteroidCollision {

//    We are given an array asteroids of integers representing asteroids in a row.
//
//    For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
//
//    Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
//
//
//
//    Example 1:
//
//    Input: asteroids = [5,10,-5]
//    Output: [5,10]
//    Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
//    Example 2:
//
//    Input: asteroids = [8,-8]
//    Output: []
//    Explanation: The 8 and -8 collide exploding each other.
//    Example 3:
//
//    Input: asteroids = [10,2,-5]
//    Output: [10]
//    Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
                continue;
            }
            if (asteroids[i] < 0) {
                int lastValue = stack.peek();
                if (lastValue < 0) {
                    stack.push(asteroids[i]);
                } else {
                    if (lastValue < asteroids[i] * -1) {
                        stack.pop();
                        --i;
                    } else if (lastValue == asteroids[i] * -1) {
                        stack.pop();
                    }
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length-1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
