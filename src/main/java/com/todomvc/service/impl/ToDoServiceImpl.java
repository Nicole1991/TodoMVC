package com.todomvc.service.impl;

import com.todomvc.domain.ToDoItem;
import com.todomvc.repository.ToDoItemRepository;
import com.todomvc.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService
{
    @Autowired
    ToDoItemRepository repository;

    @Override
    public List<ToDoItem> findAll() {
        return repository.findAll();
    }

    @Override
    public ToDoItem add(String content) {
        ToDoItem item = new ToDoItem();
        item.setContent(content);
        item.setCompleted(false);
        return repository.insert(item);
    }

    @Override
    public void update(ToDoItem newItem) {
        repository.update(newItem);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
