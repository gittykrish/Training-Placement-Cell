import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;
public class Mgmt extends JFrame implements ActionListener{
    JButton jb1,jb2;
    Mgmt(String s){
        super(s);
        setLayout(null);
        jb1=new JButton("Student");
        jb2=new JButton("Company");
        jb1.setBounds(100,100,100,50);
        jb2.setBounds(250,100,100,50);
        add(jb1);
        add(jb2);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==jb1){
            Student sd=new Student("Student");
            sd.setSize(500,500);
            sd.setVisible(true);
            this.setVisible(false);
        }
        if(e.getSource()==jb2){
            Company sd=new Company("Company");
            sd.setSize(500,500);
            sd.setVisible(true);
            this.setVisible(false);
        }
    }
  /* public static void main(String []arg){
        Mgmt d= new Mgmt("Management");
        d.setSize(500,500);
        d.setVisible(true);
    }
    */
}