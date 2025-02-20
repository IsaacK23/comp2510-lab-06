package ca.comp2522.bookstore;

import java.util.*;

/**
 * Represents a bookstore that manages a collection of literature works.
 * Provides various methods to interact with the collection, such as printing titles,
 * filtering by decade, finding the longest title, and more.
 *
 * @param <T> the type of literature managed by the bookstore, which extends Literature
 * @author Bullen Kosa
 * @author Isaac Kehler
 * @author Dominic Cheang
 * @version 1.0
 */
public class BookStore<T extends Literature> {

    private static final int            BEGINNING_COUNT = 0; // Initial count for various operations
    private static final int            DECADE_IN_YEARS = 10; // Represents the number of years in a decade
    private static final int            PERCENT_SHIFT   = 100; // Used to calculate percentages
    private final        String         storeName; // The name of the bookstore
    private final        List<T>        bookList; // List to hold literature items in the bookstore
    private final        Map<String, T> bookMap; // Map to associate book titles with their respective literature objects

    /**
     * Inner class that holds information about the bookstore.
     */
    static class BookStoreInfo {

        /**
         * Displays information about the bookstore, including its name and item count.
         *
         * @param storeName the name of the bookstore
         * @param itemCount the total number of items in the bookstore
         */
        public void displayInfo(final String storeName,
                                final int itemCount) {
            System.out.println("BookStore: " + storeName + ", Items: " + itemCount);
        }
    }

    /**
     * Inner class to calculate statistics related to novels.
     */
    class NovelStatistics {

        /**
         * Calculates the average title length of the books in the store.
         *
         * @return the average length of book titles
         */
        public double averageTitleLength() {
            int totalLength = 0;
            for (final T book : bookList) {
                totalLength += book.getTitle().length();
            }
            return (double) totalLength / bookList.size();
        }
    }

    /**
     * Constructs a new BookStore with the given name and initializes the book collection.
     *
     * @param storeName the name of the bookstore
     */
    public BookStore(final String storeName) {
        this.storeName = storeName;
        this.bookList  = new ArrayList<>();
        this.bookMap   = new HashMap<>();
        populateComics();
        populateMagazines();
        populateNovels();
        populateBookMap();

        System.out.println("BookStore: " + storeName + "\n");

    }

    /**
     * Adds a literature item to the bookstore's collection.
     *
     * @param item the literature item to add
     */
    public void addItem(final T item) {
        bookList.add(item);
    }

    /**
     * Prints the titles of all books in the bookstore.
     */
    public void printItems() {
        for (T item : bookList) {

            System.out.println("The book " + item.getTitle() +
                               " was written by " + item.getAuthor() +
                               " in " + item.getYearPublished());
        }
    }


    /**
     * The main method to demonstrate the functionality of the BookStore class.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(final String[] args) {
        final BookStore<Literature> bookstore = new BookStore<>("The Greatest Bookstore");
        final List<Literature> fifteenCharTitles;
        final Literature oldest;

        System.out.println("All Titles in UPPERCASE:");
        bookstore.printAllTitles();
        System.out.println("\nBook Titles Containing 'the':");
        bookstore.printBookTitle("the");
        System.out.println("\nAll Titles in Alphabetical Order:");
        bookstore.printTitlesInAlphaOrder();
        System.out.println("\nBooks from the 2000s:");
        bookstore.printGroupByDecade(2000);
        System.out.println("\nLongest Book Title:");
        bookstore.getLongest();
        System.out.println("\nIs there a book written in 1950?");
        System.out.println(bookstore.isThereABookWrittenIn(1950));
        System.out.println("\nHow many books contain 'heart'?");
        System.out.println(bookstore.howManyBooksContain("heart"));
        System.out.println("\nPercentage of books written between 1940 and 1950:");
        System.out.println(bookstore.whichPercentWrittenBetween(1940, 1950) + "%");
        System.out.println("\nOldest book:");
        oldest = bookstore.getOldestBook();
        System.out.println(oldest.getTitle() + " by " + oldest.getAuthor() + ", " +
                           oldest.getYearPublished());
        System.out.println("\nBooks with titles 15 characters long:");
        fifteenCharTitles = bookstore.getBooksThisLength(15);
        fifteenCharTitles.forEach(novel -> System.out.println(novel.getTitle()));
        bookstore.removeBooksWithThe();
        System.out.println("\nRemoving all books that contain 'the' within the title:");
        bookstore.printSortedBooks();


    }

    /*
     * Populates the booklist with comics.
     */
    private void populateComics() {
        ComicBook comic1 = new ComicBook("Watchmen", "Alan Moore", 1987);
        ComicBook comic2 = new ComicBook("Batman: The Dark Knight Returns", "Frank Miller", 1986);
        ComicBook comic3 = new ComicBook("Spider-Man: Blue", "Jeph Loeb", 2002);
        ComicBook comic4 = new ComicBook("Maus", "Art Spiegelman", 1991);
        ComicBook comic5 = new ComicBook("Sandman", "Neil Gaiman", 1989);

        addItem((T) comic1);
        addItem((T)comic2);
        addItem((T)comic3);
        addItem((T)comic4);
        addItem((T)comic5);
      }


    /*
       * Populates the booklist with magazines.
       */
      private void populateMagazines() {
          Magazine magazine1 = new Magazine("National Geographic", "Various", 2020);
          Magazine magazine2 = new Magazine("TIME", "Henry Luce", 1923);
          Magazine magazine3 = new Magazine("Forbes", "B.C. Forbes", 1917);
          Magazine magazine4 = new Magazine("Scientific American", "Michael Moyer", 1845);
          Magazine magazine5 = new Magazine("The New Yorker", "Harold Ross", 1925);

          addItem((T)magazine1);
          addItem((T)magazine2);
          addItem((T)magazine3);
          addItem((T)magazine4);
          addItem((T)magazine5);
      }

      /*
       * Populates the booklist with novels.
       */
      private void populateNovels() {
          Novel novel1 = new Novel("War and Peace", "Leo Tolstoy", 1869);
          Novel novel2 = new Novel("Pride and Prejudice", "Jane Austen", 1813);
          Novel novel3 = new Novel("1984", "George Orwell", 1949);
          Novel novel4 = new Novel("The Great Gatsby", "F. Scott Fitzgerald", 1925);
          Novel novel5 = new Novel("To Kill a Mockingbird", "Harper Lee", 1960);

          addItem((T)novel1);
          addItem((T)novel2);
          addItem((T)novel3);
          addItem((T)novel4);
          addItem((T)novel5);
      }


    /*
     * Populates the novel map with the novels within the bookstore.
     * The key is the title and the value is the novel object.
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
        final Iterator<String> iterator = bookMap.keySet().iterator();

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

    private void printBookTitle(final String title) {
        bookList.forEach(book -> {
            if (book.getTitle().toUpperCase().contains(title.toUpperCase())) {
                System.out.println(book.getTitle());
            }
        });
    }

    /*
     * Prints book titles in alphabetical order.
     */
    private void printTitlesInAlphaOrder() {
        List<T> sortedBooks = new ArrayList<>(bookList);
        sortedBooks.sort(Comparator.comparing(book -> book.getTitle().toLowerCase()));

        for (T book : sortedBooks) {
            System.out.println(book.getTitle());
        }
    }

    /*
     * Prints all books published in the specified decade.
     *
     * @param decade the starting year of the decade (e.g., 2000 for the 2000s)
     */
    private void printGroupByDecade(final int decade) {
        final int START_DECADE = decade - (decade % 10);
        final int END_DECADE = START_DECADE + DECADE_IN_YEARS;

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
        String longestTitle = bookList.get(0).getTitle();

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
     */
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
        int bookCount = BEGINNING_COUNT;

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
     */
    private int whichPercentWrittenBetween(final int first, final int last) {
        int bookCount = BEGINNING_COUNT;

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
     */
    private T getOldestBook() {
        T oldestBook = bookList.get(0); // Initialize with the first book

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
        final List<T> booksOfLength = new ArrayList<>();

        for (final T book : bookList) {
            if (book.getTitle().length() == titleLength) {
                booksOfLength.add(book);
            }
        }
        return booksOfLength;
    }

    /*
     * Adds all novels from the bookstore's collection to the provided novel collection.
     *
     * @param novelCollection the collection to which novels will be added
     */
    public void addNovelsToCollection(final List<? super Novel> novelCollection) {
        for (final T item : bookList) {
            if (item instanceof Novel) {
                novelCollection.add((Novel) item);
            }
        }
    }
}
