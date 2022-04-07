package lgs.learning.jpa.manytomany;


import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.common.collect.Lists;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class ManyToManyExampleApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ManyToManyExampleApplication.class, args);
    }

    // Sử dụng @RequiredArgsConstructor và final để thay cho @Autowired
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Tạo ra đối tượng Address
        Address hanoi = Address.builder()
                                 .city("hanoi")
                                 .build();
        Address hatay = Address.builder()
                               .city("hatay")
                               .build();

        // Tạo ra đối tượng person
        Person person1 = Person.builder()
                              .name("lgs1")
                              .build();
        Person person2 = Person.builder()
                              .name("lgs2")
                              .build();

        // set Persons vào address
        hanoi.setPersons(Lists.newArrayList(person1, person2));
        hatay.setPersons(Lists.newArrayList(person1));

        // Lưu vào db
        // Chúng ta chỉ cần lưu address, vì cascade = CascadeType.ALL nên nó sẽ lưu luôn Person.
        addressRepository.saveAndFlush(hanoi);
        addressRepository.saveAndFlush(hatay);


        // Vào: http://localhost:8080/h2-console/ để xem dữ liệu đã insert

        Address queryResult = addressRepository.findById(1L).get();
        System.out.println(queryResult.getCity());
        System.out.println(queryResult.getPersons());

    }

}
