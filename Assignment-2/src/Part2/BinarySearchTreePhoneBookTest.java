package Part2;

import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreePhoneBookTest {

    private BinarySearchTreePhoneBook phonebook;

    @BeforeEach
    void init() {
        phonebook = new BinarySearchTreePhoneBook();
    }

    void addSimple() {
        phonebook.insert("olivia", 1234);
    }

    @Test
    void testSize() {
        assertEquals(0, phonebook.size(), "initial phoneBook size should equal 0");
        addSimple();
        assertEquals(1, phonebook.size(), "addSimple method inserts one entry into Phonebook");
    }

    @Test
    void testInsert() {

        //inserts should occur in lexicographical ordering
        addSimple();
        phonebook.insert("lee", 5678);

        String left = phonebook.getLeft().name;
        int equals = left.compareTo("lee");
    }

    @Test
    void testFind() {
        addSimple();
        phonebook.insert("lee", 5678);

        long olivia = phonebook.find("olivia");
        long lee = phonebook.find("lee");

        assertEquals(1234, olivia);
        assertEquals(5678, lee);
        assertEquals(-1, phonebook.find("none"));

    }

    @Test
    void testMediumSample() {
    //tests first 20 lines of data.csv
        Scanner scanner = null;
        String line = "";
        String cvsSplitBy = ",";

        String last = "";

        try {
            scanner = new Scanner(new File("src/input/dataSmall.csv"));

            while (scanner.hasNextLine()) {
                // use comma as separator
                line = scanner.nextLine();
                String[] entry = line.split(cvsSplitBy);
                String entryName = entry[0];
                long entryNum = Long.parseLong(entry[1]);

                phonebook.insert(entryName, entryNum);
            }
            last = line.split(cvsSplitBy)[0];

        } catch (FileNotFoundException e) {
            System.out.println("fnf exception caught.");
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                try {
                    scanner.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        assertNotEquals(-1, phonebook.find(last));
    }
}