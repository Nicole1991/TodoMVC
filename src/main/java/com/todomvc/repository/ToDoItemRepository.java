package com.todomvc.repository;

import com.todomvc.domain.ToDoItem;

import java.util.List;

public interface ToDoItemRepository {

    List<ToDoItem> findAll();
    List<ToDoItem> findByIsCompleted(boolean status);
    ToDoItem findById(Long id);
    ToDoItem insert(ToDoItem item);
    void delete(Long id);
    void update(ToDoItem item);
}
