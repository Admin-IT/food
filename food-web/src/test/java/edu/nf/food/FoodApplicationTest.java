package edu.nf.food;

//import io.lettuce.core.api.sync.RedisCommands;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author ljf
 * @date 2020/3/30
 */
@SpringBootTest
@SpringBootApplication(scanBasePackages = "edu.nf.food")
public class FoodApplicationTest {

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Autowired
//    private RedisTemplate<String,Object> redisTemplate;
//
//    @Test
//    void contextLoads() {
////        System.out.println(redisTemplate);
//        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
//        ops.set("namg","yy");
//        String namg = ops.get("namg");
//        System.out.println(namg);
//    }
//
//
//    @Test
//    void testForValues() {
//        //添加
//        stringRedisTemplate.opsForValue().set("user:1001", "user1");
//        //依据key获取value
//        String name = stringRedisTemplate.opsForValue().get("user:1001");
//        System.out.println(name);
//        //删除
//        stringRedisTemplate.delete("user:1001");
//    }
//
//    @Test
//    void testForValue(){
//        //添加
//        redisTemplate.opsForValue().set("user:1001","user1");
//        //根据key获取value
//        String name=stringRedisTemplate.opsForValue().get("user:1001");
//        System.out.println(name);
//    }
//
//    @Test
//    void testPush(){
////        redisTemplate.opsForList().leftPush("list1","user1");
////        redisTemplate.opsForList().rightPush("list1","user2");
//
//        String list1 = stringRedisTemplate.opsForList().index("list1", 0);
//        System.out.println(list1);
//    }

//    @Test
//    void testUsers(){
//        Users users=new Users();
//        users.setId(1001);
//        users.setName("王进喜");
//        users.setAddress("珠海");
//        redisTemplate.opsForValue().set("Users:1001",users);
//
//        Users user = (Users) redisTemplate.opsForValue().get("Users:1001");
//        System.out.println(user.getName());
//    }

}