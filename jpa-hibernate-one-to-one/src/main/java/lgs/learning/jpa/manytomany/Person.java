package lgs.learning.jpa.manytomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
