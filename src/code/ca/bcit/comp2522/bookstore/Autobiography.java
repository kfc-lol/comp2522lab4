package ca.bcit.comp2522.bookstore;

public class Autobiography extends Biography implements Printable
{
    public Autobiography(String title,
                         int yearPublished,
                         Author author,
                         Person person)
    {
        super(title, yearPublished, author, person);


    }

    @Override
    public void display()
    {
        super.display();
    }

}
