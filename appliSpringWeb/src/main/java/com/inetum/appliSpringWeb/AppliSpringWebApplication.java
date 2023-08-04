package com.inetum.appliSpringWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.inetum.appliSpringWeb.dto.Devise;
import com.inetum.appliSpringWeb.rest.DeviseResrCtrl;

@SpringBootApplication
public class AppliSpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppliSpringWebApplication.class, args);
		System.out.println("http://localhost:8080/appliSpringWeb/index.html");
//		DeviseResrCtrl ctr= new DeviseResrCtrl();
//		ctr.getDeviseByCode("USD");
	}

}
