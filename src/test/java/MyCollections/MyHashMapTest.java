package MyCollections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest {

    private MyHashMap<String, Integer> map;

    @Before
    public void setUp() {
        map = new MyHashMap<>();
    }

    @Test
    public void testPutAndGet() {

        map.put("one", 1);
        map.put("two", 2);

        assertEquals(1, (int) map.get("one"));
        assertEquals(2, (int) map.get("two"));
    }

    @Test
    public void testSize() {

        map.put("one", 1);
        map.put("two", 2);

        assertEquals(2, map.size());

        map.put("three", 3);

        assertEquals(3, map.size());
    }


    @Test
    public void testContainsKey() {

        map.put("one", 1);
        map.put("two", 2);

        assertTrue(map.containsKey("one"));
        assertTrue(map.containsKey("two"));
        assertFalse(map.containsKey("three"));
    }

    @Test
    public void testRemove() {

        map.put("one", 1);
        map.put("two", 2);

        assertEquals(2, map.size());

        map.remove("one");

        assertEquals(1, map.size());
        assertNull(map.get("one"));
        assertEquals(2, (int) map.get("two"));
    }

    @Test
    public void testClear() {

        map.put("one", 1);
        map.put("two", 2);

        assertEquals(2, map.size());

        map.clear();

        assertEquals(0, map.size());
        assertNull(map.get("one"));
        assertNull(map.get("two"));
        assertTrue(map.isEmpty());
    }

    @Test
    public void testIsEmpty() {

        MyHashMap<String, Integer> emptyMap = new MyHashMap<>();
        assertTrue(emptyMap.isEmpty());

        MyHashMap<String, Integer> nonEmptyMap = new MyHashMap<>();
        nonEmptyMap.put("one", 1);
        assertFalse(nonEmptyMap.isEmpty());
    }

    @Test
    public void testValues() {

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        MyArrayList<Integer> valuesList = map.values();

        assertEquals(3, valuesList.size());
        assertTrue(valuesList.contains(1));
        assertTrue(valuesList.contains(2));
        assertTrue(valuesList.contains(3));
    }
}