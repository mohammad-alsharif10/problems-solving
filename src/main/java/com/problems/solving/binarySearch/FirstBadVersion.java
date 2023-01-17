package com.problems.solving.binarySearch;

public class FirstBadVersion {

    public static int firstBadVersion(int n) {
        return recFind(1, n);
    }

    private static int recFind(int lowerBound, int upperBound) {
        int version = (lowerBound / 2) + (upperBound / 2);
        if (isBadVersion(lowerBound)) {
            return lowerBound; // found it// can’t find it
        } else if (isBadVersion(lowerBound + 1)) {
            return lowerBound + 1;
        } else // divide range
        {
            if (isBadVersion(version)) // it’s in upper half
                return recFind(1, version - 1);
            else // it’s in lower half
                return recFind(version + 1, upperBound);
        }
    }

    static boolean isBadVersion(int version) {
        return version >= 2;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(4));
    }
}
