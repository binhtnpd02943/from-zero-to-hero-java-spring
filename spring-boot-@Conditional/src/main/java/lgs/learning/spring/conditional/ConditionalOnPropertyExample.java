package lgs.learning.spring.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalOnPropertyExample {

	/*
	 * @ConditionalOnProperty giúp gắn điều kiện cho @Bean dựa theo property trong
	 * config
	 */
	@Bean
	@ConditionalOnProperty(value = "lgs.bean2.enabled", havingValue = "true", // Nếu giá trị lgs.bean2.enabled = true
																				// thì Bean mới được khởi tạo
			matchIfMissing = false) // matchIFMissing là giá trị mặc định nếu không tìm thấy property
									// lgs.bean2.enabled
	ABeanWithCondition2 aBeanWithCondition2() {
		return new ABeanWithCondition2();
	}
}
