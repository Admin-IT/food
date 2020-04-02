package edu.nf.food;


import edu.nf.food.food.entity.Food;
import edu.nf.food.food.service.FoodService;
import edu.nf.food.label.entity.Technology;
import edu.nf.food.label.service.TechnologyService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "edu.nf.food")
class ServiceApplicationTest {

    @Autowired
    private TechnologyService technologyService;

    @Autowired
    private FoodService foodService;


    @Test
    void listTechnology() {

        List<Technology> list = technologyService.listTechnology();
        for (Technology technology : list) {
            System.out.println(technology.getTechnologyId());
        }
    }

    @Test
    void listFood() {

        List<Food> list = foodService.listFood();
        for (Food food : list) {
            System.out.println(food.getFoodName());
        }
    }
}