package com.mi.cli.example.command;


/**
 * 关闭命令
 * @author mi
 * @data 2025/4/17 10:07
 * @version 1.0
 */
public class TurnOffCommand implements Command {

    private final Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();

    }
}
