package lgs.learning.spring.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;

/*
Configuration ConditionalOnExpressionExample chỉ được tạo
khi cả 2 điều kiện thỏa mãn*/
@Configuration
@ConditionalOnExpression("${lgs.expression1.enabled:true} and ${lgs.expression2.enabled:true}")
public class ConditionalOnExpressionExample {
}
