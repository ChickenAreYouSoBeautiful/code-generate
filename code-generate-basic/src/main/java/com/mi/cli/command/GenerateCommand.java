package com.mi.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.mi.config.MainTemplateConfig;
import com.mi.generate.MainGenerate;
import lombok.Data;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * @author mi
 * @data 2025/4/17 11:38
 * @version 1.0
 */
@Data
@Command(name = "generate", mixinStandardHelpOptions = true, version = "generate 0.1",description = "生成代码")
public class GenerateCommand implements Callable<Integer> {

    @Option(names = {"-a", "--author"}, description = "Author name",interactive = true)
    String author;

    @Option(names = {"-o", "--outputText"},arity = "0..1", description = "output Text", interactive = true)
    String outputText;

    @Option(names = {"-l", "--loop"},arity = "0..1", description = "is while", interactive = true)
    boolean loop;

    @Override
    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this,mainTemplateConfig);
        MainGenerate.doGenerate(mainTemplateConfig);
        return 0;
    }
}
