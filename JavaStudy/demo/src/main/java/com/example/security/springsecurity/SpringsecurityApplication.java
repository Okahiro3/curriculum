package com.example.security.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//アプリケーションコンテキストの自動構成を自動的に有効にする Serviseを構成・推測する
//アプリケーションがどのように振る舞うかを決定する
public class SpringsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

}
