package MyCollections;

/**
 * Custom interface for a list.
 *
 * @param <E> the type of elements in the list.
 */
public interface MyList<E> extends Iterable<E> {

    /**
     * Adds an element to the end of the list.
     *
     * @param e the element to be added.
     */
    void add(E e);

    /**
     * Adds an element at the specified index in the list.
     *
     * @param index   the index at which the element should be inserted.
     * @param element the element to be added.
     */
    void add(int index, E element);

    /**
     * Removes the element at the specified index.
     *
     * @param index the index of the element to be removed.
     * @return the removed element.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size).
     */
    E remove(int index);

    /**
     * Retrieves the element at the specified index.
     *
     * @param index the index of the element to be retrieved.
     * @return the element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size).
     */
    E get(int index);

    /**
     * Replaces the element at the specified index with the specified element.
     *
     * @param index   the index of the element to be replaced.
     * @param element the new element to be stored at the specified index.
     * @return the old element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size).
     */
    E set(int index, E element);

    /**
     * Returns the current size of the list.
     *
     * @return the size of the list.
     */
    int size();

    /**
     * Removes all elements from the list.
     */
    void clear();

    /**
     * Checks if the list contains the specified element.
     *
     * @param object the element to be checked.
     * @return true if the list contains the specified element, false otherwise.
     */
    boolean contains(Object object);

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * The method reduces the capacity of the list to its current size.
     */
    void trimToSize();

}
