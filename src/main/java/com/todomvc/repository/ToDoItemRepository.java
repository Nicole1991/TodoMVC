package com.todomvc.repository;

import com.todomvc.domain.ToDoItem;

import java.util.List;

public interface ToDoItemRepository {

    List<ToDoItem> findAll();
    List<ToDoItem> findByStatus(boolean status);
    ToDoItem findById(Long id);
    Long insert(ToDoItem item);
    void delete(ToDoItem item);
    void update(ToDoItem item);
}
