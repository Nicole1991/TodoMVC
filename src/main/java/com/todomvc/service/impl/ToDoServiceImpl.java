package com.todomvc.service.impl;

import com.todomvc.domain.ToDoItem;
import com.todomvc.resposity.ToDoItemRepository;
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
    public ToDoItem add(String content) {
        ToDoItem item = new ToDoItem();
        item.setContent(content);
//        item.
        return null;
    }

    @Override
    public ToDoItem update(ToDoItem item) {
        return null;
    }

    @Override
    public void delete(Long id) {
        return ;
    }
}
