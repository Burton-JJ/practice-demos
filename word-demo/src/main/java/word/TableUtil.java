package word;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

/**
 * @author Burton
 * @location：word.TableUtil
 * @title: TableUtil
 * @projectName practice-demos
 * @description: sit-b修改
 * @date 2019/7/14 23:16
 */
public class TableUtil {

    public static void main(String[] args) {
        TableUtil tableUtil = new TableUtil();
        tableUtil.exportWordContainTab("D:\\文件\\wordPpt\\month.doc");
    }
    /**
     * 文件导出
     * @param exportFilePath
     */
    public void exportWordContainTab(String exportFilePath){
        try(OutputStream os = new FileOutputStream(exportFilePath)) {
            XWPFDocument doc = createDocument();
            doc.write(os);
            System.out.println("导出成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 创建文档
     * @return
     */
    public XWPFDocument createDocument() {
        XWPFDocument doc = new XWPFDocument();
        //添加标题
        XWPFParagraph titleParagraph = doc.createParagraph();

        //设置段落居中
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleParagraphRun = titleParagraph.createRun();
        titleParagraphRun.setText("杭州兰悦汽车服务有限公司出车表");
        titleParagraphRun.setColor("000000");
        titleParagraphRun.setFontSize(22);
        titleParagraphRun.setFontFamily("宋体");

        //设置空行
        XWPFParagraph titleParagraph2 = doc.createParagraph();
        titleParagraph2.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleParagraphRun2 = titleParagraph2.createRun();
        titleParagraphRun.setText("\r");


        //创建表格
        //这里的createTable括号里的值可以先不填，我这是直接创建了一个八行四列的表格
        XWPFTable table = doc.createTable(1, 7);

        //去掉表格边框
        //table.getCTTbl().getTblPr().unsetTblBorders();

        //设置表格宽度
        setTableWidth(table, "9000");

        //得到刚刚创建的第一行
        XWPFTableRow row1 = table.getRow(0);


        //下面这四句是给表格第一行的每一列设置宽度
        //也不知道效果到底有没有 我加上去了 感觉是有的
        //设置了一行之后 其他行的默认样式也会跟着变
//        row1.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(900));
//        row1.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000));
//        row1.getCell(2).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(900));
//        row1.getCell(3).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000));


        //设置字体样式
        //需求是要求  正文用某种字体大小 英文用某种字体大小  某个特殊的内容需要加粗下划线等等
        //为了样式的排版 所以我用了表格的形式写入内容 所以字体这块处理我用了很繁琐的方式
        //之前查了很多资料 以为能跟execel一样 一次性把表格里所有的字体设置好样式
        //但是找了很久都没有找到
        //所以还是决定写个方法老老实实的一个单元格一个单元格的赋值
        //希望有大佬能教教我有啥更简便的方式
        for (int i = 0; i<7; i++) {
            setStyleToFont(row1, i, "宋体", 14, WeekDays.getDescByNum(i), false, false, false);
        }


        //因为有很多内容是需要动态添加的 所以这个时候就可以在原来的table后追加行
        //也有很多方法可以在行与行之间插入，大家可以去博客里面找
        //下面直接createRow就是在表格最后新增一行
        XWPFTableRow row2 = table.createRow();
//        setStyleToFont(row2, 0, "宋体", 14, "内容1", false, false, false);
//        setStyleToFont(row2, 1, "宋体", 14, "内容2", true, true, true);
        for (int i = 0; i<7; i++) {
            setStyleToFont(row2, i, "宋体", 14, String.valueOf(i), false, false, false);
        }

        XWPFTableRow row3 = table.createRow();
//        setStyleToFont(row2, 0, "宋体", 14, "内容1", false, false, false);
//        setStyleToFont(row2, 1, "宋体", 14, "内容2", true, true, true);
        for (int i = 0; i<7; i++) {
            setStyleToFont(row3, i, "宋体", 14, " ", false, false, false);
        }

        //合并列
        //拿到了最后一行的下标 对新追加的行 进行合并列操作
        //mergeCellsHorizontal(table, table.getNumberOfRows() - 1, 1, 3);


        return doc;
    }


    /**
     * 给单元格的文本内容设置字体
     *
     * @param row        当前行
     * @param cellIndex  列下标
     * @param fontFamily 字体风格
     * @param fontSize   字体大小
     * @param text       写入的内容
     * @param bold       是否加粗
     * @param italic     是否倾斜
     * @param underline  下划线
     */
    private void setStyleToFont(XWPFTableRow row, int cellIndex, String fontFamily, int fontSize, String text, boolean bold, boolean italic, boolean underline) {
        //这里我是根据一个博主发的贴看到的 博主当时用的是row.getCell(0).addParagraph();
        //用add会使单元格换行，然后下面评论里面的一个大佬说换成getParagraphs()
        //果然大佬说的没错，这样效果很完美
        XWPFParagraph pIO = row.getCell(cellIndex).getParagraphs().get(0);

        XWPFRun rIO = pIO.createRun();
        rIO.setFontFamily(fontFamily);
        rIO.setFontSize(fontSize);
        rIO.setText(text);
        rIO.setItalic(italic);
        rIO.setBold(bold);
        if (underline) {
            rIO.setUnderline(UnderlinePatterns.SINGLE);
        }
    }

    /***
     * 合并列
     * @param table
     * @param row 当前行下标
     * @param fromCell  起始列
     * @param toCell   终止列
     */
    private void mergeCellsHorizontal(XWPFTable table, int row, int fromCell, int toCell) {
        for (int cellIndex = fromCell; cellIndex <= toCell; cellIndex++) {
            XWPFTableCell cell = table.getRow(row).getCell(cellIndex);
            if (cellIndex == fromCell) {
                // The first merged cell is set with RESTART merge value
                cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.RESTART);
            } else {
                // Cells which join (merge) the first one, are set with CONTINUE
                cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.CONTINUE);
            }
        }

    }

    /***
     * 导出word 设置行宽
     * @param table
     * @param width
     */
    private void setTableWidth(XWPFTable table, String width) {
        CTTbl ttbl = table.getCTTbl();
        CTTblPr tblPr = ttbl.getTblPr() == null ? ttbl.addNewTblPr() : ttbl.getTblPr();
        CTTblWidth tblWidth = tblPr.isSetTblW() ? tblPr.getTblW() : tblPr.addNewTblW();
        CTJc cTJc = tblPr.addNewJc();
        cTJc.setVal(STJc.Enum.forString("center"));
        tblWidth.setW(new BigInteger(width));
        tblWidth.setType(STTblWidth.DXA);


    }


}
