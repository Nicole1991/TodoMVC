package com.todomvc.repository.impl;

import com.todomvc.domain.ToDoItem;
import com.todomvc.repository.ToDoItemRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ToDoItemRepositoryImpl implements ToDoItemRepository
{
    private AtomicLong atomicLongId = new AtomicLong();
    private ConcurrentHashMap<Long, ToDoItem> itemsInRepository = new ConcurrentHashMap<Long, ToDoItem>();

    @Override
    public List<ToDoItem> findAll() {
        return (List<ToDoItem>) itemsInRepository.values();
    }

    @Override
    public List<ToDoItem> findByStatus(boolean status) {
        return (List<ToDoItem>) itemsInRepository.get(status);
    }

    @Override
    public ToDoItem findById(Long id) {
        return itemsInRepository.get(id);
    }

    @Override
    public Long insert(ToDoItem item) {
        Long id = atomicLongId.incrementAndGet();
        item.setId(id);
        itemsInRepository.put(id, item);
        return id;
    }

    @Override
    public void delete(ToDoItem item) {
        itemsInRepository.remove(item);
    }

    @Override
    public void update(ToDoItem newItem) {
        itemsInRepository.replace(newItem.getId(),newItem);
    }
}
