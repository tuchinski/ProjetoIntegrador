package com.projetoPI.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ImplementsUserDetailsService userDetailsService;
	
		@Override
		  protected void configure(HttpSecurity http) throws Exception {
			
		    // require all requests to be authenticated except for the resources
//		    http.authorizeRequests().antMatchers("/javax.faces.resource/**")
//		        .permitAll().anyRequest().authenticated();
		    
		    http.authorizeRequests()
		    .mvcMatchers("/cadastroFunc.xhtml").hasRole("ADMIN")
		    .mvcMatchers("/cadastraCompendio.xhtml").hasRole("ADMIN");
		    
		    
		    // login
		    http.formLogin().loginPage("/login.xhtml").permitAll()
		        .failureUrl("/login.xhtml?error=true").defaultSuccessUrl("/buscarCompendio.xhtml").and().
		        logout().logoutSuccessUrl("/login.xhtml");
		    
		    // not needed as JSF 2.2 is implicitly protected against CSRF
		    http.csrf().disable();
		    
		  }
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception{
			auth.userDetailsService(userDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
		}


//		  @Autowired
//		  public void configureGlobal(AuthenticationManagerBuilder auth)
//		      throws Exception {
//		    auth.inMemoryAuthentication().withUser("john.doe")
//		        .password("{noop}1234").roles("USER").and()
//		        .withUser("jane.doe").password("{noop}5678").roles("ADMIN");
//			  
//			auth.userDetailsService(userDetailsService)
//			.passwordEncoder(new BCryptPasswordEncoder());
//		  }

}
