package lgs.learning.spring.specification;

import static lgs.learning.spring.specification.User.UserType.NORMAL;
import static lgs.learning.spring.specification.UserSpecification.hasId;
import static lgs.learning.spring.specification.UserSpecification.hasIdIn;
import static lgs.learning.spring.specification.UserSpecification.hasType;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    private final UserRepository userRepository;

    @Bean
    CommandLineRunner run() {
        return args -> {
            // Lấy ra user nằm trong tập ID đã cho và có type là NORMAL
            // hoặc lấy ra user có ID = 10
            Specification conditions = Specification.where(hasIdIn(Arrays.asList(1L, 2L, 3L, 4L, 5L)))
                                                    .and(hasType(NORMAL))
                                                    .or(hasId(10L));
            // Truyền Specification vào hàm findAll()
            userRepository.findAll(conditions).forEach(System.out::println);
        };
    }

}
