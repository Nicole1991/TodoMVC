package com.todomvc.resposity.impl;

import com.todomvc.domain.ToDoItem;
import com.todomvc.resposity.ToDoItemRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ToDoItemRepositoryImpl implements ToDoItemRepository
{
    private AtomicLong currentId = new AtomicLong();
    private ConcurrentHashMap<Long, ToDoItem> reposity = new ConcurrentHashMap<Long, ToDoItem>();

    @Override
    public List<ToDoItem> findAll() {
        return new ArrayList<>( reposity.values());

    }

    @Override
    public List<ToDoItem> findByStatus(boolean status) {
        return null;
    }

    @Override
    public ToDoItem findById(Long id) {
        return null;
    }

    @Override
    public Long insert(ToDoItem item) {
        Long id = currentId.incrementAndGet();
        item.setId(id);
        reposity.put(id, item);
        return id;
    }

    @Override
    public void delete(ToDoItem item) {

    }

    @Override
    public void update(ToDoItem item) {

    }
}
