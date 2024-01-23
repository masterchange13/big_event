package com.mao.softwaredesigner1227.Test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Date;
import java.util.concurrent.TimeUnit;


@SpringBootTest // 如果在测试类上添加这个注解，那么将来单元测试方法执行之前会先初始化spring容器
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testSet() {
        // 向redis存储键值对
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set("name", "张三");
        stringStringValueOperations.set("id", "1", 15, TimeUnit.SECONDS);
    }

    @Test
    public void testGet() {
        // 从redis中获取键值对
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        String name = stringStringValueOperations.get("name");
        System.out.println(name);
    }

    @Test
    public void showTime(){
        System.out.println(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 300));
    }
}
