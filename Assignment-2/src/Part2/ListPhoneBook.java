package Part2;

import java.util.ArrayList;

/**
 * Implementation of PhoneBook interface using an array list as the underlying
 * data structure.
 *
 * @author olivialee
 * */
public class ListPhoneBook implements PhoneBook {

    private  ArrayList<Entry> phoneBook;
    private int size;

    ListPhoneBook() {
        phoneBook = new ArrayList<>();
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(String name, long phoneNumber) {
        Entry toAdd = new Entry(name, phoneNumber);
        phoneBook.add(toAdd);
        size++;
    }

    @Override
    public long find(String name) {
        for (int i = 0; i < size; i++) {
            Entry e = phoneBook.get(i);
            if (e.name.equals(name)) {
                return e.number;
            }
        }
        return -1;
    }

    /**
     * Helper function for insert method.
     * @return entry index if entry with same name exists, otherwise returns -1.
     * */
    private int findIndex(String name) {
        for (int i = 0; i < size; i++) {
            Entry compareTo = phoneBook.get(i);
            if (compareTo.name.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Supporting data structure to keep track of
     * each entry and its respective data.
     * */
    class Entry {
        String name;
        long number;

        Entry(String name, long number) {
            this.name = name;
            this.number = number;
        }
    }
}
