package org.example.designpattern.factory_pattern;

public class CarFactory extends MotorVehicleFactory{
    @Override
    protected MotorVehicle createMotorVehicle() {
        return new Car();
    }
}
