package com.example.security.springsecurity.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//問４－１ コントローラーを意味するアノテーションを記述
@Controller
public class AuthController {

	@Autowired
	private AccountRepository repository;
//	インスタンス変数

	public List<Account> get() {
		return (List<Account>) repository.findAll();
	}

	@RequestMapping("/")
	public String index() {
		return "redirect:/top";
	}
//	topページに戻る

	@GetMapping("/login")
	public String login() {
		return "login";
	}
//	Login成功時

	@PostMapping("/login")
	public String loginPost() {
		return "redirect:/login-error";
	}
//	login失敗時

	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}
//	interface ModelのaddAttributeメソッドが実行される
//	login画面に戻る

	@RequestMapping("/top")
	public String top() {
		return "/top";
	}
//	top.htmlにいく

}