package lgs.learning.spring.configurationproperties;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data // Lombok, xem chi tiết tại bài viết
@Component // Là 1 spring bean
//@PropertySource("classpath:lgs.yml") // Đánh dấu để lấy config từ trong file lgs.yml
@ConfigurationProperties(prefix = "lgs") // Chỉ lấy các config có tiền tố là "lgs"
public class LgsAppProperties {
	private String email;
	private String googleAnalyticsId;

	private List<String> authors;

	private Map<String, String> exampleMap;

	// standard getters and setters
}
