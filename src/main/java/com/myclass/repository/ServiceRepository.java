package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer>{

}
