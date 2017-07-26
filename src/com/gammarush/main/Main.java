package com.gammarush.main;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.gammarush.main.gui.PDFPreview;

public class Main {
	
	public JFrame frame;
	
	public JFrame coordFrame;
	public JLabel xLabel;
	public JLabel yLabel;
	public JLabel zLabel;
	public JTextField xField;
	public JTextField yField;
	public JTextField zField;
	
	public PDFPreview preview;
	
	public PDF pdf;
	
	public Main() {
		frame = new JFrame("PDF Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 800);
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
				int delta = 0;
				if(e.getKeyCode() == 38) delta = -1;
				if(e.getKeyCode() == 40) delta = 1;
				
				preview.setPageIndex(preview.getPageIndex() + delta);
				try {
					preview.render();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		
		coordFrame = new JFrame("Coords");
		coordFrame.setSize(400, 308);
		coordFrame.setResizable(false);
		coordFrame.setFocusable(true);
		coordFrame.setLocationRelativeTo(null);
		coordFrame.getContentPane().setLayout(null);
		coordFrame.setVisible(false);
		xLabel = new JLabel("X:");
		xLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		xLabel.setBounds(16, 16, 64, 64);
		coordFrame.add(xLabel);
		xField = new JTextField("X");
		xField.setFont(new Font("Verdana", Font.PLAIN, 24));
		xField.setBounds(80, 16, 300, 64);
		coordFrame.add(xField);
		yLabel = new JLabel("Y:");
		yLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		yLabel.setBounds(16, 96, 64, 64);
		coordFrame.add(yLabel);
		yField = new JTextField("Y");
		yField.setFont(new Font("Verdana", Font.PLAIN, 24));
		yField.setBounds(80, 96, 300, 64);
		coordFrame.add(yField);
		zLabel = new JLabel("#:");
		zLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		zLabel.setBounds(16, 176, 64, 64);
		coordFrame.add(zLabel);
		zField = new JTextField("Z");
		zField.setFont(new Font("Verdana", Font.PLAIN, 24));
		zField.setBounds(80, 176, 300, 64);
		coordFrame.add(zField);
		
		preview = new PDFPreview();
		preview.addMouseListener(new MouseAdapter() {
			@Override
            public void mousePressed(MouseEvent e) {
				float x = (float) e.getX() / preview.getWidth();
				float y = 1f - ((float) e.getY() / preview.getHeight());
				xField.setText(x + "");
				yField.setText(y + "");
				zField.setText(preview.getPageIndex() + "");
				coordFrame.setVisible(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            	
            }
		});
		frame.add(preview);
		
		try {
			pdf = new PDF("res/long.pdf");
	    	preview.load(pdf);
	    	preview.render();
	    	frame.setSize(preview.getWidth(), preview.getHeight());
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
	}

    public static void main(String[] args) throws IOException {
    	new Main();
    }
    
}
