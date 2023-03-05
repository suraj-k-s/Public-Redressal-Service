package com.pg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pg.entity.RegData;

@Repository
public interface RegDataRepository extends JpaRepository<RegData, Integer>{

	RegData findByTrackId(String trackId);
	
	@Query(value="select r from RegData r where r.trackId= :t")
	public RegData getDetails(@Param("t") String trackId);
}
