import java.util.*;
import java.lang.Math;
import java.util.InputMismatchException;
class Contacts{

	private int userNumber;
	private String name;
    public Contacts userarr[]=new Contacts[5];
	int size=0;
	Scanner s=new Scanner(System.in);
	public Contacts(){
		setName("");
		setUserNumber(0);	
	}
	public Contacts(int userNumber,String name){
		setUserNumber(userNumber);
		setName(name);	
	}

	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setUserNumber(int userNumber){ 
		this.userNumber=userNumber;
		}
	
	public int getUserNumber(){
		return userNumber;
	}
	
	public void registerUser(){
	    userarr[size]=new Contacts();
		try{
		System.out.println("Insert number wanna save");
		userarr[size].setUserNumber(s.nextInt());
		System.out.println("Insert Name");
		userarr[size].setName(s.next());
		}catch(InputMismatchException e){System.out.println(" wrong entery ");
		}
	    System.out.println("contact saved successfully");
		size++;
	}
	
	public void viewContacts(){
		System.out.println("	                    	");
		System.out.println();
		for(int i=0;i<size;i++){
			if(userarr[i]!=null){
				System.out.println("	Name          :"+userarr[i].getName());
				System.out.println("	ContactNumber :"+userarr[i].getUserNumber());
				System.out.println("                                                  ");
	}
		}
	}
	
	public void deleteContact(){
		int num;
		System.out.println("Enter number ");
		num=s.nextInt();
		int a = 0;
		boolean found = false;
		while (a < userarr.length && !found){
			if(userarr[a]!=null){
				if (userarr[a].getUserNumber() == num){
					found = true;
				}else{
					a++;
				}
			}else
				found=false;
		}
		if (found){
			userarr[a]= null;
			System.out.println("Contact  deleted ");
		}else
			System.out.println("not matched");
    }
	
	public int searchUser(int userNumber){
		
		for (int i=0; i<size; i++){
			if (userarr[i].getUserNumber()==userNumber)
				return i;
		}
		return -99;
	} 
	
	void display(){
		int choice;
		do{
			System.out.println(" 0   save contact");
			System.out.println(" 1   view Contacts ");
			System.out.println(" 2   Delete Contact    ");
			System.out.println("    -12 back       ");
			System.out.println();
			System.out.print("Enter option: ");
			choice=s.nextInt();
			System.out.println();
			switch(choice){
				case 0:
					registerUser();
					break;
				case 1:
					viewContacts();
					break;
				case 2:
					deleteContact();
					break;
				default:
					System.out.println("                                        ");
					break;
			}	
		}while(choice!=-12);
	}
}

class Inbox{
	Scanner s=new Scanner(System.in);
    private String[] inboxarr=new String[8]; 
    private int size=0;
	public Inbox(){
		for(int i=0; i<8; i++){
			inboxarr[i]=new String();
		}
	}
     
     public void insertToInbox(String inbox){
		    if(this.size==8)
			this.size=0;
		    this.inboxarr[size]=inbox;
		    this.size++;
	}
    
	public void printInbox(){
		System.out.println("                                                        ");
		System.out.println("        InBox              ");
		System.out.println("        >>>>>>>>>>                                             ");
	
		for(int i=0;i<8;i++){
		 if(inboxarr[i]!=null){
			System.out.println(inboxarr[i]);
		 }
		 
		 
	}
	}
    public void deleteMsg(){
        for(int i=0;i<5;i++){
       		inboxarr[i]=null;
		}
		System.out.println("All messages deleted");
}
}  

class ComposeMsg{
	private String composeMsg;
	public ComposeMsg(){
		setComposeMsg("");
	}
	public ComposeMsg(String composeMsg){
		setComposeMsg(composeMsg);
	}
		
	public void  setComposeMsg(String composeMsg){
		this.composeMsg=composeMsg;
	}
	public String getComposeMsg(){
		return composeMsg;
	}
}

class MsgApp{
	private ComposeMsg objComposeMsg;
	private Inbox objInbox;
	private Contacts objContact;
	private MobileAssign objAssign;


	Scanner s=new Scanner(System.in);
   
	public MsgApp(Contacts cont,MobileAssign mobas){
		objComposeMsg=new ComposeMsg();
		objInbox=new Inbox();
		objContact=cont;
		objAssign=mobas;
	}

	public void sendMsg(){
		try{
		objContact.viewContacts();
	    System.out.println("                                            ");
		System.out.println("Enter  number you want  send msg");
		int number=s.nextInt();
		int flag=objAssign.searchMobile(number);
		if(flag!=-99){
				System.out.println("Enter  message you want  send");
				objComposeMsg.setComposeMsg(s.next());
			    objInbox.insertToInbox(objComposeMsg.getComposeMsg());
				System.out.println("your message has been sent Suceesfully");
                System.out.println("                                              ");				
		}if(flag==-99){
			System.out.println("Not delievered ");
		}
		}catch(InputMismatchException e5){
			System.out.println("wrong input");
		}
	}
	
	public void display(){
		int choice;
		try{
		do{
			System.out.println("   0  inbox     ");
			System.out.println("   1  send message   ");
			System.out.println("   2  delete message ");
			System.out.println("  -11 for Exit        ");
			System.out.println();
			System.out.print("Enter option ");
			choice=s.nextInt();
			System.out.println();
			switch(choice){
				case 0:
					objInbox.printInbox();
					break;
				case 1:
					sendMsg();
					break;
				case 2:
					objInbox.deleteMsg();  
					break;
				default:
					System.out.println("                                             ");
			}	
		}while(choice!=-11);
		}catch(InputMismatchException e4){
			System.out.println("wrong input");
		}
	}	
}

class Calculator{
     public void add(double numberOne,double numberTwo){
	     double total;
	       System.out.println(" Sum of  = " +(total=numberOne+numberTwo));
		   }
     public void Subtract(double numberOne,double numberTwo){
	         double total;
	       System.out.println(" Subtract   = " +(total=numberOne-numberTwo));
	 	   }
     public void Divide(double numberOne,double numberTwo){
	        double total;
	       System.out.println(" Division   = " +(total=numberOne/numberTwo));
		   }
     public void Multiply(double numberOne,double numberTwo){
	         double total;
	       System.out.println(" Multiplication   = " +(total=numberOne*numberTwo));
		   }
}
class ScientificCalculator extends Calculator{
      public void Sin(double number){
		double total=Math.sin(number);
		  System.out.println(" Value of sin  = " +total);
	  }
	   public void Cos(double number){
		  double total=Math.cos(number);
		   System.out.println(" Value of Cos = " +total);
	  }
	   public void Log(double number){
		  double total=Math.log(number);
		   System.out.println(" Value of Log = " +total);
	  }
	  public void Tan(double number){
		  double total=Math.tan(number);
		  System.out.println(" Value of Tan = " +total);
	  }
	   public void SinInverse(double number){
		double total=Math.asin(number);
		  System.out.println(" Value of sin Inverse = " +total);
	  }
	   public void CosInverse(double number){
		  double total=Math.acos(number);
		   System.out.println(" Value of Cos Inverse = " +total);
	  }
	   public void TanInverse(double number){
		  double total=Math.atan(number);
		   System.out.println(" Value of Tan Inverse = " +total);
	  }
	  public void Display(){
		  Scanner s=new Scanner(System.in);
		int choice;
		double number;
		double numberOne;
	     double numberTwo;
		
	   try{
		do{
			
		    System.out.println("0 Add  ");
			System.out.println("1  Subtract  ");
			System.out.println("2  divide    ");
			System.out.println("3  Multiply  ");
			System.out.println("4  Find  value of  Sin  ");
			System.out.println("5  Find  value of  Cos  ");
			System.out.println("6  Find  value of  Tan  ");
			System.out.println("7  Find  value of  LOg  ");
			System.out.println("8  Find  value of  Sin Inverse");
			System.out.println("9  Find  value of  Cos Inverse");
			System.out.println("10  Find  value of  Tan Inverse");
			System.out.println("-1 Back                               ");
			System.out.println("Enter your Choice ");
			choice=s.nextInt();
		
		 switch(choice){
			  case 0:
			      System.out.println("Enter NumberOne  ");
			      numberOne=s.nextDouble();
			      System.out.println("Enter NumberTwo  ");
			      numberTwo=s.nextDouble();
			      add(numberOne,numberTwo);
			   break;
			 case 1:
			      System.out.println("Enter NumberOne ");
			      numberOne=s.nextDouble();
			      System.out.println("Enter NumberTwo" );
			      numberTwo=s.nextDouble();
			      Subtract(numberOne,numberTwo);
			   break;

			 case 2:
			     System.out.println("Enter NumberOne " );
			     numberOne=s.nextDouble();
			     System.out.println("Enter NumberTwo" );
			     numberTwo=s.nextDouble();
			     Divide(numberOne,numberTwo);
			   break;
			 case 3:
			       System.out.println("Enter NumberOne " );
			       numberOne=s.nextDouble();
			       System.out.println("Enter NumberTwo" );
			       numberTwo=s.nextDouble();
			       Multiply(numberOne,numberTwo);
			   break;
			  case 4:
				 System.out.println("Enter Number " );
				 numberOne=s.nextDouble();
				 Sin(numberOne);
				 break;
			 case 5:
				 System.out.println("Enter Number " );
				 numberOne=s.nextDouble();
				 Cos(numberOne);
				 break;
	     	  case 6:
				 System.out.println("Enter Number " );
				 numberOne=s.nextDouble();
				 Tan(numberOne);
	   		 case 7:
				 System.out.println("Enter Number " );
				 numberOne=s.nextDouble();
				 Log(numberOne);
				 break;
			 case 8:
				   System.out.println("Enter Number " );
				   numberOne=s.nextDouble();
				   SinInverse(numberOne);
			      break;
	    	  case 9:
				    System.out.println("Enter Number " );
				    numberOne=s.nextDouble();
				    CosInverse(numberOne);
			        break;
			 case 10:
				    System.out.println("Enter Number " );
				    numberOne=s.nextDouble();
				    TanInverse(numberOne);
			        break;
		 }
		 }while(choice!=-1);
	 }catch(Exception e){System.out.println(" wrong option ");}
	  }
	  
}
class CurrencyConverter{
	double price ;
	public void SaudiaPak(double price){
		double total;
         System.out.println(" Price Of Saudia // Pak =" +(total=40.21*price));  
	    }	
    public void PakSaudia(double price){
		double total;
         System.out.println(" Price Of  Pak //  Saudia =" +(total=0.025*price));  
	    }	
     public void USAPak(double price){
		double total;
         System.out.println(" Price Of USA // Pak =" +(total=150.71*price));  
	    }	
      public void PakUSA(double price){
		double total;
         System.out.println(" Price Of  Pak // USA =" +(total=0.0066*price));  
	    }	
       public void ChinaPak(double price){
		double total;
         System.out.println(" Price Of China // Pak =" +(total=21.84*price));  
	    }	
       public void PakChina(double price){
		double total;
         System.out.println(" Price Of  Pak // China =" +(total=0.046*price));  
	    }
      public void Display(){
		  Scanner s=new Scanner(System.in);
		int choice;
		double price;
		   try{
		do{
			
		  System.out.println("0  Saudia /// Pak ");
		  System.out.println("1  Pak   ///  Saudia ");
		  System.out.println("2  USA  ///  Pak ");
		  System.out.println("3  Pak  ///  USA ");
		  System.out.println("4  China///  Pak ");
		  System.out.println("5  Pak /// China ");
		  System.out.println(" -2  Back ");
		  System.out.println("Enter Your Choice");
		  choice =s.nextInt();
		  switch(choice){
			  case 0:
				    System.out.println("Enter Price " );
				    price=s.nextDouble();
				    SaudiaPak(price);
			        break;
					
			  case 1:
				    System.out.println("Enter Price " );
				    price=s.nextDouble();
				    PakSaudia(price);
			        break;
					
			 case 2:
				    System.out.println("Enter Price " );
				    price=s.nextDouble();
				    USAPak(price);
			        break;
					
			 case 3:
				    System.out.println("Enter Price " );
				    price=s.nextDouble();
				   PakUSA(price);
			        break;
					
			 case 4:
				    System.out.println("Enter Price " );
				    price=s.nextDouble();
				    ChinaPak(price);
			        break;
					
			 case 5:
				    System.out.println("Enter Price " );
				    price=s.nextDouble();
				    PakChina(price);
			        break;
			
		  }
		  }while(choice!=-2);
		}catch(Exception e){System.out.println(" Wrong option ");}
		 
	  }
}

class MobileAssign{
	public MobileAssign mobile[]=new MobileAssign[5];
	private String mobileModel;
	private int mobileNumber;
	int size=0;
	public MobileAssign(){
		setMobileModel("");
		setMobileNumber(0);
		for(int i=0;i<5;i++){
		}
	}
	public MobileAssign(String mobileModel){
		setMobileModel(mobileModel);
		setMobileNumber(0);
		}
	
	
	public void setMobileModel(String mobileModel){
		this.mobileModel=mobileModel;
	}
	public String getMobileModel(){
		return mobileModel;
	}
	public void setMobileNumber(int mobileNumber){
		this.mobileNumber=mobileNumber;
	}
	public int getMobileNumber(){
		return mobileNumber;
	}
	
	Scanner s=new Scanner(System.in);
	
	public void  RegisterMobile(){
		mobile[size]=new MobileAssign();
		try{
		System.out.println("Enter  mobile Number which you wanna  assign  your phone permanently");
		mobile[size].setMobileNumber(s.nextInt());
		System.out.println("Enter your Mobile model");
		mobile[size].setMobileModel(s.next());
		System.out.println("Mobile  registered");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}catch(InputMismatchException e1){System.out.println("wrong option");
		}
		size++;
	}
    
    public int searchMobile(int userNumber){
		
		for (int i=0; i<this.size; i++){
			if (mobile[i].getMobileNumber()==userNumber)	
			    return i;
	    }
	        return -99;
}
	
	public void view(){
		System.out.println("                                                          ");
		for(int i=0;i<this.size;i++){
			if(mobile[i]!=null){
				System.out.println("MobileNumber   "+mobile[i].getMobileNumber());
				System.out.println("Mobile Company "+mobile[i].getMobileModel());
			}
		}
	}
}

class Mobile{
	    private MobileAssign objAssign;
		private Contacts objContact;
		private MsgApp objMsgApp;
		private CurrencyConverter objcc;
		private ScientificCalculator objsc;
		Scanner s =new Scanner(System.in);
		public Mobile(Contacts cont,MsgApp msgApp,MobileAssign mobas,CurrencyConverter currencyConverter,ScientificCalculator scientifictCalculator){
            objContact=cont;
			objMsgApp=msgApp;	
			objAssign=mobas;
            objcc=currencyConverter;
            objsc=scientifictCalculator;	
     			
		}
	
		public void UnlockMobile(){
			Scanner s=new Scanner(System.in);
		    int userNumber;
		    System.out.println("Enter  mobile Number to unlock device ");
		    userNumber=s.nextInt();
		    int flag=objAssign.searchMobile(userNumber);
			System.out.println(flag);
		    if(flag!=-99){
				System.out.println("device unlocked");
			  int choice;
			  try{
			do{
				System.out.println("0   Contacts App ");
				System.out.println("1   Message App ");
				System.out.println("2   currency converter ");
				System.out.println("3   Scientific Calculator ");
				System.out.println("-9  back    ");
				System.out.println("Enter option:");
				choice=s.nextInt();
				switch(choice){
					case 0:
						objContact.display();
						break;
					case 1:
						objMsgApp.display();
						break;
					case 2:
						objcc.Display();  
					case 3:
					    objsc.Display();
					    
					default:  
						System.out.println("                                                              ");
						break;
				}   
			}while(choice!=-9);
			  }catch(InputMismatchException e3){
				  System.out.println("wrong input");
			  }
			}if(flag==-99){
			System.out.println(" try again ");
		}
		}
}
class Main{
	public static void main(String arg[]){
		Scanner s=new Scanner(System.in);
		ScientificCalculator sc=new ScientificCalculator();
		CurrencyConverter cc=new CurrencyConverter();
		MobileAssign objAssign=new MobileAssign();
		Contacts objContact=new Contacts();
		MsgApp  objMsgApp =new MsgApp(objContact,objAssign);
		Mobile objMobile=new Mobile(objContact,objMsgApp,objAssign,cc,sc);
		int choice;
		try{
		do{
			System.out.println(" 0  Register Mobile");
			System.out.println(" 1  UnlockMobile");
			System.out.println(" 2  view list of registered mobiles");
			System.out.println("-8  back menu");
			System.out.println("Enter you choice:");
			choice=s.nextInt();
			switch(choice){
				case 0:
					objAssign.RegisterMobile();
					break;
				case 1:
					objMobile.UnlockMobile();
					break;
				case 2:
				     objAssign.view();
				default:
					System.out.println("                                                              ");
					break;
			}   
		}while(choice!=-8);
		}catch(InputMismatchException e2){
			System.out.println("wrong input");
		}
	}
}

