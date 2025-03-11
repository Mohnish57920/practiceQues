package org.example.designpattern.factory_pattern;

public class Bike implements MotorVehicle{
    @Override
    public void build() {
        System.out.println("This is a bike.");
    }
}
