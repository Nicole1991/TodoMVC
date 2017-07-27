package com.todomvc.service;

import com.todomvc.domain.ToDoItem;

import java.util.List;

public interface ToDoService {
    ToDoItem add(String content);
    ToDoItem update(ToDoItem item);
    void delete(Long id);
}
