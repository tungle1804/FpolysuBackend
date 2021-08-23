package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.ActivityButton;
import net.javaguides.springboot.entity.ActivityMenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivityMenuRepository extends JpaRepository<ActivityMenu,Integer> {
    @Query(value = "select c from ActivityMenu c")
    Page<ActivityMenu> findAll(Pageable pageable);
//////////////////////////////////////////////////////////////////////////
    @Query(value = "select count(*) as TotalClickOnMenuEnable from activity_button join  button on button.id = activity_button.id_button \n" +
            "join menu on menu.id = button.id_menu join  users on users.email = menu.email \n" +
            "where users.email =:email and menu._status = 1 \n" +
            "and DATEPART(HOUR,activity_button.created_at) =:hour\n" +
            "and DAY(activity_button.created_at) =:day\n" +
            "and MONTH(activity_button.created_at) =:month\n" +
            "and YEAR(activity_button.created_at) =:year",nativeQuery = true)
    Integer statisticAllActionOnThisMenuEnable(@Param("email")String email,@Param("hour")Integer hour,@Param("day") Integer day
            ,@Param("month")Integer month,@Param("year")Integer year);
//////////////////////////////////////////////////////
    @Query(value = "select distinct menu.name_menu, count(*) as countNumberClickMenu from activity_button join button on button.id = activity_button.id_button \n" +
            "join menu on menu.id = button.id_menu join  users on users.email = menu.email and" +
            " users.email =:email  group by menu.name_menu",nativeQuery = true)
    Page<Object[]> getTotalNumberClickOnMenu(@Param("email")String email,Pageable pageable);

    @Query(value = "select count(*) as countNumberClickMenu from activity_button join button on button.id = activity_button.id_button \n" +
            "join menu on menu.id = button.id_menu join  users on users.email = menu.email and users.email =:email and activity_button.created_at\n" +
            "between :start AND :end and menu.id =:menuId",nativeQuery = true)
    Page<Object[]> getTotalNumberClickOnMenuByTime(@Param("email")String email,@Param("start")String start,
                                                   @Param("end")String end,@Param("menuId")Integer menuId,Pageable pageable);

//    @Query(value = "select distinct menu.name_menu, count(*) as countNumberClickMenu from activity_button join button on button.id = activity_button.id_button \n" +
//            "join menu on menu.id = button.id_menu join  users on users.email = menu.email and" +
//            " users.email =:email and activity_button.created_at between ?1start and end group by menu.name_menu",nativeQuery = true)
//    Page<Object[]> getTotalNumberClickOnMenuByTimeSelect(@Param("email")String email,Pageable pageable);

    @Query(value = "select distinct menu.name_menu, count(*) as countNumberActionMenu from activity_menu join menu on menu.id = activity_menu.id_menu join users\n" +
            "on users.email = menu.email where users.email =:email group by menu.name_menu",nativeQuery = true)
    Page<Object[]> getTotalNumberActionDisplayOnMenu(@Param("email")String email,Pageable pageable);

//    @Query(value = "select distinct menu.name_menu, count(*) as countNumberActionMenu from activity_menu join menu on menu.id = activity_menu.id_menu join users\n" +
//            "on users.email = menu.email where users.email =:email and  group by menu.name_menu",nativeQuery = true)
//    Page<Object[]> getTotalNumberActionDisplayOnMenuByTime(@Param("email")String email,Pageable pageable);

///////////////////////////////////////////////////////////
    @Query(value = "select button.type_button, count(*) as countNumberActionButtonByType from button join menu on menu.id = button.id_menu join activity_menu\n" +
            "on menu.id = activity_menu.id_menu join users on users.email = menu.email where users.email =:email group by button.type_button",nativeQuery = true)
    Page<Object[]> getTotalNumberActionDisplayOnButtonByType(@Param("email")String email,Pageable pageable);

//    @Query(value = "select  button.type_button, count(*) as countNumberActionButtonByType \n" +
//            "from activity_button join button on button.id = activity_button.id_button\n" +
//            "join menu on menu.id = button.id_menu \n" +
//            "join users on users.email = menu.email \n" +
//            "where users.email =:email and button.id_menu in (select distinct activity_menu.id_menu from activity_menu)\n" +
//            "group by button.type_button",nativeQuery = true)
    @Query(value = "select  b.TypeButton, count(ab) as countNumberActionButtonByType \n" +
            "from ActivityButton ab join Button b on b.id = ab.buttonId\n" +
            "join Menu m on m.id = b.menu.id \n" +
            "join User u on u.email = m.users.email \n" +
            "where u.email =:email and b.menu.id in (select am.menuId from ActivityMenu am)\n" +
            "group by b.TypeButton order by countNumberActionButtonByType")
    Page<Object[]> getTotalNumberClickOnButtonByType(@Param("email")String email,Pageable pageable);
    //////////////////////////////////////////////////////////////////
//    @Query(value = "select activity_button.created_at as ClickTime,menu.name_menu, button.name_button, button.link,activity_button.from_url from \n" +
//            "activity_button join button on button.id = activity_button.id_button\n" +
//            "join menu on menu.id = button.id_menu\n" +
//            "join users on users.email = menu.email\n"
//            )
    @Query(value = "select  ab.CreatedAt as ClickTime,m.name_menu, b.name_button, b.link,ab.fromUrl from \n" +
            "ActivityButton ab join Button b on b.id = ab.buttonId\n" +
            "join Menu m on m.id = b.menu.id\n" +
            "join User u on u.email = m.users.email\n"
    )
    Page<Object[]> getStatisticInformationOfAction(@Param("email")String email,Pageable pageable);


}