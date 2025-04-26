package com.mi.maker.generate.main;

import com.mi.maker.generate.file.MainGenerate;
import com.mi.maker.meta.Meta;
import com.mi.maker.meta.MetaManager;
import freemarker.template.TemplateException;

import java.io.IOException;

public class MainGenerator {

    public static void main(String[] args) throws IOException, TemplateException, InterruptedException {
        Meta metaObj = MetaManager.getMetaObj();
        MainGenerate.doGenerate(metaObj);
    }



}
