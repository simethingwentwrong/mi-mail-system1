
/**
 * Write a description of class MailClient here.
 * Create objects call clients that send messages and uses server to do that.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailClient
{
    // instance variables 
    private MailServer server;//server asociated with the client
    private String user; //user server´s adress

    /**
     * Constructor for objects of class MailClient with parametres server and user
     */
    public MailClient( MailServer server, String user)
    {
        // initialise instance variables server and user
        this.server = server;
        this.user = user;
    }

    /**
     * A method call getNextMailItem that recover of the server the objet user and return it.
     * 
     */
    public MailItem getNexMailItem()
    {
        
        return server.getNextMailItem (user);
    }
    /**
     * A method call set it.
     * 
     */
    public void showMailItem()
    {
        
        System.out.println( server.howManyMailItems (user));
    }
    /**
     * A method call printtNextMailItem that recover of the server the next mail and return it.
     * 
     */
    public MailItem printNexMailItem()
    {
        MailItem item = server.getNextMailItem (user);
        if (item == null)
        {
            System.out.println ("No new mail.");
        }
        else
        {
            item.print ();
        }
        return server.getNextMailItem (user);
    }
    
    /**
     * A method call sendMailItem that have two String parametres to and message, creates an email (MailItem object)
     *with those parametres and sends to served asociate with these client.
     *
     */
    public void sendMailItem (String to,String message, String subject)
    {
        MailItem item = new MailItem (user,to, message, subject);
        server.post (item); //send to server with method post
    }
}
