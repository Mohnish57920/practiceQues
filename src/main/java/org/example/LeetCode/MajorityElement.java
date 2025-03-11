package org.example.LeetCode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement {


    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,1,1,2};
//        System.out.println(majorityElement(arr));
        System.out.println(majorityElement_1(arr));
    }

    private static int majorityElement_1(int[] arr) {
        int maxvalue = 0, maxKey = 0 ;
        HashMap<Integer, Integer> hm = new HashMap<>();

        /**
          return Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(-1);
        **/


        for (int curr : arr){
            hm.put(curr, hm.getOrDefault(curr,0)+1);
        }

        for (Map.Entry<Integer,Integer> m : hm.entrySet()){
            if (maxvalue < m.getValue()) {
                maxvalue = m.getValue();
                maxKey = m.getKey();
            }
        }
        return maxKey;
    }

    // O(n log n)
    private static int majorityElement(int[] nums) {
            int n = nums.length/2;
            int majorityElement = 0;

            Map<Integer, Integer> map = new HashMap<>();

            for(int i=0; i<nums.length;i++){
                if(map.containsKey(nums[i]))
                    map.put(nums[i], map.get(nums[i])+1);
                else
                    map.put(nums[i], 1);
            }

            for(Map.Entry<Integer,Integer> i : map.entrySet()){
                if(i.getValue() > n)
                    return i.getKey();
                else
                    return -1;
            }

            return 0;
    }




}
