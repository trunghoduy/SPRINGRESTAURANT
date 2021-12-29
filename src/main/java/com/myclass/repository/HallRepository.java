package com.myclass.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myclass.dto.HallDto;
import com.myclass.entity.Hall;

public interface HallRepository extends JpaRepository<Hall, Integer>{

	@Query("SELECT h FROM Hall h WHERE h.name = :name")
	Page<Hall> findByName(@Param("name") String name,Pageable pageable);

	@Query("SELECT h FROM Hall h ")
	Page<Hall> findAllpaging(Pageable pageable);

	@Query("SELECT h FROM Hall h WHERE h.price BETWEEN :priceStart AND :priceEnd ")
	Page<Hall> findByPrice(@Param("priceStart") int priceStart, @Param("priceEnd") int priceEnd, Pageable pageable);

	
	
	
	
}
