package net.javaguides.springboot.repository;

import java.util.List;

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

	@Query(value = "  from Menu  where email like CONCAT('%',:email,'%')",nativeQuery = true)
	List<Menu> getMenuByEmail(@Param("email") String email);

	@Query(value = " from Menu where status=true and email like CONCAT('%',:email,'%') ",nativeQuery = true)
	List<Menu> getMenuByStatus(@Param("email") String email);
	
}
