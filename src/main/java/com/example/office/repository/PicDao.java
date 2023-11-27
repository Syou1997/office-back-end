package com.example.office.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.office.entity.Pic;

@Repository
public interface PicDao extends JpaRepository<Pic, Integer> {
	
	//JPQL
	//取得最後一筆資料
	@Query(value = "SELECT * FROM pic ORDER BY pic_id DESC limit 1",nativeQuery = true)
	public List <Pic> getPicId();


}
