package ca.bcit.comp2522.bookstore;

/**
 * Name class represents name.
 *
 * @author Kian Castro
 * @version 1
 */
public class Name implements Printable
{
    private static final int MAX_NAME_LEN = 50;

    private final String first;
    private final String last;

    public Name(final String first,
                final String last)
    {
        validate(first, last);

        this.first = first;
        this.last = last;
    }

    /**
     * Validates constructor parameters.
     *
     * @param first first name not null or blank and length is less than MAX_NAME_LEN
     * @param last last name not null or blank and length is less than MAX_NAME_LEN
     */
    private void validate(final String first,
                          final String last)
    {
        if(first == null || first.isBlank() || first.length() > MAX_NAME_LEN)
        {
            throw new IllegalArgumentException("name is invalid.");
        }

        if(last == null || last.isBlank() || last.length() > MAX_NAME_LEN)
        {
            throw new IllegalArgumentException("Name is invalid.");
        }
    }

    /**
     * First name accessor method.
     *
     * @return first name
     */
    public String getFirst()
    {
        return first;
    }

    /**
     * Last name accessor method.
     *
     * @return last name
     */
    public String getLast()
    {
        return last;
    }

    /**
     * Name concatenator method.
     *
     * @return first name plus last name
     */
    public String getName() {
        return first + " " + last;
    }

    /**
     * Displays name.
     */
    @Override
    public void display()
    {
        System.out.println(first + " " + last);
    }
}
