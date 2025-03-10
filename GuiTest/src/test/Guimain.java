package test;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Guimain extends JFrame implements ActionListener{
	private JLabel j1=new JLabel("휴먼 word system");
	private JButton btn1=new JButton("Save");
	private DefaultListModel model=new DefaultListModel(); 
	private JList l1=new JList(model);
	private JTextField jt= new JTextField();
	private JPanel jp1=new JPanel();
	private JLabel id=new JLabel("ID");
	private JLabel name=new JLabel("Name");
	private JLabel addr=new JLabel("Address");
	private JTextField idF= new JTextField(10);
	private JTextField nameF= new JTextField(10);
	private JTextField addrF= new JTextField(10);

	public Guimain() {
		this.setBounds(100, 200, 500, 500);
		this.setTitle("단어장");
		this.add("North",j1);
		this.add("East",btn1);
		btn1.setBackground(Color.GRAY);
		this.add("Center",jp1);
		jp1.setBackground(Color.YELLOW);
		jp1.setLayout(new GridLayout(3,3));
		jp1.add(id);
		jp1.add(idF);
		jp1.add(name);
		jp1.add(nameF);
		jp1.add(addr);
		jp1.add(addrF);
		this.add("South",jt);
		this.add("South",l1);
		model.addElement("abc");
		
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		btn1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			String id=idF.getText();
			String name=nameF.getText();
			String addr=addrF.getText();
			String msg=id+"/"+name+"/"+addr;
			model.addElement(msg);
			idF.setText("");
			nameF.setText("");
			addrF.setText("");
		}
	}

}
