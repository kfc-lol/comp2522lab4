package ca.bcit.comp2522.bookstore;

/**
 * Represents a biography by an author.
 *
 * @author Jessie Yuen
 * @author Kian Castro
 * @version 1
 */
public class Biography extends Book implements Printable
{
private final Person subject;

    /**
     * Constructs a biography.
     *
     * @param title the title of the biography
     * @param yearPublished the publication year of the biography
     * @param author the author of the biography
     * @param subject the subject of the biography
     */
    public Biography(final String title,
                 final int yearPublished,
                 final Author author,
                 final Person subject)
    {
        super(title,
              yearPublished,
              author);

        validateSubject(subject);

        this.subject = subject;
    }

    /**
     * Validates if subject is not null.
     *
     * @param subject subject of biography
     */
    private void validateSubject(final Person subject)
    {
        if(subject == null)
        {
            throw new IllegalArgumentException("Invalid subject.");
        }
    }

    /**
     * Compares two biographies against each other.
     *
     * @param o   the reference object with which to compare
     * @return whether the biographies are the same
     */
    @Override
    public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }

        if(!(o instanceof Biography))
        {
            return false;
        }

        Biography other;
        other = (Biography) o;
        return subject.equals(other.subject);
    }

    /**
     * Generates a hashcode for a biography's subject.
     *
     * @return the subject's hashcode
     */
    @Override
    public int hashCode()
    {
        return subject.hashCode();
    }

    /**
     * Displays information about a biography.
     */
    @Override
    public void display()
    {
        super.display();
        System.out.print(", Subject: ");
        subject.display();
    }


}
