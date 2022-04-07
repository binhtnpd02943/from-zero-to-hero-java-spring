package lgs.learning.spring.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnResource(resources = "/application.properties")
public class ConditionalOnResourceExample {
}
