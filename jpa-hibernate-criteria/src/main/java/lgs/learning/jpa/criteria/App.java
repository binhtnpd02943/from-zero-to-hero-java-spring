package lgs.learning.jpa.criteria;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lgs.learning.jpa.criteria.User.UserType;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    private final UserRepository userRepository;
    private final CustomUserRepository customUserRepository;

    @Bean
    CommandLineRunner run() {
        return args -> {
            // Get User by ID
            System.out.println(customUserRepository.getUserById(10L));
            System.out.println("=======");

            // Get User by Name Like and Type
            System.out.println(customUserRepository.getUserByComplexConditions("name-%", UserType.NORMAL));
            System.out.println("=======");
        };
    }

}
