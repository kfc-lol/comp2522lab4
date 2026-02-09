package ca.bcit.comp2522.bookstore;

public class Book implements Comparable<Book>, Printable, Reversible
{
    private final String title;
    private final int yearPublished;
    private final Author author;

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

    public String getTitle()
    {
        return title;
    }

    public int getYearPublished()
    {
        return yearPublished;
    }

    public Author getAuthor()
    {
        return author;
    }

    @Override
    public int compareTo(Book other)
    {
        return Integer.compare(other.yearPublished, this.yearPublished);
    }

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


    @Override
    public void backward() {
        String reversed = new StringBuilder(title).reverse().toString();
        System.out.println(reversed);
    }

}
