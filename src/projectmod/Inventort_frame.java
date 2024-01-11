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

public class Inventort_frame implements ActionListener{
    JFrame frame;
    Container container;
    int frame_width = 900;
    int frame_height = 800;
    JTextField days, cost, numOfProduct;
    JLabel days_label, cost_of_ticket_label, number_of_purchased_label;
    JButton start,back;
    String stats;
    SpringLayout layout;
    public Inventort_frame() {
        frame = new JFrame("Tickets Invnetory");
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
        days = new JTextField(20);
        
        cost = new JTextField(20);
        numOfProduct = new JTextField(20);
        
        
        days_label = new JLabel("Number of days");
        days_label.setFont(new Font("times", Font.BOLD , 24));
        days_label.setForeground(Color.white);
        
        cost_of_ticket_label = new JLabel("cost of ticket");
        cost_of_ticket_label.setFont(new Font("times", Font.BOLD , 24));
        cost_of_ticket_label.setForeground(Color.white);
        number_of_purchased_label = new JLabel("purchased tickets");
        number_of_purchased_label.setFont(new Font("times", Font.BOLD , 24));
        number_of_purchased_label.setForeground(Color.white);
        
        
        container = frame.getContentPane();
        container.setBackground(new Color(0,27,58));  
        container.setLayout(layout);
        container.add(start);
        container.add(back);
        container.add(days);
        
        container.add(cost);
        container.add(numOfProduct);
        
        //////////////
        container.add(days_label);
        
        container.add(cost_of_ticket_label);
        container.add(number_of_purchased_label);
        

        layout.putConstraint(SpringLayout.NORTH, start, 700, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, start,450, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, back, 700, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, back, 300, SpringLayout.WEST, container);
        //////////////////////
        layout.putConstraint(SpringLayout.NORTH, days, 100, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, days, 500, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, days_label, 100, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, days_label, 300, SpringLayout.WEST, container);
        
        layout.putConstraint(SpringLayout.NORTH, cost, 300, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, cost, 500, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, cost_of_ticket_label, 300, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, cost_of_ticket_label, 300, SpringLayout.WEST, container);
        ///////////////////
        layout.putConstraint(SpringLayout.NORTH, numOfProduct, 400, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, numOfProduct, 500, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, number_of_purchased_label, 400, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, number_of_purchased_label, 280, SpringLayout.WEST, container);
        
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
            Integer days1 = Integer.valueOf(this.days.getText());
//            Double price = Double.valueOf(this.getText());
            Integer cost1 = Integer.valueOf(this.cost.getText());
            Integer purchased_tickets = Integer.valueOf(this.numOfProduct.getText());
//            Integer min_demand = string_to_Integer(this.demand_range.getText())[0];
//            Integer max_demand = string_to_Integer(this.demand_range.getText())[1];
//            Double salvage = Double.valueOf(this.salvage_value.getText());
//            Double expec_profit_value = Double.valueOf(this.expec_profit.getText());
            Inventory np = new Inventory(cost1, days1, purchased_tickets);
            Inventory_table invent = new Inventory_table(np.simulate());
            
        }
            catch(Exception ex){
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
    

