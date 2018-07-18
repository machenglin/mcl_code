package com.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by machenglin on 2018/5/26.
 */
public class HashMapTest {

    @Test
    public void testHashMap() {
        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "MCL");
    }

    @Test
    public void test01(){
        int i=2;
        System.out.println(i>>>2);

    }
}
