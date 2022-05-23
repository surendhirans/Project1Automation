package backend.poc1.project.POC1Backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@Configuration
public class Springbootsecurity extends WebSecurityConfigurerAdapter 
{

	@Bean
	public PasswordEncoder getEncode()
	{
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("surendhiran").password(getEncode().encode("surendhiran")).roles("ADMIN");
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
	    http.authorizeRequests().anyRequest().authenticated();
	    http.httpBasic();
	    http.formLogin();
		http.csrf().disable();// post,put,delete
		//http.authorzerequests().anyrequest().permitAll();
	}

	
	
	

}
