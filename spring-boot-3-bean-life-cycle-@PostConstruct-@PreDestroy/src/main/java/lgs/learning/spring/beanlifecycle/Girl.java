package lgs.learning.spring.beanlifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Girl {

	@PostConstruct
	public void postConstruct() {
		System.out.println("\t>> Đối tượng Girl sau khi khởi tạo xong sẽ chạy hàm này");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("\t>> Đối tượng Girl trước khi bị destroy thì chạy hàm này");
	}
}
