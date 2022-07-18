package cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import cat.itacademy.barcelonactiva.ariso.toni.s05.t02.n01.fase03.security.JWTAuthorizationFilter;

@SpringBootApplication
public class S05T02N01Fase03ArisoApplication {

	public static void main(String[] args) {
		SpringApplication.run(S05T02N01Fase03ArisoApplication.class, args);
	}
	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig {

		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/user").permitAll()
				.anyRequest().authenticated();
		}
	}

}
