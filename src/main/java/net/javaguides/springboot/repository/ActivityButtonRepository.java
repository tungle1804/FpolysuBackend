package net.javaguides.springboot.repository;


import net.javaguides.springboot.entity.ActivityButton;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActivityButtonRepository extends JpaRepository<ActivityButton, Integer> {
    @Query(value = "select * from activityButton",nativeQuery = true)
    Page<ActivityButton> findAll(Pageable pageable);
}
