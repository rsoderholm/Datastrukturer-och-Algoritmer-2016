package p2;


import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Robin on 2016-09-22.
 */
public class HashTable {
    private LinkedList<Object> insertionOrder = new LinkedList<>();
    private LinkedList<Entry>[] table;
    private Object key, value;



    public HashTable(int size) {
        table = (LinkedList<Entry>[]) new LinkedList<?>[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }

    }

    private int hashIndex(Object key) {
        int hashCode = key.hashCode();
        hashCode = hashCode % table.length;
        return (hashCode < 0) ? -hashCode : hashCode;
    }

    public Object get(Object key) {
        int hashIndex = hashIndex(key);
        LinkedList<Entry> entries = table[hashIndex];
        Iterator<Entry> it = entries.listIterator();

        while (it.hasNext()) {
            Entry entry = it.next();
            if (entry.equals(key)) {
                return entry.getValue();
            }

        }
        return null;
    }

    /**
     * Returns number of elements in the hashtable by calling insertionOrder.count
     *
     * @return
     */
    public int count() {
        return insertionOrder.size();


    }

    /**
     * Adds a new entry to the hashtable if the key is not already in it. Adds 'value' last in the linkedlist
     * 'insertionOrder'
     *
     * @param key
     * @param value
     */
    public void put(Object key, Object value) {
        if (get(key) == null) {
            table[hashIndex(key)].addFirst(new Entry(key, value));
            insertionOrder.addFirst(value);


        }


    }

    /**
     * Removes an entry from the hashtable if the key is found. If the key is found, removes value from the linkedlist
     * insertionOrder
     *
     * @param key
     */
    public Object remove(Object key) {
        if (get(key) != null) {
            table[hashIndex(key)].remove(new Entry(key, null));
            getInsertionOrder(insertionOrder);
            insertionOrder.removeLast();
            return null;

        } else {
            System.out.println("The word is not in the dictionary.");

        }

        return key;
    }

    /**
     * Returns the linkedlist insertionOrder
     *
     * @return
     */
    public LinkedList<Object> getInsertionOrder(LinkedList<Object> insertionOrder) {

        return insertionOrder;
    }


}
