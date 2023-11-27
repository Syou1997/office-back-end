package com.example.office.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.office.entity.Account;

@Repository
public interface AccountDao extends JpaRepository< Account, Integer> {
	//JPA
	//取得密碼
	public Account findByPwd(String pwd);
	
	
	//JPQL
	
	//防呆，查看此帳戶是否已經被新增了
	@Query(value = "SELECT COUNT(user_id) FROM office.account"
			+ " where user_id = :user_id",nativeQuery = true)
	public int userIdCheck(@Param("user_id")int user_id);
	
	//update帳戶(只能修改權限跟帳戶啟用與否
	@Modifying
	@Transactional
	@Query(value = "update office.account"
			+ " set `account_state` = :accountState,`account_permissions` = :accountPermissions where user_id = :userId",nativeQuery = true)
	public int updateAccount(@Param("accountState")boolean accountState,@Param("accountPermissions")int accountPermissions,@Param("userId")int userId);
	
}
