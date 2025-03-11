package org.example.LeetCode;

import java.util.*;
import java.util.stream.IntStream;

public class Palindrome {


    public static void main(String[] args) {
        System.out.println(intPalindrome(12321));
        stringPalindrome("IXVXI");
    }

    private static void stringPalindrome(String s) {
        List<String> list = Arrays.asList(s.split(""));

        // using collections
        Collections.reverse(list);
        System.out.println(list);

        // using string builder
        String sb = new StringBuilder(s).reverse().toString();

        // using streams
        Optional<String> reduce = list.stream().reduce((a, b) -> b + a);

        /** # Using streams as well.
         String val = String.valueOf(i);
         return IntStream.range(0, val.length()/2)
         .allMatch(num -> val.charAt(num) == val.charAt(val.length()-1-num));
         */

        System.out.println(reduce.get().toString());
    }

    private static Boolean intPalindrome(int i) {

        /**
         String val = String.valueOf(i);
         return IntStream.range(0, val.length()/2)
                 .allMatch(num -> val.charAt(num) == val.charAt(val.length()-1-num));
         */

        if (i < 0)
            return false;

        int reverse = 0 ;
        int temp = i ;

        while(temp != 0){
            reverse = reverse*10 + (int) temp%10;
            temp /= 10;
        }
        return reverse == i;
    }
}
