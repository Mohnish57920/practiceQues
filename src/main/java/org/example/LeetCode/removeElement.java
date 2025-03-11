package org.example.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class removeElement {


    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        System.out.println(removeElement(arr, 3));
    }

    private static int removeElement(int[] nums, int val) {
        int[] temp = new int[nums.length];
        int counter = 0;

        for (int i=0; i<nums.length;i++){
            if (nums[i] != val){
                temp[counter] = nums[i];
                counter++;
            }
        }

        return counter;
    }



}
