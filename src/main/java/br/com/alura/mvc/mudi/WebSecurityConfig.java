package br.com.alura.mvc.mudi;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()// para todas as requisicoes
		.antMatchers("/home/**")// esse ** significa qualquer coisa
			.permitAll()
		.anyRequest()
			.authenticated()//o usuario tem q estar autenticado
		.and()
			//.httpBasic();//configuracao mais simples
		.formLogin(form -> form
				.loginPage("/login")
				.defaultSuccessUrl("/usuario/pedidos",true)//apos o login vai redirecionar pra usuarioController
				.permitAll()
		)
		.logout(logout -> {
			logout.logoutUrl("/logout")
				.logoutSuccessUrl("/home");//se eu apertar logout vai me redirecionar pra url home
		})
		.csrf().disable();//Desabilita o CRSF (cross-site request forgery) com Spring Security
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();// criptografia
		
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(encoder);//criptografando a senha
	}

}
