package com.codewarsH.elPlan.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewarsH.elPlan.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

User findByUsername(String username);
//	Optional<User> findByEmail(String username);
	
}
