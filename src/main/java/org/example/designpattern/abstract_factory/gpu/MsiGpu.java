package org.example.designpattern.abstract_factory.gpu;

public class MsiGpu implements GPU{
    @Override
    public void assemble() {
        System.out.println("This is msi gpu.");
    }
}
