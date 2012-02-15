package javamagFeb2012;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyWindow extends JFrame {
	public MyWindow() {
		GridLayout layout = new GridLayout(0,2,4,4);
		setLayout(layout);
		
		JLabel idLabel = new JLabel("ID:");
		
		for (String d : new String [] {"User1", "User2", "User3"})
		{
			add(idLabel);
			add(new JLabel(d));
		}
	}
	
	public static void main(String[] args) {
		new MyWindow();
	}
}