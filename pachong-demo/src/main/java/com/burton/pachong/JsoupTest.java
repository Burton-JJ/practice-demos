package com.burton.pachong;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Burton
 * @title: JsoupTest
 * @projectName practice-demos
 * @description: jsoup入门演练
 * @date 2019/7/180:57
 */
public class JsoupTest {

    //年份正则
    private static final Pattern yearPattern = Pattern.compile("[0-9]{4}");
    private static final Pattern holidayPattern1 = Pattern.compile("[0-9]{1,2}月[0-9]{1,2}日放假。");
    private static final Pattern holidayPattern2 = Pattern.compile("[0-9]{1,2}月[0-9]{1,2}日放假，与周末连休。");
    private static final Pattern holidayPattern3 = Pattern.compile("([0-9]{4}年)?[0-9]{1,2}月[0-9]{1,2}日至([0-9]{4}年)?([0-9]{1,2}月)?[0-9]{1,2}日放假调休");


    //2018年12月30日至2019年1月1日放假调休
    public static void main(String[] args) throws IOException {
        String fileUrl = null;
        String year = null;
        String url = "http://sousuo.gov.cn/s.htm?t=paper&advance=false&n=&timetype=&mintime=&maxtime=&sort=&q=%E8%8A%82%E5%81%87%E6%97%A5";
        Document doc = null;
        doc = Jsoup.connect(url).userAgent("Mozilla").get();
        Elements div = doc.getElementsByClass("result");
        Elements ul = div.get(0).getElementsByTag("ul");
        Elements lis = ul.get(0).getElementsByTag("li");
        for (Element li : lis) {
            Elements h3s = li.getElementsByClass("res-sub-title");
            Element a = h3s.get(0).getElementsByTag("a").get(0);
            //获取网址
            fileUrl = a.attr("abs:href");
            System.out.println(fileUrl);
            //获取文字 todo 正则表达式匹配出年份
            String characters = a.text();
            System.out.println(characters);
            Matcher matcher = yearPattern.matcher(characters);
            if (matcher.find()) {
                year = matcher.group();
                System.out.println(year);
            } else {
                System.out.println("未获得年份信息");
            }
            if ("2019".equals(year)) {
                break;
            }

        }
        if (fileUrl != null) {
            System.out.println("获取链接成功");
            doc = Jsoup.connect(fileUrl).userAgent("Mozilla").get();
            Elements ps = doc.getElementById("UCAP-CONTENT")
                    .getElementsByTag("p");
            for (Element element : ps) {
                String dateTime;
                System.out.println(element.text());
                Matcher matcher = holidayPattern3.matcher(element.text());
                while(matcher.find()) {
                    System.out.println("匹配到了");
                    matcher.group();
                }
            }

            String date1 = "20190226";
            String date2 = "2019022601";
            int i = date2.compareTo(date1);
            System.out.println(i);

        }
    }
}
