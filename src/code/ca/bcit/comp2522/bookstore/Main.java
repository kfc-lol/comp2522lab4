package ca.bcit.comp2522.bookstore;

public class Main
{
    public static void main(String[] args)
    {

        Author orwell = new Author(
                new Date(1903, 6, 25),
                new Date(1950, 1, 21),
                new Name("George", "Orwell"),
                "Dystopian"
        );

        Author lee = new Author(
                new Date(1926, 4, 28),
                new Date(2016, 2, 19),
                new Name("Harper", "Lee"),
                "Fiction"
        );

        Author austen = new Author(
                new Date(1800, 1, 1),
                new Date(1817, 7, 18),
                new Name("Jane", "Austen"),
                "Romance"
        );

        Author fitzgerald = new Author(
                new Date(1896, 9, 24),
                new Date(1940, 12, 21),
                new Name("F. Scott", "Fitzgerald"),
                "Fiction"
        );

        Author melville = new Author(
                new Date(1819, 8, 1),
                new Date(1891, 9, 28),
                new Name("Herman", "Melville"),
                "Adventure"
        );

        Book book1 = new Book("1984", 1949, orwell);
        Book book2 = new Book("To Kill a Mockingbird", 1960, lee);
        Book book3 = new Book("Pride and Prejudice", 1813, austen);
        Book book4 = new Book("The Great Gatsby", 1925, fitzgerald);
        Book book5 = new Book("Moby-Dick", 1851, melville);

        System.out.println("Five of the Greatest Books:");
        book1.display();
        book2.display();
        book3.display();
        book4.display();
        book5.display();

        Person moses = new Person(
                new Date(1888, 12, 18),
                new Date(1981, 7, 29),
                new Name("Robert", "Moses")
        );

        Person jobs = new Person(
                new Date(1955, 2, 24),
                new Date(2011, 10, 5),
                new Name("Steve", "Jobs")
        );

        Person churchill = new Person(
                new Date(1874, 11, 30),
                new Date(1965, 1, 24),
                new Name("Winston", "Churchill")
        );

        Person hamilton = new Person(
                new Date(1800, 1, 11),
                new Date(1804, 7, 12),
                new Name("Alexander", "Hamilton")
        );

        Person einstein = new Person(
                new Date(1879, 3, 14),
                new Date(1955, 4, 18),
                new Name("Albert", "Einstein")
        );

        Biography bio1 = new Biography(
                "The Power Broker",
                1974,
                new Author(
                        new Date(1935, 7, 30),
                        null,
                        new Name("Robert", "Caro"),
                        "Biography"
                ),
                moses
        );

        Biography bio2 = new Biography(
                "Steve Jobs",
                2011,
                new Author(
                        new Date(1952, 5, 20),
                        null,
                        new Name("Walter", "Isaacson"),
                        "Biography"
                ),
                jobs
        );

        Biography bio3 = new Biography(
                "Churchill: A Life",
                1991,
                new Author(
                        new Date(1936, 10, 25),
                        null,
                        new Name("Martin", "Gilbert"),
                        "Biography"
                ),
                churchill
        );

        Biography bio4 = new Biography(
                "Alexander Hamilton",
                2004,
                new Author(
                        new Date(1949, 3, 3),
                        null,
                        new Name("Ron", "Chernow"),
                        "Biography"
                ),
                hamilton
        );

        Biography bio5 = new Biography(
                "Einstein: His Life and Universe",
                2007,
                new Author(
                        new Date(1952, 5, 20),
                        null,
                        new Name("Walter", "Isaacson"),
                        "Biography"
                ),
                einstein
        );

        System.out.println("\nFive of the Greatest Biographies:");
        bio1.display();
        bio2.display();
        bio3.display();
        bio4.display();
        bio5.display();

        Autobiography a1 = new Autobiography(
                "The Diary of a Young Girl",
                1947,
                new Author(
                        new Date(1929, 6, 12),
                        new Date(1945, 3, 31),
                        new Name("Anne", "Frank"),
                        "Autobiography"
                ),
                new Person(
                        new Date(1929, 6, 12),
                        new Date(1945, 3, 31),
                        new Name("Anne", "Frank")
                )
        );

        Autobiography a2 = new Autobiography(
                "Long Walk to Freedom",
                1994,
                new Author(
                        new Date(1918, 7, 18),
                        new Date(2013, 12, 5),
                        new Name("Nelson", "Mandela"),
                        "Autobiography"
                ),
                new Person(
                        new Date(1918, 7, 18),
                        new Date(2013, 12, 5),
                        new Name("Nelson", "Mandela")
                )
        );

        System.out.println("\nFive of the Greatest Autobiographies:");
        a1.display();
        a2.display();

        System.out.println("\nComparisons:");
        System.out.println("Book year comparison (1984 vs Gatsby): " + book1.compareTo(book4));
        System.out.println("Author birth comparison (Orwell vs Austen): " + orwell.compareTo(austen));
        System.out.println("Biography subject comparison (Jobs vs Einstein): " + bio2.equals(bio5));

        System.out.println("\nReversed Titles:");
        book1.backward();
        book2.backward();
        book3.backward();
        book4.backward();
        book5.backward();

        System.out.println("\nReversed Author Names:");
        orwell.backward();
        lee.backward();
        austen.backward();
        fitzgerald.backward();
        melville.backward();
    }
}
