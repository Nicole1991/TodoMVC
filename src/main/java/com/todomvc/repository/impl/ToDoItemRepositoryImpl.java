package com.todomvc.repository.impl;

import com.todomvc.domain.ToDoItem;
import com.todomvc.repository.ToDoItemRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ToDoItemRepositoryImpl implements ToDoItemRepository
{
    private AtomicLong currentId = new AtomicLong();
    private ConcurrentHashMap<Long, ToDoItem> itemsInRepository = new ConcurrentHashMap<Long, ToDoItem>();

    @Override
    public List<ToDoItem> findAll() {
        return new ArrayList<>(itemsInRepository.values());
    }

    @Override
    public List<ToDoItem> findByStatus(boolean status) {
        return itemsInRepository.values().stream().filter(item -> item.isCompleted() == status).collect(Collectors.toList());
    }

    @Override
    public ToDoItem findById(Long id) {
        return itemsInRepository.get(id);
    }

    @Override
    public Long insert(ToDoItem item) {
        Long id = currentId.incrementAndGet();
        item.setId(id);
        itemsInRepository.put(id, item);
        return id;
    }

    @Override
    public void delete(ToDoItem item) {
        itemsInRepository.remove(item.getId());
    }

    @Override
    public void update(ToDoItem newItem) {
        itemsInRepository.replace(newItem.getId(),newItem);
    }
}
