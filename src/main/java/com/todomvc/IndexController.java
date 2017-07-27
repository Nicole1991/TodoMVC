package com.todomvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("/{username}")
    @ResponseBody
    public String index(@PathVariable String username) {
        return "Hello World" + username;
    }
}
