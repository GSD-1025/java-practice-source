package test;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class imageGUI extends JFrame {
	private String imagepath;
	private TDAO td;
	
	
	imageGUI(TDAO td) {
		this.td=td;
		imagepath=td.getImagePath();
		System.out.println(imagepath);
		ImageIcon imageIcon = new ImageIcon(imagepath);
		Image image=imageIcon.getImage();
		Image scalp=image.getScaledInstance(200, 200, Image.SCALE_FAST);
		ImageIcon imageIcon2= new ImageIcon(scalp);
		JLabel label=new JLabel(imageIcon2);
		this.setLayout(new BorderLayout());
		this.add(label,BorderLayout.CENTER);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
}
