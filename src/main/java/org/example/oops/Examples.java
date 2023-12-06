package org.example.oops;

public class Examples {


    public static void main(String[] args) {

        Parent p1 = new Parent();
        p1.method1();                    //parent method

        Child c1 = new Child();
        c1.method1();                   // child method

        Parent p2 = new Child();
        p2.method1();                   // child method

//        Child  c2 = new Parent(); // this will return error as we want return type of child class
//        c2.method1();
    }
}
