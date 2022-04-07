package lgs.learning.spring.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalOnBeanExample {
	/*
	 * Đây là một Bean, bạn hãy chạy ứng dụng khi comment và chạy lại lần nữa nhưng
	 * bỏ dấu comment phía dưới để xem kết quả.
	 */

	// @Bean
	RandomBean randomBean() {
		return new RandomBean();
	}

	/*
	 * ABeanWithCondition chỉ được tạo ra, khi RandomBean tồn tại trong Context.
	 */
	@Bean
	@ConditionalOnBean(RandomBean.class)
	ABeanWithCondition aBeanWithACondition() {
		return new ABeanWithCondition();
	}
}
