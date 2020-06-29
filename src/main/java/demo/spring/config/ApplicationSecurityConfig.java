package demo.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override 	// Configure users (in memory, database, idap ...etc)
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// add our users for in-memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("Debi").password("Debi").roles("EMPLOYEE"))
			.withUser(users.username("Debi Prasad").password("Debi Prasad").roles("EMPLOYEE","MANAGER"))
			.withUser(users.username("Vicky").password("Vicky").roles("EMPLOYEE","ADMIN"));
	}

	@Override // configure security of Web Paths in application, Login, Logout etc...
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()	// Restrict access based on HttpServletRequest
				.anyRequest().authenticated() 	// Any request to the app must be authenticated (logged in)
			.and()
			.formLogin() // Customize the login process
				.loginPage("/myLoginPage") 	// show our custom form at the request mapping
				.loginProcessingUrl("/authenticateTheUser") 	// Login form should POST data to this URL for processing
				.permitAll() // Allow everyone to see the login page
			.and()
			.logout().permitAll(); // logout
	}	
	
	
}

















