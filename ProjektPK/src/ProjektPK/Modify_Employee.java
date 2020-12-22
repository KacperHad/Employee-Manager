
package ProjektPK;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author kacpe
 */
public class Modify_Employee implements ActionListener {
    JFrame fUpdate;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    JButton b1,b2,b3,b4;
    String show;
    
    Modify_Employee(){
        fUpdate = new JFrame("Modyfikuj dane");
        fUpdate.setVisible(true);
        fUpdate.setSize(900,500);
        fUpdate.setLocation(450,250);
        fUpdate.setBackground(Color.WHITE);
        fUpdate.setLayout(null);
        fUpdate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fUpdate.getContentPane().setBackground(Color.lightGray);
        
        l1= new JLabel("Wpisz pracownika:");
        l1.setBounds(50,50,250,30);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("serif",Font.BOLD,25));
        fUpdate.add(l1);
        
        t1 = new JTextField();
        t1.setBounds(255,50,150,30);
        fUpdate.add(t1);
        
        b3 = new JButton("Szukaj");
        b3.setBounds(410,50,100,30);
        b3.addActionListener(this);
        fUpdate.add(b3);
        
        l2 = new JLabel("Imie i Nazwisko:");
        l2.setBounds(200,125,100,30);
        fUpdate.add(l2);
        
        t2 = new JTextField();
        t2.setBounds(200,150,150,30);
        fUpdate.add(t2);
        
        l3 = new JLabel("Adres:");
        l3.setBounds(200,185,350,30);
        l3.setForeground(Color.BLACK);
        fUpdate.add(l3);
        
        t3 = new JTextField();
        t3.setBounds(200,210,150,30);
        fUpdate.add(t3);
        
        l4 = new JLabel("Stanowisko:");
        l4.setBounds(580,125,350,30);
        l4.setForeground(Color.BLACK);
        fUpdate.add(l4);
        
        t4 = new JTextField();
        t4.setBounds(580,150,150,30);
        fUpdate.add(t4);
        
        l5 = new JLabel("Miasto:");
        l5.setBounds(200,245,350,30);
        l5.setForeground(Color.BLACK);
        fUpdate.add(l5);
        
        t5 = new JTextField();
        t5.setBounds(200,270,150,30);
        fUpdate.add(t5);
        
        l6 = new JLabel("Data rozpoczecia pracy:");
        l6.setBounds(580,185,350,30);
        l6.setForeground(Color.BLACK);
        fUpdate.add(l6);
        
        t6 = new JTextField();
        t6.setBounds(580,210,150,30);
        fUpdate.add(t6);
        
        l7 = new JLabel("Numer Telefonu:");
        l7.setBounds(200,305,350,30);
        l7.setForeground(Color.BLACK);
        fUpdate.add(l7);
        
        t7 = new JTextField();
        t7.setBounds(200,330,150,30);
        fUpdate.add(t7);
        
        l8 = new JLabel("Pensja miesieczna:");
        l8.setBounds(580,245,350,30);
        l8.setForeground(Color.BLACK);
        fUpdate.add(l8);
        
        t8 = new JTextField();
        t8.setBounds(580,270,150,30);
        fUpdate.add(t8);
        
        b1 = new JButton("Aktualizuj");
        b1.setBounds(350,400,100,30);
        b1.addActionListener(this);
        fUpdate.add(b1);
        
        b2 = new JButton("Cofnij");
        b2.setBounds(500,400,100,30);
        b2.addActionListener(this);
        fUpdate.add(b2);
        b2.setVisible(true);
        
        fUpdate.setVisible(true);
        fUpdate.setSize(900,500);
        fUpdate.setLocation(400,100);
    }
    


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b3){
            try{
            Connect conn = new Connect();
            String q = "Select * FROM pracownicy WHERE Imie_Nazwisko ='"+t1.getText()+"'";
            ResultSet rs= conn.s.executeQuery(q);
            
            if(rs.next()){
                fUpdate.setVisible(true);
                
                t2.setText(rs.getString(1));
                t3.setText(rs.getString(2));
                t4.setText(rs.getString(4));
                t5.setText(rs.getString(3));
                t6.setText(rs.getString(5));
                t7.setText(rs.getString(6));
                t8.setText(rs.getString(7));  
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Blad: "+ ex);
        }
        }
        if(e.getSource()==b1){
            try{
                Connect conn = new Connect();
                String q = "Update pracownicy set Imie_Nazwisko='"+t2.getText()+"',Adres='"+t3.getText()+"',Miasto='"+t5.getText()+"',Stanowisko='"+t4.getText()+"',Data_rozpoczecia='"+t6.getText()+"',Telefon='"+t7.getText()+"',Pensja='"+t8.getText()+"' where Imie_Nazwisko='"+t1.getText()+"'";
                conn.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Pomyslnie zakutalizowano");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Blad:"+ex);
            }
            fUpdate.setVisible(false);
            new Main();
            
        }
        if(e.getSource()==b2){
            fUpdate.setVisible(false);
            new Main();
        }
    }
    
     public static void main(String[] args){
        new Modify_Employee();
    }
    
}
