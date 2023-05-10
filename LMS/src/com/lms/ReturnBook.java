package com.lms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.lms.IssueBook.BookItem;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class ReturnBook extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame1 = new ReturnBook();
					frame1.setVisible(true);
					frame1.setTitle("Return Book Page");
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
	private JTextField memid;
	Connection cn;
	PreparedStatement st;
	ResultSet rs;
	private JTextField days;
	private JTextField fine;
	private JTable table;
	JButton add1 = new JButton("Add");
	JLabel memname = new JLabel("New label");
	JLabel lblNewLabel_7 = new JLabel("New label");
	private JTextField showdate;
	public ReturnBook() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(50, 10, 800, 800);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Return Book\n");
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
		
		JLabel lblNewLabel_4 = new JLabel("Return Date");
		lblNewLabel_4.setForeground(Color.PINK);
		lblNewLabel_4.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(16, 173, 75, 16);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Days ELap ");
		lblNewLabel_5.setForeground(Color.PINK);
		lblNewLabel_5.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(16, 210, 80, 16);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fine ");
		lblNewLabel_6.setForeground(Color.PINK);
		lblNewLabel_6.setFont(new Font("Serif", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(16, 250, 80, 16);
		getContentPane().add(lblNewLabel_6);
		
		memid = new JTextField();
		memid.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					String mid=memid.getText();
					try {
						st=cn.prepareStatement("select m.mname, b.bname,l.returndate,DATEDIFF(now(),l.returndate) as elap from issuebook l JOIN member m ON l.mid=m.mid JOIN book b ON l.bookid=b.bid and l.mid=?");
						st.setString(1, mid);
						rs=st.executeQuery();
						if(rs.next()==false)
						{
							String msg="Member ID not Found..";
							JOptionPane.showMessageDialog(memid, msg);
						}
						else 
						{
							String membername=rs.getString("m.mname");
							String memberbook=rs.getString("b.bname");
							memname.setText(membername.trim());
							lblNewLabel_7.setText(memberbook.trim());
							String date=rs.getString("l.returndate");
							showdate.setText(date);
							String elp=rs.getString("elap");
							
							int elapd=Integer.parseInt(elp);
							if(elapd>0)
							{
								days.setText(elp);
		  						int finee=elapd*100;
								
								fine.setText(String.valueOf(finee));
							}
							else
							{
								days.setText("0");
								fine.setText("0");
							}
							
						}
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		memid.setBounds(130, 77, 151, 31);
		getContentPane().add(memid);
		memid.setColumns(10);
		
		
		memname.setBounds(140, 111, 141, 21);
		contentPane.add(memname);
		
		
		lblNewLabel_7.setBounds(139, 139, 142, 21);
		contentPane.add(lblNewLabel_7);
		
		days = new JTextField();
		days.setBounds(130, 200, 151, 26);
		contentPane.add(days);
		days.setColumns(10);
		
		fine = new JTextField();
		fine.setBounds(130, 238, 151, 26);
		contentPane.add(fine);
		fine.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(310, 68, 378, 291);
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
				lblNewLabel_7.setText((String) d1.getValueAt(selectindex, 2));
				showdate.setText((String) d1.getValueAt(selectindex, 3));
				days.setText((String) d1.getValueAt(selectindex, 4));
				fine.setText((String) d1.getValueAt(selectindex, 5));
//				String memberid=memid.getText();
//				String membername=memname.getText();
//				String bookname=lblNewLabel_7.getText();
//				String returdate=showdate.getText();
//				String elpday=days.getText();
//				String ffine=fine.getText();
				
				add1.setEnabled(false);
				
			}
		});
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		
		showdate = new JTextField();
		showdate.setBounds(130, 163, 151, 31);
		contentPane.add(showdate);
		showdate.setColumns(10);
		
		
		add1.setBounds(16, 288, 80, 41);
		contentPane.add(add1);
		add1.addActionListener(this);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel d1=(DefaultTableModel) table.getModel();
				int selectindex=table.getSelectedRow();
				int id1=Integer.parseInt(d1.getValueAt(selectindex, 0).toString());
			
				try {
				Class.forName("com.mysql.jdbc.Driver");
				cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
				System.out.println("Connection Established...");
				
				st=cn.prepareStatement("delete from returnbook where rid=?");
				st.setInt(1, id1); 
				int k=st.executeUpdate();
				if(k>0)
				{
					JOptionPane.showMessageDialog(delete, "Deleted Successfully..");
					memid.setText(null);
					memname.setText(null);
					lblNewLabel_7.setText(null);
					showdate.setText(null);
					days.setText(null);
					fine.setText(null);
					add1.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(delete, "Error...");
				}
				add1.setEnabled(true);
				
				}
				catch (Exception e1) {
					e1.printStackTrace();// TODO: handle exception
				}
//				
			
			}
		});
		delete.setBounds(115, 288, 86, 41);
		contentPane.add(delete);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel d1=(DefaultTableModel) table.getModel();
				int selectindex=table.getSelectedRow();
				int id1=Integer.parseInt(d1.getValueAt(selectindex, 0).toString());
			
			try {
				
				String memberid=memid.getText();
				String membername=memname.getText();
				String bookname=lblNewLabel_7.getText();
				String returdate=showdate.getText();
				String elpday=days.getText();
				String ffine=fine.getText();

				Class.forName("com.mysql.jdbc.Driver");
				cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
				System.out.println("Connection Established...");
				
				st=cn.prepareStatement("update returnbook set mid=?,mname=?,bname=?,returndate=?,elp=?,fine=? where rid=?");
				st.setString(1, memberid);
				st.setString(2, membername);
				st.setString(3, bookname);
				st.setString(4, returdate);
				st.setString(5, elpday);
				st.setString(6, ffine);
				
				int k=st.executeUpdate();
				
				if(k>0)
				{
					JOptionPane.showMessageDialog(update, "Updated Successfully..");
					memid.setText(null);
					memname.setText(null);
					lblNewLabel_7.setText(null);
					showdate.setText(null);
					days.setText(null);
					fine.setText(null);
					add1.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(update, "Error...");
				}
				add1.setEnabled(true);
//				cn.close();
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		update.setBounds(16, 341, 86, 41);
		contentPane.add(update);
		
		JButton cancel = new JButton("Cancel\n");
		cancel.setBounds(108, 346, 87, 37);
		cancel.setFont(new Font("Serif", Font.PLAIN, 15));
		
		getContentPane().add(cancel);
		cancel.addActionListener(new ActionListener() {
//			cancelling this form
			public void actionPerformed(ActionEvent e)
			{  ReturnBook f=new ReturnBook();
				f.setVisible(false);
				
			}
		});
		
//		function calling
		connect();
		returnbookDisplay();
		
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
	public void returnbookDisplay()
	{
		int c;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
//			select m.mname, b.bname,l.returndate,DATEDIFF(now(),l.returndate) as elap from issuebook l JOIN member m ON l.mid=m.mid JOIN book b ON l.bookid=b.bid
				String qry="select r.rid,m.mname,b.bname,l.returndate from returnbook r JOIN member m ON r.mid=m.mid JOIN book b ON r.bname=b.bname  ";
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
						String rid,mid,mname,bname,returndate,elp,fine;
						
						while(rs.next())
						{
							
							rid=rs.getString(1);
							mid=rs.getString(2);
							mname=rs.getString(3);
							bname=rs.getString(4);
							returndate=rs.getString(5);
							elp=rs.getString(6);
							fine=rs.getString(7);
							
							String[] row= {rid,mid,mname,bname,returndate,elp,fine};
							d.addRow(row);
						}

						

					}
			
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		

public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==add1)
		{
			String memberid=memid.getText();
			String membername=memname.getText();
			String bookname=lblNewLabel_7.getText();
			String returdate=showdate.getText();
			String elpday=days.getText();
			String ffine=fine.getText();
			
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryMS", "root", "Apeksha@9");
				System.out.println("Connection Established...");
				
				st=cn.prepareStatement("insert into returnbook(mid,mname,bname,returndate,elp,fine) values(?,?,?,?,?,?)");
				
				st.setString(1, memberid);
				st.setString(2, membername);
				st.setString(3, bookname);
				st.setString(4, returdate);
				st.setString(5, elpday);
				st.setString(6, ffine);
				
				
				int k=st.executeUpdate();
				
				if(k>0)
				{
					JOptionPane.showMessageDialog(this, "ReturnBook Issued Successfully..");
					memid.setText(null);
					memname.setText(null);
					lblNewLabel_7.setText(null);
					showdate.setText(null);
					days.setText(null);
					fine.setText(null);
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
