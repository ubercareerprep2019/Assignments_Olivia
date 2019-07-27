package Part2;

/**
 * Interface for a phone book.
 * Each entry in the phone book is made up of 2 components: a name (String)
 * and a phone number (long)
 * */

public interface PhoneBook {

    /**
     * @return The number of entries in this phone book.
     * */
    int size();

    /**
     * Inserts an entry in this phone book.
     * @param name The name for the entry
     * @param phoneNumber The phone number for the entry.
     * */
    void insert(String name, long phoneNumber);

    /**
     * Returns the phone number associated with a name in the phone book.
     * @param name The name to search for.
     * @return The phone number for the entry, or -1 if the name is not present in the phone book.
     * */
    long find(String name);
}
