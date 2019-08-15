package com.burton;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/*********************************
 * <p> 文件名称: ContentCombine
 * <p> 模块名称：com.burton
 * <p> 功能说明: 不同文件内容合并
 * <p> 开发人员：jiangjun
 **********************************/
public class ContentCombine {
    public static void main(String[] args) {
        ContentCombine contentCombine = new ContentCombine();
        String inputPacPath = "";
        String outputPath = "";
        try {
            contentCombine.combine(inputPacPath, outputPath);
        } catch (IOException e) {
            System.out.println("文件合并失败");
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 输入一个包的路径 将包下所有文件合并成一个文件 指定输出
     * @param inputPacPath
     * @param outputPath
     */
    private void combine(String inputPacPath, String outputPath) throws IOException {
        Vector<InputStream> inputStreamVector = new Vector<InputStream>();
        File pacakage = new File(inputPacPath);
        if (!pacakage.isDirectory()) {
            System.out.println("输入路劲不是包路径");
            throw new RuntimeException("输入路劲不是包路径");
        }
        File[] files = pacakage.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                throw new RuntimeException("包路径下还有包，不允许合并");
            }
            FileInputStream fis = new FileInputStream(file);
            inputStreamVector.add(fis);
        }
//        FileInputStream fis1 = new FileInputStream("E:\\Hundsun Files\\AssetPool\\齐鲁资产池\\s1表\\COM_HOLIDAY.sql");
//        FileInputStream fis2 = new FileInputStream("E:\\Hundsun Files\\AssetPool\\齐鲁资产池\\s1表\\core.sql");
//        FileInputStream fis3 = new FileInputStream("E:\\Hundsun Files\\AssetPool\\齐鲁资产池\\s1表\\CREAT_APBIZ.sql");
//        FileInputStream fis4 = new FileInputStream("E:\\Hundsun Files\\AssetPool\\齐鲁资产池\\s1表\\WORK_FLOW.sql");
//        inputStreamVector.add(fis1);
//        inputStreamVector.add(fis2);
//        inputStreamVector.add(fis3);
//        inputStreamVector.add(fis4);
        Enumeration<InputStream> inputStreamEnumeration = inputStreamVector.elements();
        SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStreamEnumeration);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputPath));
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = sequenceInputStream.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        sequenceInputStream.close();
        bos.close();
        System.out.println("文件合并完成");
    }
}
