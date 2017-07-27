package com.todomvc.controller;

import com.todomvc.domain.ToDoItem;
import com.todomvc.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    ToDoService service;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ToDoItem add(@RequestParam String content) {
        return service.add(content);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(ToDoItem item) {
        service.update(item);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<ToDoItem> findAll() {
        return service.findAll();
    }
}
