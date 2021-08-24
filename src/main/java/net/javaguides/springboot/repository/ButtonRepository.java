package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Button;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ButtonRepository extends JpaRepository<Button, Integer> {
    @Query("  from Button")
    List<Button> listbutton();

    Optional<Button> findById(Integer id);
//	@Query(" from Button b where b.menu.id_menu=:id_menu")
//	List<Button> listButtonByIdMenu(@Param("id_menu") int id_menu);

    @Query(" from Button b where b.menu.id=:id_menu")
    List<Button> listButtonByIdMenu(@Param("id_menu") int id_menu);

}
