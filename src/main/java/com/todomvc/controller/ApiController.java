package com.todomvc.controller;

import com.todomvc.domain.ToDoItem;
<<<<<<< HEAD
import com.todomvc.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.todomvc.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
>>>>>>> TodoMVC-unitTest
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
<<<<<<< HEAD
    ToDoService service;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ToDoItem add(@RequestParam String content) {
        return service.add(content);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(ToDoItem item) {
        service.update(item);
=======
    private TodoItemService todoItemService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ToDoItem add(@RequestParam String content){
        return todoItemService.add(content);
>>>>>>> TodoMVC-unitTest
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

<<<<<<< HEAD
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<ToDoItem> findAll() {
        return service.findAll();
=======
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
>>>>>>> TodoMVC-unitTest
    }
}
