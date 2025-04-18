package com.mi;

import com.mi.cli.CommandExecutor;

/**
 * @author mi
 * @data 2025/4/10 15:56
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        //todo 强制性交互未完成，system.console 为null
        System.out.println("测试");
        //generate 生成测试
        args = new String[]{"generate","-a","-o","-l"};

        //config 生成参数查看测试
//        args = new String[]{"config"};

        //list 查看生成代码结构测试
//        args = new String[]{"list"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecutor(args);
    }

}