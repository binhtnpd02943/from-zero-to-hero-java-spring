package lgs.learning.spring.pageable;




import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByNameLike(String name, Pageable pageable);
}
