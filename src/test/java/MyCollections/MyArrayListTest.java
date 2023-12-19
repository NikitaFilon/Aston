package MyCollections;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MyArrayListTest {

    private MyArrayList<String> myArrayList;

    @Before
    public void setUp() {
        myArrayList = new MyArrayList<>();
        myArrayList.add("Item1");
        myArrayList.add("Item2");
        myArrayList.add("Item3");
        myArrayList.add("Item4");
        myArrayList.add("Item5");
        myArrayList.add("Item6");
    }

    @Test
    public void add() {
        myArrayList.add("Item");

        assertEquals(7, myArrayList.size());
        assertEquals("Item", myArrayList.get(6));
    }


    @Test
    public void addMultipleElements() {
        myArrayList.add("Item7");
        myArrayList.add("Item8");
        myArrayList.add("Item9");

        assertEquals(9, myArrayList.size());
        assertEquals("Item7", myArrayList.get(6));
        assertEquals("Item8", myArrayList.get(7));
        assertEquals("Item9", myArrayList.get(8));
    }

    @Test
    public void testAddAtIndex() {
        myArrayList.add(1, "NewItem");

        assertEquals(7, myArrayList.size());
        assertEquals("Item1", myArrayList.get(0));
        assertEquals("NewItem", myArrayList.get(1));
        assertEquals("Item2", myArrayList.get(2));
    }

    @Test
    public void remove() {
        myArrayList.remove(1);

        assertEquals(5, myArrayList.size());
        assertEquals("Item1", myArrayList.get(0));
        assertEquals("Item3", myArrayList.get(1));
        assertEquals("Item4", myArrayList.get(2));

    }


    @Test
    public void removeNonExistentElement() {

        myArrayList.remove(5);

        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.remove(5));

    }

    @Test
    public void getElementByIndex() {

        assertEquals("Item1", myArrayList.get(0));
        assertEquals("Item2", myArrayList.get(1));
        assertEquals("Item3", myArrayList.get(2));
    }

    @Test
    public void getInvalidIndex() {

        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.get(11));
    }

    @Test
    public void getNegativeIndex() {

        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.get(-1));
    }

    @Test
    public void set() {

        myArrayList.set(1, "Check");

        assertEquals("Check", myArrayList.get(1));
    }


    @Test
    public void setNegativeIndex() {

        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.set(-1, "Check"));

    }

    @Test
    public void setBigIndex() {

        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.set(11, "Check"));

    }

    @Test
    public void size() {
        myArrayList.add("Item1");
        myArrayList.add("Item2");
        myArrayList.add("Item3");
        myArrayList.add("Item4");
        myArrayList.add("Item5");
        myArrayList.add("Item6");
        assertEquals(12, myArrayList.size());
    }

    @Test
    public void clear() {

        myArrayList.clear();

        assertEquals(0, myArrayList.size());
    }

    @Test
    public void contains() {

        assertTrue(myArrayList.contains("Item6"));
    }

    @Test
    public void isEmpty() {

        assertFalse(myArrayList.isEmpty());

        myArrayList.clear();

        assertTrue(myArrayList.isEmpty());
    }


    @Test
    public void iterator() {

        Iterator<String> iterator1 = myArrayList.iterator();
        Iterator<String> iterator2 = myArrayList.iterator();


        assertNotSame(iterator1, iterator2);

        assertEquals("Item1", iterator1.next());
        assertEquals("Item2", iterator1.next());
        assertEquals("Item3", iterator1.next());
        assertEquals("Item4", iterator1.next());
        assertEquals("Item5", iterator1.next());
        assertEquals("Item6", iterator1.next());

        assertFalse(iterator1.hasNext());
    }

    @Test
    public void trimToSize() {
        MyList<String> myList = new MyArrayList<>();

        myList.trimToSize();

        assertTrue(myList.isEmpty());
    }

    @Test
    public void trimToSizeCapacityToSize() {

        myArrayList.trimToSize();

        assertEquals(6, myArrayList.size());
        assertEquals("Item1", myArrayList.get(0));
        assertEquals("Item2", myArrayList.get(1));
        assertEquals("Item3", myArrayList.get(2));
    }


}