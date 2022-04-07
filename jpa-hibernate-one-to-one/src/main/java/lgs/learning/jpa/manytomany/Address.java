package lgs.learning.jpa.manytomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Data;

@Entity // Đánh dấu đây là table trong db
@Data // lombok giúp generate các hàm constructor, get, set v.v.
@Builder // lombok giúp tạo class builder
public class Address {

    @Id //Đánh dấu là primary key
    @GeneratedValue // Giúp tự động tăng
    private Long id;

    private String city;
    private String province;

    @OneToOne // Quan hệ 1-1 với đối tượng ở dưới (Person)
    @JoinColumn(name = "person_id") // thông qua khóa ngoại person_id
    private Person person;
}
