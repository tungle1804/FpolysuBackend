package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Menu;
import net.javaguides.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    @Query("  from Menu")
    List<Menu> listmenu();

    //	@Query(" from Menu m  where m.users.email like CONCAT('%',:email,'%')")
    @Query(" from Menu m  where m.users.email=:email")
    List<Menu> getMenuByEmail(@Param("email") String email);

    @Query(" from Menu m where m.status=true and m.users.email=:email ")
    List<Menu> getMenuByStatus(@Param("email") String email);
//	@Query(value = "select m from Menu m where m.users.email=:email")
//	Page<Menu> findAllByUser(@Param("email") String email, PageRequest pageRequest);

    @Query("select count(m.id) from Menu m inner join User u on m.users = u.email inner join PaymentHistory p on u.email = p.users where p.users = :p_email " +
            "and (p.status = false or ((select count(*) from PaymentHistory) = 0))")
    Integer getBasicPro(User p_email);

//    @Query("select count(m.id) from Menu m inner join User u on m.users = u.email inner join PaymentHistory p on u.email = p.users where p.users = :p_email " +
//            "and ((select count(*) from PaymentHistory ) = 0)")
//    Integer getCountHistory(User p_user);
}
