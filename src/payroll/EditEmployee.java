package payroll;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class EditEmployee extends JFrame implements ActionListener,ItemListener
{
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JPanel panel1,panel2;
	JLabel enolbl,enamelbl,edesilbl,eaddresslbl,ephonelbl;
	JComboBox enocb,edesicb;
	JTextField enametxt,eaddresstxt,ephonetxt;
	JButton update,exit;
	String desi[]={"NO Selected","Programmer","Designer","Admin","Manager","Salesman"};
	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	String ename,edesi,eaddress,ephone,eno;
	void design()
	{
		frame=new JFrame("Edit-Employee");
		panel1=new JPanel();
		panel2=new JPanel();
		enolbl=new JLabel("Employee Number :");
		enamelbl=new JLabel("Employee Name :");
		edesilbl=new JLabel("Employee Destination :");
		eaddresslbl=new JLabel("Employee Address :");
		ephonelbl=new JLabel("Employee PhoneNumber :");
		enocb=new JComboBox();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro","root","Saemarjn@1998");
			ps=con.prepareStatement("select eno from employee");
			rs=ps.executeQuery();
			while(rs.next())
			{
				enocb.addItem(rs.getString("eno")+"");
			}
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
		}
		enocb.addActionListener(this);
		enametxt=new JTextField(20);
		edesicb=new JComboBox(desi);
		eaddresstxt=new JTextField(20);
		ephonetxt=new JTextField(20);
		update=new JButton("Update");
		update.addActionListener(this);
		exit=new JButton("Exit");
		exit.addActionListener(this);
		
		panel1.add(enolbl);
		panel1.add(enocb);
		panel1.add(enamelbl);
		panel1.add(enametxt);
		panel1.add(edesilbl);
		panel1.add(edesicb);
		panel1.add(eaddresslbl);
		panel1.add(eaddresstxt);
		panel1.add(ephonelbl);
		panel1.add(ephonetxt);
		panel1.setLayout(new GridLayout(5,2));
		panel2.add(update);
		panel2.add(exit);
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
		if(ae.getSource()==enocb)
		{
			String s=""+enocb.getItemAt(enocb.getSelectedIndex());
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
                                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro","root","Saemarjn@1998");
				st=con.createStatement();
				rs=st.executeQuery("select ename,eaddress,ephone,edesi from employee where eno='"+s+"'");
				while(rs.next())
				{
					enametxt.setText(rs.getString("ename")+"");
					eaddresstxt.setText(rs.getString("eaddress")+"");
					ephonetxt.setText(rs.getString("ephone")+"");
					edesicb.setSelectedItem(rs.getString("edesi").trim()+"");
				}
			}
			catch(ClassNotFoundException | SQLException e)
			{
				System.out.println(e);
			}
		}
		if(ae.getSource()==update)
		{
			try
			{
				eno=""+enocb.getItemAt(enocb.getSelectedIndex());
				System.out.println(eno);
				ename=enametxt.getText();
				System.out.println(ename);
				edesi=(String)edesicb.getSelectedItem();
				System.out.println(edesi);
				eaddress=eaddresstxt.getText();
				System.out.println(eaddress);
				ephone=ephonetxt.getText();
				System.out.println(ephone);
				ps=con.prepareStatement("update employee set ename=?,edesi=?,eaddress=?,ephone=? where eno=?");
				ps.setString(1,ename);
				ps.setString(2, edesi);
				ps.setString(3, eaddress);
				ps.setString(4, ephone);
				ps.setString(5, eno);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null,"Update Successfull");
			}
			catch(HeadlessException | SQLException e)
			{
				System.out.println(e);
			}
		}
			
	}
        @Override
	public void itemStateChanged(ItemEvent ie) {
		// TODO Auto-generated method stub
		
		
	}
}

