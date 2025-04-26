package com.mi.maker.generate.file;

import cn.hutool.core.io.FileUtil;

/**
 * @author mi
 * @data 2025/4/10 16:38
 * @version 1.0
 */
public class StaticFileGenerate {
    /**
     * 拷贝文件（util 实现，会将输入目录完整拷贝到输出目录下）
     * @param inputPath 模板路径
     * @param outputPath 输出路径
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }
}
