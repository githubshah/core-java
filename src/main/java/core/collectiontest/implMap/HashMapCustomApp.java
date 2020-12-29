package core.collectiontest.implMap;

/**
 * @param <K>
 * @param <V>
 * @author AnkitMittal, JavaMadeSoEasy.com
 * Copyright (c), AnkitMittal . All Contents are copyrighted and must not be
 * reproduced in any form.
 * This class provides custom implementation of HashMap(without using java api's)-
 * which allows us to store data in key-value pair form.
 * insertion order of key-value pairs is not maintained.
 */
class HashMapCustom<K, V> {

    private Entry<K, V>[] table;   //Array of Entry.
    private int capacity = 4;  //Initial capacity of HashMap

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


    @SuppressWarnings("unchecked")
    public HashMapCustom() {
        table = new Entry[capacity];
    }


    /**
     * Method allows you put key-value pair in HashMapCustom.
     * If the map already contains a mapping for the key, the old value is replaced.
     * Note: method does not allows you to put null key though it allows null values.
     * Implementation allows you to put custom objects as a key as well.
     * Key Features: implementation provides you with following features:-
     * >provide complete functionality how to override equals method.
     * >provide complete functionality how to override hashCode method.
     *
     * @param newKey
     * @param data
     */
    public V put(K newKey, V data) {
        if (newKey == null)
            return data;    //does not allow to store null.

        //calculate hash of key.
        int index = hash(newKey);
        //create new entry.
        Entry<K, V> newEntry = new Entry<K, V>(newKey, data, null);

        //if table location does not contain any entry, store entry there.
        if (table[index] == null) {
            table[index] = newEntry;
            return newEntry.value;
        } else {
            Entry<K, V> previousNode = table[index];
            Entry<K, V> currentNode = table[index];

            while (currentNode != null) { //we have reached last entry of bucket.
                if (currentNode.key.equals(newKey)) {
                    if (previousNode == null) {  //node has to be insert on first of bucket.
                        newEntry.next = currentNode.next;
                        table[index] = newEntry;
                        return newEntry.value;
                    } else {
                        newEntry.next = currentNode.next; // remove exact matched node
                        previousNode.next = newEntry;
                        return currentNode.value;
                    }
                }
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            previousNode.next = newEntry; // connect new node after at last node
            return newEntry.value;
        }
    }

    /**
     * Method returns value corresponding to key.
     *
     * @param key
     */
    public V get(K key) {
        if (key == null) {
            return table[0] == null ? null : table[0].value;
        }

        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            Entry<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next; //return value corresponding to key.
            }
            return null;   //returns null if key is not found.
        }
    }


    /**
     * Method removes key-value pair from HashMapCustom.
     */
    public boolean remove(K deleteKey) {

        if (deleteKey == null) {
            if (table[0] == null) {
                return false;
            } else {
                table[0] = null;
                return true;
            }
        }

        int hash = hash(deleteKey);

        if (table[hash] == null) {
            return false;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) { //we have reached last entry node of bucket.
                if (current.key.equals(deleteKey)) {
                    if (previous == null) {  //delete first entry node.
                        table[hash] = table[hash].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

    }


    /**
     * Method displays all key-value pairs present in HashMapCustom.,
     * insertion order is not guaranteed, for maintaining insertion order
     * refer LinkedHashMapCustom.
     */
    public void display() {

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                Entry<K, V> entry = table[i];
                while (entry != null) {
                    System.out.print("{" + entry.key + "=" + entry.value + "}" + " ");
                    entry = entry.next;
                }
            }
        }

    }

    /**
     * Method implements hashing functionality, which helps in finding the appropriate
     * bucket location to store our data.
     * This is very important method, as performance of HashMapCustom is very much
     * dependent on  this method's implementation.
     *
     * @param key
     */
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

}


/**
 * Main_ColorAbstractMethod class- to test HashMap functionality.
 */
public class HashMapCustomApp {

    public static void main(String[] args) {
        HashMapCustom<Integer, Integer> hashMapCustom = new HashMapCustom<Integer, Integer>();
        hashMapCustom.put(21, 12);
        hashMapCustom.put(25, 121);
        hashMapCustom.put(30, 151);
        hashMapCustom.put(33, 15);
        hashMapCustom.put(35, 89);

        //adding same key but diff value
        System.out.println("adding same key 35:89 but it return old value " +hashMapCustom.put(35, 100));

        System.out.println("value corresponding to key 21="
            + hashMapCustom.get(21));
        System.out.println("value corresponding to key 51="
            + hashMapCustom.get(51));

        System.out.print("Displaying : ");
        hashMapCustom.display();

        System.out.println("\n\nvalue corresponding to key 21 removed: "
            + hashMapCustom.remove(21));
        System.out.println("value corresponding to key 51 removed: "
            + hashMapCustom.remove(51));

        System.out.print("Displaying : ");
        hashMapCustom.display();

    }
}