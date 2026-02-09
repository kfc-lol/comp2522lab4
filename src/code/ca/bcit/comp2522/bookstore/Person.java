package ca.bcit.comp2522.bookstore;

public class Person implements Comparable<Person>, Printable, Reversible
{
    private final Date dateOfBirth;
    private final Date dateOfDeath;
    private final Name name;

    /**
     * Person constructor.
     *
     * @param dateOfBirth date born
     * @param dateOfDeath date died
     * @param name name
     */
    public Person(final Date dateOfBirth,
                  final Date dateOfDeath,
                  final Name name)
    {

        validate(dateOfBirth,
                 dateOfDeath,
                 name);

        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.name = name;
    }

    /**
     * Validates parameters in constructor.
     *
     * @param dateOfBirth cannot be null
     * @param dateOfDeath can be null
     * @param name cannot be null
     */
    private void validate(final Date dateOfBirth,
                          final Date dateOfDeath,
                          final Name name)
    {
        if (dateOfBirth == null || dateOfBirth.getClass() != Date.class)
        {
            throw new IllegalArgumentException("Birth date is invalid.");
        }

        if (dateOfDeath != null && dateOfDeath.getClass() != Date.class)
        {
            throw new IllegalArgumentException("Death date is invalid.");
        }
        if (name == null || name.getClass() != Name.class)
        {
            throw new IllegalArgumentException("Name cannot be null.");
        }
    }

    /**
     * Name accessor method.
     *
     * @return name of person
     */
    public Name getName()
    {
        return name;
    }

    /**
     * Date of birth accessor method.
     *
     * @return date of birth of person
     */
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * Date of death accessor method.
     * @return date of death of person, if dead
     */
    public Date getDateOfDeath()
    {
        return dateOfDeath;
    }

    /**
     * Display method printing person's values.
     */
    @Override
    public void display()
    {
        System.out.print("Name: ");
        name.display();

        System.out.print(", DOB: ");
        dateOfBirth.display();

        if(dateOfDeath != null)
        {
            System.out.print(", Death Date: ");
            dateOfDeath.display();
        }
    }

    /**
     * Prints name backwards.
     */
    @Override
    public void backward()
    {
        final String reversed =
                new StringBuilder(
                        name.getFirst() + " " + name.getLast()
                ).reverse().toString();

        System.out.println(reversed);
    }

    /**
     * Compares age of Persons.
     *
     * @param o the object to be compared.
     * @return difference in age/size
     */
    @Override
    public int compareTo(Person o)
    {
        if(this == o || o == null){
            throw new IllegalArgumentException("Not a " + getClass());
        }

        Person other;
        other = o;

        return (dateOfBirth.getYear() - other.dateOfBirth.getYear());
    }
}
