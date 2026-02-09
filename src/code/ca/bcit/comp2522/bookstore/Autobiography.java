package ca.bcit.comp2522.bookstore;

/**
 * Represents an autobiography by an author.
 *
 * @author Jessie Yuen
 * @author Kian Castro
 * @version 1
 */
public class Autobiography extends Biography implements Printable
{
    /**
     * Constructs an autobiography.
     *
     * @param title the autobiography's title
     * @param yearPublished the publication year of the autobiography
     * @param author the author of the autobiography
     */
    public Autobiography(final String title,
                         final int yearPublished,
                         final Author author)
    {
        super(title,
              yearPublished,
              author,
              author);
    }

    /**
     * Displays information about an autobiography.
     */
    @Override
    public void display()
    {
        super.display();
    }

}
