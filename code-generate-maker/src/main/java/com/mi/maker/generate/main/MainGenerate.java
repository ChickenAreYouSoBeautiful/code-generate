package com.mi.maker.generate.main;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;

import cn.hutool.json.JSONUtil;
import com.mi.maker.generate.file.DynamicFileGenerate;
import com.mi.maker.meta.Meta;
import com.mi.maker.meta.MetaManager;

import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @author mi
 * @data 2025/4/22 17:28
 * @version 1.0
 */

public class MainGenerate {
    public static void main(String[] args) throws TemplateException, IOException {
        Meta metaObj = MetaManager.getMetaObj();
        System.out.println(JSONUtil.toJsonStr(metaObj));

        String projectPath = System.getProperty("user.dir");
        String outputPath = projectPath + File.separator + "generate" + File.separator + metaObj.getName();

        //路径不存在创建路径
        if (!FileUtil.exist(outputPath)) {
            FileUtil.mkdir(outputPath);
        }

        //读取resource
        ClassPathResource resource = new ClassPathResource("meta.json");
        String inputResourcePath = resource.getFile().getParent();


        //拼接基础路径
        String basePackage = metaObj.getBasePackage();
        String basePackagePath = File.separator + basePackage.replace("/", ".");
        String outputBaseJavaPath = outputPath + File.separator + "src" + File.separator + "main" + File.separator + "java" + basePackagePath;

        //生成文件

        String inputFilePath = inputResourcePath + File.separator + "templates" + File.separator + "java" + File.separator + "model" + File.separator + "DataModel.java.ftl";
        String outputFilePath = outputBaseJavaPath + File.separator + "model" + File.separator + "DataModel.java";
        DynamicFileGenerate.doDynamicGenerate(inputFilePath, outputFilePath, metaObj);

        // cli.command.ConfigCommand
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/ConfigCommand.java.ftl";
        outputFilePath = outputBaseJavaPath + "/cli/command/ConfigCommand.java";
        DynamicFileGenerate.doDynamicGenerate(inputFilePath , outputFilePath, metaObj);

        // cli.command.GenerateCommand
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/GenerateCommand.java.ftl";
        outputFilePath = outputBaseJavaPath + "/cli/command/GenerateCommand.java";
        DynamicFileGenerate.doDynamicGenerate(inputFilePath , outputFilePath, metaObj);

        // cli.command.ListCommand
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/ListCommand.java.ftl";
        outputFilePath = outputBaseJavaPath + "/cli/command/ListCommand.java";
        DynamicFileGenerate.doDynamicGenerate(inputFilePath , outputFilePath, metaObj);

        // cli.CommandExecutor
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/CommandExecutor.java.ftl";
        outputFilePath = outputBaseJavaPath + "/cli/CommandExecutor.java";
        DynamicFileGenerate.doDynamicGenerate(inputFilePath , outputFilePath, metaObj);

        // Main
        inputFilePath = inputResourcePath + File.separator + "templates/java/Main.java.ftl";
        outputFilePath = outputBaseJavaPath + "/Main.java";
        DynamicFileGenerate.doDynamicGenerate(inputFilePath , outputFilePath, metaObj);

        // DynamicFileGenerate
        inputFilePath = inputResourcePath + File.separator + "templates/java/Main.java.ftl";
        outputFilePath = outputBaseJavaPath + "/Main.java";
        DynamicFileGenerate.doDynamicGenerate(inputFilePath , outputFilePath, metaObj);

        // StaticFGenerate
        inputFilePath = inputResourcePath + File.separator + "templates/java/Main.java.ftl";
        outputFilePath = outputBaseJavaPath + "/Main.java";
        DynamicFileGenerate.doDynamicGenerate(inputFilePath , outputFilePath, metaObj);




    }
}
