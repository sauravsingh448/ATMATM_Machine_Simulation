import java.util.Scanner;
public class ATM_Machine_Simulation {
   private int Balance;
   private int pin;
   public ATM_Machine_Simulation(int Balance, int pin){
        this.Balance = Balance;
        this.pin = pin;
   }
    public void displaymenu(){
        System.out.println("1.Check Amount: ");
        System.out.println("2. Deposit Amount: ");
        System.out.println("3. Withdrawal Amount: ");
        System.out.println("4. Pin Change: ");
        System.out.println("5. check the pin");
        System.out.println("6. Exit: ");
    }
    public void deposit(int Amount){
       Balance = Balance + Amount;   // 10000 + 20000 = 30000 Ans.
    }
    public void Withdrawal(int Amount){
       if(Balance < Amount){
           System.out.println("****** SORRY ****** Insufficient Funds! ");
           return;
       }
       Balance = Balance - Amount;  // 10000 - 15000 = - 5000
    }

    public int getBalance(){
       return Balance;
    }
    public int getPin(){
       return pin;
    }
    public boolean Validpin(int pin){
       return this.pin == pin;
    }
    public void pinChange(int newpin){
       pin = newpin;
    }

    public static void main(String[] args) {
        System.out.println("\n *********** Hello ATM User ************** ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Balance first time: ");
        int Balance = sc.nextInt();
        System.out.print("Enter a pin first time: ");
        int firstPin = sc.nextInt();
        ATM_Machine_Simulation obj = new ATM_Machine_Simulation(Balance,firstPin);
        System.out.print("\nEnter a correct pin: ");
        int pin = sc.nextInt();
        System.out.print("\nPin: "+ pin+ "\n");
        if(obj.Validpin(pin)){
           int option = 0;
           while (option != 6){
               obj.displaymenu();
               System.out.print("Enter a chose the option: ");
               option = sc.nextInt();
               switch (option){
                   case 1:
                       System.out.println("Balance: "+obj.getBalance());
                       break;
                   case 2:
                       System.out.print("Enter a Amount for Deposit: ");
                       int amount = sc.nextInt();
                       obj.deposit(amount);
                       break;
                   case 3:
                       System.out.print("Enter a Amount for Withdrawal: ");
                       amount = sc.nextInt();
                       obj.Withdrawal(amount);
                       break;
                   case 4:
                       System.out.print("Enter a new pin: ");
                       int newpin = sc.nextInt();
                       obj.pinChange(newpin);
                       break;
                   case 5:
                       System.out.println("After change the pin "+ obj.getPin());
                       break;
                   case 6:
                       System.out.println("Thank you for Using ATM!: ");
                       break;
                   default:
                   {
                       System.out.println("Your Option is Wrong ");
                       break;
               }   }
           }
        }else {
            System.out.println("\nYou have entered Invalid pin: ");
        }
    }
}