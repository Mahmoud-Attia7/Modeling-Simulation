
package projectmod;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class MN_Inventory_frame implements ActionListener{
    JFrame frame;
    Container container;
    int frame_width = 900;
    int frame_height = 800;
    JTextField Cycles_count,Days,Order_quantity,Order_condition;
    JLabel Cycles_count_lab_Label,Days_Label,Order_quantity_Label,Order_conditionLabel;
    JButton start,back;
    String stats;
    SpringLayout layout;
    public MN_Inventory_frame() {
        frame = new JFrame("MN_Inventory");
        layout = new SpringLayout();
        start = new JButton("Start");  
        start.setBackground(new Color(245, 245, 245));
        start.setFont(new Font("san serif",Font.BOLD,28));
        start.setBorder(BorderFactory.createBevelBorder(1,new Color(224, 154, 95),new Color(224, 154, 95),new Color(224, 154, 95), new Color(224, 154, 95)));
        start.addActionListener(this);
        back = new JButton("back");  
        back.setBackground(new Color(245, 245, 245));
        back.setFont(new Font("san serif",Font.BOLD,28));
        back.setBorder(BorderFactory.createBevelBorder(1,new Color(224, 154, 95),new Color(224, 154, 95),new Color(224, 154, 95), new Color(224, 154, 95)));
        back.addActionListener(this);
        Days = new JTextField(20);
        Cycles_count = new JTextField(20);
        Order_quantity = new JTextField(20);
        Order_condition = new JTextField(20);
        Days_Label = new JLabel("Number of Days");
        Days_Label.setFont(new Font("times", Font.BOLD , 24));
        Days_Label.setForeground(Color.white);
        Cycles_count_lab_Label = new JLabel("Cycle count");
        Cycles_count_lab_Label.setFont(new Font("times", Font.BOLD , 24));
        Cycles_count_lab_Label.setForeground(Color.white);
        Order_quantity_Label = new JLabel("order Quantity");
        Order_quantity_Label.setFont(new Font("times", Font.BOLD , 24));
        Order_quantity_Label.setForeground(Color.white);
        Order_conditionLabel = new JLabel("Order Condition");
        Order_conditionLabel.setFont(new Font("times", Font.BOLD , 24));
        Order_conditionLabel.setForeground(Color.white);
        
        
        container = frame.getContentPane();
        container.setBackground(new Color(127,127,127));  
        container.setLayout(layout);
        container.add(start);
        container.add(back);
        container.add(Days);
        container.add(Cycles_count);
        container.add(Order_quantity);
        container.add(Order_condition);
        //////////////
        container.add(Days_Label);
        container.add(Cycles_count_lab_Label);
        container.add(Order_quantity_Label);
        container.add(Order_conditionLabel);

        layout.putConstraint(SpringLayout.NORTH, start, 700, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, start,450, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, back, 700, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, back, 300, SpringLayout.WEST, container);
        //////////////////////
        layout.putConstraint(SpringLayout.NORTH, Days, 100, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, Days, 500, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, Days_Label, 100, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, Days_Label, 300, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, Cycles_count, 200, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, Cycles_count, 500, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, Cycles_count_lab_Label, 200, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, Cycles_count_lab_Label, 300, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, Order_quantity, 300, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, Order_quantity, 500, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, Order_quantity_Label, 300, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, Order_quantity_Label, 300, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, Order_condition, 400, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, Order_condition, 500, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, Order_conditionLabel, 400, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, Order_conditionLabel, 280, SpringLayout.WEST, container);
        
        frame.setSize(frame_width, frame_height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            Start s = new Start();
            frame.dispose();
        }
        else if(e.getSource()==start){
            try{
            Integer days = Integer.valueOf(this.Days.getText());
            Integer cycle = Integer.valueOf(this.Cycles_count.getText());
            Integer Or_Quantity = Integer.valueOf(this.Order_quantity.getText());
            Integer Or_condition = Integer.valueOf(this.Order_condition.getText());
            MN_Inventory mn = new MN_Inventory(days, cycle, Or_condition, Or_Quantity);
            MN_Inventory_table t = new MN_Inventory_table(mn.Simulate());
        }
            catch(Exception ex){
                System.out.println(ex);
               JOptionPane.showMessageDialog(null, "Please Enter valid parameters","ERROR", JOptionPane.ERROR_MESSAGE);
           }
    }
    }
     public Integer[] string_to_Integer(String s){
        Integer[] temp = new Integer[2];
        String[] string = s.split("-");
        for(int i = 0;i<2;i++){
            temp[i] = Integer.valueOf(string[i]);
        }
        return temp;
    }
    
}
