
package projectmod;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class stats {
    JFrame frame;
    JLabel data;
    JPanel p;
    public stats(String data){
        frame = new JFrame("Statistics");
        this.data = new JLabel(data);

        p = new JPanel();
        p.setLayout(new GridLayout(5, 1));
        p.setBackground(new Color(0,27,58));
        String temp ="";
        for(int i = 0;i<data.length();i++){
            temp +=data.charAt(i);
            if(data.charAt(i)=='*'){
                temp = temp.replace('*', ' ');
                JLabel templ = new JLabel();
                templ.setText(temp);
                templ.setForeground(Color.white);
                templ.setFont(new Font("times", Font.BOLD, 24));
                p.add(templ);
                temp = "";
            }
            
        }
        frame.setSize(700 , 700);
        frame.add(p);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public JFrame get_main_frame(){
       return frame;
    }
    
}
