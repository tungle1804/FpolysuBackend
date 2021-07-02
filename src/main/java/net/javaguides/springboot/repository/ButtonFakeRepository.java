package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.ButtonFake;

public interface ButtonFakeRepository extends JpaRepository<ButtonFake, Integer> {

}
