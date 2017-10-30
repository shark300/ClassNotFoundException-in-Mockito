package com.example.demo;

import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    @Test
    public void test2() {
        List<Integer> collection = testCollectionSourceProvider.getCollection(new ArrayList<>());
        given(testCollectionSourceProvider.getCollection(collection)).willReturn(new ArrayList<>());
    }

    @Test
    public void test2andhalf() {
        ArrayList<Integer> collection = testCollectionSourceProvider.getCollection(new ArrayList<>());
        given(testCollectionSourceProvider.getCollection(collection)).willReturn(new ArrayList<>());
    }

    @Test
    public void test3() {
        List<Integer> input = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        List<Integer> collection = testCollectionSourceProvider.getCollection(input);
        given(testCollectionSourceProvider.getCollection(collection)).willReturn(output);
    }

    static class TestCollectionSourceProvider {
        <T extends Collection<E>, E> T getCollection(T collection) {
            return collection;
        }
    }
}
