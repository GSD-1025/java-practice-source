package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NewGui extends JFrame implements ActionListener{
	private JButton btn1=new JButton("Save");
	private JButton btn2=new JButton("Save");
	private JButton btn3=new JButton("Save");
	private JButton btn4=new JButton("Save");
	private JButton btn5=new JButton("Save");
	private JPanel jp1=new JPanel();
	private JPanel jp2=new JPanel();
	private JPanel jp3=new JPanel();
	private JPanel jp4=new JPanel();
	private JPanel jp5=new JPanel();
	
	public NewGui() {
		this.setBounds(100, 200, 500, 500);
		this.setTitle("예시");
		this.add("Center",jp1);
		jp1.add(btn1);
		this.add("North",jp2);
		jp2.add(btn2);
		this.add("East",jp3);
		jp3.add(btn3);
		this.add("West",jp4);
		jp4.add(btn4);
		this.add("South",jp5);
		jp5.add(btn5);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
