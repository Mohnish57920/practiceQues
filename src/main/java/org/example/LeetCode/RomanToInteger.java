package org.example.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {


    public static void main(String[] args) {
        int ans = convertRomanToInteger("IXXI");
        System.out.print(ans);
    }

    private static int convertRomanToInteger(String s) {

        // create a Map for roman corresponding values
        Map<Character, Integer> romanLiteralMap = new HashMap<Character, Integer>();
        romanLiteralMap.put('I', 1);
        romanLiteralMap.put('V', 5);
        romanLiteralMap.put('X', 10);
        romanLiteralMap.put('C', 100);
        romanLiteralMap.put('L', 50);
        romanLiteralMap.put('D', 500);
        romanLiteralMap.put('M', 1000);

        // initialize ans
        int ans = 0;

        for (int i = 0; i < s.length() ; i++){

            // if its not the last char & current char is less than next char = subtract the number
            if (i < s.length()-1 && (romanLiteralMap.get(s.charAt(i)) < romanLiteralMap.get(s.charAt(i+1))))
                ans -= romanLiteralMap.get(s.charAt(i));
            // if current char is greater than next char = add the number
            else
                ans += romanLiteralMap.get(s.charAt(i));

        }
        return ans;
    }
}
