package MyCollections;

/**
 * A simple interface representing a key-value map.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public interface MyMap<K, V> {

    /**
     * Associates the specified value with the specified key in this map.
     *
     * @param key   the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     */
    void put(K key, V value);

    /**
     * @return the number of key-value mappings in this map.
     */
    int size();

    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or {@code null} if no mapping exists
     */
    V get(K key);

    /**
     * Returns {@code true} if this map contains a mapping for the specified key.
     *
     * @param key the key whose presence in this map is to be tested
     * @return {@code true} if this map contains a mapping for the specified key, otherwise {@code false}
     */
    boolean containsKey(K key);

    /**
     * Removes the mapping for a key from this map if it is present.
     *
     * @param key the key whose mapping is to be removed from the map.
     */
    void remove(K key);

    /**
     * Removes all of the mappings from this map.
     */
    void clear();

    /**
     * Returns {@code true} if this map contains no key-value mappings.
     *
     * @return {@code true} if this map contains no key-value mappings, otherwise {@code false}
     */
    boolean isEmpty();

    /**
     * @return a list of all values present in this map.
     */
    MyArrayList<V> values();
}
