/**
 * Created by Evaldas on 2015-04-18.
 */
public class Task1Test {
    static MyArrayList zoo = new MyArrayList();


    public static void printZoo() {
        System.out.print("The zoo now holds " + zoo.size() + " animals: ");
        for (int j = 0; j < zoo.size(); j++) System.out.print(zoo.get(j) + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        String[] originals = {"PPP","QQQ", "Allosaurus", "Brontosaurus", "Camposaurus", "Dilopdocus", "Europasasaurus", "FFF", "GGG"};
        String[] replacements = {"uUuU","vVvV", "Awk", "Budgie", "Crow", "Duck", "Eagle", "fFfF", "gGgG"};
        String[] insertions = {"yyy","xxx", "Antelope", "Bison", "Camel", "Dingo", "Eland", "fff", "ggg"};

        System.out.println("Initializing the zoo");
        for (int j = 2; j <= 6; j++) zoo.add(originals[j]);
        printZoo();
        System.out.println();

        // Test get(int index)
        System.out.println("Testing get(index");
        for (int j=6; j>-2; j--) {
            try {
                System.out.printf("get(%d) returns ", j);
                System.out.println(zoo.get(j));
            } catch (RuntimeException ex) {
                System.out.println(ex);
            }
        }
        System.out.println();

        // Test set(int index, Object obj)
        System.out.println("Testing set(index,object)");
        for (int j=6; j>-2; j--) {
            try {
                System.out.printf("set(%d,%s) changes item %d to ", j, replacements[j + 2], j );
                zoo.set(j, replacements[j + 2]);
                System.out.println(zoo.get(j));
            } catch (RuntimeException ex) {
                System.out.println(ex);
            }
        }
        printZoo();
        System.out.println();

        // Test add(int index, Object obj)
        System.out.println("Testing add(index,object)");
        for (int j=6; j>-2; j--) {
            try {
                System.out.printf("Adding %s at %d,", insertions[j+2], j );
                System.out.printf("before %s.  \t", replacements[j+2] );
                zoo.add(j, insertions[j+2]);
                printZoo();
            } catch (RuntimeException ex) {
                System.out.println(ex);
            }
        }
        printZoo();
        System.out.println();

        // Test remove(index,object)
        System.out.println("Testing remove(index,object)");
        for (int j=-1; j<7; j++) {
            try {
                System.out.printf("Removing item at %d. ", j );
                Object removed = zoo.remove(j);
                System.out.printf("%s removed.\t", removed );
                printZoo();
            } catch (RuntimeException ex) {
                System.out.println(ex);
            }
        }
        printZoo();

        System.out.println("\nTest complete");


    }

}
