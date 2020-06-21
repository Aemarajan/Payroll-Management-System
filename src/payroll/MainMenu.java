/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;
import javax.swing.*;
import java.awt.event.*;
class MainMenu extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JMenuBar mb;
	JMenu file,employee,tool,report;
	JMenuItem quit,add,edit,delete,setting,payslip;
	void design()
	{
		frame=new JFrame("Payroll Accounting System[Version 1.0]");
		
		mb=new JMenuBar();
		
		file=new JMenu("File");
		employee=new JMenu("Employee");
		tool=new JMenu("Tools");
		report=new JMenu("Report");
		
		quit=new JMenuItem("Quit");
		add=new JMenuItem("Add");
		edit=new JMenuItem("Edit");
		delete=new JMenuItem("Delete");
		setting=new JMenuItem("Setting");
		payslip=new JMenuItem("PaySlip");
		
		file.add(quit);
		quit.addActionListener(this);
		employee.add(add);
                add.addActionListener(this);
		employee.add(edit);
                edit.addActionListener(this);
		employee.add(delete);
                delete.addActionListener(this);
		tool.add(setting);
                setting.addActionListener(this);
		report.add(payslip);
                report.addActionListener(this);
		
		mb.add(file);
		mb.add(employee);
		mb.add(tool);
		mb.add(report);
		
		frame.setJMenuBar(mb);
		frame.setSize(900,700);
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
		if(ae.getSource()==quit)
		{
			System.exit(0);
		}
                if(ae.getSource()==add)
                {
                    AddEmployee addemp=new AddEmployee();
                    addemp.design();
                }
                if(ae.getSource()==delete)
                {
                    DeleteEmployee de=new DeleteEmployee();
                    de.design();
                }
                if(ae.getSource()==edit)
                {
                    EditEmployee ee=new EditEmployee();
                    ee.design();
                }
                if(ae.getSource()==setting)
                {
                    Settings settings=new Settings();
                    settings.design();
                }
                if(ae.getSource() == payslip){
                 
                }
	}
}