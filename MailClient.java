
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
    private MailItem items;// the last message
     // Es spam
    private boolean spam;
    
    /**
     * Constructor for objects of class MailClient with parametres server and user
     */
    public MailClient( MailServer server, String user)
    {
        // initialise instance variables server and user 
        this.server = server;
        this.user = user;
        this.items = items;//yo no lo  inciciaría
        this.spam = spam;
    }

    /**
     * A method call getNextMailItem that recover of the server the objet user and return it.
     * no cambiastes este método
     */
    public MailItem getNexMailItem()
    {
        MailItem item = server.getNextMailItem(user);
        if (item == null){
            spam = false;
            return item;
        }
        else if((item.getMessage().contains("promocion"))||(item.getMessage().contains("regalo"))) {
            spam = true;
            return null;
        }
        else {
            return item;
        }
    }
    /**
     * A method call ShowMailItem that show the messages in the server.
     * 
     */
    public void showMailItem()
    {
        
        System.out.println( "Tiene usted " + server.howManyMailItems (user) + " mensajes");
    }
   
    /**
     * A method call printtNextMailItem that recover of the server the next mail and return it and diference if be spam or not spam.
     * 
     */
    public void printNexMailItem()
   {
        MailItem item = server.getNextMailItem(user);
        if(item == null) {
            if (spam == true){
                System.out.println("Se ha recibido spam");
            }
            else{
                System.out.println("No new mail.");
            }
        }
        else {
            if (item.getMessage().contains("trabajo")){
                item.print();
            }
            else{
                item.print();
            }
        }
    }
           
        
        
    

      /**
     * A method call printLastMailItem that show the last mail.
     * 
     */
    public void printLastMailItem()
    {
        MailItem item = server.getNextMailItem (user);
        if (items == null)
        {
            System.out.println ("No new mail.");
        }
        else

            {
              items.print ();
            }
        }

    
    /**
     * A method call getNextMailItemAndAutorespond that recover of the server the next mail and return other different ("No estoy en la oficina"),
     * the same message has  the prefix "Re" too.
     */
    public void getNexMailItemAndAutorespond()
    {
        {
        MailItem item = server.getNextMailItem (user);

        if (item == null)
        {
            if (spam == true){
                System.out.println("Se ha recibido spam");
            }
            else{
                System.out.println("No new mail.");
            }
            
        }
        else
        {   
            // \n salta a una nueva línea
            // \t introduce un tabulador

            sendMailItem (item.getFrom(),"Re"  + item.getSubject(),"No estoy en la oficina.\n\t" + item.getMessage() );

        }

       }
         
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
