import java.util.Scanner;

/**
 * Created by Evaldas on 2015-01-30.
 */
public class Tables {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an integer: ");
        int x = input.nextInt();

        for(int i=1;i<=10;i++){
            int y = i*x;

            System.out.println(i+"*"+x+"="+y);
        }
    }
}
