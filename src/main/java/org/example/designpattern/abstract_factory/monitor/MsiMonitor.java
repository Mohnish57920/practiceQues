package org.example.designpattern.abstract_factory.monitor;

public class MsiMonitor implements Monitor{
    @Override
    public void assemble() {
        System.out.println("This is Msi Monitor.");
    }
}
