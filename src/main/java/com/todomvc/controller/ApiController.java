package com.todomvc.controller;

import com.todomvc.domain.ToDoItem;
import com.todomvc.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    private TodoItemService todoItemService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ToDoItem add(@RequestParam String content){
        return todoItemService.add(content);
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(ToDoItem toDoItem){
        todoItemService.update(toDoItem);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestParam Long id){
        todoItemService.remove(id);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<ToDoItem> findAll(){
        return todoItemService.findAll();
    }

    @RequestMapping(value = "/showAllItem",method = RequestMethod.GET)
    public String findAllTodoItem(Model model,@ModelAttribute("todoItem") ToDoItem toDoItem){
        model.addAttribute("todoItem", todoItemService.findAll());
        return "home";
    }
}
