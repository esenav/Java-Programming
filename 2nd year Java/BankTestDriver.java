/**
 *
 * Created by Evaldas Senavaitis 1402039 on 08/12/2015.
 *
 */
public class BankTestDriver {

    public static void main(String[] args) {
        int i;
        for(i = 0; i<1;i++ ){
            test1();
            test2();
            test3();
            test4();
            test5();
            test6();
            test7();
            test8();
            test9();
            test10();
            test11();
            test12();
            test13();
            test14();
            test15();
            test16();
            test17();
            test18();
            test19();
            test20();
            test21();
            test22();
            test23();
            test24();
            test25();
            test26();
            test27();
            test28();
            test29();
            test30();
        }

        double pofod = BankTestOracle.failed/30;
       // System.out.println(BankTestOracle.failed); shows how many failed in total
        System.out.println("POFOD is: "+pofod);
    }

    public static boolean test1(){
        int customerNumber = 1;
        int startingBalance = 100;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test1(Customer.balance);
    }
    public static boolean test2(){
        int customerNumber = 1;
        int startingBalance = 50;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test2(Customer.balance);
    }
    public static boolean test3(){
        int customerNumber = 1;
        int startingBalance = 300;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test3(Customer.balance);
    }

    public static boolean test4(){
        int customerNumber = 1;
        int startingBalance = 200;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test4(Customer.balance);
    }
    public static boolean test5(){
        int customerNumber = 1;
        int startingBalance = 300;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test5(Customer.balance);
    }
    public static boolean test6(){
        int customerNumber = 1;
        int startingBalance = 20;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test6(Customer.balance);
    }
    public static boolean test7(){
        int customerNumber = 1;
        int startingBalance = 150;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test7(Customer.balance);
    }
    public static boolean test8(){
        int customerNumber = 1;
        int startingBalance = 300;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test8(Customer.balance);
    }
    public static boolean test9(){
        int customerNumber = 1;
        int startingBalance = 300;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test9(Customer.balance);
    }
    public static boolean test10(){
        int customerNumber = 1;
        int startingBalance = 600;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test10(Customer.balance);
    }
    public static boolean test11(){
        int customerNumber = 1;
        int startingBalance = 100;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test11(Customer.balance);
    }
    public static boolean test12(){
        int customerNumber = 1;
        int startingBalance = 400;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test12(Customer.balance);
    }
    public static boolean test13(){
        int customerNumber = 1;
        int startingBalance =230 ;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test13(Customer.balance);
    }
    public static boolean test14(){
        int customerNumber = 1;
        int startingBalance = 260;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test14(Customer.balance);
    }
    public static boolean test15(){
        int customerNumber = 1;
        int startingBalance = 400;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test15(Customer.balance);
    }
    public static boolean test16(){
        int customerNumber = 1;
        int startingBalance = 100;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test16(Customer.balance);
    }
    public static boolean test17(){
        int customerNumber = 1;
        int startingBalance = 200;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test17(Customer.balance);
    }
    public static boolean test18(){
        int customerNumber = 1;
        int startingBalance = 600;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test18(Customer.balance);
    }
    public static boolean test19(){
        int customerNumber = 1;
        int startingBalance = 400;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test19(Customer.balance);
    }
    public static boolean test20(){
        int customerNumber = 1;
        int startingBalance = 1000;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test20(Customer.balance);
    }
    public static boolean test21(){
        int customerNumber = 1;
        int startingBalance = 500;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test21(Customer.balance);
    }
    public static boolean test22(){
        int customerNumber = 1;
        int startingBalance = 700;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test22(Customer.balance);
    }
    public static boolean test23(){
        int customerNumber = 1;
        int startingBalance = 600;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test23(Customer.balance);
    }
    public static boolean test24(){
        int customerNumber = 1;
        int startingBalance = 400;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test24(Customer.balance);
    }
    public static boolean test25(){
        int customerNumber = 1;
        int startingBalance = 500;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test25(Customer.balance);
    }
    public static boolean test26(){
        int customerNumber = 1;
        int startingBalance = 800;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test26(Customer.balance);
    }
    public static boolean test27(){
        int customerNumber = 1;
        int startingBalance = 900;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test27(Customer.balance);
    }
    public static boolean test28(){
        int customerNumber = 1;
        int startingBalance = 250;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test28(Customer.balance);
    }
    public static boolean test29(){
        int customerNumber = 1;
        int startingBalance = 400;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test29(Customer.balance);
    }
    public static boolean test30(){
        int customerNumber = 1;
        int startingBalance = 10;
        Bank Customer = new Bank();
        Customer.bankAccount(customerNumber, startingBalance);

        return BankTestOracle.test30(Customer.balance);
    }

}
