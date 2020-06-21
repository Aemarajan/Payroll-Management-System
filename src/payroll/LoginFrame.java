/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class SubLoginFrame extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JPanel panel1,panel2,panel3;
	JLabel Userlbl,Passlbl,Namelbl;
	JTextField Usertxt;
	JPasswordField Passtxt;
	JButton Login,Exit;
	public void design()
	{	
		frame=new JFrame("Payroll Login");
		panel1=new JPanel();
		panel1.setLayout(new FlowLayout());
		Namelbl=new JLabel("WELCOME TO PAYROLL SYSTEM");
		
		panel2=new JPanel();
		panel2.setLayout(new GridLayout(2,2));
		Userlbl=new JLabel("Username:");
		Passlbl=new JLabel("Password");
		Usertxt=new JTextField(20);
		Passtxt=new JPasswordField(20);
		
		panel3=new JPanel();
		panel3.setLayout(new FlowLayout());	
		Login=new JButton("Login");
		Exit=new JButton("Exit");
		
		panel1.add(Namelbl);
		panel2.add(Userlbl);
		panel2.add(Usertxt);
		panel2.add(Passlbl);
		panel2.add(Passtxt);
		panel3.add(Login);
		Login.addActionListener(this);
		panel3.add(Exit);
		Exit.addActionListener(this);
		
		Container pane=frame.getContentPane();
		pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
		pane.add(panel1);
		pane.add(panel2);
		pane.add(panel3);
		frame.setSize(300,200);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter()
		{
                        @Override
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		}
        @Override
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==Login)
			{
				login();
			}
			if(ae.getSource()==Exit)
			{
				frame.dispose();
			}
		}
		void login()
		{
			try
			{
				String user=Usertxt.getText();
				String pass=Passtxt.getText();
				String query="select password from login where username='"+user+"'";
				Class.forName("com.mysql.jdbc.Driver");
                            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pro","root","Saemarjn@1998")) {
                                Statement s=con.createStatement();
                                ResultSet rs=s.executeQuery(query);
                                rs.next();
                                String s1=rs.getString("password");
                                //	boolean recordfound=rs.next();
                                if(s1.equals(pass))
                                {
                                    frame.dispose();
                                    JOptionPane.showMessageDialog(null,"Login Succesfull");
                                    MainMenu mm=new MainMenu();
                                    mm.design();
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"Login Failed");
                                    Usertxt.setText(null);
                                    Passtxt.setText(null);
                                }
                            }	
			}
			catch(HeadlessException | ClassNotFoundException | SQLException e)
			{
				System.out.println(e);
			}
		}
}

/**
 *
 * @author Raja
 */
public class LoginFrame 
{
    public static void main(String args[])
    {
        SubLoginFrame sub=new SubLoginFrame();
        sub.design();
    }
}