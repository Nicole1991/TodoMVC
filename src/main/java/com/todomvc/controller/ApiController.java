package com.todomvc.controller;

import com.todomvc.domain.ToDoItem;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApiController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Long add(ToDoItem item) {
        System.out.println(item.getId());
        System.out.println(item.getContent());
        return item.getId();
    }


}
