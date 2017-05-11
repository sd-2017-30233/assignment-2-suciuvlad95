package view;

import controller.UserContr;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;


public class Login  implements ActionListener{
	 
	JButton btnLog;
	private JFrame frame;
    private JTextField textField;
    private JPasswordField passField;
   

    public Login()
    {
        frame = new JFrame();
        frame.setBounds(400, 400, 500, 500);
        frame.setTitle("Magazin de carti");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.getContentPane().setLayout(null);

        Border compound = null;
        Border redline = BorderFactory.createLineBorder(Color.red);
       compound = BorderFactory.createCompoundBorder( redline, compound);
        JPanel panel = new JPanel();
        panel.setBounds(65, 45, 207, 239);
       // panel.setBackground(Color.RED);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        panel.setBorder(compound);

        textField = new JTextField();
        textField.setBounds(10,30, 86, 20);
        
        panel.add(textField);
        textField.setColumns(15);

        passField = new JPasswordField();
        passField.setBounds(10, 80, 86, 20);
        panel.add(passField);
        passField.setColumns(15);

        btnLog = new JButton("Logare");
        btnLog.setBounds(35, 115, 90, 25);
        panel.add(btnLog);

        JLabel lblUsername = new JLabel("UserName");
        lblUsername.setBounds(10, 11, 73, 14);
        panel.add(lblUsername);

        JLabel lblPassword = new JLabel("Pass");
        lblPassword.setBounds(10, 55, 73, 14);
        panel.add(lblPassword);
        btnLog.addActionListener(this);
        btnLog.setActionCommand("Open");
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();
        String username=textField.getText();
        String password=passField.getText();
        if (username.equals("") || password.equals("")){
        
        	btnLog.setEnabled(false);
        	//btnLog.setVisible(false);
        
            JOptionPane.showMessageDialog(frame, "Completati casetele vide!","Eroare", JOptionPane.WARNING_MESSAGE);
            if(textField.getText().equals(""))
            {
            	textField.setBackground(Color.RED);
            	passField.setBackground(Color.RED);
            }
            else passField.setBackground(Color.RED);
        }
        else {
        	btnLog.setVisible(true);
        	//btnLog.setEnabled(true);
        	
        	//btnLog.setBackground(Color.BLUE);
        	
        	String type = UserContr.getLoginUser(username, password);
            if (cmd.equals("Open") && btnLog.isEnabled())
                if (type.equals("admin")) {
                    frame.dispose();
                    new AdminFrame();
                } else if (type.equals("user")) {
                    frame.dispose();
                    new UserFrame();
                }
                else if (type.equals(""))
                {
                    JOptionPane.showMessageDialog(frame,
                            "User sau parola invalida!","Eroare", JOptionPane.WARNING_MESSAGE);
                    textField.setText("");
                    passField.setText("");
                    btnLog.setEnabled(false);
                }
                else {
                	JOptionPane.showMessageDialog(frame,                
                        "Acest user are un tip diferit de admin sau user!\n Introduceti alta logare","Eroare", JOptionPane.WARNING_MESSAGE);
                	  textField.setText("");
                      passField.setText("");
                      btnLog.setEnabled(false);
                }
        }
     
      
        btnLog.setEnabled(true);
    }
    
    public static void main (String[] args)
    {
        Login login= new Login();
    }
}
