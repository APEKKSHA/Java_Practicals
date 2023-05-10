package com.lms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;

import com.lms.IssueBook.BookItem;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IssueBook extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook frame1 = new IssueBook();
					frame1.setVisible(true);
					frame1.setTitle("Member Page");
					frame1.getContentPane().setBackground(new Color(230, 230, 250));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	
JFrame frame1;
private JTextField memid;
private JTextField memname;
JComboBox<BookItem> comboBox = new JComboBox<BookItem>();

JButton add1 = new JButton("Add");
JDateChooser dateChooser = new JDateChooser();
JDateChooser returndate = new JDateChooser();
Connection cn;
PreparedStatement st;
ResultSet rs;
private JTable table;
	public IssueBook() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(50, 10, 800, 800);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Issued Book\n");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 30));
		lblNewLabel.setBounds(172, 25, 197, 31);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Member Id");
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(16, 84, 80, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Member Name");
		lblNewLabel_2.setForeground(Color.PINK);
		lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(16, 113, 100, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Book\n");
		lblNewLabel_3.setForeground(Color.PINK);
		lblNewLabel_3.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(16, 144, 61, 16);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date");
		lblNewLabel_4.setForeground(Color.PINK);
		lblNewLabel_4.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(16, 173, 61, 16);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Return Date");
		lblNewLabel_5.setForeground(Color.PINK);
		lblNewLabel_5.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(16, 210, 80, 16);
		getContentPane().add(lblNewLabel_5);
		
		memid = new JTextField();
		memid.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					String mid=memid.getText();
					try {
						st=cn.prepareStatement("select * from member where mid=?");
						st.setString(1, mid);
						rs=st.executeQuery();
						if(rs.next()==false)
						{
							String msg="Member ID not Found..";
							JOptionPane.showMessageDialog(memid, msg);
						}
						else 
						{
							String membername=rs.getString("mname");
							memname.setText(membername.trim());
						}
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		memid.setBounds(128, 68, 151, 31);
		getContentPane().add(memid);
		memid.setColumns(10);
		
		memname = new JTextField();
		memname.setBounds(128, 108, 151, 31);
		getContentPane().add(memname);
		memname.setColumns(10);
		
		
		comboBox.setBounds(128, 140, 151, 27);
		getContentPane().add(comboBox);
		
		
		dateChooser.setBounds(128, 173, 151, 26);
		getContentPane().add(dateChooser);
		
		
		returndate.setBounds(128, 210, 151, 26);
		getContentPane().add(returndate);
		
		
		add1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
			}
		});
		add1.setFont(new Font("Serif", Font.PLAIN, 15));
		add1.setBounds(33, 269, 63, 36);
		getContentPane().add(add1);
		add1.addActionListener(this);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				DefaultTableModel d1=(DefaultTableModel) table.getModel();
				int selectindex=table.getSelectedRow();
				int id1=Integer.parseInt(d1.getValueAt(selectindex, 0).toString());
				memid.setText(d1.getValueAt(selectindex, 0).toString());
				memname.setText(d1.getValueAt(selectindex, 1).toString());
				comboBox.setSelectedItem(d1.getValueAt(selectindex,2).toString());
				try {
//					String catn=tf1.getText();
//					String sts=tf2.getSelectedItem().toString();
					
					Class.forName("com.mysql.jdbc.Driver");
					cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
					System.out.println("Connection Established...");
					
					st=cn.prepareStatement("delete from issuebook where issid=?");
					
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
						memid.setText(null);
						memname.setText(null);
						comboBox.setSelectedIndex(-1);
						dateChooser.setDate(null);
						returndate.setDate(null);
						issuedbookDisplay();
						add1.setEnabled(true);
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
				}}
		});
		delete.setFont(new Font("Serif", Font.PLAIN, 15));
		delete.setBounds(110, 269, 70, 36);
		getContentPane().add(delete);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel d1=(DefaultTableModel) table.getModel();
				int selectindex=table.getSelectedRow();
				int id1=Integer.parseInt(d1.getValueAt(selectindex, 0).toString());
				memid.setText(d1.getValueAt(selectindex, 0).toString());
				memname.setText(d1.getValueAt(selectindex, 1).toString());
				comboBox.setSelectedItem(d1.getValueAt(selectindex,2).toString());
//				tfpage.setText(d1.getValueAt(selectindex, 4).toString());
//				dateChooser.setdate((SimpleDateFormat) d1.getValueAt(selectindex, 4));
//				returndate.setDate((Date) d1.getValueAt(selectindex, 5));
				add1.setEnabled(false);
				try {
					String mid=memid.getText();
					String mname=memname.getText();
					BookItem mbook=(BookItem) comboBox.getSelectedItem();
					SimpleDateFormat datefor=new SimpleDateFormat("YYYY-MM-dd");
					String idate=datefor.format(dateChooser.getDate());  

					SimpleDateFormat datefor1=new SimpleDateFormat("YYYY-MM-dd");
					String rdate=datefor1.format(returndate.getDate());
					
					Class.forName("com.mysql.jdbc.Driver");
					cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
					System.out.println("Connection Established...");
					
					st=cn.prepareStatement("update issuebook set bookid=?, issuedate=? , returndate=?  where isid=?");
					st.setString(1, mid);
					st.setInt(2, mbook.id);
					st.setString(3, idate);
					st.setString(4, rdate);
					
					int k=st.executeUpdate();
					
					if(k>0)
					{
						JOptionPane.showMessageDialog(update, "Updated Successfully..");
						memid.setText(null);
						memname.setText(null);
						comboBox.setSelectedIndex(-1);
						dateChooser.setDate(null);
						returndate.setDate(null);
						issuedbookDisplay();
						add1.setEnabled(true);
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
		update.setFont(new Font("Serif", Font.PLAIN, 15));
		update.setBounds(33, 324, 70, 36);
		getContentPane().add(update);
		
		JButton cancel = new JButton("Cancel");
		cancel.setFont(new Font("Serif", Font.PLAIN, 15));
		cancel.setBounds(107, 321, 70, 36);
		getContentPane().add(cancel);cancel.addActionListener(new ActionListener() {
//			cancelling this form
			public void actionPerformed(ActionEvent e)
			{
				frame1.setVisible(false);
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(312, 68, 402, 292);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				DefaultTableModel d1=(DefaultTableModel) table.getModel();
				int selectindex=table.getSelectedRow();
				int id1=Integer.parseInt(d1.getValueAt(selectindex, 0).toString());
				memid.setText(d1.getValueAt(selectindex, 0).toString());
				memname.setText(d1.getValueAt(selectindex, 1).toString());
				comboBox.setSelectedItem(d1.getValueAt(selectindex,2).toString());
//				tfpage.setText(d1.getValueAt(selectindex, 4).toString());
				dateChooser.setDate((Date) d1.getValueAt(selectindex, 4));
				returndate.setDate((Date) d1.getValueAt(selectindex, 5));
				
				add1.setEnabled(false);
				
			}
		});
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(690, 68, -366, 250);
//		getContentPane().add(scrollPane);
		
		
		
		frame1=new JFrame("Member Page");
		frame1.setBackground(new Color(230, 230, 250));
		frame1.getContentPane().setLayout(null);
		
		frame1.setSize(900, 700);
		
		
//		function calling
		connect();
		book();
		issuedbookDisplay();
		
	}
	
	public void connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
			System.out.println("Connection Established...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public class BookItem
	{
		int id;
		String name;
		public BookItem(int id, String name)
		{
			this.id=id;
			this.name=name;
			
		}
		public String toString()
		{
			return name;
		}
		
	}
	
	public void book()
	{
		try {
			st=cn.prepareStatement("select * from book");
			rs=st.executeQuery();
			comboBox.removeAllItems();
			while(rs.next())
			{
				comboBox.addItem(new BookItem(rs.getInt(1),rs.getString(2)));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		public void issuedbookDisplay()
		{
			int c;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
					String qry="select l.isid,m.mname,b.bname,l.issuedate,l.returndate from issuebook l JOIN member m ON l.mid=m.mid JOIN book b ON l.bookid=b.bid";
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
							String isid,mid,bid,issuedate,returndate,extra;
							
							while(rs.next())
							{
								isid=rs.getString(1);
//								mid=rs.getString(2);
								bid=rs.getString(2);
								issuedate=rs.getString(3);
								returndate=rs.getString(4);
								extra=rs.getString(5);
								String[] row= {isid,bid,issuedate,returndate,extra};
								d.addRow(row);
							}

							

						}
				
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
			

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==add1)
		{
			String mid=memid.getText();
			String mname=memname.getText();
			BookItem mbook=(BookItem) comboBox.getSelectedItem();
			SimpleDateFormat datefor=new SimpleDateFormat("YYYY-MM-dd");
			String idate=datefor.format(dateChooser.getDate());  

			SimpleDateFormat datefor1=new SimpleDateFormat("YYYY-MM-dd");
			String rdate=datefor1.format(returndate.getDate());
			
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
				System.out.println("Connection Established...");
				
				st=cn.prepareStatement("insert into issuebook(mid,bid,issuedate,returndate) values(?,?,?,?)");
				
				st.setString(1, mid);
				st.setInt(2, mbook.id);
				st.setString(3, idate);
				st.setString(4, rdate);
				
				
				int k=st.executeUpdate();
				
				if(k>0)
				{
					JOptionPane.showMessageDialog(this, "Book Issued Successfully..");
					memid.setText(null);
					memname.setText(null);
					comboBox.setSelectedIndex(-1);
					dateChooser.setDate(null);
					returndate.setDate(null);
					issuedbookDisplay();
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
