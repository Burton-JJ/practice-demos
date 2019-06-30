//package com.burton.pdfdemo.component;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.pdf.parser.Line;
//import com.itextpdf.tool.xml.XMLWorkerHelper;
//import freemarker.cache.StringTemplateLoader;
//import freemarker.template.Configuration;
//import freemarker.template.Template;
//import freemarker.template.TemplateException;
//
//import java.io.*;
//import java.nio.charset.Charset;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static com.itextpdf.tool.xml.html.HTML.Tag.HTML;
//
///**
// * @author Burton
// * @location：com.burton.pdfdemo.component.HtmlTempletePdf
// * @title: HtmlTempletePdf
// * @projectName practice-demos
// * @description:根据html模板生成pdf
// * @date 2019/6/30 0:28
// */
//public class HtmlTempletePdf {
//    private String saveFilePath;
//    public static final String FILE_PATH ="e:/html/result.html";//文件指定存放的路径
//
//
//    /*
//     * 把模板读入到String中，然后根据String构造FreeMarker模板
//     */
//    public  void createHtmlFromString(Object data) {
//        BufferedInputStream in = null;
//        FileWriter out = null;
//        try {
//            //模板文件
//            File file = new File("E:\\html\\hello.ftl");
//            //构造输入流
//            in = new BufferedInputStream(new FileInputStream(file));
//            int len;
//            byte[] bytes = new byte[1024];
//            //模板内容
//            StringBuilder content = new StringBuilder();
//            while((len = in.read(bytes)) != -1) {
//                content.append(new String(bytes, 0, len, "utf-8"));
//            }
//
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
//            File dirPath = new File(FILE_PATH);
//            if(!dirPath.getParentFile().exists()){
//                dirPath.getParentFile().mkdirs();
//            }
//            //构造输出路
//            out = new FileWriter(FILE_PATH);
//            //生成HTML
//            template.process(data, out);
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if(null != in) {
//                try {
//                    in.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(null != out) {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }
//    /**
//     * @description     导出pdf到文件
//     * @param fileName  输出PDF文件名
//     * @param data      模板所需要的数据
//     *
//     */
//    public String exportToFile(String fileName,Object data){
//        try {
//            //根据模板生成html
//            createHtmlFromString( data);
//            File file=new File(saveFilePath);
//            if(!file.getParentFile().exists()){
//                file.getParentFile().mkdirs();
//            }
//            Document document =null;
//            try{
//                // step 1
//                document = new Document();
//                // step 2
//                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
//                // step 3
//                document.open();
//                // step 4
//                XMLWorkerHelper.getInstance().parseXHtml(writer, document,
//                        new FileInputStream(FILE_PATH),  Charset.forName("UTF-8")
//                );
//                System.out.println("生成完成");
//            }catch(Exception ex){
//               // throw new PDFException("PDF export to File fail",ex);
//                throw new RuntimeException(ex.getMessage());
//            }finally{
//                document.close();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return saveFilePath;
//    }
//    public String getSaveFilePath() {
//        return saveFilePath;
//    }
//    public void setSaveFilePath(String saveFilePath) {
//        this.saveFilePath = saveFilePath;
//    }
//
//
//    //*******************//
//
//    /**
//     * Creates a PDF with the words "Hello World"
//     * @param file
//     * @throws IOException
//     * @throws DocumentException
//     */
//    public static void createPdf(String file) throws IOException, DocumentException {
//        // step 1
//        Document document = new Document();
//        // step 2
//        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
//        // step 3
//        document.open();
//        // step 4
//        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
//                new FileInputStream(HTML), Charset.forName("UTF-8"));
//        System.out.println("生成完成");
//        // step 5
//        document.close();
//    }
//    /**
//     * Creates a PDF with the words "Hello World"
//     * @param file
//     * @throws IOException
//     * @throws DocumentException
//     */
//    public static void createPdf2() throws IOException, DocumentException {
//        HtmlTempletePdf kit=new HtmlTempletePdf();
//        //数据
//        TemplateBO templateBO=new TemplateBO();
//        templateBO.setTemplateName("测试");
//        templateBO.setFreeMarkerUrl("http://www.zheng-hang.com/chm/freemarker2_3_24/ref_directive_if.html");
//        templateBO.setITEXTUrl("http://developers.itextpdf.com/examples-itext5");
//        templateBO.setJFreeChartUrl("http://www.yiibai.com/jfreechart/jfreechart_referenced_apis.html");
//        templateBO.setImageUrl("E:/3.png");
//        List<String> scores=new ArrayList<String>();
//        scores.add("94");
//        scores.add("95");
//        scores.add("98");
//        templateBO.setScores(scores);
//        List<Map<String,String>> userList=new ArrayList<Map<String,String>>();
//        Map<String,String> userMap1=new HashMap<String,String>();
//        userMap1.put("username", "张三");
//        userMap1.put("password", "123456");
//        userMap1.put("age", "12");
//        userMap1.put("address", "北京");
//        userList.add(userMap1);
//        Map<String,String> userMap2=new HashMap<String,String>();
//        userMap2.put("username", "张三");
//        userMap2.put("password", "123456");
//        userMap2.put("age", "12");
//        userMap2.put("address", "北京");
//        userList.add(userMap2);
//        templateBO.setUserList(userList);
//        //折线图数据
//        List<Line> lineList=getTemperatureLineList();
//        DefaultLineChart lineChart=new DefaultLineChart();
//        lineChart.setHeight(400);
//        lineChart.setWidth(600);
//        lineChart.setFileName("折现图");;
//        //折线图图片地址
//        String picUrl=lineChart.draw(lineList,0);
//
//        templateBO.setPicUrl(picUrl);
//        System.out.println("picUrl:"+picUrl);
//        String path= kit.createPDF(templateBO,"hello.pdf");
//        System.out.println("打印："+path);
//    }
//
//    public static List<Line> getTemperatureLineList() {
//        List<Line> list= new ArrayList<Line>();
//        for(int i=1;i<=7;i++){
//            Line line=new Line();
//            float random=Math.round(Math.random()*10);
//            line.setxValue("星期"+i);
//            line.setyValue(20+random);
//            line.setGroupName("下周");
//            list.add(line);
//        }
//        for(int i=1;i<=7;i++){
//            Line line=new Line();
//            float random=Math.round(Math.random()*10);
//            line.setxValue("星期"+i);
//            line.setyValue(20+random);
//            line.setGroupName("这周");
//            list.add(line);
//        }
//        return list;
//    }
//    public  String createPDF(Object data, String fileName){
//        //pdf保存路径
//        try {
//            PDFKit kit=new PDFKit();
//            //设置输出路径
//            kit.setSaveFilePath("e:/hello.pdf");
//            String saveFilePath=kit.exportToFile(fileName,data);
//            return  saveFilePath;
//        } catch (Exception e) {
//            System.out.println("竟然失败了，艹！");
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public static void main(String[] args) throws IOException, DocumentException {
//   /* 	File file = new File(DEST);
//          file.getParentFile().mkdirs();
//         createPdf(DEST);*/
//        createPdf2();
//
//    }
//
//
//}
