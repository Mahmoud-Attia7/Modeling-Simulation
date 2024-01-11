
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


public class SingleServer_table1 implements ActionListener{
    JFrame frame;
    JTable table;
    Integer [][] data2d;
    JScrollPane sc;
    String[] header;
    JPanel p1;
    JButton stats,back;
    String satat_data;
    stats st;
  String[] heads;
    //String stat_data
  
 
  
    public SingleServer_table1( Customer[] data){

        data2d = new Integer[data.length][9];
        for(int i=0; i<data.length; i++)
        {
            data2d[i][0]=i+1;
            data2d[i][1]=data[i].IAT;
            data2d[i][2]=data[i].Arrival_Time;
            data2d[i][3]=data[i].R_Service_Time;
            data2d[i][4]=data[i].Service_Time;
            data2d[i][5]=data[i].Service_Begin;
            data2d[i][6]=data[i].Service_End;
            data2d[i][7]=data[i].Waiting_Time;
            data2d[i][8]=data[i].Time_Spent;
        }
       // this.satat_data = stat_data;
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
        heads = new String[9];

        heads[0] = "Customer number";
        heads[1] = "IAT";
        heads[2] = "Arrival time"; 
        heads[3]="R_Service_Time";
        heads[4] = "service time";
        heads[5] = "begining time";
        heads[6] = "service end";
        heads[7] = "waiting time";
        heads[8] = "Time_Spent";
        
        
        DefaultTableModel model = new DefaultTableModel(data2d,heads);
        
        table = new JTable(model);
        table.setRowHeight(30);
        for(int i = 0; i < 9; i++){
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
            this.st = new stats(this.satat_data);
            
        }
    }

}
