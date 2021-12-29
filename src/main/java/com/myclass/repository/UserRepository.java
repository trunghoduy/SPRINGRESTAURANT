package com.myclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myclass.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("SELECT u FROM User u WHERE u.role_id = 2")
	List<User> findAllRole_id();
	
	@Query("SELECT u FROM User u WHERE u.email= :email")
	User findByEmail(@Param("email") String email);

	@Query("SELECT u FROM User u WHERE u.phone= :phone and u.role_id = 2")
	User findByPhone(@Param("phone")String phone);

	void deleteById(int id);
}
