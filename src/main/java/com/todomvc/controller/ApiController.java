package com.todomvc.controller;

import com.todomvc.domain.TodoItem;
import com.todomvc.service.impl.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    private TodoItemService todoItemService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public TodoItem add(@RequestParam String content){
        return todoItemService.add(content);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(TodoItem todoItem){
        todoItemService.update(todoItem);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        todoItemService.remove(id);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<TodoItem> findAll(){
        return todoItemService.findAll();
    }

    /*@RequestMapping(value = "/showAllItem",method = RequestMethod.GET)
    public String findAllTodoItem(Model model, @ModelAttribute("todoItem") TodoItem toDoItem){
        model.addAttribute("todoItem", todoItemService.findAll());
        return "home";
    }*/
}
