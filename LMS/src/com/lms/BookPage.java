package com.lms;

import java.awt.Color;
import java.awt.EventQueue;
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
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

public class BookPage extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookPage frame1 = new BookPage();
//					frame.setVisible(true);
//					frame.setTitle("Book Page");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public class CategoryItem
	{
		int cid;
		String name;
		public CategoryItem(int cid, String name)
		{
			this.cid=cid;
			this.name=name;	
		}
		public String toString()
		{
			return name;
		}
	}
	Connection cn;
	PreparedStatement st;
	ResultSet rs,rs1,rs2;
	public void Connect()
	{
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
			System.out.println("Connection Established...");
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void categoryData()
	{
		try {
			st=cn.prepareStatement("select * from category");
			rs=st.executeQuery();
			tfcat.removeAllItems();
			
			while(rs.next())
			{
				tfcat.addItem(new CategoryItem(rs.getInt(1), rs.getString(2)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	JFrame frame1;
	JLabel c1,catname,status;
	JTextField tf_book;
	JComboBox<Object> tfcat;
	JButton addc,delete,update,cancel;
	private JTable table;
	private String[] s1= {"Active", "Deactive"};
	private JTextField tfcont;
	private JTextField tfpage;
	private JTextField tfedition;
//	JButton btnNewButton = new JButton("Main Page");
	
	public BookPage() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(50, 10, 800, 800);
		
		frame1=new JFrame("Book Page");
		frame1.getContentPane().setBackground(new Color(230, 230, 250));
		frame1.getContentPane().setLayout(null);
		frame1.setSize(900, 700);
		frame1.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		c1=new JLabel("Book");
		c1.setFont(new Font("Serif",Font.BOLD, 30));
		c1.setBounds(300, 10, 85, 48);
		c1.setForeground(Color.BLUE);
		frame1.getContentPane().add(c1);
//		frame1.setBackground(Color.LIGHT_GRAY);
//		jp=new JPanel();
		
		catname=new JLabel("Book Name:");
		catname.setFont(new Font("Serif",Font.PLAIN, 15));
		catname.setForeground(Color.pink);
		catname.setBounds(30, 70, 85, 40);
		frame1.getContentPane().add(catname);
		
		status=new JLabel("Category");
		status.setFont(new Font("Serif",Font.PLAIN, 15));
		status.setForeground(Color.pink);
		status.setBounds(30, 130, 85, 40);
		
		tf_book=new JTextField();
		tf_book.setBounds(127, 70, 213, 40);
		
		tfcat=new JComboBox<Object>(s1);
		tfcat.setModel(new DefaultComboBoxModel(new String[] {" "}));
		tfcat.setBounds(127, 131, 170, 40);
//		tfcat.addMouseListener();
		
		addc=new JButton("Add");
		addc.setFont(new Font("Serif",Font.PLAIN, 15));
		addc.setBackground(new Color(30, 144, 255));
		addc.setBounds(50, 392, 60, 40);
		addc.addActionListener(this);
		
		delete=new JButton("Delete");
		delete.addActionListener(new ActionListener() 
		{
//			delete Query
			
			
			public void actionPerformed(ActionEvent e) {
			
			
				String bname=tf_book.getText();
				CategoryItem citem=(CategoryItem)tfcat.getSelectedItem();
				String contents=tfcont.getText();
				String pgs=tfpage.getText();
				String edition=tfedition.getText();

				DefaultTableModel d1=(DefaultTableModel) table.getModel();
				int selectindex=table.getSelectedRow();
				int id1=Integer.parseInt(d1.getValueAt(selectindex, 0).toString());
				tf_book.setText(d1.getValueAt(selectindex, 1).toString());
				tfcat.setSelectedItem(d1.getValueAt(selectindex, 2).toString());
				tfcont.setText((String) d1.getValueAt(selectindex, 3));
				tfpage.setText(d1.getValueAt(selectindex, 4).toString());
				tfedition.setText(d1.getValueAt(selectindex, 5).toString());
				addc.setEnabled(false);
				
				try {
//					String catn=tf1.getText();
//					String sts=tf2.getSelectedItem().toString();
					
					Class.forName("com.mysql.jdbc.Driver");
					cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
					System.out.println("Connection Established...");
					
					st=cn.prepareStatement("delete from book where bid=?");
					
//					st.setString(1, bname);
//					st.setInt(2, citem.cid);
//					st.setString(3, contents);
//					st.setString(4, pgs);
//					st.setString(5, edition);
					st.setInt(1, id1); 
					int k=st.executeUpdate();
					
					if(k>0)
					{
						JOptionPane.showMessageDialog(delete, this, "Deleted Successfully..", k);
						tf_book.setText(null);
						tfcont.setText(null);
						tfcat.setSelectedIndex(-1);
						tfpage.setText(null);
						tfedition.setText(null);
						bookDisplay();
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
		delete.setBounds(161, 392, 60, 40);
		
		update=new JButton("Update");
		update.addActionListener(new ActionListener()
		{
//			update Query
			
			public void actionPerformed(ActionEvent e) {
			
				String bname=tf_book.getText();
				CategoryItem citem=(CategoryItem)tfcat.getSelectedItem();
				String contents=tfcont.getText();
				String pgs=tfpage.getText();
				String edition=tfedition.getText();

				DefaultTableModel d1=(DefaultTableModel) table.getModel();
				int selectindex=table.getSelectedRow();
				int id1=Integer.parseInt(d1.getValueAt(selectindex, 0).toString());
				tf_book.setText(d1.getValueAt(selectindex, 1).toString());
				tfcat.setSelectedItem(d1.getValueAt(selectindex, 2).toString());
				tfcont.setText((String) d1.getValueAt(selectindex, 3));
				tfpage.setText(d1.getValueAt(selectindex, 4).toString());
				tfedition.setText(d1.getValueAt(selectindex, 5).toString());
				addc.setEnabled(false);
				try {
					String catn=tf_book.getText();
					String sts=tfcat.getSelectedItem().toString();
					
					Class.forName("com.mysql.jdbc.Driver");
					cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
					System.out.println("Connection Established...");
					
					st=cn.prepareStatement("update book set bname=?, cat=?, content=? , nopage=? , edition=? where bid=?");
					
					st.setString(1, bname);
					st.setInt(2, citem.cid);
					st.setString(3, contents);
					st.setString(4, pgs);
					st.setString(5, edition);
					st.setInt(6, id1);
					
					int k=st.executeUpdate();
					
					if(k>0)
					{
						JOptionPane.showMessageDialog(update, "Updated Successfully..");
						tf_book.setText(null);
						tfcont.setText(null);
						tfcat.setSelectedIndex(-1);
						tfpage.setText(null);
						tfedition.setText(null);
						bookDisplay();
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
		update.setBounds(50, 465, 60, 40);
		
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
		cancel.setBounds(161, 465, 60, 40);
		
		
		
		frame1.getContentPane().add(catname);
		
		frame1.getContentPane().add(c1);
		frame1.getContentPane().add(status);
		frame1.getContentPane().add(tf_book);
		frame1.getContentPane().add(tfcat);
		frame1.getContentPane().add(update);
		frame1.getContentPane().add(delete);
		frame1.getContentPane().add(addc);
		frame1.getContentPane().add(cancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(383, 70, 511, 412);
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
				tf_book.setText(d1.getValueAt(selectindex, 1).toString());
				tfcat.setSelectedItem(d1.getValueAt(selectindex,2).toString());
				tfcont.setText((String) d1.getValueAt(selectindex, 3));
				tfpage.setText(d1.getValueAt(selectindex, 4).toString());
				tfedition.setText(d1.getValueAt(selectindex, 5).toString());
				addc.setEnabled(false);
				
			}
		});
		scrollPane.setViewportView(table);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		
		JLabel lblNewLabel = new JLabel("Content");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setBounds(30, 193, 80, 24);
		frame1.getContentPane().add(lblNewLabel);
		
		tfcont = new JTextField();
		tfcont.setBounds(127, 183, 213, 34);
		frame1.getContentPane().add(tfcont);
		tfcont.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("No. Of Pages");
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setBounds(30, 249, 85, 24);
		frame1.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Edition");
		lblNewLabel_2.setForeground(Color.PINK);
		lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(30, 297, 61, 16);
		frame1.getContentPane().add(lblNewLabel_2);
		
		tfpage = new JTextField();
		tfpage.setBounds(127, 240, 213, 33);
		frame1.getContentPane().add(tfpage);
		tfpage.setColumns(10);
		
		tfedition = new JTextField();
		tfedition.setBounds(127, 292, 213, 34);
		frame1.getContentPane().add(tfedition);
		tfedition.setColumns(10);
		
//		function calling
		Connect();
		categoryData();
		
		bookDisplay();
		
	}
	public void bookDisplay()
	{ 
		int c;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
			String qry="select b.bid,b.bname,c.catname,b.content,b.nopage,b.edition from book b JOIN category c on b.cat=cid";
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
					String bid,bname,cat,content,nopage,edition;
					
					while(rs.next())
					{
						bid=rs.getString(1);
						bname=rs.getString(2);
						cat=rs.getString(3);
						content=rs.getString(4);
						nopage=rs.getString(5);
						edition=rs.getString(6);
						
						String[] row= {bid,bname,cat,content,nopage,edition};
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
		
		
		String bname=tf_book.getText();
		CategoryItem citem=(CategoryItem)tfcat.getSelectedItem();
		String contents=tfcont.getText();
		String pgs=tfpage.getText();
		String edition=tfedition.getText();
		
		
//		add query
		
		if(e.getSource()==addc)
		{
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
				System.out.println("Connection Established...");
				
				st=cn.prepareStatement("insert into book(bname,cat,content,nopage,edition) values(?,?,?,?,?)");
				
				st.setString(1, bname);
				st.setInt(2, citem.cid);
				st.setString(3, contents);
				st.setString(4, pgs);
				st.setString(5, edition);
				
				int k=st.executeUpdate();
				
				if(k>0)
				{
					JOptionPane.showMessageDialog(this, "Book Added Successfully..");
					tf_book.setText(null);
					tfcont.setText(null);
					tfcat.setSelectedIndex(-1);
					tfpage.setText(null);
					tfedition.setText(null);
					bookDisplay();
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

