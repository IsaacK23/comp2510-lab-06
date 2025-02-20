package ca.comp2522.bookstore;

/**
 * Represents a literary work, which may include various types of literature such as novels, comic books, and magazines.
 * This abstract class provides the foundation for different literature types by defining common attributes and methods.
 *
 * @author Bullen Kosa
 * @author Isaac Kehler
 * @version 1.0
 */
public abstract class Literature
{

    private int yearPublished;

    /**
     * Constructs a new Literature object with the specified year of publication.
     *
     * @param yearPublished the year the literature was published
     */
    public Literature(final int yearPublished)
    {
        this.yearPublished = yearPublished;
    }

    /**
     * Retrieves the year the literature was published.
     *
     * @return the year of publication
     */
    public abstract int getYearPublished();

    /**
     * Retrieves the title of the literature.
     *
     * @return the title of the literature
     */
    public abstract String getTitle();

    /**
     * Retrieves the author of the literature.
     *
     * @return the author of the literature
     */
    public abstract String getAuthor();
}
