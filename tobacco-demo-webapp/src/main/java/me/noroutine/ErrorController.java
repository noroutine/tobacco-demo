package me.noroutine;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Oleksii Khilkevych
 * @since 02.12.12
 */

@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/404")
    public String error404() {
        return "error.404";
    }

    @RequestMapping("/{code}")
    @ResponseBody
    public int error(@PathVariable int code) {
        return code;
    }
}
