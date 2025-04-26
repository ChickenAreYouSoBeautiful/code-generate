package com.mi.maker.generate.file;

/**
 * @author mi
 * @data 2025/4/22 16:26
 * @version 1.0
 */

public class FileGenerate {

    public static void main(String[] args) {
        System.out.println("文件生成");
        String inputPath = "";
        String outputPath = "";
        StaticFileGenerate.copyFilesByHutool(inputPath,outputPath);
    }
}
