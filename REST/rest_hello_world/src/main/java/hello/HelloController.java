package rest_hello_world;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private static String template = "Hello, %s";


	@RequestMapping("/hello")
	public Hello hello(@RequestParam(value = "name", defaultValue = "world") String name) {
		return new Hello(String.format(template, name));
	}
}