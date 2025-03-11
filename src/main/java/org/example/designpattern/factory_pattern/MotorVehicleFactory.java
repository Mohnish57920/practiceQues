package org.example.designpattern.factory_pattern;

public abstract class MotorVehicleFactory {

    public MotorVehicle create(){
        MotorVehicle vehicle = createMotorVehicle();
        vehicle.build();
        return vehicle;
    }

    protected abstract MotorVehicle createMotorVehicle();
}
