
package projectmod;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;


public class MN_Inventory_table implements ActionListener {
     JFrame frame;
    JTable table;
    Integer[][] data2d;
    JScrollPane sc;
    String[] header;
    JPanel p1;
    JButton stats,back;
    //String stat_data;
    //stats st;
    String[] heads ;
    public MN_Inventory_table(Day[] data){
        //this.stat_data = stat_data;
        data2d = new Integer[data.length][10];
        for(int i=0; i<data.length; i++)
        {
            data2d[i][0]=data[i].cycle;
            data2d[i][1]=i+1;
            data2d[i][2]=data[i].rdDemand;
            data2d[i][3]=data[i].demand;
            data2d[i][4]=data[i].invB;
            data2d[i][5]=data[i].invE;
            data2d[i][6]=data[i].back_ordering;
            data2d[i][7]=data[i].order_quantity;
            data2d[i][8]=data[i].rdLeadTime;
            data2d[i][9]=data[i].leadTime;
        }
        p1 = new JPanel();
        p1.setPreferredSize(new Dimension(900, 100));
        p1.setBackground(Color.darkGray);
        back = new JButton("back");  
        back.setFont(new Font("times", Font.BOLD, 24));
        back.addActionListener(this);
        stats = new JButton("Statistics");  
        stats.setFont(new Font("times", Font.BOLD, 24));
        stats.addActionListener(this);
        frame = new JFrame();
        frame.setSize(900, 700);
        frame.setTitle("table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        heads = new String[10];
        heads[0] = "Cycle";
        heads[1] = "Day";
        heads[2] = "R_demand";
        heads[3] = "Demand"; 
        heads[4]="Begin";
        heads[5] = "End";
        heads[6] = "Back Ordering";
        heads[7] = " Ordering Quantity";
        heads[8] = "R_Lead Time";
        heads[9] = "Lead Time";
        
        DefaultTableModel model = new DefaultTableModel(data2d,heads);
        
        table = new JTable(model);
        table.setRowHeight(30);
        for(int i = 0; i < 10; i++){
            table.getColumnModel().getColumn(i).setPreferredWidth(125);
        }
        
        table.setFont(new Font("times", Font.PLAIN, 20));
        sc = new JScrollPane(table);
        sc.setBackground(new Color(0,27,58));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        SpringLayout layout = new SpringLayout();
        frame.setLayout(layout);
        sc.setPreferredSize(new Dimension(880, 600));
        frame.add(sc);
        p1.add(back);
        p1.add(stats);
        frame.add(p1);
        layout.putConstraint(SpringLayout.NORTH, sc, 0, SpringLayout.NORTH, frame);
        layout.putConstraint(SpringLayout.WEST, sc, 0, SpringLayout.WEST, frame);
        layout.putConstraint(SpringLayout.NORTH, p1, 600, SpringLayout.NORTH, frame);
        layout.putConstraint(SpringLayout.WEST, p1, 0, SpringLayout.WEST, frame);
        frame.setResizable(false);
        frame.setVisible(true);

        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            Start s = new Start();
            frame.dispose();
            
        }
        else if(e.getSource() == stats){
//            this.st = new stats(this.stat_data);
            
            
        }
    }
    
}
