package com.lms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Book extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book frame = new Book();
//					frame.setVisible(true);
//					frame.setTitle("Category Page");
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
	JLabel c1,catname,status;
	JTextField tf1;
	JComboBox tf2;
	JButton addc,delete,update,cancel;
	private JTable table;
	private String[] s1= {"Active", "Deactive"};
	Connection cn;
	PreparedStatement st;
	ResultSet rs,rs1,rs2;
	
//	JPanel jp;
	public Book() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 10, 800, 800);
		
		frame1=new JFrame("Category Page");
		frame1.getContentPane().setBackground(new Color(230, 230, 250));
		frame1.getContentPane().setLayout(null);
		frame1.setSize(900, 700);
		frame1.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		c1=new JLabel("Category");
		c1.setFont(new Font("Serif",Font.BOLD, 30));
		c1.setBounds(300, 10, 170, 70);
		c1.setForeground(Color.BLUE);
//		frame1.setBackground(Color.LIGHT_GRAY);
//		jp=new JPanel();
		
		catname=new JLabel("Category Name:");
		catname.setFont(new Font("Serif",Font.PLAIN, 15));
		catname.setForeground(Color.pink);
		catname.setBounds(30, 70, 130, 40);
		
		status=new JLabel("Status");
		status.setFont(new Font("Serif",Font.PLAIN, 15));
		status.setForeground(Color.pink);
		status.setBounds(30, 130, 130, 40);
		
		tf1=new JTextField();
		tf1.setBounds(170, 70, 170, 40);
		
		tf2=new JComboBox<Object>(s1);
		tf2.setBounds(170, 130, 170, 40);
		
		addc=new JButton("Add");
		addc.setFont(new Font("Serif",Font.PLAIN, 15));
		addc.setBackground(new Color(30, 144, 255));
		addc.setBounds(50, 190, 60, 40);
		addc.addActionListener(this);
		
		delete=new JButton("Delete");
		delete.addActionListener(new ActionListener() 
		{
//			delete Query
			
			
			public void actionPerformed(ActionEvent e) {
			
			
				DefaultTableModel d1=(DefaultTableModel) table.getModel();
				int selectindex=table.getSelectedRow();
				int id1=Integer.parseInt(d1.getValueAt(selectindex, 0).toString());
				
				try {
//					String catn=tf1.getText();
//					String sts=tf2.getSelectedItem().toString();
					
					Class.forName("com.mysql.jdbc.Driver");
					cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
					System.out.println("Connection Established...");
					
					st=cn.prepareStatement("delete from category where cid=?");
					
//					st.setString(1, catn);
//					st.setString(2, sts);
					st.setInt(1, id1);
					int k=st.executeUpdate();
					
					if(k>0)
					{
						JOptionPane.showMessageDialog(delete, this, "Deleted Successfully..", k);
						tf1.setText(null);
						tf2.setSelectedIndex(-1);
						categoryDisplay();
					}
					else
					{
						JOptionPane.showInputDialog(this, "Error...");
					}
					addc.setEnabled(true);
//					cn.close();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		delete.setFont(new Font("Serif",Font.PLAIN, 15));
		delete.setBackground(Color.darkGray);
		delete.setBounds(150, 190, 60, 40);
		
		update=new JButton("Update");
		update.addActionListener(new ActionListener()
		{
//			update Query
			
			public void actionPerformed(ActionEvent e) {
			
				DefaultTableModel d1=(DefaultTableModel) table.getModel();
				int selectindex=table.getSelectedRow();
				int id1=Integer.parseInt(d1.getValueAt(selectindex, 0).toString());
				
				try {
					String catn=tf1.getText();
					String sts=tf2.getSelectedItem().toString();
					
					Class.forName("com.mysql.jdbc.Driver");
					cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
					System.out.println("Connection Established...");
					
					st=cn.prepareStatement("update category set catname=?, status=? where cid=?");
					
					st.setString(1, catn);
					st.setString(2, sts);
					st.setInt(3, id1);
					int k=st.executeUpdate();
					
					if(k>0)
					{
						JOptionPane.showMessageDialog(update, "Updated Successfully..");
						tf1.setText(null);
						tf2.setSelectedIndex(-1);
						categoryDisplay();
					}
					else
					{
						JOptionPane.showMessageDialog(update, "Error...");
					}
					addc.setEnabled(true);
//					cn.close();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		update.setFont(new Font("Serif",Font.PLAIN, 15));
		update.setBackground(Color.darkGray);
		update.setBounds(50, 250, 60, 40);
		
		cancel=new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
//			cancelling this form
			public void actionPerformed(ActionEvent e)
			{
				frame1.setVisible(false);
				
			}
		});
		cancel.setFont(new Font("Serif",Font.PLAIN, 15));
		cancel.setBackground(Color.darkGray);
		cancel.setBounds(150, 250, 60, 40);
		
		
		
		frame1.getContentPane().add(catname);
		
		frame1.getContentPane().add(c1);
		frame1.getContentPane().add(status);
		frame1.getContentPane().add(tf1);
		frame1.getContentPane().add(tf2);
		frame1.getContentPane().add(update);
		frame1.getContentPane().add(delete);
		frame1.getContentPane().add(addc);
		frame1.getContentPane().add(cancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 70, 400, 300);
		frame1.getContentPane().add(scrollPane);
//		String[][] data= {{"1","Demo","Active"},{"22","22","22"}};
//		String colname[]= {"ID","Category Name","Status"};
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				DefaultTableModel d1=(DefaultTableModel) table.getModel();
				int selectindex=table.getSelectedRow();
				int id1=Integer.parseInt(d1.getValueAt(selectindex, 0).toString());
				tf1.setText(d1.getValueAt(selectindex, 1).toString());
				tf2.setSelectedItem(d1.getValueAt(selectindex, 2).toString());
				addc.setEnabled(false);
				
			}
		});
		scrollPane.setViewportView(table);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		
		
//		function calling
		categoryDisplay();
		
	}
	public void categoryDisplay()
	{ 
		int c;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
			String qry="select * from category";
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
					String id,cat,sts;
					
					while(rs.next())
					{
						id=rs.getString(1);
						cat=rs.getString(2);
						sts=rs.getString(3);
						
						String[] row= {id,cat,sts};
						d.addRow(row);
					}

					

				}
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		
		String catn=tf1.getText();
		String sts=tf2.getSelectedItem().toString();
		
		if(e.getSource()==addc)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
				System.out.println("Connection Established...");
				
				st=cn.prepareStatement("insert into category(catname,status) values(?,?)");
				
				st.setString(1, catn);
				st.setString(2, sts);
				int k=st.executeUpdate();
				
				if(k>0)
				{
					JOptionPane.showMessageDialog(this, "Category Added Successfully..");
					tf1.setText(null);
					tf2.setSelectedIndex(-1);
					categoryDisplay();
					addc.setEnabled(true);
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
