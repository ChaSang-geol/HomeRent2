package HomeRent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJpaAuditing
public class HomeRentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeRentApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/api/incomeExpenditures")
//						.allowedOrigins("http://localhost:8080")
//						.allowedOrigins("http://127.0.0.1:8080");
//				registry.addMapping("/api/contracts")
//						.allowedOrigins("http://localhost:8080")
//						.allowedOrigins("http://127.0.0.1:8080");
//				registry.addMapping("/api/v1/contracts")
//						.allowedOrigins("http://localhost:8080")
//						.allowedOrigins("http://127.0.0.1:8080");
//			}
//		};
//	}
}
/*
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**").allowedOrigins("http://localhost:8080");
			}
		};
	}

 */