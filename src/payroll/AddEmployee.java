
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
class AddEmployee extends JFrame implements ActionListener,ItemListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JPanel panel1,panel2;
	JLabel enolbl,enamelbl,edesilbl,eaddresslbl,ephonelbl;
	JTextField enotxt,enametxt,eaddresstxt,ephonetxt;
	JComboBox edesicb;
	JButton add,exit;
	String desi[]={"NO Selected","Programmer","Designer","Admin","Manager","Salesman"};
	Connection con;
	PreparedStatement st;
	String edesi,ename,eaddress,ephone;
	String eno;
	public void design()
	{
		frame=new JFrame("Add-Employee");
		panel1=new JPanel();
		panel2=new JPanel();
		enolbl=new JLabel("Employee Number :");
		enamelbl=new JLabel("Employee Name :");
		edesilbl=new JLabel("Employee Destination :");
		eaddresslbl=new JLabel("Employee Address :");
		ephonelbl=new JLabel("Employee PhoneNumber :");

		enotxt=new JTextField(20);
		enametxt=new JTextField(20);
		edesicb=new JComboBox(desi);
		edesicb.addItemListener(this);
		eaddresstxt=new JTextField(20);
		ephonetxt=new JTextField(20);
		
		add=new JButton("Add");
		exit=new JButton("Exit");
		
		panel1.add(enolbl);
		panel1.add(enotxt);
		panel1.add(enamelbl);
		panel1.add(enametxt);
		panel1.add(edesilbl);
		panel1.add(edesicb);
		panel1.add(eaddresslbl);
		panel1.add(eaddresstxt);
		panel1.add(ephonelbl);
		panel1.add(ephonetxt);
		panel1.setLayout(new GridLayout(5,2));
		panel2.add(add);
		add.addActionListener(this);
		panel2.add(exit);
		exit.addActionListener(this);
		panel2.setLayout(new FlowLayout());
		
		Container pane=frame.getContentPane();
		pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
		pane.add(panel1);
		pane.add(panel2);
		frame.setSize(400,300);
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
		if(ae.getSource()==add)
		{
			add();
		}
	}
	void add()
	{
		try
		{
			eno=enotxt.getText();
			ename=enametxt.getText();
			eaddress=eaddresstxt.getText();
			ephone=ephonetxt.getText();
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro","root","Saemarjn@1998");
			st=con.prepareStatement("insert into employee values(?,?,?,?,?)");
			st.setString(1,eno);
			st.setString(2,ename);
			st.setString(3,edesi);
			st.setString(4,eaddress);
			st.setString(5,ephone);
			st.executeUpdate();
			JOptionPane.showMessageDialog(null,"Added Successfull");
			enotxt.setText(null);
			enametxt.setText(null);
			edesicb.setSelectedIndex(0);
			eaddresstxt.setText(null);
			ephonetxt.setText(null);
		}
		catch(HeadlessException | ClassNotFoundException | SQLException e)
		{
                        JOptionPane.showMessageDialog(null,e);
		}
	}
        @Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		edesi=(String) edesicb.getSelectedItem();
	}
}


