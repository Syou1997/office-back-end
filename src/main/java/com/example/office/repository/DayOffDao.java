package com.example.office.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.office.entity.DayOff;

@Repository
public interface DayOffDao extends JpaRepository<DayOff, Integer>{
	
	//JPA
	//靠員工Id取得假單
	public List <DayOff> findAllByUserId(int userId);
	
	//靠員工Team取得假單
	public List <DayOff> findAllByTeam(String team);

}
