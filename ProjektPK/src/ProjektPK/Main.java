package ProjektPK;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Main extends JFrame implements ActionListener {
    JFrame fMain;
    JLabel l1, l2;
    JButton bAdd, bView, bRemove, bUpdate;

    public Main() {
        fMain = new JFrame("System kontroli pracownikow");
        fMain.setBackground(Color.WHITE);
        fMain.setLayout(null);
        fMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel();
        l1.setBounds(0, 0, 700, 500);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ProjektPK/ikony/glowne.jpg"));
        l1.setIcon(i1);
        fMain.add(l1);

        l2 = new JLabel("Menager Pracowniczy");
        l2.setBounds(400, 20, 250, 40);
        l2.setFont(new Font("serif", Font.BOLD, 25));
        l2.setForeground(Color.BLACK);
        l1.add(l2);

        bAdd = new JButton("Dodaj");
        bAdd.setBounds(420, 80, 100, 40);
        bAdd.setFont(new Font("serif", Font.BOLD, 15));
        bAdd.addActionListener(this);
        l1.add(bAdd);

        bView = new JButton("Lista");
        bView.setBounds(530, 80, 100, 40);
        bView.setFont(new Font("serif", Font.BOLD, 15));
        bView.addActionListener(this);
        l1.add(bView);

        bRemove = new JButton("Usun");
        bRemove.setBounds(420, 140, 100, 40);
        bRemove.setFont(new Font("serif", Font.BOLD, 15));
        bRemove.addActionListener(this);
        l1.add(bRemove);

        bUpdate = new JButton("Zmień");
        bUpdate.setBounds(530, 140, 100, 40);
        bUpdate.setFont(new Font("serif", Font.BOLD, 15));
        bUpdate.addActionListener(this);
        l1.add(bUpdate);

        fMain.setVisible(true);
        fMain.setSize(700, 500);
        fMain.setLocation(450, 200);
        
    }

    public static void main(String[] args) {
        new Main();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bAdd) {
            fMain.setVisible(false);
            new Add_Employee();
        }
        if (e.getSource() == bView) {
            fMain.setVisible(false);
            new View_Employee();

        }
        if (e.getSource() == bRemove) {
            fMain.setVisible(false);
            new Remove_Employee();

        }
        if (e.getSource() == bUpdate) {
            fMain.setVisible(false);
            new Modify_Employee();

        }
    }
}
