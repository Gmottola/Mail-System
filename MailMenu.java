import java.util.Scanner;
/**
 *
 * Programmer: Greg Mottola
 * 
 * 
 * Using the MailSystem, MailBox, and Message Classes, this program utilizes a menu for our mail system class
 * 
 * 
 *
 */
public class MailMenu {
	public static void main(String[] args)
	{
		MailSystem mySystem = new MailSystem();
		Scanner console = new Scanner(System.in);
		String choice;
		boolean exit = false;
		boolean logout = false;
		do
		{
		System.out.println("L)og In   W)rite Message   I)nbox   S)ent Mail   "
				+ "O)ff-Log Out   E)xit");
		choice = console.next();
		System.out.print("You Choose:  " + choice + "\n");
		if(choice.equals("L") || choice.equals("l"))
		{
			String User ="";
			
			Scanner name = new Scanner(System.in);
			System.out.print("Enter Username: ");
			User = name.nextLine();
			System.out.println("Welcome: " + User);
			System.out.println("L)og In   W)rite Message   I)nbox   S)ent Mail   "
					+ "O)ff-Log Out   E)xit");
			choice = console.next();
			
			do
			{
				if(choice.equals("W") || choice.equals("w"))
				{
					String Recipient = "";
					Message m;
					Scanner Message = new Scanner(System.in);
					String myMessage = "";
					System.out.print("Please enter a recipient:");
					Recipient = name.nextLine();
					m = new Message(User, Recipient);
					System.out.println("Please Enter a Message: ");
					myMessage = Message.nextLine();
					while (!myMessage.equals("") )
					{
						m.append(myMessage);
						myMessage = Message.nextLine();
					}
					mySystem.deliver(m);
					logout = false;
					System.out.println("L)og In   W)rite Message   I)nbox   S)ent Mail   "
							+ "O)ff-Log Out   E)xit");
					choice = console.next();
				}
				if (choice.equals("I") || choice.equals("i"))
				{
					System.out.println("\n" + User + " Inbox");
					mySystem.printMessages(User, "inbox");
					System.out.println("L)og In   W)rite Message   I)nbox   S)ent Mail   "
							+ "O)ff-Log Out   E)xit");
					choice = console.next();
					logout = false;
				}
				if (choice.equals("S") || choice.equals("s"));
				{
					System.out.println("\n" + User + " outbox");
					mySystem.printMessages(User, "outbox");
					System.out.println("L)og In   W)rite Message   I)nbox   S)ent Mail   "
						+ "O)ff-Log Out   E)xit");
					choice = console.next();
					logout = false;
				}
				if(choice.equals("O")|| choice.equals("o"))
				{
					logout = true;
					System.out.println("Logged Out");
				}
			}while(!logout);
		}else if (choice.equals("E") || choice.equals("e"))
		{
			exit = true;
			System.out.println("System Shutting Down.");
		}else
		{
			System.out.println("Please Log In First");
		}
		
		
		}while(!exit);
	}

}
