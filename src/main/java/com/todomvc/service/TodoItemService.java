package com.todomvc.service;

import com.todomvc.domain.ToDoItem;

import java.util.List;

public interface TodoItemService {
    ToDoItem add(String content);
    void update(ToDoItem toDoItem);
    void remove(Long id);
    List<ToDoItem> findAll();
}
