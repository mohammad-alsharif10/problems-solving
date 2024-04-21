package com.problems.solving.mapSet;

import java.util.HashMap;
import java.util.Map;

public class EqualRowColumnPairs {

    public static int equalPairs(int[][] grid) {

        int result = 0;
        Map<String, Integer> rows = new HashMap<>();
        Map<String, Integer> col = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            String row = "";
            for (int j = 0; j < grid[i].length; j++) {
                row += grid[i][j]+",";
            }
            if (!rows.containsKey(row)) {
                rows.put(row, 1);
            } else {
                rows.put(row, rows.get(row) + 1);
            }
        }

        for (int i = 0; i < grid.length; i++) {
            String column = "";
            for (int j = 0; j < grid[i].length; j++) {
                column += grid[j][i]+",";
            }
            if (!col.containsKey(column)) {
                col.put(column, 1);
            } else {
                col.put(column, col.get(column) + 1);
            }
        }

        for (Map.Entry row : rows.entrySet()) {
            int pairs = 0;
            if (col.containsKey(row.getKey())) {
                pairs = rows.get(row.getKey()) * col.get(row.getKey());
            }

            result = result + pairs;
        }
        return result;
    }

    public static void main(String[] args) {
        equalPairs(new int[][]{{11,1}, {1,11}});
    }
}
