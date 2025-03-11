package org.example.LeetCode;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Permutations {

    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {5,1,2,6,4};
        System.out.println(checkPermutation(array1, array2)); // check sum and product
    }

//    BiFunction<int[], int[], Boolean> check = (a,b) -> {
//        Arrays.stream(a).boxed().mapToLong(Integer::longValue).collect(Collectors.summarizingLong(Long::longValue));
//        IntSummaryStatistics bSummary = Arrays.stream(b).boxed().collect(Collectors.summarizingInt(Integer::intValue));
//        return aSummary.getSum() == bSummary.getSum();
//    };


    private static Boolean checkPermutation(int[] array1, int[] array2) {

        if (array1.length != array2.length)
            return false;

        int sum1 = 0, sum2 = 0, product1 = 0, product2 = 0;

        for (int i = 0; i < array1.length; i++) {
            sum1 += array1[i];
            sum2 += array2[i];

            product1 *= array1[i];
            product2 *= array2[i];
        }

        if (sum2 == sum1 && product2 == product1)
            return true;
        return false;
    }
}
