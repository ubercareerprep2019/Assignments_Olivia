package Part2;
import com.google.common.base.Stopwatch;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RunData {

    PhoneBook listPB = new ListPhoneBook();
    PhoneBook bstPB = new BinarySearchTreePhoneBook();
    Stopwatch stopwatch;

    void readCVS(String cvsFile, PhoneBook book) {
        Scanner scanner = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            scanner = new Scanner(new File(cvsFile));
            stopwatch = Stopwatch.createStarted();

            while (scanner.hasNextLine()) {
                // use comma as separator
                line = scanner.nextLine();
                String[] entry = line.split(cvsSplitBy);
                String entryName = entry[0];
                long entryNum = Long.parseLong(entry[1]);

                book.insert(entryName, entryNum);
            }

            stopwatch.stop();
            long timeElapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("Insert took " + timeElapsed + " milliseconds.");

        } catch (FileNotFoundException e) {
            stopwatch.stop();
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
    }

    void readTXT(String txtFile, PhoneBook book) {
        int counter = 0;
        Scanner scanner = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            scanner = new Scanner(new File(txtFile));
            stopwatch = Stopwatch.createStarted();

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                book.find(line);
                counter++;
            }

            stopwatch.stop();
            long timeElapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("find() was called " + counter + " times.");
            System.out.println("Search took " + timeElapsed + " milliseconds.");

        } catch (FileNotFoundException e) {
            stopwatch.stop();
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
    }


    public static void main(String args[]) {
        RunData main = new RunData();
//        System.out.println(args[0]);
        String data = "src/input/" + args[0];
        String search = "src/input/" + args[1];

        System.out.println("The following methods are applied to a List structured phone book:");
        main.readCVS(data, main.listPB);
        System.out.println("The size of the PhoneBook is " + main.listPB.size());
        main.readTXT(search, main.listPB);
        System.out.println();

        System.out.println("The following methods are applied to a BST structured phone book:");
        main.readCVS(data, main.bstPB);
        System.out.println("The size of the PhoneBook is " + main.bstPB.size());
        main.readTXT(search, main.bstPB);
        System.out.println();
    }
}

