package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        sum2(al);

    }

//    public static void sum(ArrayList<Integer> al){
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            sum += al.get();
//        }
//        System.out.println(sum);
//    }

    public static void sum2(ArrayList<Integer> arr){
        Optional<Integer> reduce = arr.stream().reduce(Integer::sum);
        System.out.println(reduce.get());
    }




}