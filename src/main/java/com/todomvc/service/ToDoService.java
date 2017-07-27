package com.todomvc.service;

import com.todomvc.domain.ToDoItem;

import java.util.List;

public interface ToDoService {
    List<ToDoItem> findAll();
    ToDoItem add(String content);
    void update(ToDoItem newItem);
    void delete(Long id);
}
