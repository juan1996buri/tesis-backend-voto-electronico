package ec.edu.insteclrg.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "ec.edu.insteclrg" })
@EnableJpaRepositories(basePackages = { "ec.edu.insteclrg.persistence" })
@EntityScan(basePackages = { "ec.edu.insteclrg.domain" })
public class app extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(app.class, args);
	}

}
