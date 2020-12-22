
package ProjektPK;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Remove_Employee implements ActionListener {
    JFrame fRemove;
    JTextField t;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton b1,b2,b3;

    Remove_Employee(){
        fRemove = new JFrame("Usun pracownika");
        fRemove.setBackground(Color.GREEN);
        fRemove.setLayout(null);
        fRemove.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fRemove.getContentPane().setBackground(Color.lightGray);

        l1= new JLabel();
        l1.setBounds(0,0,500,500);
        l1.setLayout(null);
        fRemove.add(l1);

        l2= new JLabel("Imię i nazwisko:");
        l2.setBounds(50,50,250,30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("serif",Font.BOLD,25));
        fRemove.add(l2);

        t = new JTextField();
        t.setBounds(250,50,150,30);
        fRemove.add(t);

        b1 = new JButton("Szukaj");
        b1.setBounds(270,100,100,30);
        b1.addActionListener(this);
        fRemove.add(b1);

        l3 = new JLabel("Imie i Nazwisko:");
        l3.setBounds(50,150,250,30);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("serif",Font.BOLD,20));
        fRemove.add(l3);
        
        l6 = new JLabel();
        l6.setBounds(200,150,350,30);
        l6.setForeground(Color.BLACK);
        fRemove.add(l6);
        
        l4 = new JLabel("Adres:");
        l4.setBounds(50,190,350,30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("serif",Font.BOLD,20));
        fRemove.add(l4);
        
        l7 = new JLabel();
        l7.setBounds(200,190,360,30);
        l7.setForeground(Color.BLACK);
        fRemove.add(l7);

        l5 = new JLabel("Stanowisko:");
        l5.setBounds(50,230,250,30);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("serif",Font.BOLD,20));
        fRemove.add(l5);
        
        l8 = new JLabel();
        l8.setBounds(200,230,250,30);
        l8.setForeground(Color.BLACK);
        fRemove.add(l8);

        b2 = new JButton("Usun");
        b2.setBounds(120,300,100,30);
        b2.addActionListener(this);
        fRemove.add(b2);

        b3 = new JButton("Wroc");
        b3.setBounds(300,300,100,30);
        b3.addActionListener(this);
        fRemove.add(b3);

        l2.setVisible(true);
        b1.setVisible(true);

        fRemove.setSize(500,500);
        fRemove.setLocation(500,250);
        fRemove.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==b1){
                  try{
                      Connect conn = new Connect();
                      String q = "Select Imie_Nazwisko,Adres,Stanowisko FROM pracownicy WHERE Imie_Nazwisko ='"+t.getText()+"'";
                      ResultSet rs= conn.s.executeQuery(q);
                      if(rs.next()){
                          String ImieNaziwsko = rs.getString(1);
                          String Adres = rs.getString(2);
                          String Stanowisko = rs.getString(3);
                          
                          l3.setVisible(true);
                          l4.setVisible(true);
                          l5.setVisible(true);
                          b2.setVisible(true);
                          b3.setVisible(true);
                          l6.setText(ImieNaziwsko);
                          l7.setText(Adres);
                          l8.setText(Stanowisko);
                      }
                  }catch(Exception ex){
                      JOptionPane.showMessageDialog(null,"Blad:" +ex);
                  }
            }

            if(e.getSource()==b2){
                 try{
                     Connect conn = new Connect();
                      String q = "delete from pracownicy where Imie_Nazwisko ='"+t.getText()+"'";
                      conn.s.executeUpdate(q);
                      JOptionPane.showMessageDialog(null,"Dane zostaly usuniete");
                      l3.setVisible(false);
                      l4.setVisible(false);
                      l5.setVisible(false);
                      b2.setVisible(false);
                      b3.setVisible(false);
                      l6.setVisible(false);
                      l7.setVisible(false);
                      l8.setVisible(false);
                 }catch(Exception ex){
                     JOptionPane.showMessageDialog(null,"Blad:" + ex);
                 }  
            }
            if(e.getSource()==b3){
                fRemove.setVisible(false);
                new Main();
            }
    }

    public static void main(String[] args){
        new Remove_Employee();
    }
}
