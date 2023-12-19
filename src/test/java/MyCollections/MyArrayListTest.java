package MyCollections;

import org.junit.After;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MyArrayListTest {
    private MyArrayList<String> myArrayList;

    @After
    public void tearDown() {
        myArrayList = null;
    }

    @Test
    public void add() {
        myArrayList = new MyArrayList<>();
        myArrayList.add("Item");

        assertEquals(1, myArrayList.size());
        assertEquals("Item", myArrayList.get(0));
    }


    @Test
    public void addMultipleElements() {
        myArrayList = new MyArrayList<>();
        myArrayList.add("Item1");
        myArrayList.add("Item2");
        myArrayList.add("Item3");

        assertEquals(3, myArrayList.size());
        assertEquals("Item1", myArrayList.get(0));
        assertEquals("Item2", myArrayList.get(1));
        assertEquals("Item3", myArrayList.get(2));
    }

    @Test
    public void testAddAtIndex() {
        myArrayList = new MyArrayList<>();
        myArrayList.add("Item1");
        myArrayList.add("Item2");
        myArrayList.add(1, "NewItem");

        assertEquals(3, myArrayList.size());
        assertEquals("Item1", myArrayList.get(0));
        assertEquals("NewItem", myArrayList.get(1));
        assertEquals("Item2", myArrayList.get(2));
    }

    @Test
    public void remove() {
        myArrayList = new MyArrayList<>();
        myArrayList.add("Item1");
        myArrayList.add("Item2");
        myArrayList.add("Item3");
        myArrayList.add("Item4");
        myArrayList.remove(1);

        assertEquals(3, myArrayList.size());
        assertEquals("Item1", myArrayList.get(0));
        assertEquals("Item3", myArrayList.get(1));
        assertEquals("Item4", myArrayList.get(2));

    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void removeNonExistentElement() {
        myArrayList = new MyArrayList<>();
        myArrayList.add("Item1");
        myArrayList.add("Item2");
        myArrayList.add("Item3");
        myArrayList.add("Item4");


        myArrayList.remove(5);
    }

    @Test
    public void getElementByIndex() {
        myArrayList = new MyArrayList<>();
        myArrayList.add("Item1");
        myArrayList.add("Item2");
        myArrayList.add("Item3");

        assertEquals("Item1", myArrayList.get(0));
        assertEquals("Item2", myArrayList.get(1));
        assertEquals("Item3", myArrayList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getInvalidIndex() {
        myArrayList = new MyArrayList<>();
        myArrayList.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getNegativeIndex() {
        myArrayList = new MyArrayList<>();
        myArrayList.get(-1);
    }

    @Test
    public void set() {
        myArrayList = new MyArrayList<>();
        myArrayList.add("Item1");
        myArrayList.add("Item2");
        myArrayList.add("Item3");
        myArrayList.set(1, "Check");

        assertEquals("Check", myArrayList.get(1));
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void setNegativeIndex() {
        myArrayList = new MyArrayList<>();
        myArrayList.add("Item1");
        myArrayList.add("Item2");
        myArrayList.add("Item3");
        myArrayList.set(-1, "Check");

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setBigIndex() {
        myArrayList = new MyArrayList<>();
        myArrayList.add("Item1");
        myArrayList.add("Item2");
        myArrayList.add("Item3");
        myArrayList.set(5, "Check");


    }

    @Test
    public void size() {
        myArrayList = new MyArrayList<>();
        myArrayList.add("Item1");
        myArrayList.add("Item2");
        myArrayList.add("Item3");
        myArrayList.add("Item4");
        myArrayList.add("Item5");
        myArrayList.add("Item6");
        assertEquals(6, myArrayList.size());
    }

    @Test
    public void clear() {
        myArrayList = new MyArrayList<>();
        myArrayList.add("Item1");
        myArrayList.add("Item2");
        myArrayList.add("Item3");
        myArrayList.add("Item4");
        myArrayList.add("Item5");
        myArrayList.add("Item6");

        myArrayList.clear();

        assertEquals(0, myArrayList.size());
    }

    @Test
    public void contains() {
        myArrayList = new MyArrayList<>();
        myArrayList.add("Item1");
        myArrayList.add("Item2");
        myArrayList.add("Item3");
        myArrayList.add("Item4");
        myArrayList.add("Item5");
        myArrayList.add("Item6");

        assertTrue(myArrayList.contains("Item6"));
    }

    @Test
    public void isEmpty() {
        myArrayList = new MyArrayList<>();
        myArrayList.add("Item1");
        myArrayList.add("Item2");
        myArrayList.add("Item3");
        myArrayList.add("Item4");
        myArrayList.add("Item5");
        myArrayList.add("Item6");

        assertFalse(myArrayList.isEmpty());

        myArrayList.clear();

        assertTrue(myArrayList.isEmpty());
    }


    @Test
    public void iterator() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Item1");
        myArrayList.add("Item2");
        myArrayList.add("Item3");

        Iterator<String> iterator1 = myArrayList.iterator();
        Iterator<String> iterator2 = myArrayList.iterator();


        assertNotSame(iterator1, iterator2);

        assertEquals("Item1", iterator1.next());
        assertEquals("Item2", iterator1.next());
        assertEquals("Item3", iterator1.next());

        assertFalse(iterator1.hasNext());
    }


}