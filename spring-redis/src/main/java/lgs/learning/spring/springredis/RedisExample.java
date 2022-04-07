package lgs.learning.spring.springredis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisExample implements CommandLineRunner {
	@Autowired
	private RedisTemplate template;

	@Override
	public void run(String... args) throws Exception {
		listExample();
	}

	public void valueExample() {
		// Set giá trị của key "lgs" là "hello redis"
		template.opsForValue().set("lgs", "hello world");

		// In ra màn hình Giá trị của key "lgs" trong Redis
		System.out.println("Value of key lgs: " + template.opsForValue().get("lgs"));
	}

	public void listExample() {
		// Tạo ra một list gồm 2 phần tử
		List<String> list = new ArrayList<>();
		list.add("Hello");
		list.add("redis");

		// Set gia trị có key lgs_list
		template.opsForList().rightPushAll("lgs_list", list);
//        template.opsForList().rightPushAll("lgs_list", "hello", "world");

		System.out.println("Size of key lgs: " + template.opsForList().size("lgs_list"));
	}
}
