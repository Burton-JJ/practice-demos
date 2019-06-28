package com.burton.pdfdemo.component;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Burton
 * @location：com.burton.pdfdemo.component.TempletePdf
 * @title: PdfTempletePdf
 * @projectName practice-demos
 * @description:根据pdf模板生成pdf
 * @date 2019/6/28 23:28
 */
public class PdfTempletePdf {

    public static void main(String[] args) {
        generatePdf();
    }

    public static void generatePdf() {
        //pdf 模板地址
        String templetePath = "D:\\文件\\wordPpt\\pdfTempletefinal.pdf";
        //生成pdf输出地址
        String outPath = "D:\\文件\\pdfTemp.pdf";

        try {
            //字体
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font font = new Font(bfChinese);//正常字体
            Font fontBold = new Font(bfChinese, 12, Font.BOLD);//正常加粗字体
            Font fontBig = new Font(bfChinese, 20);//大字体
            Font fontBigBold = new Font(bfChinese, 20, Font.BOLD);//加粗大字体

            //输出流
            FileOutputStream fileOutputStream = new FileOutputStream(new File(outPath));
            //读取器 读取pdf模板
            PdfReader reader = new PdfReader(templetePath);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            PdfStamper stamper = new PdfStamper(reader, byteArrayOutputStream);
            //得到模板中需要填写的域
            AcroFields fields = stamper.getAcroFields();
            //设置字体 不能设置大小
            fields.addSubstitutionFont(bfChinese);
            //设置文字 key为pdf模板中设定的 value为自己想要呈现在pdf空格上的
            fields.setField("name", "江俊");
            fields.setField("friendName", "圆周行");
            fields.setField("hotel", "如家精选");
            fields.setField("hobby1", "basketball");
            fields.setField("hobby2", "pingpang");
            fields.setField("level1", "well");
            fields.setField("level2", "well");
            fields.setField("level2", "well");

            //设置图片
            int pageNo = fields.getFieldPositions("img").get(0).page;
            Rectangle rectangle = fields.getFieldPositions("img").get(0).position;
            float x = rectangle.getLeft();
            float y = rectangle.getBottom();
            //根据图片路劲获取图片
            Image image = Image.getInstance("D:\\文件\\西塘pc\\touxiang.jpg");
            //获取图片页面
            PdfContentByte pdfContentByte = stamper.getOverContent(pageNo);
            //图片大小自适应
            image.scaleToFit(rectangle.getWidth(), rectangle.getHeight());
            //添加图片
            image.setAbsolutePosition(x, y);
            pdfContentByte.addImage(image);
            // 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
            stamper.setFormFlattening(true);
            stamper.close();

            Document doc = new Document();
            //Font newfont = new Font(bfChinese, 32);
            PdfCopy copy = new PdfCopy(doc, fileOutputStream);
            doc.open();
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(byteArrayOutputStream.toByteArray()), 1);
            copy.addPage(importPage);
            doc.close();
            byteArrayOutputStream.close();
            fileOutputStream.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
