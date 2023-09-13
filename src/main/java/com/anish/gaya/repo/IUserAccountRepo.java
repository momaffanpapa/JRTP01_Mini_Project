package com.anish.gaya.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.anish.gaya.binding.UserAccount;

import jakarta.transaction.Transactional;

public interface IUserAccountRepo extends JpaRepository<UserAccount, Integer> {

	@Modifying
	@Transactional
	@Query("update UserAccount set activeSw=:status where userId=:userId")
	public boolean updateUserAccountStatus(Integer userId, String status);
}
