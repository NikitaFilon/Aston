package MyCollections;

import java.util.Iterator;

/**
 * Custom iterator for arrays.
 *
 * @param <E> the type of elements in the array.
 */
public class ArrayIterator<E> implements Iterator<E> {
    private int index = 0;
    private E[] element;

    /**
     * Constructs an iterator for the specified array.
     *
     * @param element the array to be iterated.
     */
    ArrayIterator(E[] element) {
        this.element = element;
    }

    /**
     * Returns true if the iteration has more elements.
     *
     * @return true if the iteration has more elements, false otherwise.
     */
    @Override
    public boolean hasNext() {
        return index < element.length;
    }

    /**
     * @return the next element in the iteration.
     */
    @Override
    public E next() {
        return element[index++];
    }

}
