package SwachhApp;

import java.util.Scanner;

public class User {

	public int choice;
	public String registerORLogin() {
		Scanner in = new Scanner(System.in);
		
		System.out.print(" Swachh Bharath ");
		
		System.out.println("Enter 1 to Sign IN or 2 to Register ");
		this.choice = in.nextInt();
		
		switch(choice) {
		case 1:
			this.UserLogin();
			break;
		case 2:
			this.UserRegister();
			break;
		}
		return null;
		
	}
	
	private String firstName;
	public String lastName;
	private String phoneNumber;
	private String emailID;
	private String password;
	
	
	public void UserRegister() {
		Scanner in = new Scanner(System.in);
		System.out.print(" First Name: ");
		this.firstName = in.nextLine();
		
		System.out.print(" Last Name: ");
		this.lastName = in.nextLine();
		
		System.out.print(" Phone Number: ");
		this.phoneNumber = in.nextLine();
		
		System.out.print("Email ID: ");
		this.emailID = in.nextLine();
		
		System.out.print("Password: ");
		this.password = in.nextLine();
		
		System.out.println("Welcome" + firstName+""+lastName); 
		//register with name, phone no., email ID
		
	}
	
	public void UserLogin()
	{
		Scanner in = new Scanner(System.in);
		//enter username
		//enter password
		// compare to the database
		
		//do you want to check balance or dump waste to recycle
		
		System.out.print("Select 1. check balance  2. dump to recycle ");
		this.choice = in.nextInt();
		
		switch(choice) {
		case 1:
			
			break;
		case 2:
			this.typeOfWastage();
			break;
		}
		//get balance
	
	//wastage + if metal, paper or plastic
		
	}
	
	public static int yesDump=1;
	public int type;
	public int noOfKG;
	public int totalKG;
	public void typeOfWastage()
	{
		Scanner in = new Scanner(System.in);
		
		while(yesDump==1) {
		System.out.println("Select the type of wastage: 1.GLASS 2.PLASTIC 3.METAL ");
		this.type = in.nextInt();
		
		System.out.println("Enter no. of kilograms");
		this.noOfKG = in.nextInt();
		
		switch(type) {
		
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		}
		System.out.print("Do you want to dump more 1.YES 0.NO ");
		this.yesDump = in.nextInt();
		
	}
	}
	
	//creating unique coupon code
	public String generateCouponCode()
	{
		return lastName.substring(0,4) + "";
	}
	
}
