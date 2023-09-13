package com.anish.gaya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anish.gaya.binding.UserAccount;
import com.anish.gaya.service.impl.UserAccountServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserAccountServiceImpl userService;

	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("user", new UserAccount());
		return "index";
	}

	@PostMapping(value = "/save-user")
	public String handleSubmitBtn(@ModelAttribute("user") UserAccount account, Model model) {
		String msg = userService.saveOrUpdateUserAcc(account);
		model.addAttribute("msg", msg);
		model.addAttribute("user", new UserAccount());
		return "index";
	}

	@GetMapping(value = "/all-user")
	public String getAllUsers(Model model) {
		List<UserAccount> users = userService.getAllUserAccounts();
		model.addAttribute("users", users);
		return "view-users";
	}

	@GetMapping("/edit")
	public String editUserById(@RequestParam("id") Integer uid, Model model) {
		UserAccount userAcc = userService.getUserAcc(uid);
		model.addAttribute("user", userAcc);
		return "index";
	}

	@GetMapping("/delete")
	public String deleteUserById(@RequestParam("id") Integer uid) {
		userService.deleteUserAcc(uid);

		return "redirect:/all-user";
	}
	
	@GetMapping("/update")
	public String updateSwitchAsPerId(@RequestParam("id") Integer uid,
			@RequestParam("status") String status) {
		userService.updateUserAccStatus(uid,status);
		return "redirect:/all-user";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
