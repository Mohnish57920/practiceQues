package org.example.LeetCode;

import java.util.HashMap;

public class MaxSubArray {


    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArrayMath(arr));
    }

    private static int maxSubArray(int[] arr) {
        int maxSum = 0 , currSum = 0;
        for (int val : arr){
            currSum += val;

            if (maxSum < currSum)
                maxSum = currSum;

            if (currSum < 0)
                currSum=0;
        }
        return maxSum;
    }

    private static int maxSubArrayMath(int[] arr) {
        int maxSum = arr[0], currentSum = arr[0];

        for(int i =0 ; i < arr.length ; i++){
           currentSum = Math.max(arr[i], currentSum+arr[i]);
           maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

//    private static int maxSubArray(int[] arr) {
//
//        int maxSum = 0;
//        int currentSum = 0;
//
//        for (int i = 0; i <arr.length; i++) {
//            currentSum += arr[i];
//
//            if (currentSum > maxSum)
//                maxSum = currentSum;
//
//            if (currentSum < 0)
//                currentSum = 0;
//        }
//        return maxSum;
//    }





}
