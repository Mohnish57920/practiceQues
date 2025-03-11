package org.example.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

import static java.util.Collections.sort;

public class TwoSum_1 {


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        checkTwoSum(arr, 9);
    }



    // logO(n) approach
    private static int[] checkTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // get difference of target - nums[i], as a complement
            int complement = target - nums[i];

            // check if the complement(difference) is present in hashmap
            if (hm.containsKey(complement)){
                return new int[]{hm.get(complement), i};
            }
            String s = "vdgreg";

            // if not present, put the num and index in hm
            hm.put(nums[i], i);
        }
        return new int[0];
    }


}
