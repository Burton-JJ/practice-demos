package com.burton.pdfdemo.component;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Burton
 * @location：com.burton.pdfdemo.component.HandlePdf
 * @title: HandlePdf
 * @projectName practice-demos
 * @description: 手画df
 * @date 2019/6/28 21:38
 */
public class HandlePdf {

    public static void main(String[] args) {
        generatePDFByHand();
    }

    public static void generatePDFByHand() {
        try {
            Document document = new Document();
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(new File("D:\\文件\\TEST.pdf")));
            document.open();

            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font font = new Font(bfChinese);//正常字体
            Font fontBold = new Font(bfChinese, 12, Font.BOLD);//正常加粗字体
            Font fontBig = new Font(bfChinese, 20);//大字体
            Font fontBigBold = new Font(bfChinese, 20, Font.BOLD);//加粗大字体

            //添加主题
            Paragraph theam = new Paragraph("还款计划表", fontBigBold);
            //居中
            theam.setAlignment(Element.ALIGN_CENTER);
            document.add(theam);

            //借款信息
            Paragraph peopleInfo = new Paragraph("借款人：江俊      借款：200万元", font);
            theam.setAlignment(Element.ALIGN_LEFT);
            document.add(peopleInfo);

            //加入空行
            //Paragraph blankRow = new Paragraph(18f, " ");
            //document.add(blankRow);

            //*************表1  3列*****************//
            PdfPTable table1 = new PdfPTable(3);
            table1.setWidthPercentage(90); // 整个表格宽度占页面宽度90%
            table1.setSpacingBefore(20f); // 整个表格距离上一个元素和下一个元素的间距
            table1.setSpacingAfter(20f);
            //得到所有行
            ArrayList<PdfPRow> rows = table1.getRows();
            //设置列宽
            float[] columnWidths = {1f, 2f, 3f};
            table1.setWidths(columnWidths);
            //第一行内容 表中每一个方格就是一个cell
            PdfPCell[] cell0 = new PdfPCell[3];
            //将三个方格放入第一行
            PdfPRow row0 = new PdfPRow(cell0);
            //第一行3个单元格赋值
            cell0[0] = new PdfPCell(new Paragraph("姓名", fontBold));//单元格内容
            cell0[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
            cell0[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
            //这个方格的高度 这一行都会是这个高度
            cell0[0].setFixedHeight(25f);
            cell0[0].setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell0[1] = new PdfPCell(new Paragraph("年龄", fontBold));
            cell0[1].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
            cell0[1].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
            cell0[1].setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell0[2] = new PdfPCell(new Paragraph("性别", fontBold));
            cell0[2].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
            cell0[2].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
            cell0[2].setBackgroundColor(BaseColor.LIGHT_GRAY);
            //将第一行加入行中
            rows.add(row0);

            //同理 多添加几行
            for(int i = 0; i<5; i++) {
                //创建每行3个方格（3列）
                PdfPCell[] cells = new PdfPCell[3];
                //将3个方格放入行中
                PdfPRow row = new PdfPRow(cells);
                cells[0] = new PdfPCell(new Paragraph("江俊",font));//单元格内容
                cells[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
                cells[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
                cells[0].setFixedHeight(25f);

                cells[1] = new PdfPCell(new Paragraph("23"));
                cells[1].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
                cells[1].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

                cells[2] = new PdfPCell(new Paragraph("man"));
                cells[2].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
                cells[2].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

                rows.add(row);

            }


            //***********表2***************//
            //表有2列
            PdfPTable table2 = new PdfPTable(2);
            table2.setWidthPercentage(90);
            table2.setSpacingBefore(20f);
            table2.setSpacingAfter(20f);

            //每列宽度
            float[] columnWidth2 = {1f, 2f};
            table2.setWidths(columnWidth2);
            //得到所有行
            ArrayList<PdfPRow> rows1 = table2.getRows();

            //第一行所有列
            PdfPCell[] cells = new PdfPCell[2];
            //将第一行所有列放入第一行
            PdfPRow row1 = new PdfPRow(cells);

            cells[0] = new PdfPCell(new Paragraph("个人爱好hobby", fontBold));
            cells[0].setHorizontalAlignment(Element.ALIGN_CENTER);
            cells[0].setVerticalAlignment(Element.ALIGN_MIDDLE);
            cells[0].setFixedHeight(25f);
            cells[0].setBackgroundColor(BaseColor.LIGHT_GRAY);
            //合并单元格
            cells[0].setColspan(2);
            //第一行加入行列表
            rows1.add(row1);

            //多加入几行
            for(int i = 0; i<5; i++) {
                //创建每行3个方格（3列）
                PdfPCell[] cells2 = new PdfPCell[2];
                //将2个方格放入行中
                PdfPRow row2 = new PdfPRow(cells2);
                cells2[0] = new PdfPCell(new Paragraph("basketball"));//单元格内容
                cells2[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
                cells2[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
                cells2[0].setFixedHeight(25f);

                cells2[1] = new PdfPCell(new Paragraph("good"));
                cells2[1].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
                cells2[1].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

                rows1.add(row2);

            }

            //把两个表放入文件中
            document.add(table1);
            document.add(table2);
            //关闭文件
            document.close();
            //关闭输出对象
            pdfWriter.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
