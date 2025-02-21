package ca.comp2522.bookstore;

/**
 * Represents a magazine, which is a type of literature.
 * A magazine has a title, an author, and a year of publication.
 * It extends the {@link Literature} class.
 * <p>
 * Provides methods to get and set magazine attributes.
 *
 * @author Bullen Kosa
 * @author Isaac Kehler
 * @version 1.0
 */
public class Magazine extends Literature
{
    private static final int MIN_YEAR     = 0;
    private static final int CURRENT_YEAR = 2025;

    private String title;
    private String author;
    private int    yearPublished;

    /**
     * Constructs a new Magazine with the specified title, author, and year of publication.
     *
     * @param title         the title of the magazine
     * @param author        the author of the magazine
     * @param yearPublished the year the magazine was published
     */
    public Magazine(final String title,
                    final String author,
                    final int yearPublished)
    {
        super(yearPublished);

        validateTitle(title);
        validateAuthor(author);
        validateYearPublished(yearPublished);

        this.title         = title;
        this.author        = author;
        this.yearPublished = yearPublished;
    }

    /*
     * Validates that the title is not null or empty.
     *
     * @param title The title to validate
     */
    private final void validateTitle(final String title)
    {
        if(title == null || title.isBlank())
        {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
    }

    /*
     * Validates that the author name is not null or empty.
     *
     * @param author The author name to validate
     */
    private final void validateAuthor(final String author)
    {
        if(author == null || author.isBlank())
        {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
    }

    /*
     * Validates that the year published is within an acceptable range.
     *
     * @param yearPublished The year to validate
     */
    private final void validateYearPublished(final int yearPublished)
    {
        if(yearPublished > CURRENT_YEAR || yearPublished < MIN_YEAR)
        {
            throw new IllegalArgumentException("Year published more than "
                                               + CURRENT_YEAR + " or less than " + MIN_YEAR);
        }
    }

    /**
     * Gets the title of the magazine.
     *
     * @return the title of the magazine
     */
    @Override
    public String getTitle()
    {
        return title;
    }

    /**
     * Sets the title of the magazine.
     *
     * @param title the new title of the magazine
     */
    public void setTitle(final String title)
    {
        this.title = title;
    }

    /**
     * Gets the author of the magazine.
     *
     * @return the author of the magazine
     */
    @Override
    public String getAuthor()
    {
        return author;
    }

    /**
     * Sets the author of the magazine.
     *
     * @param author the new author of the magazine
     */
    public void setAuthor(final String author)
    {
        this.author = author;
    }

    /**
     * Gets the year the magazine was published.
     *
     * @return the year of publication
     */
    @Override
    public int getYearPublished()
    {
        return yearPublished;
    }

    /**
     * Sets the year the magazine was published.
     *
     * @param yearPublished the new publication year
     */
    public void setYearPublished(final int yearPublished)
    {
        this.yearPublished = yearPublished;
    }

    /**
     * Returns a formatted string representation of the magazine.
     *
     * @return A string in the format "Title" by Author (Year)
     */
    @Override
    public String toString()
    {
        return "\"" + title + "\" by " + author + " (" + yearPublished + ")";
    }
}
