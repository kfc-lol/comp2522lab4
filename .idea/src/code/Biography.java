package ca.bcit.comp2522.bookstore;

public class Biography extends Book implements Printable
{
private Person subject;

public Biography(String title,
                 int yearPublished,
                 Author author,
                 Person subject)
{
    super(title, yearPublished, author);
        if (subject == null) {
            throw new IllegalArgumentException("Invalid subject.");
        }
        this.subject = subject;
    }


}
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }

        if (!(o instanceof Biography)){
            return false;
        }

        Biography other = (Biography) o;
        return subject.equals(other.subject);
    }

    @Override
    public void display(){
    super.display();
    System.out.print(", Subject: ");
    subject.display();
    }

}
