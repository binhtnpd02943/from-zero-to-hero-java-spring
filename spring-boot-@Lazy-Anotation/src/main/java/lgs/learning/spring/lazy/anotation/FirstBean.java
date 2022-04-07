package lgs.learning.spring.lazy.anotation;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class FirstBean {
    public FirstBean() {
        System.out.println("Bean FirstBean đã được khởi tạo!");
    }
}
