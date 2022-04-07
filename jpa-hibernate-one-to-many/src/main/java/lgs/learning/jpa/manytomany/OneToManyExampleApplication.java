package lgs.learning.jpa.manytomany;

import java.util.Collections;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class OneToManyExampleApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(OneToManyExampleApplication.class, args);
    }

    // Sử dụng @RequiredArgsConstructor và final để thay cho @Autowired
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {
        // Tạo ra đối tượng Address có tham chiếu tới person
        Address address = new Address();
        address.setCity("Hanoi");

        // Tạo ra đối tượng person
        Person person = new Person();
        person.setName("lgs");
        person.setAddress(address);

        address.setPersons(Collections.singleton(person));
        // Lưu vào db
        // Chúng ta chỉ cần lưu address, vì cascade = CascadeType.ALL nên nó sẽ lưu luôn Person.
        addressRepository.saveAndFlush(address);


        // Vào: http://localhost:8080/h2-console/ để xem dữ liệu đã insert

        personRepository.findAll().forEach(p -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
            System.out.println(p.getAddress());
        });
    }

}
