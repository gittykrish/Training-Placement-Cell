import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;
public class AdminLogin extends JFrame implements ActionListener{
    JLabel jl1,jl2;
    JTextField jt1,jt2;
    JButton jb1;
    AdminLogin(String s){
        super(s);
        setLayout(null);
        jl1=new JLabel("Username");
        jl2=new JLabel("password");
        jt1=new JTextField(20);
        jt2=new JTextField(20);
        jb1=new JButton("submit");
        jl1.setBounds(100,100,100,30);
        jl2.setBounds(100,150,100,30);
        jt1.setBounds(250,100,120,30);
        jt2.setBounds(250,150,120,30);
        jb1.setBounds(200,200,80,30);
        add(jl1);
        add(jl2);
        add(jt1);
        add(jt2);
        add(jb1);
        jb1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==jb1){
            String aid=jt1.getText();
            String pass=jt2.getText();
            try{
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection cn=DriverManager.getConnection("jdbc:odbc:placement");
                Statement st=cn.createStatement();
                ResultSet rs=st.executeQuery("select*from admin where adminid='"+aid+"'");
                if(rs.next()){
                    if(pass.equals(rs.getString(2))){
                        Mgmt mg=new Mgmt("Management");
                        mg.setVisible(true);
                        mg.setSize(500,500);
                        this.setVisible(false);
                    }
                   else{
                        JOptionPane.showMessageDialog(null,"Invallid Password");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invallid ID");

                     AdminLogin d= new AdminLogin("AdminLogin");
                    d.setSize(500,500);
                    d.setVisible(true);
                    
                } 
                cn.close();
            }catch(ClassNotFoundException ex){
		      System.out.print(ex.getMessage());
		
	           }
	           catch(SQLException ex){
		          System.out.print(ex.getMessage());
	           }
        }
    }

        public static void main(String []arg){
            AdminLogin d = new AdminLogin("AdminLogin`");
            d.setSize(500,500);
            d.setVisible(true);
    } 
}