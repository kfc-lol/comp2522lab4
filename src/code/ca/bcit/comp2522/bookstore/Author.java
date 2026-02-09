package ca.bcit.comp2522.bookstore;

/**
 * Represents an author that wrote a book.
 *
 * @author Kian Castro
 *
 * @version 1
 */
public class Author extends Person implements Printable
{

    private static final int MAX_GENRE_LEN = 30;

    private final String genre;

    /**
     * Author constructor.
     *
     * @param dateOfBirth birthdate
     * @param dateOfDeath deathdate
     * @param name name
     * @param genre genre author writes in
     */
    public Author(final Date dateOfBirth,
                  final Date dateOfDeath,
                  final Name name,
                  final String genre)
    {
        super(dateOfBirth,
              dateOfDeath,
              name);

        validateGenre(genre);

        this.genre = genre;
    }

    /**
     * Validates genre parameter.
     * @param genre not null or blank and must be less than MAX_GENRE_LEN
     */
    private void validateGenre(final String genre)
    {
        if (genre == null || genre.isBlank() || genre.length() > MAX_GENRE_LEN)
        {
            throw new IllegalArgumentException("Genre invalid");
        }
    }

    /**
     * Genre accessor method.
     * @return genre of author
     */
    public String getGenre()
    {
        return genre;
    }

    /**
     * Display method printing author values.
     */
    @Override
    public void display()
    {
        super.display();
        System.out.println("Genre: " + genre);
    }
}
