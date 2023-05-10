package com.lms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPage implements ActionListener 
{

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	
	JLabel lm;
	JButton cat,aut,pub,bk,mem,ibk,rbk,lg;
	JPanel panel;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
		panel=new JPanel();
		panel.setBounds(150, 50, 500, 700);
		panel.setBackground(Color.darkGray);
		panel.setLayout(null);
		
		lm=new JLabel("Library Management");
		lm.setFont(new Font("Serif",Font.PLAIN, 50));
		lm.setForeground(Color.yellow);
		lm.setBounds(40, 20, 450, 70);
		
		cat=new JButton("Categories");
		cat.setForeground(Color.pink);
		cat.setFont(new Font("Serif",Font.PLAIN, 20));
		cat.setBounds(140, 150, 200, 50);
		cat.addActionListener(this);
		
//		aut=new JButton("Authors");
//		aut.setForeground(Color.pink);
//		aut.setFont(new Font("Serif",Font.PLAIN, 20));
//		aut.setBounds(140, 210, 200, 50);
//		
//		pub=new JButton("Publishers");
//		pub.setForeground(Color.pink);
//		pub.setFont(new Font("Serif",Font.PLAIN, 20));
//		pub.setBounds(140, 270, 200, 50);
		
		bk=new JButton("Books");
		bk.setForeground(Color.pink);
		bk.setFont(new Font("Serif",Font.PLAIN, 20));
		bk.setBounds(140, 210, 200, 50);
		bk.addActionListener(this);
		
		mem=new JButton("Members");
		mem.setForeground(Color.pink);
		mem.setFont(new Font("Serif",Font.PLAIN, 20));
		mem.setBounds(140, 270, 200, 50);
		mem.addActionListener(this);
		
		ibk=new JButton("Issued Books");
		ibk.setForeground(Color.pink);
		ibk.setFont(new Font("Serif",Font.PLAIN, 20));
		ibk.setBounds(140, 330, 200, 50);
		ibk.addActionListener(this);
		
		rbk=new JButton("Returned Books");
		rbk.setForeground(Color.pink);
		rbk.setFont(new Font("Serif",Font.PLAIN, 20));
		rbk.setBounds(140, 390, 200, 50);
		rbk.addActionListener(this);
		
//		lg=new JButton("Logout");
//		lg.setForeground(Color.pink);
//		lg.setFont(new Font("Serif",Font.PLAIN, 20));
//		lg.setBounds(140, 450, 200, 50);
//		lg.addActionListener(this);
		
//		adding all the components into panel 
		panel.add(lm);
		panel.add(cat);
//		panel.add(aut);
//		panel.add(pub);
		panel.add(bk);
		panel.add(mem);
		panel.add(ibk);
		panel.add(rbk);
//		panel.add(lg);
		
//		adding panel into frame
		frame.add(panel);
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setLayout(null);
		frame.setTitle("Main Page");
//		frame.getContentPane().setBackground(Color.pink);
		frame.setBounds(100, 50, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cat)
		{
			new Category();
//			frame.dispose();
		}
		else if(e.getSource()==bk)
		{
			new BookPage();
//			frame.dispose();
		}
		else if(e.getSource()==mem)
		{
		Member m=new Member();
		m.setVisible(true);
		}
		else if(e.getSource()==ibk)
		{
			IssueBook ib= new IssueBook();
			ib.setVisible(true);
		}
		else if(e.getSource()==rbk)
		{
			ReturnBook rb= new ReturnBook();
			rb.setVisible(true);
		}
//		else if(e.getSource()==lg)
//		{
//			
//		}
		
	}



}
