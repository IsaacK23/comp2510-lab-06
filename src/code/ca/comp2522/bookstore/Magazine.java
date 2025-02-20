package ca.comp2522.bookstore;

/**
 * Represents a magazine, which is a type of literature.
 * A magazine has a title, an author, and a year of publication.
 * It extends the {@link Literature} class.
 *
 * Provides methods to get and set magazine attributes.
 *
 * @author Bullen Kosa
 * @author Isaav Kehler
 * @version 1.0
 */
public class Magazine extends Literature {

    private String title;
    private String author;
    private int yearPublished;

    /**
     * Constructs a new Magazine with the specified title, author, and year of publication.
     *
     * @param title        the title of the magazine
     * @param author       the author of the magazine
     * @param yearPublished the year the magazine was published
     */
    public Magazine(final String title, final String author, final int yearPublished) {
        super(yearPublished);
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    /**
     * Gets the title of the magazine.
     *
     * @return the title of the magazine
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the magazine.
     *
     * @param title the new title of the magazine
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Gets the author of the magazine.
     *
     * @return the author of the magazine
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the magazine.
     *
     * @param author the new author of the magazine
     */
    public void setAuthor(final String author) {
        this.author = author;
    }

    /**
     * Gets the year the magazine was published.
     *
     * @return the year of publication
     */
    @Override
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * Sets the year the magazine was published.
     *
     * @param yearPublished the new publication year
     */
    public void setYearPublished(final int yearPublished) {
        this.yearPublished = yearPublished;
    }
}
