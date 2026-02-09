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

    public String getFirst()
    {
        return first;
    }

    public String getLast()
    {
        return last;
    }

    public String getName() {
        return first + " " + last;
    }

    @Override
    public void display()
    {
        System.out.println(first + " " + last);
    }
}
