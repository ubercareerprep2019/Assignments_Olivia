package Part2;

public class BinarySearchTreePhoneBook implements PhoneBook {

    private entryBST phoneBook;
    int size;

    BinarySearchTreePhoneBook() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public long find(String name) {
        entryBST track = phoneBook;

        while (track != null) {
            if (track.name.compareTo(name) == 0) {
                return track.number;
            } else if (track.name.compareTo(name) < 0) {
                track = track.right;
            } else {
                track = track.left;
            }
        }

        return -1;
    }

    @Override
    public void insert(String name, long phoneNumber) {
        entryBST track = phoneBook;
        entryBST toAdd = new entryBST(name, phoneNumber);

        if (phoneBook == null) {
            phoneBook = toAdd;
        }

        while (track != null) {
            if (track.name.compareTo(name) == 0) {
                entryBST prevRight = track.right;
                track.right = toAdd;
                toAdd.right = prevRight;
            } else if (track.name.compareTo(name) < 0) {
                if (track.right == null) {
                    track.right = toAdd;
                    break;
                }
                track = track.right;
            } else {
                if (track.left == null) {
                    track.left = toAdd;
                    break;
                }
                track = track.left;
            }
        }

        //skips to base case (when phoneBook is initially empty)
        size++;
    }


    /**
     * Supporting data structure to keep track of
     * each entry and its respective data using a BST model.
     * */
    class entryBST {
        String name;
        long number;
        entryBST left;
        entryBST right;

        entryBST(String name, long number) {
            this.name = name;
            this.number = number;
            left = null;
            right = null;
        }
    }

    entryBST getLeft() {
        return phoneBook.left;
    }
    entryBST getRight() {
        return phoneBook.right;
    }

//    //simple sanity test
//    public static void main(String[] args) {
//        BinarySearchTreePhoneBook test = new BinarySearchTreePhoneBook();
//
//    }
}
