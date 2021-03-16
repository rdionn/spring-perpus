package rtek.perpus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
		"rtek.perpus.controllers",
		"rtek.perpus.config",
		"rtek.perpus.services"
})
public class PerpusApplication {
	public static void main(String[] args) {
		SpringApplication.run(PerpusApplication.class, args);
	}
}
