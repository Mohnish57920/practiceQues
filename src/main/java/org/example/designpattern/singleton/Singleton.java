package org.example.designpattern.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton {

    /**
     * private static variable reference
     * private constructor
     * public static get method
     */

    private static Singleton instance;
    private String data;

    private Singleton() {}

    public static Singleton getInstance(){
        if (instance == null){
           synchronized (Singleton.class){
               if (instance == null)
                   instance = new Singleton();
           }
        }
        return instance;
    }

}
