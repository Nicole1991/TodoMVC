package com.todomvc.repository.impl;

import com.todomvc.domain.ToDoItem;
import com.todomvc.repository.ToDoItemRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ToDoItemRepositoryImpl implements ToDoItemRepository {

    private AtomicLong atomicLongId = new AtomicLong();
    private ConcurrentHashMap<Long, ToDoItem> itemsInRepository = new ConcurrentHashMap<Long, ToDoItem>();

    @Override
    public List<ToDoItem> findAll() {
        return new ArrayList<ToDoItem>(itemsInRepository.values());
    }

    @Override
    public List<ToDoItem> findByIsCompleted(boolean isCompleted) {
        return (List<ToDoItem>) itemsInRepository.get(isCompleted);
    }

    @Override
    public ToDoItem findById(Long id) {
        return itemsInRepository.get(id);
    }

    @Override
    public ToDoItem insert(ToDoItem item) {
        Long id = atomicLongId.incrementAndGet();
        item.setId(id);
        itemsInRepository.put(id, item);
        return item;
    }

    @Override
    public void delete(Long id) {
        itemsInRepository.remove(id);
    }

    @Override
    public void update(ToDoItem toDoItem) {
        itemsInRepository.replace(toDoItem.getId(), toDoItem);
    }
}
