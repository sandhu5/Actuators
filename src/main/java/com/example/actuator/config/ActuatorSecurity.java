package com.example.actuator.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ActuatorSecurity extends WebSecurityConfigurerAdapter {
	
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests()
      .anyRequest().hasRole("ADMIN")
      .and()
      .httpBasic();
  }
  
	  @Bean
		public BCryptPasswordEncoder passwordEncoder() {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			return bCryptPasswordEncoder;
		}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		String password = "12345678";
		
		InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> 	mngConfig = auth.inMemoryAuthentication();

		UserDetails user = User.withUsername("user").password(this.passwordEncoder().encode(password)).roles("USER").build();
		UserDetails subUser = User.withUsername("subUser").password(this.passwordEncoder().encode(password)).roles("SUBUSER").build();
		UserDetails admin = User.withUsername("admin").password(this.passwordEncoder().encode(password)).roles("ADMIN").build();
		UserDetails subAdmin = User.withUsername("subAdmin").password(this.passwordEncoder().encode(password)).roles("SUBADMIN").build();

		mngConfig.withUser(subUser);
		mngConfig.withUser(admin);
		mngConfig.withUser(subAdmin);
		mngConfig.withUser(user);
	}
  
}