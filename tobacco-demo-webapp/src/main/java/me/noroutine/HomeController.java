package me.noroutine;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping(value = "/{page}")
	public String home(@PathVariable String page) {
        if (Arrays.asList("home", "about", "contact").contains(page)) {
            return "view." + page;
        } else {
            return "error.404";
        }
	}
}
