package SwachhApp;
import java.util.Scanner;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class registerORLogin {
	
	public String choice;
		public registerORLogin() {
			Scanner in = new Scanner(System.in);
			
			System.out.println("----------- Swachh Bharath------------- ");
			
			System.out.println("----Enter 'L'ogin or 'R'egister---- ");
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
		
		public int id=0;
		
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
			
			userName = firstName+" "+lastName;
			
			System.out.println("Your ID is " + id++);
			
			System.out.println("-----Welcome	" + userName); 
			//register with name, phone no., email ID
			System.out.println("Continue to the Login Page");
			
			
			this.UserLogin();// working on uploading the data from the input to the XML file 
			
		}
		
		public String userNameN;
		public String passwordN;
		public int idN;
		
		public void UserLogin()
		{
			Scanner in = new Scanner(System.in);
			
			
			while(userNameN!="0") {
			System.out.println("Login Page \n User Name: ");
			this.userNameN = in.nextLine();
			
			System.out.println("Password: ");
			this.passwordN = in.nextLine();
			
			System.out.println("ID: ");
			this.idN = in.nextInt();
			
			this.retriveXML(idN);
			
			if((userNameN == userName) && (passwordN == password))
			{
			userNameN="0";
			}
			}
			
			
			System.out.println("Press 'C'heck balance  or 'D'ump to recycle ");
			this.choice = in.nextLine();
			
			switch(choice) {
			case "C":
				
				break;
			case "D":
				this.Wastage();
				break;
			}	
			
		}
		
		public void retriveXML(int idN)
		{
			DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
			try {
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse("users.xml");
				NodeList personList = doc.getElementsByTagName("person");
				
				
					Node p = personList.item(idN);
					if(p.getNodeType()== Node.ELEMENT_NODE)
					{
						Element person = (Element) p;
						String user = person.getAttribute("user");
						NodeList nameList = person.getChildNodes();
					
							Node n = nameList.item(idN);
							System.out.println(n);
							
					}
				}
						
			 catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
		//get balance
		//wastage + if metal, paper or plastic
		private int yesDump=1;
		private String type;
		private String noOfKG;
		public int totalKG;
		public String listOfWastage="\t";
		private String brand;
		
		public int uniqueNO=12000;
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
				// the code value from chart multiplied to the no. of KGS gives us a more accurate figure
			totalPoints += c;
			listOfWastage += "\n" + type +" "+ noOfKG +" "+brand+ " "+c;
			
			System.out.print("Enter 0 to quit and any number to continue ");
			this.yesDump = in.nextInt();
			
		}
			System.out.println(listOfWastage+"\n"+ "Total points: "+ totalPoints);
			uniqueNO++;
			this.generateCouponCode(totalPoints, uniqueNO, id);
		}
		
		public int couponPoints(int B ,int T)
		{
			int[][] codeChart = {{1, 2, 3 }, {2, 4, 6}, {3, 6, 9}};
			
			/*this code chart must be worked on based on the price and worth of different quality and type of material
			Also the type of plastic differentiated by brand might be too specific hence a user friendly chart is suggested*/
			
			return codeChart[T][B];
							
		}
		
		public String CouponCode;
		
		//creating unique coupon code
		public void generateCouponCode(int points,int uniqueNO, int id)
		{
			
			String lastNameU = //working on retriving data from XML file
			CouponCode = lastName.substring(0,2) + "" +Integer.toString(id);
			System.out.println("Coupon Code:" + CouponCode);
		}
	}
