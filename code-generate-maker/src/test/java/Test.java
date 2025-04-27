import cn.hutool.json.JSONUtil;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author mi
 * @data 2025/4/27 11:36
 * @version 1.0
 */

public class Test {

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\mi\\Downloads\\发票批量下载_20250427105809.zip";
        String fileSavePath = "D:\\seawork\\upload\\invoiceupload\\2025-04-27\\";
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(filePath),Charset.forName("gbk"));
        List<String> list = savePdf(zipInputStream, fileSavePath);
        JSONUtil.toJsonStr(list);

    }

    /**
     * 保存pdf文件
     * @param zipIn
     * @param destDirectory
     * @return
     * @throws IOException
     */
    private static List<String> savePdf(ZipInputStream zipIn, String destDirectory) throws IOException {

        if (zipIn == null) {
            throw new IOException("系统错误，zip为 null");
        }
        File destDir = new File(destDirectory);
        ZipEntry entry = zipIn.getNextEntry();
        List<String> fileNames = new ArrayList<>();
        byte[] buffer = new byte[1024];
        while (entry != null) {
            if (!entry.isDirectory() && entry.getName().endsWith(".pdf")) {
                File newFile = new File(destDir, entry.getName());
                // fix for Windows-created archives
                File parent = newFile.getParentFile();
                if (!parent.exists()) {
                    parent.mkdirs();
                }

                try (BufferedOutputStream out = new BufferedOutputStream(Files.newOutputStream(newFile.toPath()))) {
                    int len;
                    while ((len = zipIn.read(buffer)) > 0) {
                        out.write(buffer, 0, len);
                    }
                }
                fileNames.add(entry.getName());
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
        return fileNames;
    }
}
