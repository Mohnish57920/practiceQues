package org.example.LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagram {


    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs);
    }

    private static void groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        Arrays.stream(strs).
                forEach(current -> {
                    String sortedStr = Arrays.stream(current.split(""))
                            .sorted().collect(Collectors.joining());
                    if (!hashMap.containsKey(sortedStr))
                        hashMap.put(sortedStr, new ArrayList<>());
                    hashMap.get(sortedStr).add(current);
                });
        System.out.println(hashMap.values());

//        for (String str : strs){
//            String sortedStr = Arrays.stream(str.split(""))
//            .sorted().reduce("", (a, b) -> a + b);
//
//            if (!hashMap.containsKey(sortedStr))
//                hashMap.put(sortedStr, new ArrayList<>());
//
//            hashMap.get(sortedStr).add(str);
//        }
//        System.out.println(hashMap.values());
    }

//    public static List<List<String>> groupAnagrams(String[] strs) {
//        String[] arr = strs;
//        Map<String, List<String>> map = new HashMap<>();
//        for (String word : arr){
//            char[] charArray = word.toCharArray();
//            Arrays.sort(charArray);
//            String str = Arrays.toString(charArray);
//
//            if (!map.containsKey(str))
//                map.put(str, new ArrayList<>());
//
//            map.get(str).add(word);
//        }
//        return new ArrayList<>(map.values());
//    }




}
