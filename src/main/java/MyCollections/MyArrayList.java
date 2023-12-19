package MyCollections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * Custom implementation of an ArrayList.
 *
 * @param <E> the type of elements stored in the list.
 */
public class MyArrayList<E> implements MyList<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private E[] elements;

    private int size;

    /**
     * Constructs an empty list with the default initial capacity.
     */
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list.
     * @throws IllegalArgumentException if the specified initial capacity is negative.
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        elements = (E[]) new Object[initialCapacity];
        this.size = 0;
    }

    /**
     * Adds the specified element to the end of the list.
     *
     * @param element the element to be added.
     */
    @Override
    public void add(E element) {
        ensureCapacity();
        elements[size++] = element;
    }

    /**
     * Adds the specified element at the specified position in the list.
     *
     * @param index   the position at which to add the element.
     * @param element the element to be added.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size).
     */
    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        rangeCheck(index);
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Increases the capacity of the list if necessary.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            copyElementsToNewArray(newCapacity);
        }
    }

    /**
     * Copies elements to a new array with the specified capacity.
     *
     * @param newCapacity the new capacity of the array.
     */
    private void copyElementsToNewArray(int newCapacity) {
        E[] newElements = (E[]) new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    /**
     * Removes the element at the specified position in the list.
     *
     * @param index the index of the element to be removed.
     * @return the removed element.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size).
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        rangeCheck(index);
        E oldElement = elements[index];

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }

        elements[--size] = null;

        return oldElement;
    }

    /**
     * The method reduces the capacity of the list to its current size
     */
    @Override
    public void trimToSize() {
        if (size < elements.length) {
            copyElementsToNewArray(size);
        }
    }


    /**
     * Checks if the index is within the bounds of the list size.
     *
     * @param index the index to be checked.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size).
     */
    private void rangeCheck(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    /**
     * Retrieves the element at the specified position in the list.
     *
     * @param index the index of the element to be retrieved.
     * @return the element at the specified position.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size).
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * Replaces the element at the specified position in the list with the specified element.
     *
     * @param index   the index of the element to be replaced.
     * @param element the new element to be stored at the specified position.
     * @return the old element at the specified position.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size).
     */
    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        return elements[index] = element;
    }

    /**
     * Returns the current size of the list.
     *
     * @return the size of the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all elements from the list, leaving it empty.
     */
    @Override
    public void clear() {
        for (int index = 0; index < size; index++) {
            elements[index] = null;
        }
        size = 0;
    }

    /**
     * Checks if the list contains the specified element.
     *
     * @param object the element to be checked.
     * @return true if the list contains the specified element, false otherwise.
     */
    @Override
    public boolean contains(Object object) {
        for (int index = 0; index < size; index++) {
            if (Objects.equals(object, elements[index]))
                return true;
        }
        return false;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an iterator over the elements in the list.
     *
     * @return an iterator over the elements in the list.
     */
    @Override
    public Iterator<E> iterator() {
        E[] copy = Arrays.copyOf(elements, size);
        return new ArrayIterator<>(copy);
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(" Size = " + size + " [");
        for (int i = 0; i < size; i++) {
            result.append(elements[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

}
