package edu.nf.food;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author admin
 * @date 2020/3/11
 */
@SpringBootApplication
@MapperScan(basePackages = {"edu.nf.food.label.dao", "edu.nf.food.food.dao", "edu.nf.food.user.dao", "edu.nf.food.video.dao"})
public class FoodApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodApplication.class, args);
    }
}