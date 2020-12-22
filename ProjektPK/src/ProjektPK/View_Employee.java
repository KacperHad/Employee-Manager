package ProjektPK;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class View_Employee implements ActionListener {
    
    JFrame fView;
    JTable lista;
    JPanel panel;
    JLabel l1;
    JScrollPane scroll;
    JButton b,b1;
    
    public View_Employee(){
        fView = new JFrame("Lista Pracownikow");
        fView.setLayout(null);
        fView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fView.setBounds(100,100,858,458);
        fView.setBackground(Color.GREEN);
        fView.setVisible(true);
        fView.getContentPane().setBackground(Color.lightGray);
        
        l1 = new JLabel("Lista Pracowników");
        l1.setBounds(330, 11, 593, 40);
        l1.setFont(new Font("serif",Font.BOLD,25));
        fView.add(l1);
        
        scroll = new JScrollPane();
        scroll.setBounds(47, 69, 741, 224);
        fView.add(scroll);
        
        lista = new JTable();
        scroll.setViewportView(lista);
        
        b = new JButton("Pokaz liste");
        b.addActionListener(this);
        b.setBounds(325, 340, 198, 23);
        fView.add(b);
        
        b1 = new JButton("Cofnij");
        b1.addActionListener(this);
        b1.setBounds(680,340,100,23);
        fView.add(b1);
        
        b1.setVisible(true);
        
        
    }
    public void resultSetToTableModel(ResultSet rs, JTable table) throws SQLException{
        
        DefaultTableModel tableModel = new DefaultTableModel();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
            tableModel.addColumn(metaData.getColumnLabel(columnIndex));
        }
        Object[] row = new Object[columnCount];
        while (rs.next()){
            for (int i = 0; i < columnCount; i++){
                row[i] = rs.getObject(i+1);
            }
            tableModel.addRow(row);
        }
        table.setModel(tableModel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
                if(e.getSource()==b){
                    try{
                        Connect conn = new Connect();
                        String q = "select * from pracownicy";
                        ResultSet rs= conn.s.executeQuery(q);
                        resultSetToTableModel(rs,lista);
                        
                    }catch(SQLException ex){
                        System.out.println("Error : " + ex);
                    }
                }
                if(e.getSource()==b1){
                    fView.setVisible(false);
                    new Main();
                }
            }
    
    
    public static void main(String[] args){
        new View_Employee();
    }
    
    
}

