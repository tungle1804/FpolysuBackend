package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    User findOneByEmail(String email);

    Boolean existsByEmail(String email);

    @Query(value = "from User u where u.role = 'admin' or u.role = 'employee'")
    List<User> getUserByRole();

    @Query(value = "select distinct u.role from User u where u.role not in ('customer')")
    List<String> getRole();

    @Query(value = "from User u where u.role = 'customer'")
    List<User> getUserByRoleCustomer();

    @Query(value = "select distinct u.status from User u ")
    List<String> getStatus();

    int countByRole(String role);

}
