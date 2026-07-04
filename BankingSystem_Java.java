package GroupProject;
import java.util.Scanner;

/**
 * ---------------------------------------------------------------
 *                BANKING SYSTEM PROJECT
 * ---------------------------------------------------------------
 *  Course   : SWE 201 - Structured Programming
 *  Semester : Fall 2025
 *  Name   : Amna Furkhan
 *  ID       : 1101690 
 *  Purpose  : Console-based banking management system using arrays
 * ---------------------------------------------------------------
 */

public class BankingSystem {

    // -------------------------------------------------------
    // --- DATA STORAGE SECTION ---
    // -------------------------------------------------------
    static String[] names = new String[50];
    static String[] genders = new String[50];
    static String[] phones = new String[50];
    static String[] passwords = new String[50];
    static int[] accountNumbers = new int[50];
    static double[] balances = new double[50];
    static int customerCount = 0;

    // -------------------------------------------------------
    // --- MAIN MENU ---
    // -------------------------------------------------------
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print(
                "\n" + printLine() +
                "\nWelcome to the Banking System Program" +
                "\n" + printLine() +
                "\n             Menu" +
                "\n" + printLine() +
                "\n         1. Admin Login" +
                "\n         2. Customer Login" +
                "\n         3. Sign Up" +
                "\n         4. Exit" +
                "\n" + printLine() +
                "\n     Enter your choice: ");
            
            int choice = input.nextInt();
            System.out.println(printLine());

            switch (choice) {
                case 1: 
                    admin(); 
                    break;
                case 2: 
                    customer(); 
                    break;
                case 3: 
                    signUp(); 
                    break;
                case 4:
                    System.out.println("\nYou have successfully exited the Banking System...");
                    System.exit(0);
                default:
                    System.out.println("\nInvalid Choice. Please try again.");
            }
        }
    }

    // -------------------------------------------------------
    // --- FORMATTING METHOD: PRINT LINE ---
    // -------------------------------------------------------
    public static String printLine() {
        return "-------------------------------------";
    }

    // =====================================================================
    // ========================= ADMIN SECTION ============================
    // =====================================================================

    // --- ADMIN LOGIN ---
    public static void admin() {
        Scanner input = new Scanner(System.in);
        String adminUser = "teller123";
        String adminPass = "admin@123";

        System.out.print(
            "\n" + printLine() +
            "\nWelcome to Admin Login" +
            "\n" + printLine() +
            "\n     User ID : ");
        String id = input.next();
        System.out.print("     Password: ");
        String pass = input.next();

        if (id.equals(adminUser) && pass.equals(adminPass)) {
            adminMenu();
        } else {
            System.out.println(printLine());
            System.out.println("Invalid Admin credentials. Access denied.");
        }
    }

    // --- ADMIN MENU ---
    public static void adminMenu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print(
                "\n" + printLine() +
                "\n            ADMIN MENU" +
                "\n" + printLine() +
                "\n        1. View All Customers" +
                "\n        2. Search Customer by Account Number" +
                "\n        3. Delete Customer Account" +
                "\n        4. Exit to Main Menu" +
                "\n" + printLine() +
                "\n     Enter your choice: ");
            
            int choice = input.nextInt();
            System.out.println(printLine());

            switch (choice) {
                case 1: 
                    viewAllCustomers(); 
                    break;
                case 2: 
                    searchCustomer(); 
                    break;
                case 3: 
                    deleteCustomer(); 
                    break;
                case 4:
                    System.out.println("\nReturning to Main Menu...");
                    return;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    // --- VIEW ALL CUSTOMERS ---
    public static void viewAllCustomers() {
        if (customerCount == 0) {
            System.out.println("\nNo customers found in the system.");
            return;
        }

        System.out.print(
            "\n" + printLine() +
            "\n           CUSTOMER LIST" +
            "\n" + printLine());

        for (int i = 0; i < customerCount; i++) {
            System.out.print(
                "\nAccount No : " + accountNumbers[i] +
                "\nName       : " + names[i] +
                "\nGender     : " + genders[i] +
                "\nPhone      : " + phones[i] +
                "\nBalance    : " + balances[i] +
                "\n" + printLine());
        }
    }

    // --- SEARCH CUSTOMER ---
    public static void searchCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.print(
            "\n" + printLine() +
            "\n        SEARCH CUSTOMER" +
            "\n" + printLine() +
            "\nEnter Account Number to search: ");
        int acc = input.nextInt();
        boolean found = false;

        for (int i = 0; i < customerCount; i++) {
            if (accountNumbers[i] == acc) {
                found = true;
                System.out.print(
                    "\n" + printLine() +
                    "\nCustomer Found!" +
                    "\n" + printLine() +
                    "\nAccount No : " + accountNumbers[i] +
                    "\nName       : " + names[i] +
                    "\nGender     : " + genders[i] +
                    "\nPhone      : " + phones[i] +
                    "\nBalance    : " + balances[i] +
                    "\n" + printLine());
                break;
            }
        }

        if (!found) System.out.println("\nNo customer found with that account number.");
    }

    // --- DELETE CUSTOMER ACCOUNT (Admin) ---
    public static void deleteCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.print(
            "\n" + printLine() +
            "\n        DELETE CUSTOMER ACCOUNT" +
            "\n" + printLine() +
            "\nEnter Account Number to delete: ");
        int acc = input.nextInt();
        boolean found = false;

        for (int i = 0; i < customerCount; i++) {
            if (accountNumbers[i] == acc) {
                found = true;
                System.out.print("Are you sure you want to delete this account? (Y/N): ");
                String confirm = input.next();

                if (confirm.equalsIgnoreCase("Y")) {
                    // Shift remaining data left
                    for (int j = i; j < customerCount - 1; j++) {
                        names[j] = names[j + 1];
                        genders[j] = genders[j + 1];
                        phones[j] = phones[j + 1];
                        passwords[j] = passwords[j + 1];
                        accountNumbers[j] = accountNumbers[j + 1];
                        balances[j] = balances[j + 1];
                    }
                    customerCount--;
                    System.out.println("\nAccount deleted successfully.");
                } else {
                    System.out.println("\nAccount deletion cancelled.");
                }
                break;
            }
        }

        if (!found) System.out.println("\nAccount not found.");
    }

    // =====================================================================
    // ======================== CUSTOMER SECTION ===========================
    // =====================================================================

    // --- CUSTOMER LOGIN ---
    public static void customer() {
        Scanner input = new Scanner(System.in);
        System.out.print(
            "\n" + printLine() +
            "\nWelcome to Customer Login" +
            "\n" + printLine() +
            "\n     User ID : ");
        int userId = input.nextInt();
        input.nextLine();

        boolean found = false;

        for (int i = 0; i < customerCount; i++) {
            if (accountNumbers[i] == userId) {
                found = true;
                System.out.print("     Password : ");
                String password = input.nextLine();

                if (passwords[i].equals(password)) {
                    System.out.println(printLine() + "\nLogin successful. Welcome, " + names[i] + "!");
                    customerMenu(i);
                } else {
                    System.out.println(printLine() + "\nIncorrect password. Please try again.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println(printLine() + "\nAccount not found. Please sign up first.");
            System.out.println(printLine() + "\nRedirecting to Sign Up...");
            signUp();
        }
    }

    // --- CUSTOMER MENU ---
    public static void customerMenu(int index) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print(
                "\n" + printLine() +
                "\n          CUSTOMER BANKING MENU" +
                "\n" + printLine() +
                "\n        1. View Balance" +
                "\n        2. Deposit Money" +
                "\n        3. Withdraw Money" +
                "\n        4. Transfer Money" +
                "\n        5. Delete Account" +
                "\n        6. Logout" +
                "\n" + printLine() +
                "\n     Enter your choice: ");
            
            int choice = input.nextInt();
            System.out.println(printLine());

            switch (choice) {
                case 1: 
                    viewBalance(index); 
                    break;
                case 2: 
                    deposit(index); 
                    break;
                case 3: 
                    withdraw(index); 
                    break;
                case 4: 
                    transfer(index); 
                    break;
                case 5: 
                    deleteOwnAccount(index); 
                    return;
                case 6:
                    System.out.println("\nLogging out...\n");
                    return;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    // --- VIEW BALANCE ---
    public static void viewBalance(int index) {
        System.out.print(
            "\n" + printLine() +
            "\n         ACCOUNT BALANCE" +
            "\n" + printLine() +
            "\nAccount No : " + accountNumbers[index] +
            "\nName       : " + names[index] +
            "\nBalance    : " + balances[index] +
            "\n" + printLine());
    }

    // --- DEPOSIT MONEY ---
    public static void deposit(int index) {
        Scanner input = new Scanner(System.in);
        System.out.print(
            "\n" + printLine() +
            "\n            DEPOSIT MONEY" +
            "\n" + printLine() +
            "\nEnter amount to deposit: ");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Deposit cancelled.");
            return;
        }

        balances[index] += amount;
        System.out.println("\nDeposit successful! Updated Balance: " + balances[index]);
    }

    // --- WITHDRAW MONEY ---
    public static void withdraw(int index) {
        Scanner input = new Scanner(System.in);
        System.out.print(
            "\n" + printLine() +
            "\n           WITHDRAW MONEY" +
            "\n" + printLine() +
            "\nEnter amount to withdraw: ");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Try again.");
            return;
        } else if (amount > balances[index]) {
            System.out.println("Insufficient balance. Withdrawal cancelled.");
            return;
        }

        balances[index] -= amount;
        System.out.println("\nWithdrawal successful! Updated Balance: " + balances[index]);
    }

    // --- TRANSFER MONEY ---
    public static void transfer(int index) {
        Scanner input = new Scanner(System.in);
        System.out.print(
            "\n" + printLine() +
            "\n           TRANSFER MONEY" +
            "\n" + printLine() +
            "\nEnter receiver's Account Number: ");
        int receiver = input.nextInt();

        int receiverIndex = -1;
        for (int i = 0; i < customerCount; i++) {
            if (accountNumbers[i] == receiver) {
                receiverIndex = i;
                break;
            }
        }

        if (receiverIndex == -1) {
            System.out.println("Receiver account not found.");
            return;
        }

        System.out.print("Enter amount to transfer: ");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        } else if (amount > balances[index]) {
            System.out.println("Insufficient balance. Transfer cancelled.");
            return;
        }

        balances[index] -= amount;
        balances[receiverIndex] += amount;

        System.out.println("\nTransfer successful!");
        System.out.println("Your new balance: " + balances[index]);
    }

    // --- DELETE OWN ACCOUNT ---
    public static void deleteOwnAccount(int index) {
        Scanner input = new Scanner(System.in);
        System.out.print(
            "\n" + printLine() +
            "\n         DELETE ACCOUNT" +
            "\n" + printLine() +
            "\nAre you sure you want to delete your account? (Y/N): ");
        String confirm = input.next();

        if (confirm.equalsIgnoreCase("Y")) {
            for (int j = index; j < customerCount - 1; j++) {
                names[j] = names[j + 1];
                genders[j] = genders[j + 1];
                phones[j] = phones[j + 1];
                passwords[j] = passwords[j + 1];
                accountNumbers[j] = accountNumbers[j + 1];
                balances[j] = balances[j + 1];
            }
            customerCount--;
            System.out.println("\nAccount deleted successfully. Returning to main menu...");
        } else {
            System.out.println("\nAccount deletion cancelled.");
        }
    }

    // =====================================================================
    // ==================== ACCOUNT MANAGEMENT SECTION =====================
    // =====================================================================

    // --- SIGN UP ---
    public static void signUp() {
        Scanner input = new Scanner(System.in);
        System.out.print(
            "\n" + printLine() +
            "\nWelcome to Customer Sign Up" +
            "\n" + printLine() + "\n");

        if (customerCount >= names.length) {
            System.out.println("System full. Cannot create more accounts.");
            System.exit(0);
        }

        System.out.print("Enter Full Name: ");
        String name = input.nextLine();

        System.out.print("Enter Gender (M/F): ");
        String gender = input.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = input.nextLine();

        // Password validation
        String password;
        while (true) {
            System.out.print("Create Password (min 8 chars, 1 upper, 1 lower, 1 number, 1 special): ");
            password = input.nextLine();

            int lc = 0, uc = 0, sp = 0, nm = 0;
            String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String lowercase = "abcdefghijklmnopqrstuvwxyz";
            String special = "!@#$%^&~*_";
            String number = "0123456789";

            if (password.length() >= 8) {
                for (int i = 0; i < password.length(); i++) {
                    char ch = password.charAt(i);
                    if (lowercase.indexOf(ch) != -1) lc++;
                    if (uppercase.indexOf(ch) != -1) uc++;
                    if (special.indexOf(ch) != -1) sp++;
                    if (number.indexOf(ch) != -1) nm++;
                }
            }

            if (password.length() >= 8 && lc >= 1 && uc >= 1 && sp >= 1 && nm >= 1) break;
            else System.out.println("Weak password! Try again.\n");
        }

        int newAccount = createID();

        names[customerCount] = name;
        genders[customerCount] = gender;
        phones[customerCount] = phone;
        passwords[customerCount] = password;
        accountNumbers[customerCount] = newAccount;
        balances[customerCount] = 0.0;
        customerCount++;

        System.out.println(printLine());
        System.out.println("Account successfully created!");
        System.out.println("Your Account Number is: " + newAccount);
        System.out.println("Please remember it for future logins.");
        System.out.println(printLine());
    }

    // --- CREATE RANDOM ACCOUNT ID ---
    public static int createID() {
        int id;
        boolean exists;
        do {
            exists = false;
            id = (int)(100000 + Math.random() * 900000);
            for (int i = 0; i < customerCount; i++) {
                if (accountNumbers[i] == id) {
                    exists = true;
                    break;
                }
            }
        } while (exists);
        return id;
    }
}
