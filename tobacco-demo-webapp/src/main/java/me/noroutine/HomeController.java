package me.noroutine;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping(value = "/home")
	public String home() {
        return "view.home";
	}

    @RequestMapping(value = "/about")
   	public String about() {
           return "view.about";
   	}
}
