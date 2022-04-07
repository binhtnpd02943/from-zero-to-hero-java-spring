package lgs.learning.spring.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalOnMissingBeanExample {

	public static class SomeMissingBean {

	}

	/*
	 * Nếu trong Context chưa tồn tại một SomeMissingBean nào Thì Bean ở dưới đây
	 * mới được tạo
	 * 
	 * @return
	 */
	@ConditionalOnMissingBean
	SomeMissingBean someMissingBean() {
		return new SomeMissingBean();
	}
}
