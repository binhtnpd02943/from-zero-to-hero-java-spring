package lgs.learning.spring.jpaauditing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// Bạn phải kích hoạt chức năng Auditing bằng annotation @EnableJpaAuditing
@EnableJpaAuditing
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Autowired
	AppParamsRepository appParamsRepository;

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			AppParams appParams = AppParams.builder().paramName("lgs").paramValue("handsome - https://lgs.me")
					.build();
			System.out.println("Đối tượng Param trước khi insert: " + appParams);
			appParamsRepository.save(appParams);
			System.out.println("Đối tượng Param sau khi insert: " + appParams);

			System.out.println("In ra tất cả bản ghi trong DB:");
			System.out.println(appParamsRepository.findAll());
		};
	}
}
