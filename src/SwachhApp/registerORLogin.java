package SwachhApp;
import java.util.Scanner;

public class registerORLogin {
	
	public String choice;
		public registerORLogin() {
			Scanner in = new Scanner(System.in);
			
			System.out.println("----------- Swachh Bharath------------- ");
			
			System.out.println("--Enter 'L'ogin or 'R'egister-- ");
			this.choice = in.nextLine();
			
			switch(choice) {
			case "L":
				this.UserLogin();
				break;
			case "R":
				this.UserRegister();
				break;
			}
		}
		
		private String firstName;
		public String lastName;
		public String userName;
		private String phoneNumber;
		private String emailID;
		private String password;
		
		
		public void UserRegister() {
			Scanner in = new Scanner(System.in);
			System.out.print("First Name: ");
			this.firstName = in.nextLine();
			
			System.out.print("Last Name: ");
			this.lastName = in.nextLine();
			
			System.out.print("Phone Number: ");
			this.phoneNumber = in.nextLine();
			
			System.out.print("Email ID: ");
			this.emailID = in.nextLine();
			
			System.out.print("Password: ");
			this.password = in.nextLine();
			
			userName = firstName+""+lastName;
			System.out.println("-----Welcome	" + userName); 
			//register with name, phone no., email ID
			System.out.println("Continue to the Login Page");
			
			this.UserLogin();
			
		}
		
		
	//get balance
		
		//wastage + if metal, paper or plastic
		public String userNameN;
		public String passwordN;
		
		public void UserLogin()
		{
			Scanner in = new Scanner(System.in);
			
			
			while(userName!="0") {
			System.out.println("Login Page \n User Name: ");
			this.userNameN = in.nextLine();
			
			System.out.println("Password: ");
			this.passwordN = in.nextLine();
			
			if((userNameN == userName) && (passwordN == password))
			{
			userNameN="0";
			}
			}
			
			
			System.out.println("Press 'C' to check balance  'D' dump to recycle ");
			this.choice = in.nextLine();
			
			switch(choice) {
			case "C":
				
				break;
			case "D":
				this.Wastage();
				break;
			}	
			
		}
		private int yesDump=1;
		private String type;
		private String noOfKG;
		public int totalKG;
		public String listOfWastage="\t";
		private String brand;
		public int id=12000;
		private int totalPoints;
		public int c;
		
		public void Wastage()
		{
			Scanner in = new Scanner(System.in);
			while(yesDump!=0) 
			{
			System.out.println("Select the type of wastage: 0.PLASTIC 1.METAL 2.GLASS  ");
			this.type = in.nextLine();
			
			System.out.println("Enter no. of kilograms");
			this.noOfKG = in.nextLine();
		
			System.out.println("Enter brand based on the code chart (length and quality) ");
			this.brand = in.nextLine();
			
			c = Integer.valueOf(noOfKG) * couponPoints(Integer.valueOf(brand),Integer.valueOf(type));
				
			totalPoints += c;
			listOfWastage += "\n" + type +" "+ noOfKG +" "+brand+ " "+c;
			
			System.out.print("Enter 0 to quit and any number to continue ");
			this.yesDump = in.nextInt();
			
		}
			System.out.println(listOfWastage+"\n"+ "Total points: "+ totalPoints);
			id++;
			this.generateCouponCode(totalPoints, id);
		}
		
		public int couponPoints(int B ,int T)
		{
			int[][] codeChart = {{1, 2, 3 }, {2, 4, 6}, {3, 6, 9}};
			
			return codeChart[T][B];
							
		}
		
		//creating unique coupon code
		public void generateCouponCode(int points,int id)
		{
			lastName="SAMA";
			String CouponCode = lastName.substring(0,2) + "" +Integer.toString(id);
			System.out.println("Coupon Code:" + CouponCode);
		}
	}
