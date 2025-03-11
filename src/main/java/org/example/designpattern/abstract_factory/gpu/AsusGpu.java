package org.example.designpattern.abstract_factory.gpu;

public class AsusGpu implements GPU{
    @Override
    public void assemble() {
        System.out.println("This is Asus Gpu.");
    }
}
