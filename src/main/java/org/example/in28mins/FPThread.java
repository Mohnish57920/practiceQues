package org.example.in28mins;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class FPThread {

//    public static void main(String[] args) {
//
//
//        Runnable printNumbers = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100000; i++) {
//                    System.out.println(Thread.currentThread().getId() + " : " + i);
//                }
//            }
//        };
//
////        Thread t1 = new Thread(printNumbers);
////        t1.start();
////        Thread t2 = new Thread(printNumbers);
////        t2.start();
////        Thread t3 = new Thread(printNumbers);
////        t3.start();
//
//        // print even odd number using 2 threads
//
//        Runnable printEven = () -> {
//            IntStream.rangeClosed(1, 100).filter(i-> i%2==0).forEach(e-> System.out.println(Thread.currentThread().getId() + " - " + Thread.currentThread().getName() + " : " + e));
//        };
//
//        Runnable printOdd = () -> {
//            IntStream.rangeClosed(1, 100).filter(i-> i%2!=0).forEach(e-> System.out.println(Thread.currentThread().getId() + " - " + Thread.currentThread().getName() + " : " + e));
//        };
//
//        Thread evenThread = new Thread(printEven);
//        evenThread.setName("Even Thread");
//        evenThread.start();
//
//        Thread OddThread = new Thread(printOdd);
//        OddThread.setName("Odd Thread");
//        OddThread.start();
//
//        // print even odd number using 2 threads
//    }

    public static void main(String[] args) {
        FPThread f = new FPThread();
        f.evenOddPrinter();

    }

    private void evenOddPrinter() {
        AtomicInteger count = new AtomicInteger(1);
        int max = 10;


        // print even odd using two threads sequentially
        Runnable printEven = () -> {
            synchronized (this){
                while (count.get() < max){
                    if (count.get() %2 != 0 ){
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getId() + " : even no is : " + count);
                    count.getAndIncrement();
                    notify();
                }
            }
        };

        Runnable printOdd = () -> {
            synchronized (this){
                while (count.get() < max){
                    if (count.get() %2 == 0){
                        try{
                            wait();
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getId() + " : Odd no is : " + count);
                    count.getAndIncrement();
                    notify();
                }
            }
        };

        Thread evenThread = new Thread(printEven);
        evenThread.setName("EvenThread");
        Thread oddThread = new Thread(printOdd);
        oddThread.setName("oddThread");
        evenThread.start();
        oddThread.start();
    }


}
