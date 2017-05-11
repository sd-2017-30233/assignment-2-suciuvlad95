package view;

import controller.BookContr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserFrame{
    private JFrame frame;
    private JPanel panel;
    private JTextField textField;

    public UserFrame ()
    {
        frame = new JFrame();
        frame.setBounds(100, 100, 500,250);
        frame.setTitle("Fereastra angajat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        

        String[] patternExamples = {
                "Titlu",
                "Autor",
                "Gen"
        };
        
        JLabel lblprint = new JLabel("Cautare sau vanzare carti ");
        lblprint.setBounds(35,-30,150,80);
        panel.add(lblprint);
        
        JComboBox comboBox = new JComboBox(patternExamples);
        comboBox.setEditable(false);
        //comboBox.addActionListener(this);
        comboBox.setBounds(126, 50, 100, 20);
        panel.add(comboBox);

        
        JLabel lblSearchBooks = new JLabel("Cautare dupa: ");
        lblSearchBooks.setBounds(35, 50, 100, 14);
        panel.add(lblSearchBooks);

        JButton btnSearch = new JButton("Cautare");
        btnSearch.setBounds(230, 50 , 89, 23);
        panel.add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("search Books");
                String text = comboBox.getSelectedItem().toString();

                if (text.equals("Titlu")) {
                    JTable table =new JTable(BookContr.listBySearchItem("title"));
                    JOptionPane.showMessageDialog(null, new JScrollPane(table));
                }
                else
                if (text.equals("Autor"))
                    {
                        JTable table =new JTable(BookContr.listBySearchItem("author"));
                        JOptionPane.showMessageDialog(null, new JScrollPane(table));
                    }
                else
                if (text.equals("Gen"))
                    {
                        JTable table =new JTable(BookContr.listBySearchItem("genre"));
                        JOptionPane.showMessageDialog(null, new JScrollPane(table));
                    }
            }
        });

        JLabel lblBookTitle = new JLabel("Titlul vanzarii:");
        lblBookTitle.setBounds(30, 90, 90, 15);
        panel.add(lblBookTitle);

        textField = new JTextField();
        textField.setBounds(130, 90, 100, 20);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblquant = new JLabel("Cantitatea :");
        lblquant.setBounds(30, 115, 90, 15);
        panel.add(lblquant);

        JTextField quantField = new JTextField();
        quantField.setBounds(130,115, 100, 20);
        panel.add(quantField);
        quantField.setColumns(5);
                
        JButton btnSell = new JButton("Vinde");
        btnSell.setBounds(236, 115, 90 , 20);
        panel.add(btnSell);
        btnSell.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
               
                String titluVanzarii=textField.getText();
                String quant=quantField.getText();
                
                if (!titluVanzarii.equals("")) {
                	BookContr.updateBook(titluVanzarii,"vinde",null,null,quant);
                    JOptionPane.showMessageDialog(frame, "Carte vanduta!");
                }
                else
                    JOptionPane.showMessageDialog(frame, "Completati datele!","Eroare", JOptionPane.WARNING_MESSAGE);
                

            }
        });

        frame.setVisible(true);
    }

}
