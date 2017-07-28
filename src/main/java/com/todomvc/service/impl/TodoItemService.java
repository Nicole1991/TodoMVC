package com.todomvc.service.impl;

import com.todomvc.domain.TodoItem;
import com.todomvc.repository.impl.TodoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemService {

    TodoItemRepository todoItemRepository = new TodoItemRepository();
    
    public TodoItem add(String content) {
        TodoItem todoItem = new TodoItem();
        todoItem.setContent(content);
        todoItem.setCompleted(false);
        return todoItemRepository.insert(todoItem);
    }

    
    public void update(TodoItem todoItem) {
        todoItemRepository.update(todoItem);
    }

    
    public void remove(Long id) {
        todoItemRepository.delete(id);
    }

    
    public List<TodoItem> findAll() {
        return todoItemRepository.findAll();
    }
}
