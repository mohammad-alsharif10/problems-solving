package com.problems.solving.twoPointers;

public class ValidPalindromeII {
   static boolean ispli(String s , int l , int r)
    {
        while(l<=r)
        {
            if(s.charAt(l)!=s.charAt(r))
                return false;

            l++;
            r--;
        }

        return true;
    }


  static   boolean validPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        while(l<=r)
        {
            if(s.charAt(l)==s.charAt(r))
            {
                l++;
                r--;
            }
            else
            {
                return (ispli(s,l+1,r)||ispli(s,l,r-1));
            }
        }

        return true;
    }

    public static String reformString(String s) {
        return s.replaceAll("\\s", "").toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("ebcbbececabbacecbbcbe"));
    }
}
