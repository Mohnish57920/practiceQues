package org.example.in28mins;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class FilesReadingFP {

    public static void main(String[] args) throws IOException {

        Stream<String> lineStream = Files.lines(Paths.get("text.txt"));

//        lineStream.forEach(System.out::println);

        // find unique words
        lineStream.map(s-> s.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);
    }
}
