/**
 * Created by Evaldas on 2015-01-31.
 */
public class Circle {

    private double radius;
    private static int count;

    public Circle(int r){
        radius = r ;
        count++;
    }

    public double circumference(){
        return 2* Math.PI * radius;
    }

    public double area(){
        return Math.PI*(radius*radius);
    }

    public void report(){
        System.out.printf(" Radius:%6.2f", radius);
        System.out.printf(" Circumference:%7.3f", circumference());
        System.out.printf(" Area:%9.4f", area());
        System.out.println();
    }

    public static void main(String[] args){
        System.out.println(count + " circles have been created.");
        for (int r=1; r<=10; r++){new Circle(r).report();}
        System.out.println(count + " circle have been created.");

    }
}
