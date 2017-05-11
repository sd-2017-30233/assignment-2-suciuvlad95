package view;

import controller.BookContr;
import controller.UserContr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminFrame {
    private JFrame frame,frame1,frame2;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField priceField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField stField_13;
    private JTextField textField_14;
    private JTextField textField_15;
    public AdminFrame()
    {
        frame = new JFrame();
        frame.setBounds(100, 100, 300,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        JButton btnCarti = new JButton("Modifica Carti");
        btnCarti.setBounds(79, 164, 150, 23);
        panel.add(btnCarti);
        
      
        
        btnCarti.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	frame.dispose();
            	 frame1 = new JFrame();
                 frame1.setBounds(100, 100, 800, 500);
                 frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                 frame1.setTitle("Modificari la carti by ADMIN");
                 JPanel panel1 = new JPanel();
                 frame1.getContentPane().add(panel1, BorderLayout.CENTER);
                 panel1.setLayout(null);
            	 JLabel lblBook = new JLabel("Book");
                 lblBook.setBounds(10, 11, 46, 14);
                 panel1.add(lblBook);

                 JLabel lblTitle = new JLabel("Title");
                 lblTitle.setBounds(10, 36, 46, 14);
                 panel1.add(lblTitle);

                 JLabel lblAuthor = new JLabel("Author");
                 lblAuthor.setBounds(10, 61, 46, 14);
                 panel1.add(lblAuthor);

                 JLabel lblGenre = new JLabel("Genre");
                 lblGenre.setBounds(10, 86, 46, 14);
                 panel1.add(lblGenre);

                 JLabel lblQuantity = new JLabel("Quantity");
                 lblQuantity.setBounds(10, 111, 73, 14);
                 panel1.add(lblQuantity);

                 JLabel lblPrice = new JLabel("Price");
                 lblPrice.setBounds(10, 136, 46, 14);
                 panel1.add(lblPrice);

                 textField = new JTextField();
                 textField.setBounds(82, 33, 86, 20);
                 panel1.add(textField);
                 textField.setColumns(10);

                 textField_1 = new JTextField();
                 textField_1.setBounds(82, 58, 86, 20);
                 panel1.add(textField_1);
                 textField_1.setColumns(10);

                 textField_2 = new JTextField();
                 textField_2.setBounds(82, 83, 86, 20);
                 panel1.add(textField_2);
                 textField_2.setColumns(10);

                 textField_3 = new JTextField();
                 textField_3.setBounds(82, 108, 86, 20);
                 panel1.add(textField_3);
                 textField_3.setColumns(10);

                 priceField_4 = new JTextField();
                 priceField_4.setBounds(82, 133, 86, 20);
                 panel1.add(priceField_4);
                 priceField_4.setColumns(10);

                 JButton btnNewBook = new JButton("New Book");
                 btnNewBook.setBounds(79, 164, 115, 23);
                 panel1.add(btnNewBook);
                 btnNewBook.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent arg0) {
                     System.out.println("Update Title");
                     String title=textField.getText();
                     String author=textField_1.getText();
                     String genre=textField_2.getText();
                     String quantity=textField_3.getText();
                     String price=priceField_4.getText();

                     if (!title.equals("") && !author.equals("") && !genre.equals("") && !quantity.equals("") && !price.equals("")) {
                         BookContr.addBook(title,author,genre,quantity,price);
                         JOptionPane.showMessageDialog(frame1,
                                 "Carte adaugata!");
                     }
                     else
                     {
                         JOptionPane.showMessageDialog(frame1,
                                 "Completati campurile corespunzator!","Eroare",
                                 JOptionPane.WARNING_MESSAGE);
                     }
                 }
             });

                 JLabel lblNewTitle = new JLabel("New Title");
                 lblNewTitle.setBounds(178, 36, 73, 14);
                 panel1.add(lblNewTitle);

                 JLabel lblNewAuthor = new JLabel("New Author");
                 lblNewAuthor.setBounds(178, 61, 73, 14);
                 panel1.add(lblNewAuthor);

                 JLabel lblNewGenre = new JLabel("New Genre");
                 lblNewGenre.setBounds(178, 86, 73, 14);
                 panel1.add(lblNewGenre);

                 JLabel lblNewQuantity = new JLabel("New Quant.");
                 lblNewQuantity.setBounds(178, 111, 73, 14);
                 panel1.add(lblNewQuantity);

                 JLabel lblNewPrice = new JLabel("New Price");
                 lblNewPrice.setBounds(178, 136, 73, 14);
                 panel1.add(lblNewPrice);

                 textField_5 = new JTextField();
                 textField_5.setBounds(261, 33, 86, 20);
                 panel1.add(textField_5);
                 textField_5.setColumns(10);

                 textField_6 = new JTextField();
                 textField_6.setBounds(261, 58, 86, 20);
                 panel1.add(textField_6);
                 textField_6.setColumns(10);

                 textField_7 = new JTextField();
                 textField_7.setBounds(261, 83, 86, 20);
                 panel1.add(textField_7);
                 textField_7.setColumns(10);

                 textField_8 = new JTextField();
                 textField_8.setBounds(261, 108, 86, 20);
                 panel1.add(textField_8);
                 textField_8.setColumns(10);

                 textField_9 = new JTextField();
                 textField_9.setBounds(261, 133, 86, 20);
                 panel1.add(textField_9);
                 textField_9.setColumns(10);

                 JButton btnUpdateTitle = new JButton("Update Title");
                 btnUpdateTitle.setBounds(357, 32, 122, 23);
                 panel1.add(btnUpdateTitle);
                 btnUpdateTitle.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent arg0) {
                         System.out.println("Update Title");
                         String oldTitle=textField.getText();
                         String newTitle=textField_5.getText();
                         //String r=role.getText();
                         if (!oldTitle.equals("") && !newTitle.equals("")) {
                             BookContr.updateBook("","title",oldTitle,newTitle,null);
                             JOptionPane.showMessageDialog(frame1,
                                     "Titlu actualizat!");
                         }
                         else
                         {
                             JOptionPane.showMessageDialog(frame1,
                                     "Completati campurile corespunzator!","Eroare",
                                     JOptionPane.WARNING_MESSAGE);
                         }
                     }
                 });

                 JButton btnUpdateAuthor = new JButton("Update Author");
                 btnUpdateAuthor.setBounds(357, 57, 122, 23);
                 panel1.add(btnUpdateAuthor);
                 btnUpdateAuthor.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent arg0) {
                     System.out.println("Update Author");
                     String newAuthor=textField_6.getText();
                     String oldTitle=textField.getText();
                     //String r=role.getText();
                     if (!newAuthor.equals("") && !oldTitle.equals("")) {
                         BookContr.updateBook(oldTitle,"author",null,newAuthor,null);
                         JOptionPane.showMessageDialog(frame1,
                                 "Autor actualizat!");
                     }
                     else
                     {
                         JOptionPane.showMessageDialog(frame1,
                                 "Completati campurile corespunzator!","Eroare",
                                 JOptionPane.WARNING_MESSAGE);
                     }
                 }
             });

                 JButton btnUpdateGenre = new JButton("Update Genre");
                 btnUpdateGenre.setBounds(357, 82, 122, 23);
                 panel1.add(btnUpdateGenre);
                 btnUpdateGenre.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent arg0) {
                     System.out.println("Update Genre");
                     //String oldGenre=textField_2.getText();
                     String newGenre=textField_7.getText();
                     String title=textField.getText();
                     //String r=role.getText();
                     if (!newGenre.equals("") && !title.equals("")) {
                         BookContr.updateBook(title,"genre",null,newGenre,null);
                         JOptionPane.showMessageDialog(frame1,
                                 "Gen actualizat!");
                     }
                     else
                     {
                         JOptionPane.showMessageDialog(frame1,
                                 "Completati campurile corespunzator!","Eroare",
                                 JOptionPane.WARNING_MESSAGE);
                     }
                 }
             });

                 JButton btnUpdateQuantity = new JButton("Update Quant.");
                 btnUpdateQuantity.setBounds(357, 107, 122, 23);
                 panel1.add(btnUpdateQuantity);
                 btnUpdateQuantity.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent arg0) {
                         System.out.println("Update Quantity");
                        // String oldQ=textField_3.getText();
                         String newQ=textField_8.getText();
                         String title=textField.getText();
                         //String r=role.getText();
                         if ( !newQ.equals("") && !title.equals("")) {
                             BookContr.updateBook(title,"quantity",null,newQ,null);
                             JOptionPane.showMessageDialog(frame1,
                                     "Cantitate actualizata!");
                         }
                         else
                         {
                             JOptionPane.showMessageDialog(frame1,
                                     "Completati campurile corespunzator!","Eroare",
                                     JOptionPane.WARNING_MESSAGE);
                         }
                     }
                 });

                 JButton btnUpdatePrice = new JButton("Update Price");
                 btnUpdatePrice.setBounds(357, 132, 122, 23);
                 panel1.add(btnUpdatePrice);
                 btnUpdatePrice.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent arg0) {
                     System.out.println("Update Author");
                     //String oldPrice=textField_1.getText();
                     String newPrice=textField_6.getText();
                     String title=textField.getText();
                     //String r=role.getText();
                     if (!newPrice.equals("") && !title.equals("")) {
                         BookContr.updateBook(title,"price",null,newPrice,null);
                         JOptionPane.showMessageDialog(frame1,
                                 "Pret actualizat!");
                     }
                     else
                     {
                         JOptionPane.showMessageDialog(frame1,
                                 "Completati campurile corespunzator!","Eroare",
                                 JOptionPane.WARNING_MESSAGE);
                     }
                 }
             });

                 JButton btnDeleteBook = new JButton("Sterge Carte");
                 btnDeleteBook.setBounds(79, 189, 115, 23);
                 panel1.add(btnDeleteBook);
                 btnDeleteBook.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent arg0) {
                         //System.out.println("View Client");
                         String title=textField.getText();
                         //String r=role.getText();
                         if (!title.equals("")) {
                             BookContr.deleteBook(title);
                             JOptionPane.showMessageDialog(frame1,
                                     "Carte stearsa!");
                         }
                         else
                         {
                             JOptionPane.showMessageDialog(frame1,
                                     "Completati campurile corespunzator!","Eroare",
                                     JOptionPane.WARNING_MESSAGE);
                         }

                     }
                 });

                 JButton btnListBooks = new JButton("Afisare Stoc");
                 btnListBooks.setBounds(357, 164, 122, 23);
                 panel1.add(btnListBooks);
                 btnListBooks.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent arg0) {
                         //System.out.println("View Client");
                         JTable table =new JTable(BookContr.listAllBooks());
                         JOptionPane.showMessageDialog(null, new JScrollPane(table));
                     }
                 });
                 JButton btnInapoi = new JButton("Inapoi");
                 btnInapoi.setBounds(79, 250, 115, 23);
                 panel1.add(btnInapoi);
                 
                 btnInapoi.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent arg0) {
                     	
                     	 frame = new JFrame();
                          frame.setBounds(100, 100, 800, 500);
                          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                          JPanel panel = new JPanel();
                          frame.getContentPane().add(panel, BorderLayout.CENTER);
                          panel.setLayout(null);
                          frame.setVisible(true);
                          frame1.setVisible(false);
                         
                          
                          
                     } 
                 });
                 frame1.setVisible(true);
            }
        });
        
        
        ///////////////////////////////////////////////////////////////////
        JButton btnAngajati = new JButton("Modifica Angajati");
        btnAngajati.setBounds(79, 250, 150, 23);
        panel.add(btnAngajati);
        
        btnAngajati.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	
            	frame.dispose();
            	 frame2 = new JFrame();
                 frame2.setBounds(100, 100, 500, 500);
                 frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 frame2.setTitle("Modificari la angajati by admin");
                 
                 JPanel panel2 = new JPanel();
                 frame2.getContentPane().add(panel2, BorderLayout.CENTER);
                 panel2.setLayout(null);
                 
                 
            	JLabel lblUser = new JLabel("Modificari");
                lblUser.setBounds(200, 11, 60, 20);
                panel2.add(lblUser);

                JLabel lblUsername = new JLabel("User");
                lblUsername.setBounds(100, 36, 66, 14);
                panel2.add(lblUsername);
                
                textField_10 = new JTextField();
                textField_10.setBounds(200, 33, 86, 20);
                panel2.add(textField_10);
                textField_10.setColumns(12);

                JLabel lblPassword = new JLabel("Parola");
                lblPassword.setBounds(100, 61, 66, 14);
                panel2.add(lblPassword);
                
                JTextField textField_11 = new JTextField();
                textField_11.setBounds(200, 58, 86, 20);
                panel2.add(textField_11);
                textField_11.setColumns(10);

                JLabel lblType = new JLabel("Tip");
                lblType.setBounds(100, 86, 46, 14);
                panel2.add(lblType);             

                JTextField textField_12 = new JTextField();
                textField_12.setBounds(200, 83, 86, 20);
                panel2.add(textField_12);
                textField_12.setColumns(10);

                JLabel lblNewUsername = new JLabel("Username nou");
                lblNewUsername.setBounds(100, 111, 96, 14);
                panel2.add(lblNewUsername);

                JTextField textField_13 = new JTextField();
                textField_13.setBounds(200, 108, 86, 20);
                panel2.add(textField_13);
                textField_13.setColumns(10);

                JLabel lblNewPassword = new JLabel("Parola noua");
                lblNewPassword.setBounds(100, 136, 86, 14);
                panel2.add(lblNewPassword);

                textField_14 = new JTextField();
                textField_14.setBounds(200, 133, 86, 20);
                panel2.add(textField_14);
                textField_14.setColumns(10);

                JLabel lblNewType = new JLabel("New Type");
                lblNewType.setBounds(100, 161, 66, 14);
                panel2.add(lblNewType);

                textField_15 = new JTextField();
                textField_15.setBounds(200, 158, 86, 20);
                panel2.add(textField_15);
                textField_15.setColumns(12);

                JButton btnNewUser = new JButton("User Nou");
                btnNewUser.setBounds(80, 200, 106, 23);
                panel2.add(btnNewUser);
                
                String username = textField_10.getText();
                String password = textField_11.getText();
                String type = textField_12.getText();
                String newUser = textField_13.getText();
                String newPass=  textField_14.getText();
                String newType = textField_15.getText();
                
                btnNewUser.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {

                       if (!username.equals("") && !password.equals("") && !type.equals("")) {
                            UserContr.addUser(username,password,type);
                            JOptionPane.showMessageDialog(frame2,  "User nou adaugat cu succes!");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(frame2,  "Completati tot necesarul!","Eroare",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                                                        
                    }
                });

                JButton btnUpdateUser = new JButton("Update User");
                btnUpdateUser.setBounds(80, 250, 106, 23);
                panel2.add(btnUpdateUser);
                
                btnUpdateUser.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {

                        //String username = textField_10.getText();
                        //String newUser = textField_13.getText();
                        //String newPass=  textField_14.getText();
                        //String newType = textField_15.getText();
                        if (!username.equals("") && !newUser.equals("") && !newPass.equals("") && !newType.equals("")) {
                            UserContr.updateUser(username,newUser,newPass,newType);
                            JOptionPane.showMessageDialog(frame2, "User actualizat!");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(frame2, "Completati campurile corespunzator!","Eroare",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                        //JTable table =new JTable(UserController.listAllUsers());
                        System.out.println("New User");
                        // JOptionPane.showMessageDialog(null, new JScrollPane(table));
                    }
                });

                JButton btnDeleteUser = new JButton("Sterge User");
                btnDeleteUser.setBounds(220, 200, 106, 23);
                panel2.add(btnDeleteUser);
                btnDeleteUser.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        System.out.println("Delete User");
                        String username = textField_10.getText();

                        if (!username.equals("")) {
                            UserContr.deleteUser(username);
                            JOptionPane.showMessageDialog(frame2, "User sters!");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(frame2,  "Completati campurile corespunzator!","Eroare",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                      
                        System.out.println("User nou");
                      
                    }
                });

                JButton btnListUsers = new JButton("Afisare Useri");
                btnListUsers.setBounds(350, 250, 120, 23);
                panel2.add(btnListUsers);
                
                btnListUsers.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {

                        JTable table =new JTable(UserContr.listAllUsers());
                        JOptionPane.showMessageDialog(null, new JScrollPane(table));
                    }
                });
                
                JButton btnPDF = new JButton("PDF");
                btnPDF.setBounds(220, 250, 106, 23);
                panel2.add(btnPDF);
                
                btnPDF.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        //System.out.println("View Client");
                        BookContr.generateReport("PDF");
                        JOptionPane.showMessageDialog(frame2, "Raport alcatuit!");
                    }
                });

                JButton btnCSV = new JButton("CSV");
                btnCSV.setBounds(350, 200, 120, 23);
                panel2.add(btnCSV);
                
                btnCSV.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        //System.out.println("View CSV");
                        BookContr.generateReport("CSV");
                        //JOptionPane.showMessageDialog(frame2, "Raport Creat!");
                    }
                });
                
              
                frame2.setVisible(true);
            }
            
        });

        frame.setVisible(true);
       
    }
//public static void main(String[] args)
 //   {
 //      AdminFrame ad = new AdminFrame();
  //  }

}