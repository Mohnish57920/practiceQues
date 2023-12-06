package test;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {

    public static void main(String[] args) {
        String s ="abc1def2ghi3jk4lm5nop6" ;

        char[] charArray = s.toCharArray();
        List<String> result = new ArrayList<>();
        String temp = "";
        Integer counter = 0;
        List<Integer> resultCount = new ArrayList<>();

        for (int i = 0; i< charArray.length; i++) {
            try{
                Integer.parseInt(String.valueOf(charArray[i]));
                counter++;

                if (temp.length() == 2)
                    resultCount.add(counter);

                temp = "";
            } catch (Exception e){
                temp = temp + charArray[i];
            }
        }
//        System.out.println(result);
//        System.out.println(resultCount);

        /// --------------------------------------------------
        // using streams
//        StringUtils.isNumeric();
//        String[] split = s.split("[^0-9]]");
        AtomicInteger counter1 = new AtomicInteger(0);

        List<Integer> collect = Arrays.stream(s.split("\\d+"))
                .map(e -> {
                    int val = counter1.incrementAndGet();
                    if (e.trim().length() == 2) {
                        return val;
                    }
                    return new AtomicInteger(0).get();
                })
                .filter(i -> i != 0)
                .collect(Collectors.toList());

        System.out.println(collect);


    }


}