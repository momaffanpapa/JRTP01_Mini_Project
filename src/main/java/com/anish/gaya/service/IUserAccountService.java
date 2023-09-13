package com.anish.gaya.service;

import java.util.List;

import com.anish.gaya.binding.UserAccount;

public interface IUserAccountService {

	public String saveOrUpdateUserAcc(UserAccount userAccount);
	
	public List<UserAccount> getAllUserAccounts();
	
	public UserAccount getUserAcc(Integer userId);
	
	public String deleteUserAcc(Integer userId);
	
	public boolean updateUserAccStatus(Integer userId,String status);
	
}
