package lgs.learning.spring.customconditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/*
Một điều kiện, phải kế thừa lớp Condition của Spring Boot cung cấp*/
public class WindowRequired implements Condition {

	@Override
	public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
		// Nếu OS ra window trả ra true.
		return System.getProperty("os.name").toLowerCase().contains("win");
	}
}
