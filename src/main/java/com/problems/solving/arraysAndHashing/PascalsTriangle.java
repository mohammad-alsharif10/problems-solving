package com.problems.solving.arraysAndHashing;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        for (int outerIndex = 0; outerIndex < numRows; outerIndex++) {
            if (outerIndex == 0) {
                results.add(List.of(1));
                continue;
            }
            if (outerIndex == 1) {
                results.add(List.of(1, 1));
                continue;
            }
            List<Integer>row= new ArrayList<>();
            for (int innerIndex=0;innerIndex<=outerIndex;innerIndex++){
               if (innerIndex==0){
                   row.add(1);
                   continue;
               }
                if (innerIndex==outerIndex) {
                    row.add(1);
                    continue;
                }
                List<Integer>prev=results.get(outerIndex-1);
                row.add(prev.get(innerIndex)+prev.get(innerIndex-1));
            }
            results.add(row);
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
