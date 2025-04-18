package com.mi.cli.example.command;

/**
 * 调用者
 * @author mi
 * @data 2025/4/17 10:29
 * @version 1.0
 */

public class RemoteControl {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

}
