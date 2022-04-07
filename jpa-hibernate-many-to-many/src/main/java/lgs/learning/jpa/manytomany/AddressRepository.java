package lgs.learning.jpa.manytomany;

import org.springframework.data.jpa.repository.JpaRepository;

// Kế thừa JpaRepository để giao tiếp với database
public interface AddressRepository extends JpaRepository<Address,Long> {
}
