package com.lzh.springsecurity;

import com.lzh.springsecurity.servlet.VerifyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * 注入验证码servlet
	 */
	@Bean
	public ServletRegistrationBean indexServletRegistration(){
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new VerifyServlet());
		registrationBean.addUrlMappings("/getVerifyCode");
		return registrationBean;
	}

}
