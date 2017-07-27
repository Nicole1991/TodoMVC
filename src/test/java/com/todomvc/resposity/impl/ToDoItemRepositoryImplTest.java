package com.todomvc.resposity.impl;

import com.todomvc.domain.ToDoItem;
import com.todomvc.resposity.ToDoItemRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToDoItemRepositoryImplTest {

    @Autowired
    ToDoItemRepository reposity;

    ToDoItem item;

    @Before
    public void setUp() {
        item = new ToDoItem();
        item.setContent("first todo item");
    }
    @Test
    public void findAll() throws Exception {
        reposity.insert(item);
        List<ToDoItem> lists = reposity.findAll();
        for (ToDoItem todo:
             lists) {
            Assert.assertEquals(item.getContent(), "first todo item");
        }
    }

    @Test
    public void findByStatus() throws Exception {
    }

}