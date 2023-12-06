package org.example.in28mins;

import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GeneratedStreams {


    public static void main(String[] args) {


        //IntStreams -> create stream of integers
        IntStream.range(1,10).forEach(System.out::println);

        // Intstreams - print first 20 even numbers
        IntStream.iterate(1, e->e+1).filter(i->i%2==0).limit(20).forEach(System.out::println);

        // Intstreams - first 10 powers of 2
        IntStream.rangeClosed(1,10).map(e->e*e).forEach(System.out::println);

        // Intstreams - collect first 20 elements in a list
        // IntStream.iterate(2, e-> e+2).collect(Collectors.toList()); This will give error as we are doing this on primitive type
        System.out.println(IntStream.iterate(2, e->2+e).limit(10).boxed().collect(Collectors.toList()));

        // Change the type to BigInteger
        BigInteger reduce = IntStream.rangeClosed(1, 40).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
        System.out.println(reduce);

    }
}
