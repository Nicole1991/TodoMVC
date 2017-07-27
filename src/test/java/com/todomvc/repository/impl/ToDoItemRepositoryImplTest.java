package com.todomvc.repository.impl;

import com.todomvc.domain.ToDoItem;
import com.todomvc.repository.ToDoItemRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToDoItemRepositoryImplTest {

    @Autowired
    ToDoItemRepository repository;

    ToDoItem toDoItem;
    List<ToDoItem> toDoItems = new ArrayList<ToDoItem>();

    @Before
    public void setUp(){
        toDoItem = new ToDoItem();
        toDoItem.setContent("test todoItem");
        toDoItem.setCompleted(false);
        toDoItems.add(toDoItem);
    }

    @Test
    public void shouldReturnAllItemsInRepository() throws Exception {
        for (ToDoItem toDoItemList:toDoItems
             ) {
            toDoItemList.getId();
            Assert.assertEquals("test todoItem", toDoItemList.getContent());
        }
    }

    @Test
    public void shouldReturnItemsStatusAreCompleted() throws Exception {
        for (ToDoItem toDoItemList:toDoItems
                ) {
            toDoItemList.isCompleted();
            Assert.assertEquals(false, toDoItemList.isCompleted());
        }
    }

}