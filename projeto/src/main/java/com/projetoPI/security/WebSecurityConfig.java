package com.projetoPI.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ImplementsUserDetailsService userDetailsService;
	
		@Override
		  protected void configure(HttpSecurity http) throws Exception {		    
		    http.authorizeRequests()
		    .mvcMatchers("/documentos/documento.xhtml").hasAnyRole("ADMIN,CHEFEDEPTO,DIRETOR,GERENTE,FUNCIONARIO")
		    .mvcMatchers("/funcionario/cadastroFunc.xhtml").hasRole("ADMIN")
		    .mvcMatchers("/compendio/*").hasAnyRole("ADMIN,DIRETOR")
		    .mvcMatchers("/funcionario/*").hasAnyRole("ADMIN,CHEFEDEPTO,DIRETOR,GERENTE")
		    .mvcMatchers("/departamento/*").hasAnyRole("ADMIN,CHEFEDEPTO,DIRETOR,GERENTE")
		    .mvcMatchers("/setor/*").hasAnyRole("ADMIN,CHEFEDEPTO,DIRETOR,GERENTE")
		    .mvcMatchers("/documentos/validaDocumento.xhtml").hasAnyRole("ADMIN,CHEFEDEPTO,DIRETOR,GERENTE")
		    .mvcMatchers("/categoria/*").hasAnyRole("ADMIN,CHEFEDEPTO,DIRETOR,GERENTE,FUNCIONARIO")
		    .mvcMatchers("/documentos/documentosRejeitados.xhtml").hasAnyRole("ADMIN,CHEFEDEPTO,DIRETOR,GERENTE,FUNCIONARIO")
		    .mvcMatchers("/paginaprincipal/buscarCompendio.xhtml").hasAnyRole("ADMIN,CHEFEDEPTO,DIRETOR,GERENTE,FUNCIONARIO");

		    
		    
		    // login
		    http.formLogin().loginPage("/login.xhtml").permitAll()
		        .failureUrl("/login.xhtml?error=true").defaultSuccessUrl("/paginaPrincipal/buscarCompendio.xhtml").and().
		        logout().logoutSuccessUrl("/login.xhtml");
		    
		    // not needed as JSF 2.2 is implicitly protected against CSRF
		    http.csrf().disable();
		    
		  }
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception{
			auth.userDetailsService(userDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
		}

}
