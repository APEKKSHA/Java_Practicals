package com.lms;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Member extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Member frame1 = new Member();
					frame1.setVisible(true);
					frame1.setTitle("Member Page");
					frame1.getContentPane().setBackground(new Color(230, 230, 250));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	JFrame frame1; 
	JComboBox<?> tf2;
	private JTable table;
	Connection cn;
	PreparedStatement st;
	ResultSet rs;
	private JTextField tfname;
	private JTextField tfphone;
	JButton add1 = new JButton("Add");
	JTextArea textArea = new JTextArea();
	public Member() {
		setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
		setBounds(50, 10, 800, 800);
		
		frame1=new JFrame("Member Page");
		frame1.setBackground(new Color(230, 230, 250));
		frame1.getContentPane().setLayout(null);
		
		frame1.setSize(900, 700);
//		frame1.setVisible(true);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel mem1 = new JLabel("Member");
		mem1.setForeground(Color.BLUE);
		mem1.setFont(new Font("Serif", Font.BOLD, 30));
		mem1.setBounds(250, 18, 170, 29);
		contentPane.add(mem1);
		
		JLabel mem2 = new JLabel("Name");
		mem2.setForeground(Color.PINK);
		mem2.setFont(new Font("Serif", Font.PLAIN, 15));
		mem2.setBounds(20, 85, 49, 16);
		contentPane.add(mem2);
		
		JLabel lblNewLabel = new JLabel("Address");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setBounds(20, 127, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Phone");
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 224, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		tfname = new JTextField();
		tfname.setBounds(91, 80, 141, 35);
		contentPane.add(tfname);
		tfname.setColumns(10);
		
		tfphone = new JTextField();
		tfphone.setBounds(93, 224, 139, 35);
		contentPane.add(tfphone);
		tfphone.setColumns(10);
		
		
		add1.setFont(new Font("Serif", Font.PLAIN, 15));
		add1.setBounds(20, 296, 75, 35);
		contentPane.add(add1);
		add1.addActionListener(this);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel d1=(DefaultTableModel) table.getModel();
				int selectindex=table.getSelectedRow();
				int id1=Integer.parseInt(d1.getValueAt(selectindex, 0).toString());
				System.out.println(id1);
				try {
//					String catn=tf1.getText();
//					String sts=tf2.getSelectedItem().toString();
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
					System.out.println("Connection Established...");
					
					st=cn.prepareStatement("delete from member where mid=?");
					
//					st.setString(1, catn);
//					st.setString(2, sts);
					st.setInt(1, id1);
					int k=st.executeUpdate();
					
					if(k>0)
					{
						JOptionPane.showMessageDialog(delete, this, "Deleted Successfully..", k);
						tfname.setText(null);
						textArea.setText(null);
						tfphone.setText(null);
						memberDisplay();
					}
					else
					{
						JOptionPane.showInputDialog(this, "Error...");
					}
					add1.setEnabled(true);
//					cn.close();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		delete.setFont(new Font("Serif", Font.PLAIN, 15));
		delete.setBounds(115, 296, 75, 35);
		contentPane.add(delete);
		
		
		textArea.setBounds(93, 127, 139, 86);
		contentPane.add(textArea);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				DefaultTableModel d1=(DefaultTableModel) table.getModel();
				int selectindex=table.getSelectedRow();
				int id1=Integer.parseInt(d1.getValueAt(selectindex, 0).toString());
				
				try {
					String mname=tfname.getText();
					String address=textArea.getText();
					String phone=tfphone.getText();
					
					Class.forName("com.mysql.jdbc.Driver");
					cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
					System.out.println("Connection Established...");
					
					st=cn.prepareStatement("update member set mname=?, address=?, phone=? where mid=?");
					
					st.setString(1, mname);
					st.setString(2, address);
					st.setString(3, phone);
					st.setInt(4, id1);
					int k=st.executeUpdate();
					
					if(k>0)
					{
						JOptionPane.showMessageDialog(update, "Updated Successfully..");
						tfname.setText(null);
						textArea.setText(null);
						tfphone.setText(null);
						memberDisplay();
					}
					else
					{
						JOptionPane.showMessageDialog(update, "Error...");
					}
					add1.setEnabled(true);
//					cn.close();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
				
			}
		});
		update.setBounds(20, 343, 75, 35);
		contentPane.add(update);
		
		JButton cancel = new JButton("Cancel\n");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frame1.setVisible(false);
				
			}
		});
		cancel.setBounds(115, 343, 75, 35);
		contentPane.add(cancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(278, 82, 381, 296);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				DefaultTableModel d1=(DefaultTableModel) table.getModel();
				int selectindex=table.getSelectedRow();
				int id1=Integer.parseInt(d1.getValueAt(selectindex, 0).toString());
				tfname.setText(d1.getValueAt(selectindex, 1).toString());
				textArea.setText(d1.getValueAt(selectindex, 2).toString());
				tfphone.setText(d1.getValueAt(selectindex, 3).toString());
				add1.setEnabled(false);
				
			}
		});
		scrollPane.setViewportView(table);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		
//		function calling 
		memberDisplay();
	}
	
	public void memberDisplay()
	{ 
		int c;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
			String qry="select * from member";
			st=cn.prepareStatement(qry);
			rs=st.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			c=rsmd.getColumnCount();
			String[] colname=new String[c];
			
			DefaultTableModel d=(DefaultTableModel) table.getModel();
			d.setRowCount(0);
				for(int i=0;i<c;i++)
				{
					colname[i]=rsmd.getColumnClassName(i+1);
					d.setColumnIdentifiers(colname);
					String mid,mname,address,phone;
					
					while(rs.next())
					{
						mid=rs.getString(1);
						mname=rs.getString(2);
						address=rs.getString(3);
						phone=rs.getString(4);
						
						String[] row= {mid,mname,address,phone};
						d.addRow(row);
					}
				}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		
		
		String mname=tfname.getText();
		String address=textArea.getText();
		String phone=tfphone.getText();
		
		if(e.getSource()==add1)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
				System.out.println("Connection Established...");
				
				st=cn.prepareStatement("insert into member(mname,address,phone) values(?,?,?)");
				
				st.setString(1,mname);
				st.setString(2, address);
				st.setString(3, phone);
				int k=st.executeUpdate();
				
				if(k>0)
				{
					JOptionPane.showMessageDialog(this, "Member Added Successfully..");
					tfname.setText(null);
					textArea.setText(null);
					tfphone.setText(null);
					memberDisplay();
					add1.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Error...");
				}
				
//				cn.close();
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
