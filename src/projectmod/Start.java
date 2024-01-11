
package projectmod;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Start implements ActionListener{
    JFrame frame;
    JPanel p1,p2,p3,p4,p5,p6,p7,p8;
    JButton start;
    ArrayList<JRadioButton> radio_buttons;
    JRadioButton ms,in,ss,mn,ee;
    ButtonGroup bg;
    int frame_width = 900;
    int frame_height = 700;
    public Start(){
        frame = new JFrame("START");
        radio_buttons = new ArrayList<>();
        ms = new JRadioButton("M-SQ");
        in = new JRadioButton("Inventory");
        ss = new JRadioButton("S-SQ");
        mn = new JRadioButton("MN_Inventory");
        ee = new JRadioButton("Event scheduling");
        radio_buttons.add(ms);     
        radio_buttons.add(in);
        radio_buttons.add(ss);
        radio_buttons.add(mn);
        radio_buttons.add(ee);
        bg = new ButtonGroup();
        p1 = new JPanel();
        p1.setBackground(new Color(200,200,200));
        p2 = new JPanel();
        p2.setBackground(new Color(200,200,200));
        p3 = new JPanel();
        p3.setBackground(new Color(200,200,200));
        p4 = new JPanel();
        p4.setBackground(new Color(200,200,200));
        p5 = new JPanel();
        p5.setBackground(new Color(200,200,200));
        p6 = new JPanel();
        p6.setBackground(new Color(200,200,200));
        p7 = new JPanel();
        p7.setBackground(new Color(200,200,200));
        p8 = new JPanel();
        p8.setBackground(new Color(200,200,200));
        start = new JButton("START");
        start.setFont(new Font("times", Font.BOLD, 24));
        start.addActionListener(this);
        for(int i = 0;i<radio_buttons.size();i++){
            radio_buttons.get(i).setBackground(new Color(0,27,58));
            radio_buttons.get(i).setForeground(Color.WHITE);
            radio_buttons.get(i).setFont(new Font("times", Font.BOLD, 24));
            radio_buttons.get(i).setActionCommand(""+i);
            bg.add(radio_buttons.get(i));
            
            
        }      
        p1.setLayout(new GridLayout(7,1));
        
        p1.add(p2);
        p3.add(ms);
        p1.add(p3);
        p4.add(in);
        p1.add(p4);
        p5.add(ss);
        p1.add(p5);
        p6.add(mn);
        p1.add(p6);
        p7.add(ee);
        p1.add(p7);
        p8.add(start);
        p1.add(p8);
        frame.setSize(frame_width, frame_height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(p1);
        frame.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start){
            if(ms.isSelected()){
                MultiServer_Simulation_frame temp = new MultiServer_Simulation_frame();
                this.frame.dispose();
            }

             if(in.isSelected()){
                Inventort_frame temp = new Inventort_frame();
                this.frame.dispose();
            }
            else if(ss.isSelected()){
                SingleServer_frame temp = new SingleServer_frame();
                this.frame.dispose();
            }
             else if(mn.isSelected()){
                MN_Inventory_frame temp = new MN_Inventory_frame();
                this.frame.dispose();
            }
             else if(ee.isSelected()){
                EventScheduling_frame temp = new EventScheduling_frame();
                this.frame.dispose();
            }
                
        }
    }
}
