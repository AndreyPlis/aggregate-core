package com.tibbo.datatable.multiMap;

import java.util.*;

import com.sun.media.jfxmediaimpl.*;
import org.junit.*;

import junit.framework.TestCase;

public class MultiMapTest extends TestCase {
    @Test
    public void testPut() {
        MultiMap<String, Integer> mm1 = new MultiMap<>();
        mm1.put("one",1);
        mm1.put("tens", 10);
        mm1.put("tens", 20);
        mm1.put("tens", 30);
        mm1.put("year", 2020);
        System.out.println("Count for one: " + mm1.getCount("one"));
        System.out.println("Count for tens: " + mm1.getCount("tens"));
        for(Integer val: mm1.getValues("tens")){
            System.out.println(val);
        }
        assertEquals(1, mm1.getCount("one"));
        assertEquals(3, mm1.getCount("tens"));
    }
    @Test
    public void testRemoveValue() {
        MultiMap<String, Integer> mm1 = new MultiMap<>();
        mm1.put("one",1);
        mm1.put("tens", 10);
        mm1.put("tens", 20);
        mm1.put("tens", 30);
        mm1.put("year", 2020);
        assertEquals(3, mm1.getCount("tens"));
        mm1.removeValue("tens", 20);
        assertEquals(2, mm1.getCount("tens"));
    }
    @Test
    public void testGetValues() {
        MultiMap<String, Integer> mm1 = new MultiMap<>();
        mm1.put("one",1);
        mm1.put("tens", 10);
        mm1.put("tens", 20);
        mm1.put("tens", 30);
        mm1.put("year", 2020);
        assertEquals(new LinkedList(Arrays.asList(10, 20, 30)), mm1.getValues("tens"));
    }

}