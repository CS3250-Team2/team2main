

   
import java.util.*;
import java.io.*;
import javax.swing.*;  
import javax.swing.border.*;  
import java.awt.*;  
import java.awt.event.*;  
   
public class JavaLogin extends JFrame 
{ 
     
         
    public static void main(String[] args) {
         
        File file = new File("users.txt");
        try
        {
            Scanner scan = new Scanner(file);
             
            while (scan.hasNextLine())
            {
                String line = scan.nextLine();
                System.out.println(line);
            }    
                scan.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
       
        JFrame frame = new JFrame("Log In Here!");  
        frame.setSize(300,150);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
           
        JPanel panel = new JPanel();  
        frame.add(panel);  
        logonComponents(panel);  
        JavaLogin access = new JavaLogin();  
           
        frame.setVisible(true);  
 
private static void logonComponents (JPanel panel) {  
    panel.setLayout(null);  
       
    JLabel user = new JLabel("Username");  
    user.setBounds(10, 10, 80, 25);  
    panel.add(user);  
       
    JTextField text = new JTextField(13);  
    text.setBounds(100, 10, 160, 25);  
    panel.add(text);  
       
    JLabel pass = new JLabel("Password");  
    pass.setBounds(10, 40, 80, 25);  
    panel.add(pass);  
       
    JPasswordField secret = new JPasswordField(13);  
    secret.setBounds(100, 40, 160, 25);  
    panel.add(secret);  
       
    JButton login = new JButton("Access");  
    login.setBounds(10, 80, 120, 25);  
    panel.add(login);  
    login.addActionListener(new ActionListener()
    {
     
     
      public void actionPerformed(ActionEvent e)
      {
        if (text.equals("users.text")) && (secret.equals("users.txt")))
        {
            JOptionPane.showMessageDialog(null,"You're in");
        }   
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid Username or Password. Try again.", "Error Message", JOptionPane.ERROR);
        }
      }        
     
    });
       
    JButton end = new JButton("Cancel");  
    end.setBounds(160, 80, 120, 25);  
    panel.add(end);  
    end.addActionListener(new ActionListener()
    {
     
     
      public void actionPerformed(ActionEvent e)
      {
          System.exit(0);
      }        
     
    });
}
 
 
}
}