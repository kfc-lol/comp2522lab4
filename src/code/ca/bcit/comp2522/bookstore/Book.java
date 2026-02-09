package ca.bcit.comp2522.bookstore;

/**
 * Represents a book.
 *
 * @author Jessie Yuen
 * @author Kian Castro
 * @version 1
 */
public class Book implements Comparable<Book>, Printable, Reversible
{
    private final String title;
    private final int yearPublished;
    private final Author author;

    /**
     * Constructs a book.
     *
     * @param title the title of the book
     * @param yearPublished the publication year of the book
     * @param author the author of the book
     */
    public Book(String title, int yearPublished, Author author)
    {
        if(title == null ||
                title.isBlank() ||
                title.length() >= 100)
        {
            throw new IllegalArgumentException("Invalid title.");
        }

        if(yearPublished < 1 || yearPublished > Date.getCurrentYear())
        {
            throw new IllegalArgumentException("Invalid publication year.");
        }

        if(author == null)
        {
            throw new IllegalArgumentException("Author cannot be null.");
        }

        this.title = title;
        this.yearPublished = yearPublished;
        this.author = author;
    }

    /**
     * Gets the book title
     *
     * @return the title of the book
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Gets the book's publication year.
     *
     * @return the publication year of the book
     */
    public int getYearPublished()
    {
        return yearPublished;
    }

    /**
     * Gets the book's author.
     *
     * @return the author of the book
     */
    public Author getAuthor()
    {
        return author;
    }

    /**
     * Compares two books by publication year.
     *
     * @param other the object to be compared.
     *
     * @return a positive integer if the first book is older, a negative integer if it is younger, and zero if they
     * were published the same year
     */
    @Override
    public int compareTo(Book other)
    {
        return Integer.compare(other.yearPublished, this.yearPublished);
    }

    /**
     * Displays information about the book.
     */
    @Override
    public void display()
    {
        System.out.print("Title: " +
                title +
                ", Year Published: " +
                yearPublished +
                ", Author: ");
        author.display();
    }

    /**
     * Prints the book title backwards.
     */
    @Override
    public void backward() {
        String reversed = new StringBuilder(title).reverse().toString();
        System.out.println(reversed);
    }

}
