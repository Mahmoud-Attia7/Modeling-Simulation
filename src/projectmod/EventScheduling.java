
package projectmod;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventScheduling extends JFrame implements ActionListener{
JPanel containerPanel;
    JPanel userPanel;
    JPanel backPanel;
    JPanel output;
    JLabel labelAccount;
    JLabel UserNumberLabel;
    JTextField customerNumberTxt;
    JButton backButton;
    public static TextArea t = new TextArea();

    public EventScheduling() {
      
        containerPanel = new JPanel(new GridLayout(4, 1));
        userPanel = new JPanel();

        output = new JPanel();
        

        customerNumberTxt = new JTextField();
        backPanel = new JPanel();
        backButton = new JButton("enter");

        labelAccount = new JLabel("Event Scheduling");
        UserNumberLabel = new JLabel("Simlation Length ");

        // PANELS BACKGROUND
        containerPanel.setBackground(Color.decode("#3c475d"));
        userPanel.setBackground(Color.decode("#3c475d"));
        backPanel.setBackground(Color.decode("#3c475d"));
        output.setBackground(Color.decode("#3c475d"));

        // BACK BUTTON DESIGN
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.decode("#3c475d"));
        backButton.setPreferredSize(new Dimension(100, 50));
        backButton.setFocusable(false);

        // ACTION LISTENERS
        backButton.setActionCommand("Enter");
        backButton.addActionListener(this);
        

        // ADDING THE BACK BUTTON TO THE BACK PANEL
        backPanel.add(backButton);

        // JLABEL DESIGN
        labelAccount.setHorizontalTextPosition(JLabel.LEFT);
        labelAccount.setHorizontalAlignment(JLabel.CENTER);
        labelAccount.setVerticalAlignment(JLabel.CENTER);
        labelAccount.setFont(new Font("sans-serif", Font.BOLD, 30));
        labelAccount.setForeground(Color.WHITE);

        // ADDING THE FIRST LABEL TO THE CONTAINER
        containerPanel.add(labelAccount);

        // ACCOUNT NUMBER PANELS SETTINGS
        UserNumberLabel.setPreferredSize(new Dimension(110, 40));
        customerNumberTxt.setPreferredSize(new Dimension(250, 40));
        t.setPreferredSize(new Dimension(500, 500));
        

        // ADDING COMPONENTS TO THE SECOND PANEL
        userPanel.add(UserNumberLabel);
        userPanel.add(customerNumberTxt);

        output.add(t);

        // ADDING THE PANELS TO THE CONTAINER
        containerPanel.add(userPanel);
        containerPanel.add(backPanel);
        containerPanel.add(output);

//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLocationRelativeTo(null);
//        this.setResizable(true);
//        this.setVisible(true);
      this.add(containerPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);
    }
    

        public static String rd1 ;

    public Customer[] simulate() {
        Random random = new Random();
        int rd = Integer.parseInt(rd1);
        System.out.println(rd);

        int[] iat = new int[rd];
        iat[0] = 0;
        for (int i = 1; i < iat.length; i++) {
            iat[i] = random.nextInt((60 - 0 + 1));
            // System.out.println(iat[i]); 
        }

        int[] at = new int[iat.length];
        int[] st = new int[iat.length];
        for (int i = 0; i < iat.length; i++) {
            st[i] = random.nextInt((10 - 0 + 1));
            //System.out.println(st[i]); 
        }
        int[] dt = new int[iat.length];
        at[0] = 0;
        dt[0] = st[0];
        for (int i = 1; i < at.length; i++) {

            at[i] = iat[i] + at[i - 1];

        }
        //dt = start + service time
        for (int i = 1; i < at.length; i++) {
            if (at[i] < dt[i - 1]) { //fy 7alt ano wsl badry wy aly 2blo lsa m5las4
                dt[i] = st[i] + dt[i - 1];  //fa hybda2 by w2t nhayt aly 2blo
            } else {
                dt[i] = st[i] + at[i];
            }
        } //wsl wly 2ablo kda kda mashy fa hybda2 3latol
        int[] wt = new int[iat.length];
        wt[0] = 0;
        for (int i = 1; i < at.length; i++) {
            if (dt[i - 1] > at[i]) {
                wt[i] = dt[i - 1] - at[i];
            }
            //if(i>0){
            //tt[i]=dt[i]-at[i]+(dt[i-1]-at[i]);}
        }

        int size = at.length + dt.length;

        int clockends = dt[dt.length - 1];

        int clock[] = new int[size];
        char eventtype[] = new char[size];
        int j = 0;
        int k = 0;
        int c = 0;
        clock[0] = 0;
        eventtype[0] = 'A';

        //////
        for (int i = 0; i < clockends + 1; i++) {
            if (j < rd && i == at[j]) {
                clock[c] = i;
                eventtype[c] = 'A';
                c++;
                if (j < rd - 1 && i == at[j + 1]) {
                    clock[c] = i;
                    eventtype[c] = 'A';
                    c++;
                    j++;
                }
                j++;
            }
            if (k < rd && i == dt[k]) {
                clock[c] = i;
                eventtype[c] = 'D';
                c++;
                if (k < rd - 1 && i == dt[k + 1]) {
                    clock[c] = i;
                    eventtype[c] = 'D';
                    c++;
                    k++;
                }
                k++;
            }
        }
        /////

        int[] lq = new int[size];
        int[] ls = new int[size];
        int[] nd = new int[size];
        int[] mq = new int[size];
        String[] checkout = new String[size];
        String[] futureEvent = new String[size];

        int s[] = new int[size];
        s[0] = 0;
        int F[] = new int[size];
        F[0] = 0;
        int f = random.nextInt(8 - 0 + 1) + 1;
        int Dnbr = -1;
        int max = 0;
        int counter = 1;
        lq[0] = 0;
        ls[0] = 1;
        nd[0] = 0;
        checkout[0] = "T1";
        for (int i = 1; i < size; i++) {
            if (eventtype[i] == 'A') {
                if (ls[i - 1] == 1) {
                    lq[i] = lq[i] + 1;
                }
                ls[i] = 1;
                counter++;
                checkout[i] = checkout[i - 1] + "T" + counter;
            }
            //////////
            nd[i] = nd[i - 1];
            s[i] = s[i - 1];
            F[i] = F[i - 1];
            /////////
            if (eventtype[i] == 'D') {
                //calc ls lq
                if (lq[i - 1] > 0) {
                    lq[i] = lq[i - 1] - 1;
                    ls[i] = 1;
                }
                if (lq[i - 1] == 0) {
                    lq[i] = 0;
                    ls[i] = 0;
                }
                ///////////
                nd[i] = nd[i] + 1;

                if (checkout[i - 1].length() > 3) {
                    for (int x = 1; x < checkout[i - 1].length(); x++) {
                        if (checkout[i - 1].charAt(x) == 'T') {
                            checkout[i] = checkout[i - 1].substring(x, checkout[i - 1].length());
                            break;
                        }

                    }
                } else {
                    checkout[i] = "";
                }

                Dnbr++;
                s[i] = s[i - 1] + st[Dnbr] + wt[Dnbr];
                if (st[Dnbr] >= f) {
                    F[i] = F[i - 1] + 1;
                } else {
                    F[i] = F[i - 1];
                }

            }
            mq[i] = max;
            if (max < lq[i]) {
                max = lq[i];
                mq[i] = max;
            }

        }

       
        int Fnbr = 0;

        for (int i = 1; i < size - 1; i++) {

            futureEvent[Fnbr] = "( " + eventtype[i] + " ," + clock[i] + " )" + "( " + eventtype[i + 1] + " ," + clock[i + 1] + " )";
            Fnbr++;
        }
        futureEvent[size - 2] = "( " + eventtype[size - 1] + " ," + clock[size - 1] + " )" + "            ";
        futureEvent[size - 1] = "---------" + "            ";
        t.append("TAT" + "\t" + "ST" + "\t" + "AT" + "\t" + "DT" + "\t" );//+"\t"+"-"+"\t"+"-"+"\t"+"-"+"\t"+"-"+"\t"+"\t"
        t.append("\n");
        for (int i = 0; i < at.length; i++) {

            t.append(iat[i] + "\t" + st[i] + "\t" + at[i] + "\t" + dt[i] + "\t" );
            t.append("\n");
        }

        t.append("\n");
        t.append("clock" + "\t" + "event" + "\t" + "LQ(t)" + "\t" + "LS(t)" +"\t" +  "FEL" + "\t"+"Checkout");
        for (int i = 0; i < size; i++) {
            t.append("\n");
            t.append(clock[i] + "\t" + eventtype[i] +  "\t" + lq[i] +  "\t" + ls[i] +  "\t" + futureEvent[i] +  "\t" + checkout[i]);

        }

//    
//    System.out.println("TAT"+"\t"+"ST"+"\t"+"AT"+"\t"+"DT"+"\t"+"WT");   
//    for(int i=0;i<at.length;i++){
//    System.out.println(iat[i]+"\t"+st[i]+"\t"+at[i]+"\t"+dt[i]+"\t"+wt[i]);}
//    System.out.println();
//     System.out.println("F are the number of trucks worked for "+f+" houres or more");
//    System.out.println("clock"+"\t"+"event"+"\t"+"LQ(t)"+"\t"+"LS(t)"+"\t"+"S"+"\t"+"F"+"\t"+"ND"+"\t"+"FEL"+"\t"+"\t"+"\t"+"M(Q)"+"\t"+"Checkout");
//    for(int i=0;i<size;i++){
//    System.out.println(clock[i]+"\t"+eventtype[i]+"\t"+lq[i]+"\t"+ls[i]+"\t"+s[i]+"\t"+F[i]+"\t"+nd[i]+"\t"+fel[i]+"\t"+mq[i]+"\t"+checkout[i]);
//    }
//    
        return null;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
          if (e.getActionCommand().equals("Enter")) {
            rd1 = customerNumberTxt.getText();
            simulate();

        
        
    }
}

   
    
    
}
