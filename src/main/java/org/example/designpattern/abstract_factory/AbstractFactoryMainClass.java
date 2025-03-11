package org.example.designpattern.abstract_factory;

import org.example.designpattern.abstract_factory.gpu.GPU;
import org.example.designpattern.abstract_factory.monitor.Monitor;

public class AbstractFactoryMainClass {

    public static void main(String[] args) {
        // Asus
        Manufacturer asusManufacturer = new AsusManufacturer();

        // Msi
        Manufacturer msiManufacturer = new MsiManufacturer();

        // assemble - asus
        GPU gpu = asusManufacturer.createGpu();
        Monitor asusMonitor = asusManufacturer.createMonitor();
        gpu.assemble();
        asusMonitor.assemble();

        // assemble - msi
        GPU msiGpu = msiManufacturer.createGpu();
        msiGpu.assemble();
        Monitor msiMonitor = msiManufacturer.createMonitor();
        msiMonitor.assemble();

    }
}
