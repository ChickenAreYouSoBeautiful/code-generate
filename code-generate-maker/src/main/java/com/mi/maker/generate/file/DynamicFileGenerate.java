package com.mi.maker.generate.file;

import cn.hutool.core.io.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

/**
 * @author mi
 * @data 2025/4/10 16:38
 * @version 1.0
 */
public class DynamicFileGenerate {

    /**
     * 动态生成文件（FreeMarker 实现）
     * @param inputPath 模板文件路径
     * @param outputPath 输出文件路径
     * @param model 数据模型
     * @throws IOException 异常
     * @throws TemplateException 异常
     */
    public static void doDynamicGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
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

        //路径不存在就创建
        if (!FileUtil.exist(outputPath)){
            FileUtil.touch(outputPath);
        }

        Writer out = new FileWriter(outputPath, StandardCharsets.UTF_8);

        template.process(model, out);
        // 生成文件后别忘了关闭哦
        out.close();
    }
}
