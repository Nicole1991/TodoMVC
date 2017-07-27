package com.todomvc;

import com.todomvc.domain.ToDoItem;
import com.todomvc.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    ToDoService service;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Long add(@RequestParam(value = "content") String content) {
        service.add(content);
        return 0L;
    }
}
