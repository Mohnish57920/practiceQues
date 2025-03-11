package org.example.designpattern.abstract_factory;

import org.example.designpattern.abstract_factory.gpu.AsusGpu;
import org.example.designpattern.abstract_factory.gpu.GPU;
import org.example.designpattern.abstract_factory.monitor.AsusMonitor;
import org.example.designpattern.abstract_factory.monitor.Monitor;

public class AsusManufacturer extends Manufacturer{
    @Override
    public GPU createGpu() {
        return new AsusGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new AsusMonitor();
    }
}
