package org.example.designpattern.factory_pattern;

public class main {


    public static void main(String[] args) {
        MotorVehicleFactory motorVehicleFactory = new BikeFactory();
        motorVehicleFactory.create();
    }
}
