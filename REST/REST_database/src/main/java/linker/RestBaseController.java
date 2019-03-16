package Linker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class RestBaseController {
	@RequestMapping("/get_links")
	public List<Link> getLinks() {
		return Base.getLinks();
	}
}