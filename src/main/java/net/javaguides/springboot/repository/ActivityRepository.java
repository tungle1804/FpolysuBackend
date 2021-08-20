package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Activity;
import net.javaguides.springboot.entity.ButtonFake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
