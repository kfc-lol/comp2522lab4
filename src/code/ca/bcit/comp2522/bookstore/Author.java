package ca.bcit.comp2522.bookstore;

public class Author extends Person
{
    private final String genre;

    public Author(final Date dateOfBirth,
                  final Date dateOfDeath,
                  final Name name,
                  final String genre)
    {
        super(dateOfBirth,
              dateOfDeath,
              name);

        this.genre = genre;
    }

    public String getGenre()
    {
        return genre;
    }
}
