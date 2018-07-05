import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * Created by Evaldas Senavaitis 1402039 on 08/12/2015.
 *
 */
public class Bank {

    int balance;

    public int bankAccount(int customerNumber, int startingBalance) {
        Scanner stdin = new Scanner(System.in);
        System.out.println("Welcome to the Bank");


        //Get customer

        Customer myCustomer = new Customer();
        int customerNo = Customer.getWithCustomerNumber(customerNumber);

        //Get customer name
        String name = myCustomer.name;

        //Get starting balance
        balance = startingBalance;

        //Get date and time
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        //Get user choice
        //1. Make a deposit
        //2. Make a withdrawal
        //3. Print balance
        //4. Quit

        int choice = 0;

        //Continue processing choices until the user quits
        while (choice != 4) {
            //Reprint the menu
            System.out.println("Your customer Id: "+customerNo);
            System.out.println("Here are your menu options: ");
            System.out.println("1. Make a deposit: ");
            System.out.println("2. Make a withdrawal: ");
            System.out.println("3. Print your balance: ");
            System.out.println("4. Quit");
            System.out.println("Please enter the number of your choice: ");
            choice = stdin.nextInt();
            switch (choice) {
                case 1: {
                    // Handle a deposit
                    System.out.println("Enter the amount of your deposit: ");
                    int deposit = stdin.nextInt();
                    balance = balance + deposit;
                    System.out.println(dateFormat.format(date)+" " + "Cutomer" +" " + name +" "+ "new balance is $"+" "+ balance + ".");
                    break;
                }
                case 2: {
                    //Handle a withdrawal
                    System.out.println("Enter the amount of your withdrawal:");
                    int withdrawal = stdin.nextInt();
                    if (balance - withdrawal >= 0) {
                        balance = balance - withdrawal;
                        System.out.println(dateFormat.format(date)+" " + "Customer"+" "+ name +" "+ "new balance is $"+" "+ balance + ".");
                    } else {
                        System.out.println(dateFormat.format(date) + " Customer " + name + " Insufficient funds for withdrawal. Balance is $ " + balance + ".");
                    }
                    break;
                }
                case 3: {
                    //Print out the current balance
                    System.out.println(dateFormat.format(date)+" Customer " + name + " balance is $ " + balance + ".");
                    break;
                }
                case 4: {
                    //Do nothing, we quit
                    break;
                }
                default: {
                    System.out.println("Sorry that is not valid choice");
                }
            }
        }
        System.out.println("Thank you for using the bank!");
        return balance;
    }
}
