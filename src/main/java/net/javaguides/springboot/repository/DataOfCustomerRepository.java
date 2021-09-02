package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.DataOfCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
<<<<<<< HEAD
public interface DataOfCustomerRepository extends JpaRepository<DataOfCustomer, String> {
=======
public interface DataOfCustomerRepository  extends JpaRepository<DataOfCustomer,Integer> {
>>>>>>> d72fff00065cc0c712d96b4c01edc6266772614e

//    @Query("from DataOfCustomer")
//    List<DataOfCustomer> listDataOfCustomer();

    @Query(value = "from DataOfCustomer where fullName like concat('%',:fullname,'%') ")
    List<DataOfCustomer> getDataOfCustomerByFullName(@Param("fullname") String fullname);

    @Query(value = "from DataOfCustomer where email=:email")
    List<DataOfCustomer> getDataOfCustomersByUsers(String email);


}
