package com.pg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pg.entity.Officer;


@Repository

public interface ViewOfficerRepository extends JpaRepository< Officer, Integer>{

}
