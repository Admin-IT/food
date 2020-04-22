package edu.nf.food;


import edu.nf.food.food.entity.Food;
import edu.nf.food.food.service.FoodService;
import edu.nf.food.label.entity.Technology;
import edu.nf.food.label.service.TechnologyService;
import edu.nf.food.message.service.ProducerService;
import edu.nf.food.user.entity.User;
import edu.nf.food.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "edu.nf.food")
class ServiceApplicationTest {

    @Autowired
    private ProducerService service;

    @Test
    public void testSendMessage() {
        service.sendMessage("Hello world");
    }

    @Test
    public void testSendObject() {
        Technology orderDTO = new Technology();
        orderDTO.setTechnologyId(10001);
        orderDTO.setTechnologyName("烤");
        service.sendObject(orderDTO);
    }

}