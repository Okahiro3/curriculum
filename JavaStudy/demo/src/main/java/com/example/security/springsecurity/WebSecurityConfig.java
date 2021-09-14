package com.example.security.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.security.springsecurity.account.AccountService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AccountService userService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
//		認証されたユーザーの認証情報を返却
		.antMatchers("/login", "/login-error").permitAll()
//		指定したパスパターンに一致するリソースを適用対象にする 全てのユーザーがアクセス可
		.antMatchers("/**").hasRole("USER")
//		ユーザー画面
		.and()
		.formLogin()
//		フォーム認証の適用
		.loginPage("/login").failureUrl("/login-error");
//		ログインページへの遷移指定
	}


	//変更点 ロード時に、「admin」ユーザを登録する。
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userService)
//		認証するユーザーを設定する ユーザー情報を検索する
		.passwordEncoder(passwordEncoder());
//		パスワードをハッシュ化

		if (userService.findAllList().isEmpty()) {
			userService.registerAdmin("admin", "secret", "admin@localhost");
			userService.registerManager("manager", "secret", "manager@localhost");
			userService.registerUser("user", "secret", "user@localhost");
		}
	}
	//変更点 PasswordEncoder(BCryptPasswordEncoder)メソッド
	@Bean
	public PasswordEncoder passwordEncoder() {
		//
		return new BCryptPasswordEncoder();
	}

}