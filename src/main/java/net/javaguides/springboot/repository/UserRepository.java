package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.javaguides.springboot.model.Button;
import net.javaguides.springboot.model.Menu;
import net.javaguides.springboot.model.User;

public interface UserRepository extends JpaRepository<User,String> {
//	@Query("  from User")
//	List<Button> listbutton();
	
}
