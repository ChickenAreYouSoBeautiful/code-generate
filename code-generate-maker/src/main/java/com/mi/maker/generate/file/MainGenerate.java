package com.mi.maker.generate.file;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import com.mi.maker.meta.Meta;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @author mi
 * @data 2025/4/23 17:48
 * @version 1.0
 */

public class MainGenerate {

    public static void doGenerate(Meta metaObj) throws TemplateException, IOException, InterruptedException {

        String projectPath = System.getProperty("user.dir");
        String outputPath = projectPath + File.separator + "generator" + File.separator + metaObj.getName();

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
        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/DynamicGenerator.java.ftl";
        outputFilePath = outputBaseJavaPath + "/generator/DynamicGenerator.java";
        DynamicFileGenerate.doDynamicGenerate(inputFilePath , outputFilePath, metaObj);

        // MainGenerator
        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/MainGenerator.java.ftl";
        outputFilePath = outputBaseJavaPath + "/generator/MainGenerator.java";
        DynamicFileGenerate.doDynamicGenerate(inputFilePath , outputFilePath, metaObj);

        // StaticFGenerate
        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/StaticGenerator.java.ftl";
        outputFilePath = outputBaseJavaPath + "/generator/StaticGenerator.java";
        DynamicFileGenerate.doDynamicGenerate(inputFilePath , outputFilePath, metaObj);



        // pom.xml
        inputFilePath = inputResourcePath + File.separator + "templates/pom.xml.ftl";
        outputFilePath = outputPath + "/pom.xml";
        DynamicFileGenerate.doDynamicGenerate(inputFilePath , outputFilePath, metaObj);

        JarGenerator.doGenerate(outputPath);

        // ScriptGenerator
        String shellOutputFilePath = outputPath + File.separator + "generator";
        String jarName = String.format("%s-%s-jar-with-dependencies.jar", metaObj.getName(), metaObj.getVersion());
        String jarPath = "target/" + jarName;
        ScriptGenerator.doGenerate(shellOutputFilePath , jarPath);

    }
}
