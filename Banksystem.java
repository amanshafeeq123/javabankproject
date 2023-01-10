package banksystem;
import java.util.Scanner;

public class Banksystem {


    public static void main(String[] args) {
        System.out.println("Welcome to bank X!"); // leaivng the name as bank X for now, we all can discuss on a name later
        System.out.println("Would you like to:\n1. Login\n2. Create a new account");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        
        if (option == 1){
            login();
            selection();
            int option2 = sc.nextInt();
            if (option2 == 1) {
                updateAccount();
            }
            else if (option2 == 2) {
                depositMoney();
            }
            else if (option2 == 3) {
                withdrawMoney();
            }
            else if (option2 == 4) {
                logOut();
            }
            else if (option2 == 5) {
                deleteAccount();
            }
            else {
                System.out.println("Invalid option.");
            }
        }
        else if (option == 2) {
            signUp();
        }
        else {
            System.out.println("Invalid option.");
        }
    }
    public static void login() {
        System.out.println("You chose to login!"); // for now, im just making a simple outline, the code will come later
        System.out.println("Enter your Account ID: ");
        Scanner sc = new Scanner(System.in);
        String ID = sc.nextLine();
        System.out.println("Ender your password: ");
        String pw = sc.nextLine();
        // i assume there will be an array somewhere here in play
        
    }
    public static void signUp() {
        System.out.println("You chose the option to sign up! Please input these details below...");  //again like i said above, there is supposed to be an array somewhere here, but it'll be added later since this is the outline for the program.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your fullname: ");
        String name = sc.nextLine();
        System.out.println("Enter your age: ");
        int age = sc.nextInt();
        System.out.println("Enter your desired account ID: ");
        String ID = sc.nextLine();
        System.out.println("Enter your password: ");
        String pw = sc.nextLine();
        System.out.println("Identity card number: ");
        String ic = sc.nextLine();
        System.out.println("Enter your email address:");
        String email = sc.nextLine();
        System.out.println("Enter your phone number: ");
        int pnum = sc.nextInt();
        System.out.println("Enter your home address: ");
        String hadd = sc.nextLine(); //we can loop it back to the sign in or login option
    }
        public static void selection() {
            System.out.println("Please choose an option:\n1. Update account\n2. Deposit money\n3. Withdraw money\n4. Log out\n5. Delete account");
        }
        public static void updateAccount() {
            signUp(); // have to change it a little but this is it for now
        }
        public static void depositMoney() {
            System.out.println("You chose to deposit money. How much money would you like to deposit?\n");
            Scanner sc = new Scanner(System.in);
            double dep = sc.nextDouble();
            System.out.println("You have deposited " + dep);
        }
        public static void withdrawMoney() {
            System.out.println("You chose to withdraw money."); //again need a array for the money 
            
        }
        public static void logOut() {
            System.out.println("You chose to log out. Thank you for using your bank!");
        }
        public static void deleteAccount() {
            System.out.println("You chose the option to delete your account. Are you sure? (Y/N)\n");
            Scanner sc = new Scanner(System.in);
            String yn = sc.nextLine();
            if (yn == "Y") {
                System.out.println("You have deleted your account.");
            }
            else if (yn == "N"){
                System.out.println("You have not deleted your account.");
                
            }
            else {
                System.out.println("Invalid option.");
            }
        }
    }
