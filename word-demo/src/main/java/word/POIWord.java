package word;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

/**
 * @author Burton
 * @title: POIWord
 * @projectName practice-demos
 * @description: TODO
 * @date 2019/7/1322:12
 */
public class POIWord {
    public static void main(String[] args) throws IOException {
        //todo git sit-A测试
        //新建文件
        XWPFDocument xwpfDocument = new XWPFDocument();
        FileOutputStream fos = new FileOutputStream(new File("D:\\文件\\wordPpt\\month.doc"));
        //region 标题
        //新建标题段落
        //sit-A 测试
        XWPFParagraph titleParagrah = xwpfDocument.createParagraph();
        //设置居中
        titleParagrah.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleXWPFRun = titleParagrah.createRun();
        titleXWPFRun.setText("杭州兰悦汽车服务有限公司出车表");
        titleXWPFRun.setColor("000000");
        titleXWPFRun.setFontSize(20);
        //endregion
        //region 标题
        XWPFTable table = xwpfDocument.createTable(5,7);
        //列宽自动分割
        CTTblWidth tableWidth = table.getCTTbl().addNewTblPr().addNewTblW();
        tableWidth.setType(STTblWidth.DXA);
        tableWidth.setW(BigInteger.valueOf(9072));

        XWPFTableRow rowOne = table.getRow(0);
        rowOne.createCell().setText("星期日");
        rowOne.createCell().setText("星期一");
        rowOne.createCell().setText("星期二");
        rowOne.createCell().setText("星期三");
        rowOne.createCell().setText("星期四");
        rowOne.createCell().setText("星期五");
        rowOne.createCell().setText("星期六");

        XWPFTableRow rowTwo = table.getRow(1);
        rowTwo.createCell().setText("1");
        rowTwo.createCell().setText("2");
        rowTwo.createCell().setText("3");
        rowTwo.createCell().setText("4");
        rowTwo.createCell().setText("5");
        rowTwo.createCell().setText("6");
        rowTwo.createCell().setText("7");

        XWPFTableRow rowThree = table.getRow(2);
        rowThree.createCell().setText("   ");
        rowThree.createCell().setText("   ");
        rowThree.createCell().setText("   ");
        rowThree.createCell().setText("   ");
        rowThree.createCell().setText("   ");
        rowThree.createCell().setText("   ");
        rowThree.createCell().setText("   ");

        xwpfDocument.write(fos);
        fos.close();
    }
}
