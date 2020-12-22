package ProjektPK;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class Add_Employee implements ActionListener {

    JFrame fGlowne;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    JButton b1,b2,b3,b4;

    Add_Employee(){
        fGlowne = new JFrame("Dodaj Pracownika");
        fGlowne.setBackground(Color.WHITE);
        fGlowne.setLayout(null);
        fGlowne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fGlowne.getContentPane().setBackground(Color.lightGray);

        l1=new JLabel();
        l1.setBounds(0,0,900,700);
        l1.setLayout(null);

        l2 = new JLabel("Szczegoly nowego pracownika");
        l2.setBounds(250,30,500,50);
        l2.setFont(new Font("serif",Font.ITALIC,25));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        fGlowne.add(l1);

        l3 = new JLabel("Imie i Nazwisko");
        l3.setBounds(50,150,100,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        l1.add(l3);

        t1 = new JTextField();
        t1.setBounds(200,150,150,30);
        l1.add(t1);

        l4 = new JLabel("Adres");
        l4.setBounds(400,150,200,30);
        l4.setFont(new Font("serif",Font.BOLD,20));
        l1.add(l4);

        t2 = new JTextField();
        t2.setBounds(600,150,150,30);
        l1.add(t2);

        l5 = new JLabel("Miasto");
        l5.setBounds(50,200,100,30);
        l5.setFont(new Font("serif",Font.BOLD,20));
        l1.add(l5);

        t3 = new JTextField();
        t3.setBounds(200,200,150,30);
        l1.add(t3);

        l6 = new JLabel("Stanowisko");
        l6.setBounds(400,200,200,30);
        l6.setFont(new Font("serif",Font.BOLD,20));
        l1.add(l6);

        t4 = new JTextField();
        t4.setBounds(600,200,150,30);
        l1.add(t4);

        l7 = new JLabel("Data rozpoczęcia pracy");
        l7.setBounds(50,250,100,30);
        l7.setFont(new Font("serif",Font.BOLD,20));
        l1.add(l7);

        t5 = new JTextField();
        t5.setToolTipText("Rok/Miesiac/Dzien");
        t5.setBounds(200,250,150,30);
        l1.add(t5);

        l8 = new JLabel("Numer Telefonu");
        l8.setBounds(400,250,100,30);
        l8.setFont(new Font("serif",Font.BOLD,20));
        l1.add(l8);

        t6 = new JTextField();
        t6.setBounds(600,250,150,30);
        l1.add(t6);

        l9 = new JLabel("Pensja Miesieczna");
        l9.setBounds(50,300,100,30);
        l9.setFont(new Font("serif",Font.BOLD,20));
        l1.add(l9);

        t7 = new JTextField();
        t7.setBounds(200,300,150,30);
        l1.add(t7);


        b1 = new JButton("Zapisz");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(250,350,150,40);

        l1.add(b1);

        b2 = new JButton("Cofnij");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(450,350,150,40);

        l1.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        fGlowne.setVisible(true);
        fGlowne.setSize(800,500);
        fGlowne.setLocation(400,150);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    String ImieNazwisko = t1.getText();
    String Adres = t2.getText();
    String Miasto = t3.getText();
    String Stanowisko = t4.getText();
    String Data = t5.getText();
    String nrTel = t6.getText();
    String Pensja = t7.getText();
    if(e.getSource()==b1){
        Connect conn = new Connect();
        String q = "insert into pracownicy values('"+ImieNazwisko+"','"+Adres+"','"+Miasto+"','"+Stanowisko+"','"+Data+"','"+nrTel+"','"+Pensja+"')";
        try {
            conn.s.executeUpdate(q);
        } catch (SQLException ex) {
            Logger.getLogger(Add_Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Dane zostaly umieszczone w bazie");
        fGlowne.setVisible(false);
        new Main();
    }
    else if(e.getSource()==b2){
        fGlowne.setVisible(false);
        new Main();
    }
    }

    public static void main(String[] args) {
        new Add_Employee();
    }
}
