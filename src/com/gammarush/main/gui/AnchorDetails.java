package com.gammarush.main.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AnchorDetails extends JPanel {
	
	private static final long serialVersionUID = -602279748094284667L;
	
	private Font font = new Font("Verdana", Font.PLAIN, 20);
	
	public JLabel nameLabel = new JLabel("Name:");
	public JTextField nameField = new JTextField();
	
	public JLabel xLabel = new JLabel("X:");
	public JTextField xField = new JTextField();
	
	public JLabel yLabel = new JLabel("Y:");
	public JTextField yField = new JTextField();
	
	public AnchorDetails() {
		nameLabel.setBounds(4, 4, 56, 40);
		nameLabel.setFont(font);
		add(nameLabel);
		nameField.setBounds(36, 4, 56, 40);
		nameField.setFont(font);
		/*nameField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {}
			public void removeUpdate(DocumentEvent e) {}
			public void insertUpdate(DocumentEvent e) {}
		});*/
		add(nameField);
		
		xLabel.setBounds(4, 48, 56, 40);
		xLabel.setFont(font);
		add(xLabel);
		xField.setBounds(36, 48, 56, 40);
		xField.setFont(font);
		/*nameField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {}
			public void removeUpdate(DocumentEvent e) {}
			public void insertUpdate(DocumentEvent e) {}
		});*/
		add(xField);
		
		yLabel.setBounds(4, 92, 56, 40);
		yLabel.setFont(font);
		add(nameLabel);
		yField.setBounds(36, 92, 56, 40);
		yField.setFont(font);
		/*yField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {}
			public void removeUpdate(DocumentEvent e) {}
			public void insertUpdate(DocumentEvent e) {}
		});*/
		add(yField);
	}
	
}
