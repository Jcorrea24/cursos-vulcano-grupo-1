package com.grupo1.cursosvulcano.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo1.cursosvulcano.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
