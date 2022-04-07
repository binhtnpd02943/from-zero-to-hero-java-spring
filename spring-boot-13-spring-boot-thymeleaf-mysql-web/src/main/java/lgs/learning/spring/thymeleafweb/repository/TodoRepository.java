package lgs.learning.spring.thymeleafweb.repository;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lgs.learning.spring.thymeleafweb.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
