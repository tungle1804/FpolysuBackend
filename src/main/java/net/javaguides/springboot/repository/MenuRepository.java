package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.javaguides.springboot.entity.Menu;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;


@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer>{
	@Query("  from Menu")
	List<Menu> listmenu();

//	@Query(" from Menu m  where m.users.email like CONCAT('%',:email,'%')")
@Query(" from Menu m  where m.users.email=:email")
	List<Menu> getMenuByEmail(@Param("email") String email);

<<<<<<< HEAD

	@Query(" from Menu m where m.status = true and m.users.email = :email ")
	List<Menu> getMenuByStatus(@Param("email") String email);
//
//	@Query(" from Menu where status=true and email=:email ")


	
=======
	@Query(" from Menu m where m.status=true and m.users.email=:email ")
	List<Menu> getMenuByStatus(@Param("email") String email);
//	@Query(value = "select m from Menu m where m.users.email=:email")
//	Page<Menu> findAllByUser(@Param("email") String email, PageRequest pageRequest);
>>>>>>> 36ef5c9d14449dbf46b9e59111b3bb94c0f9d30f
}
