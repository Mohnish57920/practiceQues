package org.example.designpattern.abstract_factory;

import org.example.designpattern.abstract_factory.gpu.GPU;
import org.example.designpattern.abstract_factory.monitor.Monitor;

public abstract class Manufacturer {

    public abstract GPU createGpu();
    public abstract Monitor createMonitor();
}
