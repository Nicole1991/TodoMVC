package com.todomvc.service.impl;

import com.todomvc.domain.ToDoItem;
import com.todomvc.repository.impl.ToDoItemRepositoryImpl;
import com.todomvc.service.TodoItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemServiceImpl implements TodoItemService{

    ToDoItemRepositoryImpl toDoItemRepository = new ToDoItemRepositoryImpl();
    @Override
    public ToDoItem add(String content) {
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setContent(content);
        return toDoItemRepository.insert(toDoItem);
    }

    @Override
    public void update(ToDoItem toDoItem) {
        toDoItemRepository.update(toDoItem);
    }

    @Override
    public void remove(Long id) {
        toDoItemRepository.delete(id);
    }

    @Override
    public List<ToDoItem> findAll() {
        return toDoItemRepository.findAll();
    }
}
