package Mini_project;
import java.util.Scanner;
public class Simple_Banking {
	int choice;
    Scanner sc = new Scanner(System.in); 
    
    Simple_Banking() {
    	System.out.println("\u001B[33m \t\t---------------------------");
    	System.out.println("\u001B[33m \t\t|| WELCOME TO CROWN BANK ||");
    	System.out.println("\u001B[33m \t\t---------------------------");
    }
    void options() {
    	System.out.println("\u001B[34mChoose from the options below");
    	System.out.println("\u001B[37m1.Check Balance");
    	System.out.println("2.Deposit");
    	System.out.println("3.Withdraw");
    	System.out.println("4.Exit");
    	choice=sc.nextInt();
    	switch(choice) {
    	case 1:
    	{
    		Balance.checkUserBalance();
    		options();
    		break;
    	}
    	case 2:
    	{
    		Transaction.cashDeposit();
    		options();
    		break;
    	}
    	case 3:
    	{ 
    		Transaction.cashWithdraw();
    		options();
    		break;
    	}
    	case 4:
    	{
    		System.out.println("\u001B[35mTHANK YOU FOR USING OUR SERVICES!");
    		System.out.println("\u001B[33mContact customer support \u001B[34m1800 0500,1800 1102 \u001B[33mfor queries. ");
    		System.exit(0);
    	}
    	default:
    	{
    		System.out.println("\u001B[31mInvalid Option. Please refresh your page. \n");
    		options();
    	}
    	}
    }
    void select() {
    	System.out.println("\u001B[36mEnter your choice:");
    	System.out.println("Choose 1 to Sign up-(NEW USER)");
    	System.out.println("Choose 2 to Log in -(EXISTING USER)\u001B[37m");
    	choice=sc.nextInt();
    	switch(choice) {
    	case 1:
    	{
    		createuser.newuser();
    		break;
    	}
    	case 2:
    	{
    		userlogin.login();
    		break;
    	}
    	default:
    	{
    		System.out.println("\u001B[31mEnter a valid choice. Refresh your page and try again.");
    		System.exit(0);
    	}
    	}
    }  
    
	public static void main(String[] args) {
		Simple_Banking sb= new Simple_Banking();
		sb.select();
		sb.options();
	}

}
