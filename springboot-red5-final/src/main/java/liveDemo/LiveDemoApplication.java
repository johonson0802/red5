package liveDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class LiveDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiveDemoApplication.class, args);
	}
}
