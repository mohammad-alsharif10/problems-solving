package com.problems.solving.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class ArrayProblems {

    public List<Integer> reverseArray(List<Integer> a) {
        // Write your code here
        List<Integer> reversedList = new ArrayList<>();
        for (int i = a.size() - 1; i >= 0; i--) {
            reversedList.add(a.get(i));
        }
        return reversedList;
    }

    public int hourGlassSum(List<List<Integer>> arr) {
        IntStream.range(0, 6).forEach(value -> {
            arr.add(new ArrayList<>());
            IntStream.range(0, 6).forEach(value1 -> arr.get(value).add(-(value1 + value)));
        });
        // Write your code here
        int sum = Integer.MIN_VALUE;
        int column = 0;
        int row = 0;

        while (row < arr.size() - 2) {
            while (column < arr.size() - 2) {
                int sum1 = arr.get(row).subList(column, column + 3).stream().mapToInt(Integer::intValue).sum();
                int sum2 = arr.get(row + 1).subList(column, column + 3).get(1);
                int sum3 = arr.get(row + 2).subList(column, column + 3).stream().mapToInt(Integer::intValue).sum();
                int total = sum1 + sum2 + sum3;
                sum = Math.max(total, sum);
                column++;
            }
            column = 0;
            row++;
        }

        return sum;
    }
}
