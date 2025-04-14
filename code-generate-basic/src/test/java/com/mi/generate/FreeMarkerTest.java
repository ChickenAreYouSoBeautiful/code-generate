package com.mi.generate;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author mi
 * @data 2025/4/10 19:57
 * @version 1.0
 */

public class FreeMarkerTest {

    @Test
    void testTemplate() throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");
        //设置数字格式
        configuration.setNumberFormat("0.######");

        // 创建模板对象，加载指定模板
        Template template = configuration.getTemplate("web.html.ftl");

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("title", "睿智的web页面");
        dataMap.put("description", "这是一个由 FreeMarker 自动生成的页面");
        List<String> menuItem = new ArrayList<>();
        menuItem.add("首页");
        menuItem.add("关于我们");
        menuItem.add("联系我们");
        dataMap.put("menuItem", menuItem);
        dataMap.put("currentYear", LocalDate.now().getYear());
        dataMap.put("company", "睿智有限公司");
        Writer out = new FileWriter("web.html");

        template.process(dataMap, out);
        // 生成文件后别忘了关闭哦
        out.close();
    }

    @Test
    void test() {
        List<String> list = Arrays.asList();

        String collect = list.stream().collect(Collectors.joining(","));
        System.out.println(collect);
    }
}
