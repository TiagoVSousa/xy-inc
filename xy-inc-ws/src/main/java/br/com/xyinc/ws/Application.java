package br.com.xyinc.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

import br.com.xyinc.business.config.XYBusinessConfig;

/**
 * Classe principal.
 * 
 * @author tiago
 *
 */

@SpringBootApplication
@Import(value = XYBusinessConfig.class)
public class Application {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
