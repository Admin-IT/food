package edu.nf.food.utils;

import edu.nf.food.food.entity.Content;
import edu.nf.food.food.entity.Food;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ljf
 * @date 2020/4/16
 * 获取网页 相关信息
 */
@Component
public class HtmlPareUtil {

//    public static void main(String[] args) throws Exception{
//        new HtmlPareUtil().parseJD("烤").forEach(System.out::println);
//    }

    public List<Content> parseJD(String keyword) throws Exception {
        //获取请求，https://search.jd.com/Search?keyword=java&enc=utf-8
        // 前提 需要联网
        String url = "https://so.meishi.cc/index.php?q=" + keyword + "&enc=utf-8";
        //解析网页
        Document document = Jsoup.parse(new URL(url), 30000);
        // 所有你在js中可以使用的方法，这里都能用!
        Elements element = document.getElementsByClass("search2015_cpitem_w");
//         System.out.println(element.html());

        //创建  集合
        ArrayList<Content> foodsList = new ArrayList<>();
        for (Element element1 : element) {
            // 获取外框内的div元素
            Elements elements = element1.getElementsByClass("search2015_cpitem");
            for (Element el : elements) {
                //获取所有div下的元素
                //获取图片
                String img = el.getElementsByTag("img").eq(0).attr("src");
                // 获取 名字
                String foodId = el.getElementsByClass("cpn").eq(0).text();
                //简介
                String js = el.getElementsByClass("des").eq(0).text();
                System.out.println("---------------");
                System.out.println(img);
                System.out.println(foodId);
                System.out.println(js);
                Content food = new Content();
                food.setTitle(foodId);
                food.setPrice(js);
                food.setImg(img);
                //放入集合
                foodsList.add(food);
            }
        }


        return foodsList;
    }


}