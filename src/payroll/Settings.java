/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
class Settings extends JFrame implements ActionListener,ItemListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JPanel panel1,panel2,panel3,panel4,panel5;
	JLabel edesilbl,bslbl,enolbl,head1,head2,head3,head4,dalbl,hralbl,walbl,head5,head6,head7,head8;
	JLabel gpflbl,liclbl,itlbl,pflbl,gislbl;
	JTextField bstxt,edesitxt,datxt,hratxt,watxt,dainfo,hrainfo,wainfo;
	JTextField gpftxt,ittxt,gistxt,lictxt,pftxt,gpfinfo,itinfo,gisinfo,licinfo,pfinfo;
	String desi[]={"NO Selected","Programmer","Designer","Admin","Manager","Salesman"};
	JCheckBox dach,hrach,wach,gisch,itch,gpfch,licch,pfch;
	JButton add,edit,delete,exit;
	JComboBox enocb;
	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	String sda="false";
	String shra="false";
	String swa="false";
	String sgis="false";
	String sit="false";
	String sgpf="false";
	String slic="false";
	String spf="false";
	String vda,vhra,vwa,vgis,vit,vgpf,vlic,vpf,bs;
	String eno,edesi;
	String s,s1;
	String tda,thra,twa,tgpf,tit,tgis,tlic,tpf;
	String ida,ihra,iwa,igpf,iit,igis,ilic,ipf,ibs;
	public void design()
	{
		frame=new JFrame("Employee-Settings");
		panel1=new JPanel();
		enolbl=new JLabel("Employee Number:");
		enocb=new JComboBox();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro","root","Saemarjn@1998");
			st=con.createStatement();
			rs=st.executeQuery("select eno from employee");
			while(rs.next())
			{
				enocb.addItem(rs.getString("eno")+" ");
			}
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
		}
		enocb.addActionListener(this);
		edesilbl=new JLabel("Employee Destination:");
		edesitxt=new JTextField(10);		
		edesitxt.setEditable(false);
		panel1.setLayout(new FlowLayout());
		panel1.add(enolbl);
		panel1.add(enocb);
		panel1.add(edesilbl);
		panel1.add(edesitxt);
		
		panel2=new JPanel();
		bslbl=new JLabel("Basic Salary:");
		bstxt=new JTextField(10);
		panel2.setLayout(new FlowLayout());
		panel2.add(bslbl);
		panel2.add(bstxt);
		
		panel3=new JPanel();
		head1=new JLabel("Chech for %");
		head2=new JLabel("Allowance");
		head3=new JLabel("Allowance Value");
		head4=new JLabel("Information");
		dalbl=new JLabel("DA Allowance :");
		hralbl=new JLabel("HRA Allowance :");
		walbl=new JLabel("WA Allowance :");
		dach=new JCheckBox("DA",false);
		dach.addItemListener(this);
		hrach=new JCheckBox("HRA",false);
		hrach.addItemListener(this);
		wach=new JCheckBox("WA",false);
		wach.addItemListener(this);
		datxt=new JTextField(10);
		hratxt=new JTextField(10);
		watxt=new JTextField(10);
		dainfo=new JTextField(10);
		dainfo.setText("Enter in Rupee");
		dainfo.setEditable(false);
		hrainfo=new JTextField(10);
		hrainfo.setText("Enter in Rupee");
		hrainfo.setEditable(false);
		wainfo=new JTextField(10);
		wainfo.setText("Enter in Rupee");
		wainfo.setEditable(false);
		head5=new JLabel("Check for %");
		head6=new JLabel("Deduction");
		head7=new JLabel("Deduction Value");
		head8=new JLabel("Information");
		gpflbl=new JLabel("GPF Deduction :");
		itlbl=new JLabel("IT Deduction :");
		gislbl=new JLabel("GIS Deduction :");
		liclbl=new JLabel("LIC Deduction :");
		pflbl=new JLabel("PF Deduction");
		gpfch=new JCheckBox("GPF",false);
		gpfch.addItemListener(this);
		itch=new JCheckBox("IT",false);
		itch.addItemListener(this);
		gisch=new JCheckBox("GIS",false);
		gisch.addItemListener(this);
		licch=new JCheckBox("LIC",false);
		licch.addItemListener(this);
		pfch=new JCheckBox("PF",false);
		pfch.addItemListener(this);
		gistxt=new JTextField(10);		
		ittxt=new JTextField(10);
		gpftxt=new JTextField(10);
		lictxt=new JTextField(10);
		pftxt=new JTextField(10);
		gpfinfo=new JTextField(10);
		gpfinfo.setText("Enter in Rupee");
		gpfinfo.setEditable(false);
		itinfo=new JTextField(10);
		itinfo.setText("Enter in Rupee");
		itinfo.setEditable(false);
		gisinfo=new JTextField(10);
		gisinfo.setText("Enter in Rupee");
		gisinfo.setEditable(false);
		licinfo=new JTextField(10);
		licinfo.setText("Enter in Rupee");
		licinfo.setEditable(false);
		pfinfo=new JTextField(10);
		pfinfo.setText("Enter in Rupee");
		pfinfo.setEditable(false);
		panel3.setLayout(new GridLayout(4,4));
		panel3.add(head1);
		panel3.add(head2);
		panel3.add(head3);
		panel3.add(head4);
		panel3.add(dalbl);
		panel3.add(dach);
		panel3.add(datxt);
		panel3.add(dainfo);
		panel3.add(hralbl);
		panel3.add(hrach);
		panel3.add(hratxt);
		panel3.add(hrainfo);
		panel3.add(walbl);
		panel3.add(wach);
		panel3.add(watxt);
		panel3.add(wainfo);
		
		panel4=new JPanel();
		panel4.add(head5);
		panel4.add(head6);
		panel4.add(head7);
		panel4.add(head8);
		panel4.add(gpflbl);
		panel4.add(gpfch);
		panel4.add(gpftxt);
		panel4.add(gpfinfo);
		panel4.add(itlbl);
		panel4.add(itch);
		panel4.add(ittxt);
		panel4.add(itinfo);
		panel4.add(gislbl);
		panel4.add(gisch);
		panel4.add(gistxt);
		panel4.add(gisinfo);
		panel4.add(liclbl);
		panel4.add(licch);
		panel4.add(lictxt);
		panel4.add(licinfo);
		panel4.add(pflbl);
		panel4.add(pfch);
		panel4.add(pftxt);
		panel4.add(pfinfo);
		panel4.setLayout(new GridLayout(6,4));
		
		add=new JButton("Add New");
		add.addActionListener(this);
		edit=new JButton("Edit");
		edit.addActionListener(this);
		delete=new JButton("Delete");
		delete.addActionListener(this);
		exit=new JButton("Exit");
		exit.addActionListener(this);
		panel5=new JPanel();
		panel5.setLayout(new FlowLayout());
		panel5.add(add);
		panel5.add(edit);
		panel5.add(delete);
		panel5.add(exit);
		
		Container pane=frame.getContentPane();
		pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
		pane.add(panel1);
		pane.add(panel2);
		pane.add(panel3);
		pane.add(panel4);
		pane.add(panel5);
		frame.setSize(700,500);
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
			addnew();
		}
		if(ae.getSource()==edit)
		{
			edit();
		}
		if(ae.getSource()==delete)
		{
			delete();
		}
		if(ae.getSource()==enocb)
		{
			try
			{
				s=""+enocb.getItemAt(enocb.getSelectedIndex());
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro","root","Saemarjn@1998");
				st=con.createStatement();
				rs=st.executeQuery("select edesi from employee where eno='"+s+"'");
				while(rs.next())
				{
					edesitxt.setText(rs.getString(1)+"");
				}
			}
			catch(ClassNotFoundException | SQLException e)
			{
				System.out.println(e);
			}
			try
			{
				s1=""+enocb.getItemAt(enocb.getSelectedIndex());
				String q="select * from settings where eno='"+s+"'";
				st=con.createStatement();
				rs=st.executeQuery(q);
				int found=0;
				while(rs.next())
				{
					ibs=rs.getString("bs");
					tda=rs.getString("sda");
					thra=rs.getString("shra");
					twa=rs.getString("swa");
					tgpf=rs.getString("sgpf");
					tit=rs.getString("sit");
					tgis=rs.getString("sgis");
					tlic=rs.getString("slic");
					tpf=rs.getString("spf");
					ida=rs.getString("vda");
					ihra=rs.getString("vhra");
					iwa=rs.getString("vwa");
					igpf=rs.getString("vgpf");
					iit=rs.getString("vit");
					igis=rs.getString("vgis");
					ilic=rs.getString("vlic");
					ipf=rs.getString("vpf");
					found=1;
				}	
				if(found==0)
				{
					hratxt.setText(null);
					datxt.setText(null);
					watxt.setText(null);
					gpftxt.setText(null);
					gistxt.setText(null);
					lictxt.setText(null);
					ittxt.setText(null);
					pftxt.setText(null);
					bstxt.setText(null);
					dach.setSelected(false);
					hrach.setSelected(false);
					wach.setSelected(false);
					gisch.setSelected(false);
					gpfch.setSelected(false);
					licch.setSelected(false);
					itch.setSelected(false);
					pfch.setSelected(false);
					JOptionPane.showMessageDialog(null,"Record Not Found\nPlease Add New Settings for Employee");
				}
				if(found==1)
				{
				if(tda.equals("true"))
				{
					dach.setSelected(true);
				}
				else if(tda.equals("false"))
				{
					dach.setSelected(false);
				}
				if(thra.equals("true"))
				{
					hrach.setSelected(true);
				}
				else if(thra.equals("false"))
				{
					hrach.setSelected(false);
				}
				if(twa.equals("true"))
				{
					wach.setSelected(true);
				}
				else if(twa.equals("false"))
				{
					wach.setSelected(false);
				}
				if(tgpf.equals("true"))
				{
					gpfch.setSelected(true);
				}
				else if(tgpf.equals("false"))
				{
					gpfch.setSelected(false);
				}
				if(tit.equals("true"))
				{
					itch.setSelected(true);
				}
				else if(tit.equals("false"))
				{
					itch.setSelected(false);
				}
				if(tgis.equals("true"))
				{
					gisch.setSelected(true);
				}
				else if(tgis.equals("false"))
				{
					gisch.setSelected(false);
				}
				if(tlic.equals("true"))
				{
					licch.setSelected(false);
				}
				else if(tlic.equals("false"))
				{
					licch.setSelected(false);
				}
				if(tpf.equals("true"))
				{
					pfch.setSelected(true);
				}
				else if(tpf.equals("false"))
				{
					pfch.setSelected(false);
				}
				bstxt.setText(ibs);
				datxt.setText(ida);
				hratxt.setText(ihra);
				watxt.setText(iwa);
				gpftxt.setText(igpf);
				ittxt.setText(iit);
				gistxt.setText(igis);
				lictxt.setText(ilic);
				pftxt.setText(ipf);
				}
			}
			catch(HeadlessException | SQLException e)
			{
				
			}
		}
	}
        @Override
	public void itemStateChanged(ItemEvent ie) {
		// TODO Auto-generated method stud
		if(ie.getItemSelectable()==dach)
		{
			if(ie.getStateChange()==ItemEvent.SELECTED)
			{
				sda="true";
				dainfo.setText("Enter in %");
			}
			else if(ie.getStateChange()==ItemEvent.DESELECTED)
			{
				sda="false";
				dainfo.setText("Enter in Rupee");
			}
		}
		else if(ie.getItemSelectable()==hrach)
		{
			if(ie.getStateChange()==ItemEvent.SELECTED)
			{
				shra="true";
				hrainfo.setText("Enter in %");
			}
			else if(ie.getStateChange()==ItemEvent.DESELECTED)
			{
				shra="false";
				hrainfo.setText("Enter in Rupee");
			}
		}
		else if(ie.getItemSelectable()==wach)
		{
			if(ie.getStateChange()==ItemEvent.SELECTED)
			{
				swa="true";
				wainfo.setText("Enter in %");
			}
			else if(ie.getStateChange()==ItemEvent.DESELECTED)
			{
				swa="false";
				wainfo.setText("Enter in Rupee");
			}
		}
		else if(ie.getItemSelectable()==gisch)
		{
			if(ie.getStateChange()==ItemEvent.SELECTED)
			{
				sgis="true";
				gisinfo.setText("Enter in %");
			}
			else if(ie.getStateChange()==ItemEvent.DESELECTED)
			{
				sgis="false";
				gisinfo.setText("Enter in Rupee");
			}
		}
		else if(ie.getItemSelectable()==itch)
		{
			if(ie.getStateChange()==ItemEvent.SELECTED)
			{
				sit="true";
				itinfo.setText("Enter in %");
			}
			else if(ie.getStateChange()==ItemEvent.DESELECTED)
			{
				sit="false";
				itinfo.setText("Enter in Rupee");
			}
		}
		else if(ie.getItemSelectable()==gpfch)
		{
			if(ie.getStateChange()==ItemEvent.SELECTED)
			{
				sgpf="true";
				gpfinfo.setText("Enter in %");
			}
			else if(ie.getStateChange()==ItemEvent.DESELECTED)
			{
				sgpf="false";
				gpfinfo.setText("Enter in Rupee");
			}
		}
		else if(ie.getItemSelectable()==licch)
		{
			if(ie.getStateChange()==ItemEvent.SELECTED)
			{
				slic="true";
				licinfo.setText("Enter in %");
			}
			else if(ie.getStateChange()==ItemEvent.DESELECTED)
			{
				slic="false";
				licinfo.setText("Enter in Rupee");
			}
		}
		else if(ie.getItemSelectable()==pfch)
		{
			if(ie.getStateChange()==ItemEvent.SELECTED)
			{
				spf="true";
				pfinfo.setText("Enter in %");
			}
			else if(ie.getStateChange()==ItemEvent.DESELECTED)
			{
				spf="false";
				pfinfo.setText("Enter in Rupee");
			}
		}
	}
	public void addnew()
	{
		eno=""+enocb.getItemAt(enocb.getSelectedIndex());
		edesi=edesitxt.getText();
		bs=bstxt.getText();
		vda=datxt.getText();
		vhra=hratxt.getText();
		vwa=watxt.getText();
		vgpf=gpftxt.getText();
		vit=ittxt.getText();
		vlic=lictxt.getText();
		vpf=pftxt.getText();
		vgis=gistxt.getText();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro","root","Saemarjn@1998");
			ps=con.prepareStatement("insert into settings values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,eno);
			ps.setString(2,edesi);
			ps.setString(3,bs);
			ps.setString(4,sda);
			ps.setString(5,shra);
			ps.setString(6,swa);
			ps.setString(7,sgpf);
			ps.setString(8,sit);
			ps.setString(9,sgis);
			ps.setString(10,slic);
			ps.setString(11,spf);
			ps.setString(12,vda);
			ps.setString(13,vhra);
			ps.setString(14,vwa);
			ps.setString(15,vgpf);
			ps.setString(16,vit);
			ps.setString(17,vgis);
			ps.setString(18,vlic);
			ps.setString(19,vpf);
			ps.executeUpdate();
			hratxt.setText(null);
			datxt.setText(null);
			watxt.setText(null);
			gpftxt.setText(null);
			gistxt.setText(null);
			lictxt.setText(null);
			ittxt.setText(null);
			pftxt.setText(null);
			bstxt.setText(null);
			dach.setSelected(false);
			hrach.setSelected(false);
			wach.setSelected(false);
			gisch.setSelected(false);
			gpfch.setSelected(false);
			licch.setSelected(false);
			itch.setSelected(false);
			pfch.setSelected(false);			
			edesitxt.setText(null);
			JOptionPane.showMessageDialog(null,"Added Successfull");
		}
		catch(HeadlessException | ClassNotFoundException | SQLException e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
	}
	public void edit()
	{
		try
		{
			eno=""+enocb.getItemAt(enocb.getSelectedIndex());
			vda=datxt.getText();
			vhra=hratxt.getText();
			vwa=watxt.getText();
			vgpf=gpftxt.getText();
			vit=ittxt.getText();
			vlic=lictxt.getText();
			vpf=pftxt.getText();
			vgis=gistxt.getText();
			ps=con.prepareStatement("update settings set bs=?,sda=?,shra=?,swa=?,sgpf=?,sit=?,sgis=?,slic=?,spf=?,vda=?,vhra=?,vwa=?,vgpf=?,vit=?,vgis=?,vlic=?,vpf=? where eno=?");
			ps.setString(1,bstxt.getText());
			ps.setString(2,sda);
			ps.setString(3,shra);
			ps.setString(4,swa);
			ps.setString(5,sgpf);
			ps.setString(6,sit);
			ps.setString(7,sgis);
			ps.setString(8,slic);
			ps.setString(9,spf);
			ps.setString(10,vda);
			ps.setString(11,vhra);
			ps.setString(12,vwa);
			ps.setString(13,vgpf);
			ps.setString(14,vit);
			ps.setString(15,vgis);
			ps.setString(16,vlic);
			ps.setString(17,vpf);
			ps.setString(18,eno);
			ps.executeUpdate();
			hratxt.setText(null);
			datxt.setText(null);
			watxt.setText(null);
			gpftxt.setText(null);
			gistxt.setText(null);
			lictxt.setText(null);
			ittxt.setText(null);
			pftxt.setText(null);
			bstxt.setText(null);
			dach.setSelected(false);
			hrach.setSelected(false);
			wach.setSelected(false);
			gisch.setSelected(false);
			gpfch.setSelected(false);
			licch.setSelected(false);
			itch.setSelected(false);
			pfch.setSelected(false);
			edesitxt.setText(null);
			JOptionPane.showMessageDialog(null,"Edit Successful");
		}
		catch(HeadlessException | SQLException e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
	}
	public void delete()
	{
		try
		{
			s=""+enocb.getItemAt(enocb.getSelectedIndex());
			st=con.createStatement();
			st.executeUpdate("delete from settings where eno='"+s+"'");
			JOptionPane.showMessageDialog(null,"Deleted Successfull");
			hratxt.setText(null);
			datxt.setText(null);
			watxt.setText(null);
			gpftxt.setText(null);
			gistxt.setText(null);
			lictxt.setText(null);
			ittxt.setText(null);
			pftxt.setText(null);
			bstxt.setText(null);
			dach.setSelected(false);
			hrach.setSelected(false);
			wach.setSelected(false);
			gisch.setSelected(false);
			gpfch.setSelected(false);
			licch.setSelected(false);
			itch.setSelected(false);
			pfch.setSelected(false);			
			edesitxt.setText(null);
		}
		catch(HeadlessException | SQLException e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
	}
}
