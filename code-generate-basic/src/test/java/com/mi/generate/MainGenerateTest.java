package com.mi.generate;

import com.mi.Main;
import com.mi.config.MainTemplateConfig;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author mi
 * @data 2025/4/24 9:21
 * @version 1.0
 */
class MainGenerateTest {

    @Test
    void doGenerate() throws TemplateException, IOException {
            MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
            mainTemplateConfig.setAuthor("睿智");
            mainTemplateConfig.setLoop(false);
            mainTemplateConfig.setOutputText("求和结果：");
            MainGenerate.doGenerate(mainTemplateConfig);
    }
}