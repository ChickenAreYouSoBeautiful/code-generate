package com.mi.cli.example.command;

/**
 * @author mi
 * @data 2025/4/17 10:11
 * @version 1.0
 */

public class Client {
    public static void main(String[] args) {
        //电视机
        Device tv1 = new Device("TV1");
        Device tv2 = new Device("TV2");
        //匹配电视机，定义开启和关闭命令
        TurnOffCommand turnOffCommand = new TurnOffCommand(tv1);
        TurnOnCommand turnOnCommand = new TurnOnCommand(tv2);
        //遥控器
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(turnOffCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(turnOnCommand);
        remoteControl.pressButton();

    }
}
