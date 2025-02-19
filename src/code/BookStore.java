package ca.comp2522.bookstore;


import java.util.*;

/**
 * Represents a bookstore that manages a collection of novels.
 * Provides various methods to interact with the collection, such as printing titles,
 * filtering by decade, finding the longest title, and more.
 *
 * @author Bullen Kosa
 * @author Dominic Cheang
 * @version 1.0
 */
public class BookStore<T extends Literature> {

    private static final int                BEGINNING_COUNT = 0;
    private static final int                DECADE_IN_YEARS = 10;
    private static final int                PERCENT_SHIFT   = 100;
    private final        String             storeName;
    private final        List<T>            bookList;
    private final        Map<String, T>     bookMap;

    static class BookStoreInfo {
        public void displayInfo(final String storeName,
                                final int itemCount) {
            System.out.println("BookStore: " + storeName + ", Items: " + itemCount);
        }
    }

    class NovelStatistics {
        public double averageTitleLength() {
            int totalLength;
            totalLength = 0;
            for (final T item : bookList) {
                totalLength += item.getTitle().length();
            }
            return (double) totalLength / bookList.size();
        }
    }


    /**
     * Constructs a new BookStore with the given name and populates it with a list of novels.
     *
     * @param storeName the name of the bookstore
     */
    public BookStore(final String storeName) {
        this.storeName = storeName;
        this.bookList = new ArrayList<>();
        this.bookMap  = new HashMap<>();

        System.out.println("BookStore: " + storeName + "\n");
        printItems();



    }

    public void addItem(final T item) {
        bookList.add(item);
    }

    public void printItems() {
        for (T item : bookList) {
            System.out.println(item.getTitle());
        }
    }

    /**
     * The main method to demonstrate the functionality of the BookStore class.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(final String[] args) {
        final BookStore<Literature> store;
        store = new BookStore<>("The Greatest Bookstore");
        store.addItem(new Novel("War and Peace", "something", 2020));
        store.addItem(new ComicBook("Spider-Man", "something", 2020));
        store.addItem(new Magazine("National Geographic", "something", 2020));
        store.printItems();
        store.printAllTitles();
    }


    /*
     * Populates the novel map with the novels within the bookstore.
     * The key is the title and value is the novel object.
     */
    private void populateBookMap() {
        for (final T book : bookList) {
            bookMap.put(book.getTitle(), book);
        }
    }

    /*
     * Removes all books whose title contains "the" (case-insensitive).
     */
    private void removeBooksWithThe() {
        final Iterator<String> iterator;
        iterator = bookMap.keySet().iterator();

        while (iterator.hasNext()) {
            String title = iterator.next();
            if (title.toLowerCase().contains("the")) {
                iterator.remove();
            }
        }
    }

    /*
     * Prints all book titles in sorted order after filtering.
     */
    private void printSortedBooks() {
        final List<String> keyList;
        keyList = new ArrayList<>(bookMap.keySet());

        Collections.sort(keyList);
        for (final String title : keyList) {
            System.out.println(bookMap.get(title));
        }
    }

    /*
     * Prints all book titles in uppercase.
     */
    private void printAllTitles() {
        for (final T book : bookList) {
            System.out.println(book.getTitle().toUpperCase());
        }
    }

    /*
     * Prints all book titles that contain the specified word (case-insensitive).
     *
     * @param title the word to search for in book titles
     */
    private void printBookTitle(final String title) {
        bookList.forEach(book -> {
            if (book.getTitle().contains(title)) {
                System.out.println(book.getTitle());
            }
        });
    }


    /**
     * Prints all book titles in alphabetical order.
     *
     */
    public void printTitlesInAlphaOrder() {
        bookList.sort(String::compareToIgnoreCase);
        bookList.forEach(book -> System.out.println(book.getTitle()));
    }


    /*
     * Prints all books published in the specified decade.
     *
     * @param decade the starting year of the decade (e.g., 2000 for the 2000s)
     *
    private void printGroupByDecade(final int decade) {
        final int START_DECADE;
        final int END_DECADE;
        START_DECADE = decade - (decade % 10);
        END_DECADE   = START_DECADE + DECADE_IN_YEARS;

        for (final T book : bookList) {
            if (book.getYearPublished() >= START_DECADE && book.getYearPublished() < END_DECADE) {
                System.out.println(book.getTitle());
            }
        }
    }

    /*
     * Prints the longest book title in the collection.
     */
    private void getLongest() {
        String longestTitle;
        longestTitle = bookList.getFirst().getTitle();

        for (final T book : bookList) {
            if (book.getTitle().length() > longestTitle.length()) {
                longestTitle = book.getTitle();
            }
        }
        System.out.println(longestTitle);
    }

    /*
     * Checks if there is a book published in the specified year.
     *
     * @param year the year to check
     * @return true if a book was published in the specified year, false otherwise
     *
    private boolean isThereABookWrittenIn(final int year) {
        for (final T book : bookList) {
            if (book.getYearPublished() == year) {
                return true;
            }
        }
        return false;
    }

    /*
     * Counts the number of books whose titles contain the specified word (case-insensitive).
     *
     * @param word the word to search for in book titles
     * @return the number of books containing the word
     */
    private int howManyBooksContain(final String word) {
        int bookCount;
        bookCount = BEGINNING_COUNT;

        for (final T book : bookList) {
            if (book.getTitle().toUpperCase().contains(word.toUpperCase())) {
                bookCount++;
            }
        }
        return bookCount;
    }

    /*
     * Calculates the percentage of books published between the specified years (inclusive).
     *
     * @param first the starting year
     * @param last  the ending year
     * @return the percentage of books published between the specified years
     *
    private int whichPercentWrittenBetween(final int first, final int last) {
        int bookCount;
        bookCount = BEGINNING_COUNT;

        for (final T book : bookList) {
            if (book.getYearPublished() >= first && book.getYearPublished() <= last) {
                bookCount++;
            }
        }
        return bookCount * PERCENT_SHIFT / bookList.size();
    }

    /*
     * Finds and returns the oldest book in the collection.
     *
     * @return the oldest book
     *
    private T getOldestBook() {
        T oldestBook;
        oldestBook = bookList.getFirst();

        for (final T book : bookList) {
            if (book.getYearPublished() < oldestBook.getYearPublished()) {
                oldestBook = book;
            }
        }
        return oldestBook;
    }

    /*
     * Returns a list of books whose titles are of the specified length.
     *
     * @param titleLength the length of the title to search for
     * @return a list of books with titles of the specified length
     */
    private List<T> getBooksThisLength(final int titleLength) {
        final List<T> booksOfLength;
        booksOfLength = new ArrayList<>();

        for (final T book : bookList) {
            if (book.getTitle().length() == titleLength) {
                booksOfLength.add(book);
            }
        }
        return booksOfLength;
    }


    public void addNovelsToCollection(final List<? super Novel> novelCollection) {
        for (final T item : bookList) {
            if (item instanceof Novel) {
                novelCollection.add((Novel) item);
            }
        }
    }


}
