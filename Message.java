/**
 * This class sets up a model format for an email
 * @author Gregory
 *
 */
public class Message {
	
	private String recipientName;
	private String senderName;
	private String messageBody;
	/**
	 * parameters r and s are used to input the senders and recipients name
	 * and sets the message body to be empty
	 * @param r
	 * @param s
	 */
	public Message(String r, String s)
	{
		recipientName = s;
		senderName = r;
		messageBody ="";
	}
	/**
	 * returns the senders name
	 * @return
	 */
	public String getSender()
	{
		return senderName;
	}
	/**
	 * returns the recipients name
	 * @return
	 */
	public String getRecipient()
	{
		return recipientName;
	}
	/**
	 * adds new lines onto the message body
	 * @param a
	 */
	public void append(String a)
	{
		messageBody = messageBody + a + '\n';
	}
	/**
	 * formats the entire email to look proper
	 */
	public String toString ()
	{
		return "From: " +senderName+ "\nTo: "+recipientName+"\n\n" + messageBody;
	}
	

}
