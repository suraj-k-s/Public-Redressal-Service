package com.pg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pg.entity.Admindetails;



@Repository
public interface ViewAdminDetailsRepository extends JpaRepository< Admindetails, Integer> {

}
