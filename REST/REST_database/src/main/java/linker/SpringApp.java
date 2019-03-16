package Linker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApp {
	public static void main(String[] args) {
		Base db = new Base();
		SpringApplication.run(SpringApp.class, args);
	}
}