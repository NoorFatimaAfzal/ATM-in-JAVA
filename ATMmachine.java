import java.util.Scanner;

class ATM{

    private float balance;
    private final int realPin = 1234;
    private final Scanner sc;

    // Constructor 
    public ATM(Scanner scanner){
        this.sc = scanner;
        System.out.println("Welcome to ATM Machine");
        System.out.println("Enter your pin");
        int pin = sc.nextInt();
        if (pin == realPin){
            menu();
        }
        else{
            System.out.println("Enter correct pin");
        }
    }
    
    // menue method
    public final void menu(){
        while(true) {
            System.out.println("1. Check balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> checkBalance();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> {
                    System.out.println("Thank you for using ATM");
                    return;
                }
                default -> System.out.println("Enter correct choice");
            }
        }
    }
    
                                   // methods

    public void checkBalance(){
        System.out.println("Your balance is: "+balance);
    }
            
    public void deposit(){
        System.out.println("Enter amount to deposit");
        float amount = sc.nextFloat();
        balance = balance + amount;
        System.out.println("Amount deposited successfully");
    }

    public void withdraw(){
        System.out.println("Enter amount to be withdrawn");
        float amount = sc.nextFloat();
        if (amount <= balance){
            balance = balance - amount;
            System.out.println("Amount withdrawn successfully");
        }else{
            System.out.println("Insufficient balance");
        }
    }

}

                                 // Main class

public class ATMmachine {
   public static void main(String[] args) {
         try (Scanner scanner = new Scanner(System.in)) {
             ATM obj = new ATM(scanner);
         }
   }
}