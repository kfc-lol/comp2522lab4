package ca.bcit.comp2522.bookstore;

public class Person implements Comparable, Printable, Reversible
{
    private final Date dateOfBirth;
    private final Date dateOfDeath;
    private final Name name;


    public Person(final Date dateOfBirth,
                  final Date dateOfDeath,
                  final Name name)
    {

        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.name = name;
    }

    public Name getName()
    {
        return name;
    }

    @Override
    public void display()
    {
        System.out.println("DOB: " + dateOfBirth);
        System.out.println("Death Date: " + dateOfDeath);
        System.out.println("Name: " + name);
    }

    @Override
    public void backward()
    {
        final String reversed = new StringBuilder(name.toString()).reverse().toString();
        System.out.println(reversed);
    }

    @Override
    public int compareTo(Object o)
    {
        if (this == o || !(o instanceof Person)){
            throw new IllegalArgumentException("Not a " + getClass());
        }

        Person other;
        other = (Person) o;

        return (dateOfBirth.getYear() - other.dateOfBirth.getYear());
    }
}
