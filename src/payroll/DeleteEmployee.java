/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class DeleteEmployee extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JComboBox enocb;
	JPanel panel1,panel2;
	JButton delete,exit;
	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	String s;
	public void design()
	{
		frame=new JFrame("Delete-Employee");
		enocb=new JComboBox();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro","root","Saemarjn@1998");
			st=con.createStatement();
			rs=st.executeQuery("select eno from employee");
			while(rs.next())
			{
				enocb.addItem(rs.getString("eno"));
			}
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
		}
		panel1=new JPanel();
		panel2=new JPanel();
		delete=new JButton("Delete");
		exit=new JButton("Exit");
		exit.addActionListener(this);
		panel1.add(enocb);
		panel1.setLayout(new FlowLayout());
		panel2.add(delete);
		delete.addActionListener(this);
		panel2.add(exit);
		panel2.setLayout(new FlowLayout());
		
		Container pane=frame.getContentPane();
		pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
		pane.add(panel1);
		pane.add(panel2);
		frame.setSize(300,200);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter()
		{
                        @Override
			public void windowClosing(WindowEvent we)
			{
				frame.dispose();
			}
		});
	}
        @Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==exit)
		{
			frame.dispose();
		}
		if(ae.getSource()==delete)
		{
			s=""+enocb.getItemAt(enocb.getSelectedIndex());
			System.out.println(s);
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1811");
				ps=con.prepareStatement("delete from employee where eno=?");
				ps.setString(1,s);
				ps.executeUpdate();
				enocb.removeAllItems();
				ps=con.prepareStatement("select eno from employee");
				rs=ps.executeQuery();
				while(rs.next())
				{
					enocb.addItem(rs.getString("eno"));
				}
				JOptionPane.showMessageDialog(null,"Delete Successfull");
				
			}
			catch(HeadlessException | ClassNotFoundException | SQLException e)
			{
				System.out.println(e);
			}
		}
	}
}