package org.example.in28mins;

import java.util.stream.LongStream;

public class parallelStream {

    public static void main(String[] args) {

        Long currentTime = System.currentTimeMillis();
        // find sum of 1 - 1000000 using parallel stream
        System.out.println(LongStream.rangeClosed(1, 1000000000).reduce(Long::sum).getAsLong());
        System.out.println(System.currentTimeMillis() - currentTime);


        //using parallel
        Long currentTimeP = System.currentTimeMillis();
        // find sum of 1 - 1000000 using parallel stream
        System.out.println(LongStream.rangeClosed(1, 1000000000).parallel().reduce(Long::sum).getAsLong());
        System.out.println(System.currentTimeMillis() - currentTimeP);
    }
}
