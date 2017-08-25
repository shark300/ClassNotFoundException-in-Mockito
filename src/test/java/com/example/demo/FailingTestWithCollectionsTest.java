package com.example.demo;

import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class FailingTestWithCollectionsTest {
    @Mock
    private TestCollectionSourceProvider testCollectionSourceProvider;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {
        given(testCollectionSourceProvider.getCollection(new ArrayList<Integer>())).willReturn(new ArrayList<>());
    }

    static class TestCollectionSourceProvider {
        <T extends Collection<E>, E> T getCollection(T collection) {
            return collection;
        }
    }
}
