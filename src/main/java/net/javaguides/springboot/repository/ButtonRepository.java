package net.javaguides.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.javaguides.springboot.entity.Button;
import org.springframework.stereotype.Repository;

@Repository
public interface ButtonRepository extends JpaRepository<Button,Integer> {
	@Query("  from Button")
	List<Button> listbutton();
Optional<Button> findById(Integer id);
//	@Query(" from Button b where b.menu.id_menu=:id_menu")
//	List<Button> listButtonByIdMenu(@Param("id_menu") int id_menu);

	@Query(" from Button b where b.menu.id=:id_menu")
	List<Button> listButtonByIdMenu(@Param("id_menu") int id_menu);
	
}
