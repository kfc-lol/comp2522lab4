package ca.bcit.comp2522.bookstore;

public class Autobiography extends Biography implements Printable
{
    public Autobiography(final String title,
                         final int yearPublished,
                         final Author author,
                         final Person person)
    {
        super(title, yearPublished, author, person);


    }

    @Override
    public void display()
    {
        super.display();
    }

}
