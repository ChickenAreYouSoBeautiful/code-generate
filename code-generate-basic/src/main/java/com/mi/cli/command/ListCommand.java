package com.mi.cli.command;

import picocli.CommandLine.Command;

import java.io.File;
import java.util.concurrent.Callable;

/**
 * @author mi
 * @data 2025/4/17 11:38
 * @version 1.0
 */
@Command(name = "list", description = "列出模板文件",version = "list 0.1",mixinStandardHelpOptions = true)
public class ListCommand implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        String inputPath = new File(parentFile, "code-generate-basic/acm-template").getAbsolutePath();
        File fileDir = new File(inputPath);

        // 打印根目录名称
        System.out.println(fileDir.getName() + "/");
        // 递归打印文件树
        printFileTree(fileDir, 1);
        return 0;
    }


    // 递归打印文件树结构的辅助方法
    private void printFileTree(File dir, int level) {
        File[] files = dir.listFiles();
        if (files == null) return;

        for (File file : files) {
            // 打印缩进
            for (int i = 0; i < level; i++) {
                System.out.print("│   ");
            }

            if (file.isDirectory()) {
                // 如果是目录，打印目录名并递归处理
                System.out.println("├── " + file.getName() + "/");
                printFileTree(file, level + 1);
            } else {
                // 如果是文件，直接打印文件名
                System.out.println("├── " + file.getName());
            }
        }
    }
}
