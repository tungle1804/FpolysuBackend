package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.javaguides.springboot.model.Button;
import net.javaguides.springboot.model.Menu;

public interface MenuRepository extends JpaRepository<Menu,Integer>{
	@Query("  from Menu")
	List<Menu> listmenu();
	@Query("  from Menu  where email like CONCAT('%',:email,'%')")
	List<Menu> getMenuByEmail(@Param("email") String email);
	@Query(" from Menu where status=true and email like CONCAT('%',:email,'%') ")
	List<Menu> getMenuByStatus(@Param("email") String email);
	
}
