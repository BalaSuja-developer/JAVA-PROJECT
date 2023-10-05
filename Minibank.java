package banking;
import java.util.*;

public class Minibank {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("*******************************");
		System.out.println("Welcome to ABC Bank");
		System.out.println("*******************************");
		System.out.println();
		System.out.println("Enter Account Holder Name: ");
		String name=sc.next();
		System.out.println("Enter Account Number: ");
		int id=sc.nextInt();
		bankapp b1=new bankapp(name,id);
		b1.show();
	}
}

class bankapp{
	Scanner sc=new Scanner(System.in);
	String cust_name;
	int cust_id;
	long balance,amt,previous;
	bankapp(String name,int id){
		cust_name=name;
		cust_id=id;
		balance=1000;//predefined amount balance for all customer
	}
	void deposit(long amount) {
		balance+=amount;
		previous=amount;
		System.out.println("Deposited Successfully!\n\n");
	}
	void withdraw(long amount) {
		balance-=amount;
		previous=-amount;
		System.out.println("Amount detected successfully!\n\n");
	}
	void previous_transaction() {
		if(previous<0) {
			System.out.println("You are Withdraw "+Math.abs(previous)+" in your Account.\n\n");
		}else {
			System.out.println("You are Deposit "+previous+" in your Account.\n\n");
		}
	}
	void show() {
		int n;
		System.out.println("WELCOME "+cust_name);
		System.out.println("Your customer ID is :"+cust_id+"\n");
		System.out.println("*******************************");
		do {
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Cash Withdraw");
			System.out.println("4. Previous Transaction");
			System.out.println("5. Exit");
			System.out.println("*******************************");
			System.out.print("Enter Your Choice: ");
			n=sc.nextInt();
			switch(n) {
			case 1:
				System.out.println("Your Account Balance : "+balance);
				break;
			case 2:
				System.out.println("Enter Amount : ");
				amt=sc.nextLong();
				deposit(amt);
				break;
			case 3:
				System.out.println("Enter Amount : ");
				amt=sc.nextLong();
				withdraw(amt);
				break;
			case 4:
				previous_transaction();
				break;
			case 5:
				System.out.println("Thank you!!");
				break;
			default:
				System.out.println("Invalid option...");
				break;
			}
		}while(n!=5);
	}
}
