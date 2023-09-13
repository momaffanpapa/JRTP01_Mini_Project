package com.anish.gaya.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anish.gaya.binding.UserAccount;
import com.anish.gaya.repo.IUserAccountRepo;
import com.anish.gaya.service.IUserAccountService;

@Service
public class UserAccountServiceImpl implements IUserAccountService {

	private IUserAccountRepo userRepo;
	
	public UserAccountServiceImpl(IUserAccountRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public String saveOrUpdateUserAcc(UserAccount userAccount) {
		Integer id = userAccount.getUserId();
		userRepo.save(userAccount);
		if (id == null) {
			return "user account saved";
		} else
			return "user account updated";
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {
		return userRepo.findAll();
	}

	@Override
	public UserAccount getUserAcc(Integer userId) {

		Optional<UserAccount> userAccountObj = userRepo.findById(userId);
		if (userAccountObj.isPresent()) {
			return userAccountObj.get();
		} else {
			return null;
		}

	}

	@Override
	public String deleteUserAcc(Integer userId) {
		if (userRepo.existsById(userId)) {
			userRepo.deleteById(userId);
			return "Delete success";
		}

		return "No Record Found";
	}

	@Override
	public boolean updateUserAccStatus(Integer userId, String status) {
		try {
			userRepo.updateUserAccountStatus(userId,status);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
