package com.mi.generate;

import com.mi.config.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mi
 * @data 2025/4/12 15:16
 * @version 1.0
 */

public class DynamicGenerateTest {

    public static void main(String[] args) throws IOException, TemplateException {

    }


    @Test
    void dynamicGenerateTest() throws IOException, TemplateException {
        String projectPath = System.getProperty("user.dir");
        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = projectPath + File.separator + "MainTemplate.java";
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("睿智");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        doDynamicGenerate(inputPath, outputPath, mainTemplateConfig);
    }

    public void doDynamicGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(new File(inputPath).getParentFile());

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");
        //设置数字格式
        configuration.setNumberFormat("0.######");

        // 创建模板对象，加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);
        Writer out = new FileWriter(outputPath);

        template.process(model, out);
        // 生成文件后别忘了关闭哦
        out.close();
    }
}
