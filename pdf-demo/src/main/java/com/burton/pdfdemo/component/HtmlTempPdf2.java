package com.burton.pdfdemo.component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Burton
 * @location：com.burton.pdfdemo.component.HtmlTempPdf2
 * @title: HtmlTempPdf2
 * @projectName practice-demos
 * @description:
 * @date 2019/6/30 15:59
 */
public class HtmlTempPdf2 {
    private String tempFilePath;
    private String tempFileName;

    public HtmlTempPdf2() {}

    public HtmlTempPdf2(String tempFilePath, String tempFileName) {
        this.tempFilePath=tempFilePath;
        this.tempFileName=tempFileName;
    }

    public String getTempFilePath() {
        return tempFilePath;
    }
    public void setTempFilePath(String tempFilePath) {
        this.tempFilePath = tempFilePath;
    }
    public String getTempFileName() {
        return tempFileName;
    }
    public void setTempFileName(String tempFileName) {
        this.tempFileName = tempFileName;
    }



    public static void main(String[] args) {
        String tempName = "htmlTemp.html";
        String tempPath = "D:\\文件\\wordPpt";
        HtmlTempPdf2 pdfUtil = new HtmlTempPdf2(tempPath,tempName);
        Map<String, Object> paraMap = new HashMap<String, Object>(16);
        paraMap.put("constructionName","123");
        paraMap.put("empName","123");
        paraMap.put("idCode","123");
        paraMap.put("teamName","123");
        paraMap.put("projectName","123");
        try {
            String uploadfile = pdfUtil.fillTemplate(paraMap);
            System.out.println(uploadfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     * 填充模板
     * @param paramMap
     * @throws Exception
     */
    public  String  fillTemplate(Map<String, Object> paramMap) throws Exception {
        File modelFile = new File(tempFilePath);
        if(!modelFile.exists()) {
            modelFile.mkdirs();
        }
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setDirectoryForTemplateLoading(modelFile);
        configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_23));
        configuration.setDefaultEncoding("GB2312");   //这个一定要设置，不然在生成的页面中 会乱码
        //获取或创建一个模版。
        Template template = configuration.getTemplate(tempFileName);
        //template.setOutputEncoding("UTF-8");
        StringWriter stringWriter = new StringWriter();
        BufferedWriter writer = new BufferedWriter(stringWriter);
        template.process(paramMap, writer); //把值写进模板


//        //模板内容
//        StringBuilder content = new StringBuilder();
//        //模板文件
//        File file = new File(tempFilePath + File.separator + tempFileName);
//        //构造输入流
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
//        String line = null;
//        while ((line = br.readLine()) != null) {
//            content.append(line);
//        }


//            //构造Configuration
//            Configuration configuration = new Configuration();
//            //构造StringTemplateLoader
//            StringTemplateLoader loader = new StringTemplateLoader();
//            //添加String模板
//            loader.putTemplate("test", content.toString());
//            //把StringTemplateLoader添加到Configuration中
//            configuration.setTemplateLoader(loader);
//            //构造Model
//            //获取模板
//            Template template = configuration.getTemplate("test");
//            //生成html
//            File dirPath = new File("D:\\文件\\wordPpt\\result.html");
//            if(!dirPath.getParentFile().exists()){
//                dirPath.getParentFile().mkdirs();
//            }
//            //构造输出路
//            FileWriter out = new FileWriter(dirPath);
//            //生成HTML
//            template.process(paramMap, out);

        String htmlStr = stringWriter.toString();
        writer.flush();
        writer.close();

        String resultPath = tempFilePath + File.separator + "temp";
        File tmepFilePath = new File(resultPath);
        if (!tmepFilePath.exists()) {
            tmepFilePath.mkdirs();
        }
        //生成pdf的名字
        String  tmpFileName =System.currentTimeMillis()+".pdf";
        String outputFile = resultPath + File.separatorChar + tmpFileName;
        FileOutputStream outFile = new FileOutputStream(outputFile);
        createPDFFile(htmlStr, outFile);

        return outputFile;
    }


    /**
     * 根据HTML字符串创建PDF文件
     * @param htmlStr
     * @param os
     * @throws Exception
     */
    private  void createPDFFile(String htmlStr, OutputStream os) throws Exception{
        ByteArrayInputStream bais = new ByteArrayInputStream(htmlStr.getBytes("UTF-8"));
        // step 1
        Document document = new Document();
        try {
            // step 2
            PdfWriter writer = PdfWriter.getInstance(document, os);
            // step 3
            document.open();
            FontProvider  provider = new FontProvider();
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, bais, Charset.forName("UTF-8"),provider);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally {
            try {
                document.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                bais.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * 字体
     *
     */
    private  class FontProvider extends XMLWorkerFontProvider {

        public Font getFont(final String fontname, final String encoding,
                            final boolean embedded, final float size, final int style,
                            final BaseColor color) {
            BaseFont bf = null;
            try {
                bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Font font = new Font(bf, size, style, color);
            font.setColor(color);
            return font;
        }
    }
    /**
     * 生成html模板
     * @param content
     * @return
     */
    public String createdHtmlTemplate(String content){
        String fileName = tempFilePath + "/" + tempFileName;
        try{
            File file = new File(tempFilePath);
            if(!file.isDirectory()) {
                file.mkdir();
            }
            file = new File(fileName);
            if(!file.isFile()) {
                file.createNewFile();
            }
            //打开文件
            PrintStream printStream = new PrintStream(new FileOutputStream(fileName));

            //将HTML文件内容写入文件中
            printStream.println(content);
            printStream.flush();
            printStream.close();
            System.out.println("生成html模板成功!");
        }catch(Exception e){
            e.printStackTrace();
        }
        return fileName;
    }


}
