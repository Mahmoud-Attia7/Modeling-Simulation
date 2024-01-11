
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


public class SingleServer_frame implements ActionListener{
    JFrame frame;
    Container container;
    JButton start,back;
    JTextField  customer_number, service_time_range,IAT_range;
    JLabel customer, service_time, IAT;
    int frame_width = 900;
    int frame_height = 700;
    SpringLayout layout;
    int min_service_time , min_IAT, max_service_time,max_IAT;
    public SingleServer_frame (){
        frame = new JFrame("Single Server");
        layout = new SpringLayout();
        container = frame.getContentPane();
        container.setLayout(layout);
        container.setBackground(new Color(127,127,127));
        start = new JButton("Start");  
        start.setBackground(new Color(245, 245, 245));
        start.setFont(new Font("san serif",Font.BOLD,28));
        start.setBorder(BorderFactory.createBevelBorder(1,new Color(224, 154, 95),new Color(224, 154, 95),new Color(224, 154, 95), new Color(224, 154, 95)));
        start.addActionListener(this);
        back = new JButton(" back");  
        back.setBackground(new Color(245, 245, 245));
        back.setFont(new Font("san serif",Font.BOLD,28));
        back.setBorder(BorderFactory.createBevelBorder(1,new Color(224, 154, 95),new Color(224, 154, 95),new Color(224, 154, 95), new Color(224, 154, 95)));
        back.addActionListener(this);
        
        customer_number = new JTextField(20);
        service_time_range = new JTextField(20);
//        key_field = new JTextField(20);
        IAT_range = new JTextField(20);

        customer = new JLabel("Enter number of customers");
        customer.setForeground(Color.white);
        customer.setFont(new Font("times", Font.BOLD, 24));
        service_time = new JLabel("Enter range of service time");
        service_time.setFont(new Font("times", Font.BOLD, 24));
        service_time.setForeground(Color.white);
        IAT = new JLabel("Enter range of IAT");
        IAT.setFont(new Font("times", Font.BOLD, 24));
        IAT.setForeground(Color.white);
        
        container.add(start);
        
        container.add(customer);
        
        container.add(customer_number);
        container.add(service_time_range);
        container.add(IAT);
        container.add(service_time);
        container.add(IAT_range);
        
        container.add(back);
        layout.putConstraint(SpringLayout.NORTH, start, 550, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, start, 450, SpringLayout.WEST, container);
        
        layout.putConstraint(SpringLayout.NORTH, customer, 400, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, customer, 110, SpringLayout.WEST, container);
        
        layout.putConstraint(SpringLayout.NORTH, customer_number, 407, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, customer_number, 450, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, service_time_range, 307, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, service_time_range, 450, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, IAT_range, 207, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, IAT_range, 450, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, service_time, 307, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, service_time, 110, SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, IAT, 207, SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, IAT, 110, SpringLayout.WEST, container);
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
           Integer customer_number_value = Integer.valueOf(this.customer_number.getText());
           Integer service_range = Integer.valueOf(this.service_time_range.getText());
           Integer IAT_range_values = Integer.valueOf(this.IAT_range.getText());
           SingleServer SS = new SingleServer(IAT_range_values, customer_number_value, service_range);
           SingleServer_table1 t = new SingleServer_table1(SS.Simulate());
           
           frame.dispose();
           }
           catch(Exception ex){
               System.out.print(ex);
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
