import java.util.Iterator;

/**
 * Created by Evaldas on 2015-04-20.
 */
public class Task4Test {
    static MyArrayList zoo = new MyArrayList();


    public static void printZoo() {
        System.out.print("The zoo now holds " + zoo.size() + " animals: ");
        for (int j = 0; j < zoo.size(); j++) System.out.print(zoo.get(j) + " ");
        System.out.println();
    }
    public static void main(String[] args) {

        String[] zooList = {"Cheetah", "Jaguar", "Leopard", "Lion", "Panther", "Tiger"};

        for (String x: zooList) zoo.add(x);
        printZoo();

        System.out.printf("\nTesting the iterator\n>> ");
        Iterator it = zoo.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        System.out.printf("\nTesting the iterator again without resetting\n>> ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        System.out.printf("\nTesting the iterator again after resetting\n>> ");
        it = zoo.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        System.out.printf("\nTesting for-each loop\n>> ");
        for(Object animal: zoo) System.out.print(animal + " ");
        System.out.println();

        System.out.println("\nLetting all the animals escape");
        while (zoo.size()>0) zoo.remove(0);
        printZoo();

        System.out.printf("\nTesting the iterator with an empty list\n>> ");
        it = zoo.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        System.out.println("\nTest complete");


    }
}
