// Aman, amanshafeeq123@gmail.com

package banksystem;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;

public class Banksystem {
static String ID;
static String pw;
static String name;
static int age;
static String ic;
static String email;
static String pnum;
static String hadd;
static int amt;
static double dep;
static boolean loggedin = false;

    // create local vars to store data in program

    public static void main(String[] args) {
        System.out.println("Welcome to bank X!"); // leaivng the name as bank X for now, we all can discuss on a name later
        
        File myFile = new File("data.txt");

        try{
        if(myFile.exists())
        {
            myFile.createNewFile();
        }
        else
        {
            System.out.println("There has been an error.");
            System.exit(0);
        }
        }

        catch(Exception e){

        }

        while(true){
        System.out.println("Would you like to:\n1. Login\n2. Create a new account\n3. Exit");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch(option){
            case 1:
                login();
                while(loggedin){
                    System.out.printf("Hello there %s\n ", name);
                    selection();
                    int option2 = sc.nextInt();
                    switch(option2){
                        case 1:
                            updateAccount();
                            break;
                        case 2:
                            depositMoney();
                            break;
                        case 3:
                            withdrawMoney();
                            break;
                        case 4:
                            logOut();
                            break;
                        case 5:
                            deleteAccount();
                            break;
                            default:
                            System.out.println("Invalid option.");
                            break;
                    }
                }
                if (!loggedin){
                   break;
                    
                }
            case 2:
                signUp();
                System.out.printf("Thank you for joining us %s!", name );
                break;
            case 3:
                System.out.println("Thank you for using our bank, Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }

    }
    }

    public static void login() { //aman
        System.out.println("You chose to login!"); // for now, im just making a simple outline, the code will come later
        System.out.println("Enter your Account ID: ");
        Scanner sc = new Scanner(System.in);
        ID = sc.nextLine();
        System.out.println("Enter your password: ");
        pw = sc.nextLine();
        // i assume there will be an array somewhere here in play
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = br.readLine()) != null && !loggedin) {
                String[] values = line.split(",");
                if (values[0].equals(ID) && values[1].equals(pw)) {
                    ID = values[0];         
                    pw = values[1];
                    name = values[2];
                    age = Integer.parseInt(values[3]);
                    ic = values[4];
                    email = values[5];
                    pnum = values[6];
                    hadd = values[7];
                    amt = Integer.parseInt(values[8]);
                    loggedin = true;
                } else {
                     System.out.println("Wrong username or password!");
                     loggedin = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // if information exists, save data to global vars to update
        // if it doesnt, reject login
        
    }
    public static void signUp() {
        System.out.println("You chose the option to sign up! Please input these details below...");  //again like i said above, there is supposed to be an array somewhere here, but it'll be added later since this is the outline for the program.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your fullname: ");
        name = sc.nextLine();
        System.out.println("Enter your age: ");
        age = sc.nextInt();
        sc.nextLine(); // to avoid skipping the new scan
        System.out.println("Enter your desired account ID: ");
        ID = sc.nextLine();
        System.out.println("Enter your password: ");
        pw = sc.nextLine();
        System.out.println("Identity card number: ");
        ic = sc.nextLine();
        System.out.println("Enter your email address:");
        email = sc.nextLine();
        System.out.println("Enter your phone number: ");
        pnum = sc.nextLine();
        System.out.println("Enter your home address: ");
        hadd = sc.nextLine();
        System.out.println("Amount you would like to deposit: ");
        amt = sc.nextInt();
        //sc.nextLine(); // to avoid skipping the new scan

        
    try {
        FileWriter output = new FileWriter("data.txt", true);
        String x = ID + "," + pw + "," + name + "," + Integer.toString(age) + "," + ic + "," + email + "," + pnum + "," + hadd + "," + Integer.toString(amt) + "\n";
        output.write(x);
        output.close();

    } 
    catch (IOException ex) {
        
    }
    //also add at the end the amount being 0
        // create new information into csv file and arange the data properly
        // makes sure you can read this information line by line and easily convert them into local global vars
    }
        public static void selection() {
            System.out.println("Please choose an option:\n1. Update account\n2. Deposit money\n3. Withdraw money\n4. Log out\n5. Delete account");
            
        }
        public static void updateAccount() {
            boolean hasUpdated = true;
            String updatedName = name;
            int updatedAge = age;
            String updatedPassword = pw;
            String updatedIc = ic;
            String updatedEmail = email;
            String updatedPn = pnum;
            String updatedHadd = hadd;
            
            System.out.println("What would you like to update: ");
            System.out.println("1. Name");
            System.out.println("2. Age");
            System.out.println("3. Password");
            System.out.println("4. IC");
            System.out.println("5. Email");
            System.out.println("6. Phone number");
            System.out.println("7. Home address");
            Scanner sc = new Scanner(System.in);
            int option1 = sc.nextInt();
            sc.nextLine();
            switch(option1){
                case 1:
                    System.out.println("Please enter your updated name: ");
                    updatedName = sc.nextLine();
                    break;
                case 2:
                    System.out.println("Please enter your updated age: ");
                    updatedAge = sc.nextInt();
                    break;
                case 3:
                    System.out.println("Please enter your updated password: ");
                    updatedPassword = sc.nextLine();
                    break;
                case 4:
                    System.out.println("Please enter your updated IC: ");
                    updatedIc = sc.nextLine();
                    break;
                case 5:
                    System.out.println("Please enter your updated email: ");
                    updatedEmail = sc.nextLine();
                    break;
                case 6:
                    System.out.println("Please enter your updated phone number: ");
                    updatedPn = sc.nextLine();
                    break;
                case 7:
                    System.out.println("Please enter your updated home address: ");
                    updatedHadd = sc.nextLine();
                    break;
                default:
                    System.out.println("Invalid option.");
                    hasUpdated = false;
            }
            if(hasUpdated){
            String oldData = ID + "," + pw + "," + name + "," + age + "," + ic + "," + email + "," + pnum + "," + hadd + "," + amt;
            String newData = ID + "," + updatedPassword + "," + updatedName + "," + updatedAge + "," + updatedIc + "," + updatedEmail + "," + updatedPn + "," + updatedHadd + "," + amt;
            replaceLines(oldData, newData);
            pw = updatedPassword;
            name = updatedName;
            age = updatedAge;
            ic = updatedIc;
            pnum = updatedPn;
            hadd = updatedHadd;
            email = updatedEmail;
            }
            
            
        }
        public static void depositMoney() {
            System.out.println("Your current balance is : " + amt);
            System.out.println("You chose to deposit money. How much money would you like to deposit?\n");
            double nb;
            Scanner sc = new Scanner(System.in);
            dep = sc.nextDouble();
            nb = amt + dep;
            System.out.println("You have deposited " + dep + ". Your new balance is: " + nb);
            
            String oldData = ID + "," + pw + "," + name + "," + age + "," + ic + "," + email + "," + pnum + "," + hadd + "," + amt;
            String newData = ID + "," + pw + "," + name + "," + age + "," + ic + "," + email + "," + pnum + "," + hadd + "," + Integer.toString((int)(amt+dep));

            replaceLines(oldData, newData);
            // this only updates the amount tab
            // make sure user types positive integer and no non numbers
        }
public static void withdrawMoney() {
        //ask user for withdraw amount
        System.out.println("Your current balance is:  " + amt);
        System.out.println("Enter the amount you would like to withdraw:");
        Scanner sc = new Scanner(System.in);
        double withdrawAmount = sc.nextDouble();
        double oldAmount;
        double nb;
        //make sure user has enough money
        if (withdrawAmount > amt) {
            System.out.println("Transaction failed. You do not have enough funds.");
        } else {
            //deduct withdraw amount from current amount
            oldAmount = amt;
            nb = amt - withdrawAmount;
            System.out.println("Transaction successful. Your new balance is: " + nb);
            String oldData = ID + "," + pw + "," + name + "," + age + "," + ic + "," + email + "," + pnum + "," + hadd + "," + amt;
            String newData = ID + "," + pw + "," + name + "," + age + "," + ic + "," + email + "," + pnum + "," + hadd + "," + Integer.toString((int)(amt-withdrawAmount));
            
            
            replaceLines(oldData, newData);
    
        }
}

        public static void logOut() {
            System.out.println("You chose to log out. Thank you for using your bank!");
            ID = "";         
            pw = "";
            name = "";
            age = 0;
            ic = "";
            email = "";
            pnum = "";
            hadd = "";;
            amt = 0;
            dep = 0;
            loggedin = false;
            // if logout, throw back to inital loop and clear internal global vars
            // also would be good to close the file if it is open, but you need to decide if you want to open and close every time you update
        }
public static void deleteAccount() {
    try {
        File oldFile = new File("data.txt");
        File newFile = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(oldFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));

        String lineToRemove = ID + "," + pw + "," + name + "," + age + "," + ic + "," + email + "," + pnum + "," + hadd + "," + amt;
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(lineToRemove)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close(); 
        reader.close(); 
        oldFile.delete();
        newFile.renameTo(oldFile);
        System.out.println("Account has been deleted!");
        logOut();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static void replaceLines(String oldData, String newData) {
    try {
        // input the (modified) file content to the StringBuffer "input"
        BufferedReader file = new BufferedReader(new FileReader("data.txt"));
        StringBuffer inputBuffer = new StringBuffer();
        String line;

        while ((line = file.readLine()) != null) {
            if(line.equals(oldData)) 
            {   
                //System.out.println(line);
                inputBuffer.append(newData);
            }
            else {
                //System.out.println(newData);
                inputBuffer.append(line);
            }
            inputBuffer.append('\n');
        }
        file.close();

        // write the new string with the replaced line OVER the same file
        FileOutputStream fileOut = new FileOutputStream("data.txt");
        fileOut.write(inputBuffer.toString().getBytes());
        fileOut.close();

    } catch (Exception e) {
        System.out.println("Problem reading file.");
    }
}
        
    }