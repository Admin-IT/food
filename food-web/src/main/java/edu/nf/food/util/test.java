package edu.nf.food.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ljf
 * @date 2020/4/7
 */
public class test {

    public static void main(String[] args) {
        //创建map
        Map<String, String> map = new HashMap();
        //map 初始化值
        String name = "ljf1";
        String name2 = "ljf2";
        String name3 = "ljf3";
        //赋值 user1为key  代表着ID
        map.put("user1", name);
        map.put("user2", name2);
        map.put("user3", name3);
        //判断map中是否有为user1的值，有则显示
        if (map.containsKey("user1")) {//存在返回true
            //输出值
            System.out.println(map.get("user1"));
        }
        //判断map中是否有user2的值
        if (map.containsKey("user2")) {
            //有则删除
            map.remove("user2");
        }
        //判断map是否有user3的值
        if (map.containsKey("user3")) {
            //有则修改
            map.put("user3", "wjx");
        }
        //循环输出
        for (Map.Entry<String, String> maps : map.entrySet()) {
            System.out.println("key为：" + maps.getKey() + " 值为：" + maps.getValue());
        }

        //map.containsKey() 判断是否存在key  存在返回为true
        //map.containsValue() 判断是否存在value 存在返回true
        //map.containsKey() 前面加上!  可理解为不存在返回true

        // map.put(key,value)  添加值  key代表
    }
}