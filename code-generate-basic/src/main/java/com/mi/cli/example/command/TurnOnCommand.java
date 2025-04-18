package com.mi.cli.example.command;

/**
 * 打开命令
 * @author mi
 * @data 2025/4/17 10:07
 * @version 1.0
 */

public class TurnOnCommand implements Command {

    private final Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}
