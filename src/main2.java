import com.sun.org.apache.bcel.internal.classfile.Constant;
import com.sun.org.apache.bcel.internal.classfile.ConstantString;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Locale;
import javax.swing.*;
import javax.swing.border.Border;


public class main2 extends JFrame{
    private JList JL1;
    private JList JL2;
    private JButton JBT;
    private JButton JBS;
    private JTextField JTF1;
    private JTextField JTF2;

    String[] org = {"Ucheba", "Igry","Son","Filmy","Progulki"};
    String[] org2 = {"","","","",""};
    public main2(){
        super("Tudy-Sjudy");
        JL1 = new JList(org);
        JL2 = new JList(org2);
        Container contentPane = super.getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);
        super.setMinimumSize(new Dimension(400,300));
        Font f = new Font("Serif",Font.BOLD,25);
        JL1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JL2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JL1.setVisibleRowCount(5);
        JL2.setVisibleRowCount(5);
        DefaultListCellRenderer renderer =  (DefaultListCellRenderer)JL1.getCellRenderer();
        DefaultListCellRenderer renderer1 =  (DefaultListCellRenderer)JL2.getCellRenderer();

        renderer.setHorizontalAlignment(JLabel.CENTER);
        renderer1.setHorizontalAlignment(JLabel.CENTER);
        JBT = new JButton("Tudy -->");
        JBS = new JButton("<-- Sudy");
        JTF1 = new JTextField("Bolt kladu");
        JTF2 = new JTextField("Delaju");
        JTF1.setEnabled(false);
        JTF2.setEnabled(false);
        JTF1.setFont(f);
        JTF2.setFont(f);
        JTF1.setHorizontalAlignment(SwingConstants.CENTER);
        JTF2.setHorizontalAlignment(SwingConstants.CENTER);
        JTF1.setDisabledTextColor(Color.BLACK);
        JTF2.setDisabledTextColor(Color.BLACK);
        JL1.setFixedCellHeight(23);
        JL2.setFixedCellHeight(23);

        //JTF1
        layout.putConstraint(SpringLayout.WEST, JTF1,
                30,
                SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.SOUTH, JTF1,
                -20,
                SpringLayout.SOUTH, contentPane);

        layout.putConstraint(SpringLayout.EAST, JTF1,
                -30,
                SpringLayout.WEST, JBS);

        layout.putConstraint(SpringLayout.NORTH, JTF1,
                10,
                SpringLayout.SOUTH, JL1);
        // JL1
        layout.putConstraint(SpringLayout.EAST, JL1,
                -10,
                SpringLayout.WEST, JBT);

        layout.putConstraint(SpringLayout.WEST, JL1,
                20,
                SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.NORTH, JL1,
                20,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.SOUTH, JL1,
                -150,
                SpringLayout.SOUTH, contentPane);
        // JBT
        layout.putConstraint(SpringLayout.NORTH, JBT,
                30,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, JBT,
                150,
                SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.EAST, JBT,
                -150,
                SpringLayout.EAST, contentPane);


        // JBS
        layout.putConstraint(SpringLayout.NORTH, JBS,
                20,
                SpringLayout.SOUTH, JBT);
        layout.putConstraint(SpringLayout.WEST, JBS,
                0,
                SpringLayout.WEST, JBT);
        layout.putConstraint(SpringLayout.EAST, JBS,
                0,
                SpringLayout.EAST, JBT);
        // JL2
        layout.putConstraint(SpringLayout.WEST, JL2,
                10,
                SpringLayout.EAST, JBT);

        layout.putConstraint(SpringLayout.EAST, JL2,
                -20,
                SpringLayout.EAST, contentPane);

        layout.putConstraint(SpringLayout.NORTH, JL2,
                20,
                SpringLayout.NORTH, contentPane);
        // JTF2
        layout.putConstraint(SpringLayout.EAST, JTF2,
                -30,
                SpringLayout.EAST, contentPane);

        layout.putConstraint(SpringLayout.SOUTH, JTF2,
                -20,
                SpringLayout.SOUTH, contentPane);

        layout.putConstraint(SpringLayout.WEST, JTF2,
        30,
                SpringLayout.EAST, JBS);

        layout.putConstraint(SpringLayout.NORTH, JTF2,
                10,
                SpringLayout.SOUTH, JL1);


        //contentPane.add(JTF1);
        contentPane.add(JL1);
        contentPane.add(JBT);
        contentPane.add(JBS);
        contentPane.add(JL2);
        //contentPane.add(JTF2);

        JBT.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        List ar = JL1.getSelectedValuesList();
                        lrb(ar,JL1);
                        System.out.println(ar);
                    }});
        JBS.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        List ar = JL2.getSelectedValuesList();
                        lrb(ar,JL2);
                        System.out.println(ar);
                    }});

    }





    public void lrb(List ar,Object o){
        int j = 0;
        for (int i = 0;i<5;) {
            int x = 0;
            boolean bo = false;

            if (o == JL1)
            {bo = ar.contains(org[i]) && otherbp(JL1.getSelectedValues());}
            else if (o == JL2)
            {bo = ar.contains(org2[i]) && otherbp(JL2.getSelectedValues());}
            if (bo)
            {
                if (o == JL1)
                {
                    x = getXmore(x, org2);
                    org2[x] = String.valueOf(ar.get(j)) != "" ? String.valueOf(ar.get(j)):org2[x];
                    org[i] = String.valueOf(ar.get(j)) != "" ?"":org[i];
                    System.out.println(ar.get(j));
                }
                else if (o == JL2)
                {
                    x = getXmore(x, org);
                    org[x] = String.valueOf(ar.get(j)) != "" ? String.valueOf(ar.get(j)):org[x];
                    org2[i] = String.valueOf(ar.get(j)) != "" ? "":org2[i];
                    System.out.println(ar.get(j));
                }
                j++;
                JL1.updateUI();
                JL2.updateUI();
                super.getContentPane().repaint();
            }
            i++;
        }
    }
    private int getXmore(int x, String[] org3) {
        for (String k: org3){
            if (!k.equals("")){x++;}else if(k.equals(""))break;
            x = x==5?x-1:x;
        }
        return x;
    }
    private boolean otherbp(Object[] org4){
        int j = 0;
        int i = 0;
        for (Object ks: org4){
            if (ks.equals("")) i++; else j++;
        }
        if (i>=1 && j==0) return false; else if (j>0) return true; else return false;
    }
}