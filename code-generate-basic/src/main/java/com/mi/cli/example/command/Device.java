package com.mi.cli.example.command;

/**
 * @author mi
 * @data 2025/4/17 10:09
 * @version 1.0
 */

public class Device {

    private String name;

    public Device(String name) {
        this.name = name;
    }

    public void turnOn() {
        System.out.println(name+"Turn on the device");
    }
    public void turnOff() {
        System.out.println(name+"Turn off the device");
    }
}
