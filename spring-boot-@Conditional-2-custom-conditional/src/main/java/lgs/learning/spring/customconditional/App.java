package lgs.learning.spring.customconditional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lgs.learning.spring.customconditional.AppConfiguration.SomeBean;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(App.class, args);
		try {
			SomeBean someBean = context.getBean(SomeBean.class);
			System.out.println("SomeBean tồn tại!");
		} catch (Exception e) {
			System.out.println("SomeBean chỉ được tạo nếu chạy trên Window");
		}

	}
}
