package org.example.designpattern.factory_pattern;

public class BikeFactory extends MotorVehicleFactory{
    @Override
    protected MotorVehicle createMotorVehicle() {
        return new Bike();
    }
}
