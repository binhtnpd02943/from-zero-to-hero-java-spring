package lgs.learning.spring.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lgs.learning.spring.swagger.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
