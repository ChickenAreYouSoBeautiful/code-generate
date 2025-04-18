package com.mi.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.mi.config.MainTemplateConfig;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;
import java.util.concurrent.Callable;

/**
 * @author mi
 * @data 2025/4/17 11:38
 * @version 1.0
 */
@Command(name = "config", mixinStandardHelpOptions = true, version = "config 0.1",description = "打印代码生成参数")
public class ConfigCommand implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        System.out.println("============================config region=================================");
        for (Field field : fields) {
            System.out.println("参数名称："+field.getName());
            System.out.println("参数类型："+field.getType().getName());
            System.out.println("----------------------------------");
        }
        System.out.println("============================end region=================================");
        return 0;
    }
}
