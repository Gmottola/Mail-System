import java.util.ArrayList;
/**
 * this class uses the message class to set up a mailbox that holds messages
 * @author Gregory
 *
 */
public class Mailbox {
	private ArrayList<Message> list;
	private String owner;
	/**
	 * parameter m is used to set the name of the mailboxes owner
	 * list sets up an arraylist of messages
	 * @param m
	 */
	public Mailbox (String m)
	{
		owner = m;
		list = new ArrayList<Message>();
	}
	/*
	 * returns the owner of the mailbox
	 */
	public String getOwner()
	{
		return owner;
	}
	/**
	 * parameter m is used to add a message to the mailbox
	 * @param m
	 */
	public void addMessage(Message m)
	{
		list.add(m);
	}
	/**
	 * parameter i is used return the message at index i
	 * @param i
	 * @return
	 */
	public Message getMessage(int i)
	{
		return list.get(i);
	}
	/**
	 * parameter i is used to remove a message at index i
	 * @param i
	 */
	public void removeMessage(int i)
	{
		list.remove(i);
	}
	/**
	 * returns the size of the mailbox
	 * @return
	 */
	public int getSize()
	{
		return list.size();
	}

}
