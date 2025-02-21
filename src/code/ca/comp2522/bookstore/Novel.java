package ca.comp2522.bookstore;


/**
 * Represents a novel with a title, an author, and a year of publication.
 * Implements Comparable to allow sorting by title.
 *
 * @author Bullen Kosa, Dominic Cheang
 * @version 1.0
 */
public class Novel extends Literature implements Comparable<Novel>
{

    private static final int MIN_YEAR     = 0;
    private static final int CURRENT_YEAR = 2025;

    private final String title;
    private final String author;
    private final int    yearPublished;

    /**
     * Constructs a new Novel object with the specified title, author, and year published.
     *
     * @param title         The title of the novel
     * @param author        The author of the novel
     * @param yearPublished The year the novel was published
     */
    public Novel(final String title,
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
     * Gets the title of the novel.
     *
     * @return The novel's title
     */
    @Override
    public String getTitle()
    {
        return title;
    }

    /**
     * Gets the author's name of the novel.
     *
     * @return The author's name
     */
    @Override
    public String getAuthor()
    {
        return author;
    }

    /**
     * Gets the year the novel was published.
     *
     * @return The publication year
     */
    @Override
    public int getYearPublished()
    {
        return yearPublished;
    }

    /**
     * Returns a formatted string representation of the novel.
     *
     * @return A string in the format "Title" by Author (Year)
     */
    @Override
    public String toString()
    {
        return "\"" + title + "\" by " + author + " (" + yearPublished + ")";
    }

    /**
     * Compares this novel with another novel based on the title.
     *
     * @param otherNovel The novel to compare with
     * @return A negative, zero, or positive integer as this title is less than, equal to, or greater than the other
     */
    @Override
    public int compareTo(final Novel otherNovel)
    {
        return this.title.compareTo(otherNovel.title);
    }
}
