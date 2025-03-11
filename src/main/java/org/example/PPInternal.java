package org.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PPInternal {

    private static int CHARACTER_RANGE= 256;
    public static void main(String[] args) {

        PPInternal ppInternal = new PPInternal();
        //q1Method("My name is anthony gonsalves");
        //q2Method(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)), 3);
        //q3Method();
        //q4Method(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
//        q5Method();
//        System.out.println(factorial(5));
//        System.out.println(isAnagram("ant", "tan"));
        System.out.println(isPalindrome("9An8a."));
//        charFrequency();
//        q10Method();
//        ppInternal.evenOddPrinter();
//        removeItems();
//        substring();
    }

    //Q1 reverse the words in space separated string
    static void q1Method(String s){

        List<String> strArr = Arrays.stream(s.split(" ")).collect(Collectors.toList());
        Collections.reverse(strArr);
        System.out.println(strArr);
    }

    // Q2 : Program to shift element to left 3 times in an array
    //    Input list[] = [0, 1, 2, 3, 4] , output = [3,4,5,1,2]
    //    D = 2
    static void q2Method(ArrayList<Integer> arr, Integer t){
        List<Integer> temp = new ArrayList<>();
        Integer size = arr.size();
//        Arrays.sort();

        for (int i = size-t; i < size ; i++) {
            temp.add(arr.get(i));
        }
        System.out.println(temp);
        arr.removeAll(temp);
        temp.addAll(arr);
        System.out.println(temp);
    }

    // Q3 : Integer arr - multiply by 3 and if even value show as output
    static void q3Method(){
        ArrayList<Integer> result = new ArrayList<>();
        IntStream.rangeClosed(1,20)
                .map(i-> i*3)
                .filter(e->e%2==0)
                .forEach(result::add);
        System.out.println(result);
    }

    //Q4 : integer array [3,5,4,6,2] &sum = 7, output pair is sum ex: [5,2],[4,3]
    static void q4Method(List<Integer> arr){
        List<List<Integer>> result = new ArrayList<>();

        Integer i = 0;
        Integer j = 0;
        Integer size = arr.size();
        Collections.sort(arr);
        while (i < size){
            j = i;
            while (j >= i && j < size) {
                List<Integer> temp = new ArrayList<>();
                if (arr.get(i) + arr.get(j) == 7){
                    temp.add(arr.get(i));
                    temp.add(arr.get(j));
                    result.add(temp);
                    break;
                }
                j++;
            }
            i++;
        }
        System.out.println(result);
    }

    //Q5 : find duplicate character and count from string
    static void q5Method(){
        String str = "anstansaia";

        Map<String, Long> duplcateChars = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(duplcateChars);

        // highest occurred str
        Long maxValue = Collections.max(duplcateChars.values());
        for (Map.Entry m : duplcateChars.entrySet()) {
            if (m.getValue() == maxValue)
                System.out.println(m);
        }
    }

    //Q6 factorial with recursion
    static Integer factorial(Integer n){
        if (n == 0)
            return 1;
        else
            return n * factorial(n-1);

    }

    //Q7 : find the given two strings are anagrams or not without using collection framework like List, map etc.
    static Boolean isAnagram(String str1, String str2){

        if (str1.length() != str2.length())
            return  false;

        int[] count = new int[CHARACTER_RANGE];

        for (int i=0; i<str1.length(); i++){
            count[str1.charAt(i)] ++;
            count[str2.charAt(i)] --;
        }

        for (int i = 0; i < CHARACTER_RANGE; i++) {
            if (count[i] != 0)
                return false;
            return true;
        }
        return false;
    }

    public static boolean isAnagramCounting(String string1, String string2) {
        if (string1.length() != string2.length())
            return false;

        int[] count = new int[256];

        for (int i = 0; i < string1.length(); i++) {
            count[string1.charAt(i)]++;
            count[string2.charAt(i)]--;
        }

        for (int i = 0; i <256; i++) {
            if (count[i] != 0)
                return false;
        }
        return true;
    }

    // Q8: given a string, check if the string is palindrom (same when reversed), the string might have special characters/numbers in it-ignore those and
    //only consider the alphabates - example :  ",(9An8a.:" - it is a palindrom as alphabates Ana when reversed gives the same.
    public static boolean isPalindrome(String str){

        List<String> strArr = Arrays.asList(str.split("")).stream()
                .filter(e -> e.matches("^[A-Za-z]"))
                .collect(Collectors.toList());

        String s = str.replaceAll("^[A-Za-z]", "");


        for (int i = 0; i < strArr.size(); i++) {
            if (!strArr.get(i).equalsIgnoreCase(strArr.get(strArr.size()-1-i)))
                return false;
            return true;
        }
        return false;
    }

    // Q9: Program for Frequency of characters using hashmap.
    static void charFrequency(){
        String str = "this is a  very good name";
        str.replaceAll(" ", "");

        Map<String, Long> charFreq = Arrays.asList(str.split("")).stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));

        System.out.println(charFreq);
//        Predicate
    }

    //Q10: Input => array [-12, 11, -13, -5, 6, -7, 5, -3, -6]
    //Output => {11, 6, 5,-12,-13,-5,-7,-3,-6}
    static void q10Method(){

        int[] arr = new int[]{-12, 11, -13, -5, 6, -7, 5, -3, -6};

        ArrayList<Integer> positiveInteger = new ArrayList<>();
        ArrayList<Integer> negativeInteger = new ArrayList<>();

        for (int a:arr) {
            if (a < 0)
                negativeInteger.add(a);
            else
                positiveInteger.add(a);
        }

        Collections.sort(positiveInteger, Collections.reverseOrder());
        Collections.sort(negativeInteger);

        positiveInteger.addAll(negativeInteger);
        System.out.println(positiveInteger);
    }

    // Q11: print even odd number using 2 threads in sequential manner
    void evenOddPrinter(){
//        Boolean isOdd = false;
//        List<Integer> numbers = Stream.of(1,2,3,4,5,6,7,8,9,10).collect(Collectors.toList());

        AtomicInteger count = new AtomicInteger(1);
        int max = 10;

        Runnable evenPrinter = () -> {
            synchronized (this){
                while (count.get() < max){
                    if (count.get() %2 != 0) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " - Even number is : "+ count);
                    count.getAndIncrement();
                    notify();
                }
            }
        };

        Runnable oddPrinter = () -> {
            synchronized (this){
                while (count.get() < max){
                    if (count.get() %2==0) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " - Odd number is : "+ count);
                    count.getAndIncrement();
                    notify();
                }
            }
        };

        Thread t1 = new Thread(evenPrinter);
        Thread t2 = new Thread(oddPrinter);
        t1.start();
        t2.start();

    }
    static boolean isEven(Integer a){
        if (a%2==0)
            return true;
        return false;
    }

    // "ACB-100-10001-lASD-20-4420Y-150" & list[10,20,30,50,100] = "ACB-10001-lASD-4420Y-150"
    static void removeItems(){
        String s1 = "ACB";
        List<Integer> numbers = Arrays.asList(10,20,30,50,100);
        List<String> sNumbers = numbers.stream().map(String::valueOf).collect(Collectors.toList());

        String result = Arrays.stream(s1.split("-"))
                .filter(i -> !sNumbers.contains(i))
                .collect(Collectors.joining("-"));
        System.out.println(result);
    }

    static void substring(){
        String s1 = "ACB-100-10001-lASD-20-4420Y-150-50";
        String s2 = s1.substring(s1.length() - 8);
        System.out.println(s2);
    }
}
