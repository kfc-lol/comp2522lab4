package ca.bcit.comp2522.bookstore;

public class Autobiography extends Biography implements Printable
{
    public Autobiography(String title,
                         int yearPublished,
                         Author author)
    {
        super(title, yearPublished, author, author);


    }

    @Override
public void display(){
    super.display();
    }

}
