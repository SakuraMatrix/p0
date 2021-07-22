import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class AccountManager {
    static Account myAcc = new Account();
    static Account.Check_Save_Account mySavings = Account.Check_Save_Account.AccountContainer;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = new String("");
        String password = new String("");
        System.out.println("Enter Username");
        username = scan.nextLine();
        System.out.println("Enter Password");
        password = scan.nextLine();


        //Account.Check_Save_Account myChecking = Account.Check_Save_Account.AccountContainer;
        myAcc.SetUserName(username);
        myAcc.SetPassword(password);
        myAcc.CreateAccount(mySavings, 500, 0);
        //myAcc.CreateAccount(myChecking, 250, 1);
        //System.out.println("Checking Balance: "+ myChecking.amount);


        boolean loop = true;
        while(loop) {
            System.out.println("\n\nMyBank");
            System.out.println("\nMENU");
            System.out.println("1: Make a Deposit");
            System.out.println("2: Make a Withdrawl");
            System.out.println("3: Check Balance");
            System.out.println("4: EXIT");
            int choice = 0;
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    Menu1();
                    break;
                case 2:
                    Menu2();
                    break;
                case 3:
                    Menu3();
                    break;
                case 4:
                    Menu4();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static void Menu1(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Deposit Amount: ");
        double amount = scan.nextDouble();

        myAcc.AdjustAccount(mySavings, Math.abs(amount) , 0);
    }
    public static void Menu2(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Withdrawl Amount: ");
        double amount = scan.nextDouble();
        myAcc.AdjustAccount(mySavings, -Math.abs(amount), 0);
    }
    public static void Menu3(){
        System.out.println("\n\nAccount Balance: "+ mySavings.amount);
    }
    public static void Menu4(){
        System.out.println("Thank you for using MyBank!");
    }
}

