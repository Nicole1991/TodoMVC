package com.todomvc.repository.impl;

import com.todomvc.domain.TodoItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository

public class TodoItemRepository {

    private AtomicLong currentId = new AtomicLong();
    private ConcurrentHashMap<Long, TodoItem> itemsInRepository = new ConcurrentHashMap<Long, TodoItem>();

    
    public List<TodoItem> findAll() {
        return new ArrayList<>(itemsInRepository.values());
    }

    
    public List<TodoItem> findByStatus(boolean status) {
        return itemsInRepository.values().stream().
                filter(item -> item.isCompleted() == status).
                collect(Collectors.toList());
    }

    
    public TodoItem findById(Long id) {
        return itemsInRepository.get(id);
    }

    
    public TodoItem insert(TodoItem item) {
        Long id = currentId.incrementAndGet();
        item.setId(id);
        itemsInRepository.put(id, item);
        return item;
    }

    
    public void delete(Long id) {
        itemsInRepository.remove(id);
    }

    
    public void update(TodoItem todoItem) {
        itemsInRepository.replace(todoItem.getId(), todoItem);
    }
}
