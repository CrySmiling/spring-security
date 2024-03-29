package com.lzh.springsecurity.security;

import com.lzh.springsecurity.filter.VerifyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/*
 * @author H
 *
 * @date 2019/7/22
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private DataSource dataSource;

	@Bean
	public PersistentTokenRepository persistentTokenRepository(){
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		return tokenRepository;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
			@Override
			public String encode(CharSequence charSequence) {
				return charSequence.toString();
			}

			@Override
			public boolean matches(CharSequence charSequence, String s) {
				return s.equals(charSequence.toString());
			}
		});
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// 如果有允许匿名的url，填在下面
				.antMatchers("/getVerifyCode").permitAll()
				.anyRequest().authenticated()
				.and()
				// 设置登陆页
				.formLogin().loginPage("/login")
				// 设置登陆成功页
				.defaultSuccessUrl("/").permitAll()
				// 登录失败Url
				.failureUrl("/login/error")
				// 自定义登陆用户名和密码参数，默认为username和password
//                .usernameParameter("username")
//                .passwordParameter("password")
				.and()
				.addFilterBefore(new VerifyFilter(), UsernamePasswordAuthenticationFilter.class)
				.logout().permitAll()
				// 自动登录
				.and().rememberMe()
					.tokenRepository(persistentTokenRepository())
					// 有效时间：单位S
					.tokenValiditySeconds(60)
					.userDetailsService(userDetailsService);

		// 关闭CSRF跨域
		http.csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 设置拦截忽略文件夹，可以对静态资源放行
		web.ignoring().antMatchers("/css/**", "/js/**");
	}

}

