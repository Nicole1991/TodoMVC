package com.todomvc.repository.impl;

import com.todomvc.domain.TodoItem;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.util.Lists.newArrayList;
import static org.easymock.EasyMock.expect;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.util.ReflectionTestUtils.setField;

public class TodoItemRepositoryTest {

    private final EasyMockSupport easyMockSupport;
    private TodoItemRepository todoItemRepository;
    private ConcurrentHashMap mockItemsRepository;
    private AtomicLong mockAtomicLong;

    public TodoItemRepositoryTest() {
        easyMockSupport = new EasyMockSupport();
    }

    @Before
    public void setUp() {
        todoItemRepository = new TodoItemRepository();
        mockAtomicLong = easyMockSupport.createMock(AtomicLong.class);
        mockItemsRepository = easyMockSupport.createMock(ConcurrentHashMap.class);
        setField(todoItemRepository, "currentId", mockAtomicLong);
        setField(todoItemRepository, "itemsInRepository", mockItemsRepository);

    }

    @Test
    public void shouldReturnAllItemsInRepository() throws Exception {
        expect(mockItemsRepository.values()).andReturn(newArrayList(new TodoItem()));

        easyMockSupport.replayAll();
        List<TodoItem> all = todoItemRepository.findAll();
        easyMockSupport.verifyAll();

        assertThat(all.size(), is(1));
    }

    @Test
    public void shouldReturnAllCompletedItems() {
        expect(mockItemsRepository.values()).andReturn(newArrayList
                (new TodoItem(1L,"help",true),
                        new TodoItem(2L,"app1",true),
                        new TodoItem(3L,"application",false)
                ));

        easyMockSupport.replayAll();
        List<TodoItem> completedTodoItem = todoItemRepository.findByStatus(true);
        easyMockSupport.verifyAll();

        assertThat(completedTodoItem.size(),is(2));
    }

    @Test
    public void shouldReturnTheItemByGivenId() {
        expect(mockItemsRepository.get(1L)).andReturn(new TodoItem(1L, "Hello", true));
        easyMockSupport.replayAll();
        TodoItem item = todoItemRepository.findById(1L);
        easyMockSupport.verifyAll();
        assertThat(item.getId(), is(1L));
        assertThat(item.getContent(), is("Hello"));
    }

    @Test
    public void shouldReturnItemWhenInsertANewItem() throws Exception {
       /* expect(mockItemsRepository.put(1L, new TodoItem(1L, "Hello", true))).andReturn(new TodoItem(1L, "Hello", true));
        expect(mockAtomicLong.incrementAndGet()).andReturn(null);
        easyMockSupport.replayAll();
        TodoItem item = todoItemRepository.insert(new TodoItem(1L, "Hello", true));
        easyMockSupport.verifyAll();
        assertThat(item.getId(), is(1L));*/
    }

}