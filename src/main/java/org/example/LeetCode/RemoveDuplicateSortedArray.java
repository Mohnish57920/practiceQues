package org.example.LeetCode;

public class RemoveDuplicateSortedArray {

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,4,4,5};
        System.out.println(removeDupsSortedArray(arr));
    }

    private static int removeDupsSortedArray(int[] arr) {

        if (arr.length == 0)
            return 0;

        int uniqueCounter = 1;

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] != arr[i+1])
                uniqueCounter++;
        }

        return uniqueCounter;
    }

//    private static int removeDupsSortedArray(int[] arr) {
//        if (arr.length == 0)
//            return 0;
//
//        int uniqueCounter = 1;
//        for (int i = 0; i < arr.length-1; i++) {
//            if (arr[i] != arr[i+1]){
//                uniqueCounter++;
//            }
//        }
//        return uniqueCounter;
//    }

}
