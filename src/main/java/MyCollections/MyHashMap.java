package MyCollections;

import java.util.Objects;

/**
 * A simple implementation of a hashMap.
 *
 * @param <K> the type of keys
 * @param <V> the type of values
 */
public class MyHashMap<K, V> implements MyMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;

    private Node<K, V>[] buckets;

    /**
     * Constructs a new hashMap with the default initial capacity.
     */
    public MyHashMap() {
        buckets = new Node[DEFAULT_CAPACITY];
    }

    /**
     * Constructs a new hashMap with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the hashMap
     */
    public MyHashMap(int initialCapacity) {
        if (initialCapacity < 0)
            initialCapacity = DEFAULT_CAPACITY;
        buckets = new Node[initialCapacity];
    }

    /**
     * Associates the specified value with the specified key in this map.
     *
     * @param key   the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     */
    @Override
    public void put(K key, V value) {

        int hash = hash(key);
        int bucketIndex = getIndex(hash, buckets.length);

        Node<K, V> newNode = new Node<>(hash, key, value, null);

        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = newNode;
        } else {
            Node<K, V> current = buckets[bucketIndex];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = newNode;
            }
        }
    }

    /**
     * Resizes and rehashes the hash map when needed.
     */
    private void resizeAndRehash() {
        int newCapacity = buckets.length * 2;
        Node<K, V>[] newBuckets = new Node[newCapacity];

        for (Node<K, V> bucket : buckets) {
            Node<K, V> current = bucket;

            while (current != null) {
                int newBucketIndex = getIndex(current.hash, newCapacity);
                Node<K, V> newNode = new Node<>(current.hash, current.key, current.value, null);

                if (newBuckets[newBucketIndex] == null) {
                    newBuckets[newBucketIndex] = newNode;
                } else {
                    Node<K, V> newCurrent = newBuckets[newBucketIndex];
                    while (newCurrent.next != null) {
                        newCurrent = newCurrent.next;
                    }
                    newCurrent.next = newNode;
                }

                current = current.next;
            }
        }

        buckets = newBuckets;
    }

    /**
     * @return the number of key-value mappings in this map.
     */
    @Override
    public int size() {
        int count = 0;

        for (Node<K, V> bucket : buckets) {
            Node<K, V> current = bucket;

            while (current != null) {
                count++;
                current = current.next;
            }
        }

        return count;
    }

    /**
     * Returns the value to which the specified key is mapped.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or {@code null} if no mapping exists.
     */
    @Override
    public V get(K key) {
        int bucketIndex = getIndex(hash(key), buckets.length);

        Node<K, V> current = buckets[bucketIndex];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    /**
     * Returns  if this map contains a mapping for the specified key.
     *
     * @param key the key whose presence in this map.
     * @return {@code true} if this map contains a mapping for the specified key.
     */

    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            return false;
        }

        int bucketIndex = getIndex(hash(key), buckets.length);

        Node<K, V> current = buckets[bucketIndex];

        while (current != null) {
            if (Objects.equals(current.key, key)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /**
     * Removes the mapping for a key from this map if it is present.
     *
     * @param key the key whose mapping is to be removed from the map.
     */
    @Override
    public void remove(K key) {
        int hash = hash(key);
        int bucketIndex = getIndex(hash, buckets.length);

        Node<K, V> current = buckets[bucketIndex];
        Node<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[bucketIndex] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    /**
     * Removes all of the mappings from this map.
     */
    @Override
    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
    }

    /**
     * @return {@code true} if this map contains no key-value mappings, otherwise {@code false}
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * @return a list of all values present in this map
     */
    @Override
    public MyArrayList<V> values() {
        MyArrayList<V> valuesList = new MyArrayList<>();

        for (Node<K, V> bucket : buckets) {
            Node<K, V> current = bucket;

            while (current != null) {
                valuesList.add(current.value);
                current = current.next;
            }
        }

        return valuesList;
    }

    /**
     * Returns the index within the buckets array for the specified hash and length.
     *
     * @param hash   the hash code of the key
     * @param length the length of the buckets array
     * @return the index within the buckets array
     */
    private int getIndex(int hash, int length) {
        return hash % length;
    }

    /**
     * Returns the hash code for the specified key, or a constant value if the key is null.
     *
     * @param key the key for which to get the hash code
     * @return the hash code for the specified key
     */
    private int hash(K key) {
        return key == null ? 55 : key.hashCode();
    }

    /**
     * Represents a node in the hash map containing key-value pairs.
     *
     * @param <K> the type of keys
     * @param <V> the type of values
     */
    static class Node<K, V> {
        Node<K, V> next;
        V value;

        /**
         * Constructs a new node with the specified hash, key, value, and next node reference.
         *
         * @param hash  the hash code of the key
         * @param key   the key of the node
         * @param value the value of the node
         * @param next  the next node in the chain
         */
        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        final K key;
        final int hash;

        /**
         * @return the key of the node
         */
        public K getKey() {
            return key;
        }

        /**
         * @return the value of the node
         */
        public V getValue() {
            return value;
        }

        /**
         * Sets the value of the node.
         *
         * @param value the new value to be set
         */
        public void setValue(V value) {
            this.value = value;
        }

        /**
         * @return the next node in the chain
         */
        public Node<K, V> getNext() {
            return next;
        }

    }


}
