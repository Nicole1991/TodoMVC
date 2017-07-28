package com.todomvc.repository.impl;

import com.todomvc.domain.ToDoItem;
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

public class ToDoItemRepositoryImplTest {

    private final EasyMockSupport easyMockSupport;
    private ToDoItemRepositoryImpl toDoItemRepository;
    private ConcurrentHashMap mockItemsRepository;
    private AtomicLong mockAtomicLong;

    public ToDoItemRepositoryImplTest() {
        easyMockSupport = new EasyMockSupport();
    }

    @Before
    public void setUp() {
        toDoItemRepository = new ToDoItemRepositoryImpl();
        mockAtomicLong = easyMockSupport.createMock(AtomicLong.class);
        mockItemsRepository = easyMockSupport.createMock(ConcurrentHashMap.class);
        setField(toDoItemRepository, "atomicLongId", mockAtomicLong);
        setField(toDoItemRepository, "itemsInRepository", mockItemsRepository);
    }

    @Test
    public void shouldReturnAllItemsInRepository() throws Exception {
        expect(mockItemsRepository.values()).andReturn(newArrayList(new ToDoItem()));

        easyMockSupport.replayAll();
        List<ToDoItem> all = toDoItemRepository.findAll();
        easyMockSupport.verifyAll();

        assertThat(all.size(), is(1));
    }

}