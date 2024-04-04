package co.edu.uptc.distri1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Distri1Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Distri1Application.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(Distri1Application.class);
	}
}
