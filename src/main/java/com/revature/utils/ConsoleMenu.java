package com.revature.utils;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.services.AccountOps;
import com.revature.services.UserOps;

public class ConsoleMenu {
	
	private static final Scanner scan = new Scanner(System.in);
	private UserOps uo = new UserOps();
	private AccountOps ao = new AccountOps();
	
	public void consoleMenu() {
		
		System.out.println("Welcome to Bank of  Women in Tech!");
		System.out.println("Plelase select an option: \n"+"[a] Log In\n"+"[b] Create a New User\n"+"[c] Exit");
		String ans1 = scan.nextLine();
		firstMenu(ans1);
	}

	private void firstMenu(String ans1) {
		ans1 = ans1.toLowerCase();
		
		switch(ans1) {
			case "a":
				logIn();
				System.out.println("Please select an end user:\n"+"[a] Customer\n"+"[b] Employee\n"+"[c] Admin");
				String ans2 = scan.nextLine();
				secondMenu(ans2);
				break;
			case "b":
				createNewUser();
				System.out.println("You have successfully created a new account.\n"
						+"Please return to the main menu to login");
				consoleMenu();
				break;
			case "c":
				System.out.println("Thank you for choosing WIT for your banking needs! Have a great day!");
				break;
			default:
				System.out.println("You have enter an invalid option, please enter a valid option.");
				consoleMenu();
				break;
		}
		
	}

	private void createNewUser() {
		System.out.println("Please create a username.");
		String uName = scan.nextLine();
		System.out.println("Please create a password.");
		String uPass = scan.nextLine();
		System.out.println("Please enter end user type?");
		String uType = scan.nextLine();
		System.out.println("Please enter your first name?");
		String fName = scan.nextLine();
		System.out.println("Please enter your last name?");
		String lName = scan.nextLine();
		System.out.println("Please enter your birth date? Please enter in month/ day/ year format.");
		int bDate = scan.nextInt();
		scan.nextLine();
		User u = new User(uName, uPass, uType, fName, lName, bDate);
		
		if (uo.createNewUser(u)) {
			System.out.println("Thank you for creating a new account.");
		} else {
			System.out.println("You have enter an invalid option, please enter a valid option.");
			consoleMenu();
		}
	}

	private void secondMenu(String ans2) {
		ans2 = ans2.toLowerCase();
		
		switch(ans2) {
			case "a":
				customerMenu();
				break;
			case "b":
				employeeMenu();
				break;
			case "c":
				adminMenu();
				break;
			default:
				System.out.println("You have entered an invalid option, please enter a valid option..");
				consoleMenu();
				break;
		}
	}

	private void adminMenu() {
		System.out.println("Please select from the menu option: \n"+"[a] View Your Customers' Information\n"+"[b] Deposit\n"+"[c] Withdraw\n"+"[d] Transfer\n"
				+"[e] Approve Account\n"+"[f] Deny Account\n"+"[g] Close Account\n"+"[h] Exit");
		String adAns = scan.nextLine();
		adAns = adAns.toLowerCase();
		
		switch(adAns) {
			case "a":
				getAllCustInfo();
				getAllAcc();
				System.out.println("Would you like to perform other transaction? ");
				adminMenu();
				break;
			case "b":
				depositIntoAcc();
				System.out.println("Would you like to perform other transaction?");
				adminMenu();
				break;
			case "c":
				withdrawFromAcc();
				System.out.println("Would you like to perform other transaction?");
				adminMenu();
				break;
			case "d":
				transferMoneyFromAcc1ToAcc2();
				System.out.println("Would you like to perform other transaction?");
				adminMenu();
				break;
			case "e":
				approveAcc();
				System.out.println("Would you like to perform other transaction?");
				adminMenu();
				break;
			case "f":
				denyAcc();
				System.out.println("Would you like to perform other transaction?");
				adminMenu();
				break;
			case "g":
				closeAcc();
				System.out.println(" Would you like to perform other transaction?");
				adminMenu();
				break;
			case "h":
				System.out.println("Thank you for choosing WIT for your banking needs! Have a great day!");
				break;
			default:
				System.out.println("You have enter an invalid option, please enter a valid option.");
				adminMenu();
				break;
		}
		
	} 

	private void closeAcc() {
		System.out.println("Please enter your login credentials, to authorize transaction.");
		int i1 = scan.nextInt();
		scan.nextLine();
		System.out.println("Please enter Account ID you would like to close.");
		int i2 = scan.nextInt();
		scan.nextLine();
		String stats = ao.closeAccount(i1, i2);
		
		System.out.println("The status of the account with id "+i2+" is now "+stats+".");
	}

	private void employeeMenu() {
		System.out.println("Please select from the  menu option:\n"+"[a] View Your Customers' Information\n"+"[b] Approve Account\n"+"[c] Deny Account\n"
				+"[d] Exit");
		String empAns = scan.nextLine();
		empAns = empAns.toLowerCase();
		
		switch(empAns) {
			case "a":
				getAllCustInfo();
				getAllAcc();
				System.out.println("Would you like to perform other transaction?");
				employeeMenu();
				break;
			case "b":
				approveAcc();
				System.out.println("Would you like to perform other transaction?");
				employeeMenu();
				break;
			case "c":
				denyAcc();
				System.out.println("Would you like to perform other transaction?");
				employeeMenu();
				break;                       
			case "d":
				System.out.println("Thank you for choosing WIT for your banking needs! Have a great day!");
				break;
			default:
				System.out.println("You have entered an invalid option, please enter a valid option.");
				employeeMenu();
				break;
		}
		
	}

	private void denyAcc() {
		System.out.println("Please enter your login credentials, to authorize transaction.");
		int i1 = scan.nextInt();
		scan.nextLine();
		System.out.println("Please enter the Account ID you would like to deny?");
		int i2 = scan.nextInt();
		scan.nextLine();
		String stats = ao.denyAccount(i1, i2);
		
		System.out.println("The status of the account with id "+i2+" is now "+stats+".");
	}

	private void approveAcc() {
		System.out.println("Please enter your login credentials, to authorize transaction.");
		int i1 = scan.nextInt();
		scan.nextLine();
		System.out.println("Please enter the Account ID you would like to approve?");
		int i2 = scan.nextInt();
		scan.nextLine();
		String stats = ao.approveAccount(i1, i2);
		
		System.out.println("The status of the account with id "+i2+" is now "+stats+".");
	}

	private void getAllAcc() {
		List<Account> allAcc = ao.getAllAccounts();
		System.out.println("All Active Accounts: ");
		for (Account a: allAcc) {
			System.out.println(a);
		}
	}

	private void getAllCustInfo() {
		List<User> customers = uo.getAllCustomers();
		System.out.println("All Active Customers: ");
		for (User u: customers) {
			System.out.println(u);
		}
	}

	private void customerMenu() {
		System.out.println("Please select from the option menu: \n"+"[a] View Your Accounts\n"+"[b] Deposit\n"+"[c] Withdraw\n"+"[d] Transfer\n"
				+"[e] Create a New Account\n"+"[f] Exit");
		String custAns = scan.nextLine();
		custAns = custAns.toLowerCase();
		
		switch(custAns) {
			case "a":
				viewAccByUserId();
				System.out.println("Would you like to perform other transaction?");
				customerMenu();
				break;
			case "b":
				depositIntoAcc();
				System.out.println("Would you like to perform other transaction?");
				customerMenu();
				break;
			case "c":
				withdrawFromAcc();
				System.out.println("Would you like to perform other transaction?");
				customerMenu();
				break;
			case "d":
				transferMoneyFromAcc1ToAcc2();
				System.out.println("Would you like to perform other transaction?");
				customerMenu();
				break;
			case "e":
				createNewAcc();
				System.out.println("Would you like to perform other transaction?");
				customerMenu();
				break;
			case "f":
				System.out.println("Thank you for choosing WIT for your banking needs! Have a great day!");
				break;
			default:
				System.out.println("You have entered an invalid option, please enter a valid option.");
				customerMenu();
				break;
		}
		
	}

	private void createNewAcc() {
		System.out.println("Enter your user ID?");
		int i = scan.nextInt();
		scan.nextLine();
		User u = uo.getUserById(i);
		System.out.println("What account would you like to access?");
		String type = scan.nextLine();
		System.out.println(" Account balance of the account: ");
		double d = scan.nextDouble();
		scan.nextLine();
		
		Account a = new Account(u, type, d, "Account Status Pending");
		
		if(ao.createNewAccount(a)) {
			System.out.println("Your account is not active.");
		} else {
			System.out.println("You have entered an invalid option, please enter a valid option.");
		}
	}

	private void viewAccByUserId() {
		System.out.println("Please enter your User ID associated with the account you would like to access?");
		int iA = scan.nextInt();
		scan.nextLine();
		User u = uo.getUserById(iA);
		List<Account> custAccounts = ao.getAccountsByUserId(u);
		
		System.out.println("Here is your accounts: ");
		for(Account a: custAccounts) {
			System.out.println(a);
		}
	}

	private void transferMoneyFromAcc1ToAcc2() {
		System.out.println("Please enter Account ID for account transfering from:");
		int firstId = scan.nextInt();
		scan.nextLine();
		Account firstAcc = ao.getAccountById(firstId);
		System.out.println("Please enter Account ID for account transfering to: ");
		int secondId = scan.nextInt();
		scan.nextLine();
		Account secondAcc = ao.getAccountById(secondId);
		System.out.println("Enter amount to be transfer:");
		double transAmt = scan.nextDouble();
		scan.nextLine();
		double[] newAccBalances = ao.transferTo(firstId, secondId, transAmt);
		double newFirstAccBalance = newAccBalances[0];
		double newSecondAccBalance = newAccBalances[1];
		
		System.out.println("New balance for account "+firstAcc.getAccountId()+" is "+newFirstAccBalance+".");
		System.out.println("New balance for account "+secondAcc.getAccountId()+" is "+newSecondAccBalance+".");
	}

	private void withdrawFromAcc() {
		System.out.println("Enter Account ID of the account you are withdrawing from?");
		int i = scan.nextInt();
		scan.nextLine();
		Account a = ao.getAccountById(i);
		System.out.println("Enter amount to be withdrawn: ");
		double withAmt = scan.nextDouble();
		scan.nextLine();
		double newAccBalance = ao.withdraw(i, withAmt);
		
		System.out.println("New balance for account "+a.getAccountId()+" is "+newAccBalance);
	}

	private void depositIntoAcc() {
		System.out.println("What is the ID of the account that you are trying to deposit into?");
		int i = scan.nextInt();
		scan.nextLine();
		Account a = ao.getAccountById(i);
		System.out.println("How much would you like to deposit?");
		double depoAmt = scan.nextDouble();
		scan.nextLine();
		double newAccBalance = ao.deposit(i, depoAmt);
		
		System.out.println("The new balance for account with id "+a.getAccountId()+" is "+newAccBalance);
	}

	private void logIn() {
		System.out.println("What is the id of the user you are trying to log in as?");
		int i = scan.nextInt();
		scan.nextLine();
		User u = uo.getUserById(i);
		System.out.println("What is your username?");
		String uName = scan.nextLine();
		System.out.println("What is your password?");
		String uPass = scan.nextLine();
		
		if (uName.equals(u.getLoginName()) && uPass.equals(u.getPassword())) {
			System.out.println("Welcome back "+u.getFirstName()+" to Women In Tech Bank!");
		} else {
			System.out.println("You may have typed something wrong. Please try again.");
			consoleMenu();
		}
	}	
}
			
			
		





