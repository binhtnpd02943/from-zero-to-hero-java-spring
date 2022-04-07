package lgs.learning.spring.configurationpropertiesanno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class App implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Autowired
	LgsAppProperties lgsAppProperties;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Global variable:");
		System.out.println("\t Email: " + lgsAppProperties.getEmail());
		System.out.println("\t GA ID: " + lgsAppProperties.getGoogleAnalyticsId());
		System.out.println("\t Authors: " + lgsAppProperties.getAuthors());
		System.out.println("\t Example Map: " + lgsAppProperties.getExampleMap());
	}
}
