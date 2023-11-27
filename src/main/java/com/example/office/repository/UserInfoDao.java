package com.example.office.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.office.entity.UserInfo;
import com.example.office.vo.AccountAndUserinfoVo;

@Repository
public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {
	
	//JPQL
	//防呆，查看此帳戶資訊是否已經被新增了
	@Query(value = "SELECT COUNT(user_id) FROM office.user_info"
			+ " where user_id = :user_id",nativeQuery = true)
	public int userInfoCheck(@Param("user_id")int user_id);
	
	//Join userInfo和account的表
	@Query(value = "SELECT new com.example.office.vo.AccountAndUserinfoVo(u.userId,u.email,a.pwd) from UserInfo as u "
			+"join Account as a on u.userId = a.userId")
	public List<AccountAndUserinfoVo> joinUserinfoAndAccount();
	
	//姓名的模糊搜尋
	@Query(value = "SELECT * FROM office.user_info"
			+ " where user_name like concat('%', :user_name,'%')",nativeQuery = true)
	public List<UserInfo> likeSearch(@Param("user_name")String user_name);
}	
