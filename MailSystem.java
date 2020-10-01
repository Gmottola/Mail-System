import java.util.ArrayList;
/**
 * This class sets up a mail system to hold a variety of mailboxes and messages within the mail
 * @author Gregory
 *
 */
public class MailSystem {
	private ArrayList<Mailbox> mbList;
	/**
	 * set up an arraylist of mailboxes 
	 */
	public MailSystem()
	{
		mbList = new ArrayList<Mailbox>();
	}
	/**
	 * prameter M is passed through to put a message into 2 mailboxes, the senders outbox and recievers inbox
	 * @param m
	 */
	public void deliver(Message m)
	{
		String reciever = m.getRecipient();
		String sender = m.getSender();
		/**
		 * if else statement checks if the reciever is already in the mailSystem and sets up a mailbox for them if they dont, then adds the messafe into their mailbox
		 */
		if(getIndex(reciever)== -1)
		{
			Mailbox recieverMailbox = new Mailbox(reciever);
			recieverMailbox.addMessage(m);
			mbList.add(recieverMailbox);
		}else
		{
			Mailbox recieverMailbox = mbList.get(getIndex(reciever));
			recieverMailbox.addMessage(m);
		}
		/**
		 * if else statement checks if the sender is already in the mailSystem and sets up a mailbox for them if they dont, then adds the messafe into their mailbox
		 */
		if(getIndex(sender)== -1)
		{
			Mailbox senderMailbox = new Mailbox(sender);
			senderMailbox.addMessage(m);
			mbList.add(senderMailbox);
		}else
		{
			Mailbox senderMailbox = mbList.get(getIndex(sender));
			senderMailbox.addMessage(m);
		}
	}
	/**
	 * owner is the owner of the mailbox
	 * message type is whether or not the message is in the owners in or out box
	 * @param owner
	 * @param messageType
	 */
	public void printMessages(String owner, String messageType)
	{
		/**
		 * if statement to check id the user is in the mail system, and if they aren't no messages is displayed
		 * nested if statments will go through the mail system and check each user and print out their in boxes and out boxes
		 * if a user does not have anything in their mailbox no message will be displayed
		 */
		if(getIndex(owner) == -1)
		{
			System.out.println("No messages");
		}
		else
		{
			Mailbox ownerMailbox = mbList.get(getIndex(owner));
			if(messageType.equalsIgnoreCase("outbox"))
			{
				boolean messageFound= false;
					for( int i = 0; i < ownerMailbox.getSize(); i++)
					{
						Message m = ownerMailbox.getMessage(i);
						if(m.getSender().equalsIgnoreCase(owner))
						{
							System.out.println(m.toString());
							messageFound = true;
						}
					}
					if(!messageFound)
					{
						System.out.println("No Messages");
					}
				
			}else if(messageType.equalsIgnoreCase("inbox"))
			{
				boolean messageFound = false;
					for( int i = 0; i < ownerMailbox.getSize(); i++)
					{
						Message m = ownerMailbox.getMessage(i);
						if(m.getRecipient().equalsIgnoreCase(owner))
						{
							System.out.println(m.toString());
							messageFound = true;
						}
					}
					if(!messageFound)
					{
						System.out.println("No Messages");
					}
				
			}
		}
	}
	
	/**
	 * uses parameter owner to check the users location index in the mail system and returns said index
	 * if a user is not in the mail system a -1 is returned
	 * @param owner
	 * @return
	 */
	private int getIndex(String owner)
	{
		int getIndex = -1;
		for(int i = 0; i < mbList.size(); i ++)
		{
			Mailbox b = mbList.get(i);
			String bOwner = b.getOwner();
			if(bOwner.equalsIgnoreCase(owner))
			{
				getIndex = i;
			}
		}
		return getIndex;
	}

}
