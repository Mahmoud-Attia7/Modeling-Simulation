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



public class EventScheduling_frame implements ActionListener{
  
    JFrame frame;
    Container container;
    JButton start,back;
    JTextField  customer_number;
    JLabel  customer;
    int frame_width = 900;
    int frame_height = 700;
    SpringLayout layout;
    int min_service_time , min_IAT, max_service_time,max_IAT;
    public EventScheduling_frame() {
         frame = new JFrame("event scheduling");
        layout = new SpringLayout();
        container = frame.getContentPane();
        container.setLayout(layout);
        container.setBackground(new Color(127,127,127));
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
        
        customer_number = new JTextField(20);
        
        customer = new JLabel("Enter number of customers");
        customer.setForeground(Color.white);
        customer.setFont(new Font("times", Font.BOLD, 24));
        
        container.add(start);
       
        container.add(customer);
        
        container.add(customer_number);
        
        
        container.add(back);
        layout.putConstraint(SpringLayout.NORTH, start, 550, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, start, 450, SpringLayout.WEST, container);
//        
        layout.putConstraint(SpringLayout.NORTH, customer, 400, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, customer, 110, SpringLayout.WEST, container);
        
        layout.putConstraint(SpringLayout.NORTH, customer_number, 407, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, customer_number, 450, SpringLayout.WEST, container);
        
        layout.putConstraint(SpringLayout.NORTH, back, 550, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, back, 300, SpringLayout.WEST, container);
        
        frame.setSize(frame_width, frame_height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == this.start){
           try{
           Integer customer_number = Integer.valueOf(this.customer_number.getText());
           EventScheduling ee = new EventScheduling();
           EventTable t = new  EventTable(ee.simulate());
           }
           catch(Exception ex){
               JOptionPane.showMessageDialog(null, "Please Enter valid parameters","ERROR", JOptionPane.ERROR_MESSAGE);
           }
       }
       else if(e.getSource() == this.back){
           Start s = new Start();
           frame.dispose();
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
