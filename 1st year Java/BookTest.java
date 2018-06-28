import java.util.ArrayList;
/**
 * Created by Evaldas on 2015-02-10.
 */
public class BookTest {
    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<Book>();
        library.add(new Fiction("The Saga of An Aga", "F001", 3, "A.Stove"));
        library.add(new Fiction("Dangerous Cliffs", "F002", 4, "Eileen Dover"));
        library.add(new NonFiction("Penguins Of The Sahara", "N001", 1, 1987));
        library.add(new ReferenceBook("Paper Clips: A Collector's Guide", "R001", 1, 1943));

        for (Book b : library) System.out.println(b);
        System.out.println();

        for (Book b : library) b.borrowBook();
        for (Book b : library) System.out.println(b);
        System.out.println();

        library.get(0).borrowBook();
        library.get(2).borrowBook();
        for (Book b : library) System.out.println(b);
        System.out.println();

        library.get(0).returnBook();
        library.get(2).returnBook();
        for (Book b : library) System.out.println(b);
        System.out.println();

    }
}
