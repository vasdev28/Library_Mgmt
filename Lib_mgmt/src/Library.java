import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.sql.*;

import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.Toolkit;

import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Library {
	private JFrame frmLibraryDb;
	private static Connection conn = null;
	private JScrollPane scrollPane;
	private JTextField bookId;
	private JTextField bookName;
	private JTextField authorFname;
	private JTable table1;
	private JTextField bfname;
	private JTextField blname;
	private JTextField baddress;
	private JTextField bphone;
	private JTable table3;
	private JTextField bookId1;
	private JTextField branchId1;
	private JTextField cardNumber1;
	private JTable table2;
	private JTextField mFname;
	private JTextField mLname;
	private JTable table4;
	private JTextField txtLoanId;
	private JTextField txtCardNumber;
	private JTextField txtFname;
	private JTextField txtLname;

	public Library() {
		initialize();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library window = new Library();
					window.frmLibraryDb.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		frmLibraryDb =  new JFrame();
		frmLibraryDb.setTitle("Library DB");
		
		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = ((int) tk.getScreenSize().getHeight());  
		
		frmLibraryDb.setSize(779,489);
		//frmLibraryDb.setSize(xSize,ySize);
		frmLibraryDb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLibraryDb.getContentPane().setLayout(new BorderLayout(0, 0));
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmLibraryDb.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel1 = new JPanel();
		tabbedPane.addTab("Book Search", null, panel1, null);
		tabbedPane.setEnabledAt(0, true);
		panel1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book ID");
		lblNewLabel.setBounds(52, 12, 52, 33);
		panel1.add(lblNewLabel);
		
		bookId = new JTextField();
		bookId.setBounds(156, 17, 231, 23);
		panel1.add(bookId);
		bookId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name");
		lblNewLabel_1.setBounds(52, 55, 89, 14);
		panel1.add(lblNewLabel_1);
		
		bookName = new JTextField();
		bookName.setBounds(156, 51, 231, 23);
		panel1.add(bookName);
		bookName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Author Name");
		lblNewLabel_2.setBounds(52, 89, 89, 14);
		panel1.add(lblNewLabel_2);
		
		authorFname = new JTextField();
		authorFname.setBounds(156, 85, 231, 23);
		panel1.add(authorFname);
		authorFname.setColumns(10);
		
		JScrollPane scrollpane1 = new JScrollPane();
		scrollpane1.setBounds(50, 147, 707, 278);
		panel1.add(scrollpane1);
		table1 = new JTable();
		table1.setBounds(50, 147, 688, 208);
		scrollpane1.setViewportView(table1);				
		
		JButton btnShowBooks = new JButton("Show Books");
		btnShowBooks.setBounds(424, 17, 135, 91);
		panel1.add(btnShowBooks);
		
		JButton btnproc2Chkout = new JButton("Proceed to Checkout");
		btnproc2Chkout.setBounds(569, 17, 170, 91);
		panel1.add(btnproc2Chkout);
		
		final JPanel panel2 = new JPanel();
		tabbedPane.addTab("Book Loans", null, panel2, null);
		panel2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Book_Id");
		lblNewLabel_5.setBounds(46, 14, 46, 14);
		panel2.add(lblNewLabel_5);
		
		bookId1 = new JTextField();
		bookId1.setBounds(146, 11, 86, 20);
		panel2.add(bookId1);
		bookId1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Branch_Id");
		lblNewLabel_6.setBounds(46, 65, 69, 14);
		panel2.add(lblNewLabel_6);
		
		branchId1 = new JTextField();
		branchId1.setBounds(146, 65, 86, 20);
		panel2.add(branchId1);
		branchId1.setColumns(10);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setBounds(433, 14, 90, 14);
		panel2.add(lblCardNumber);
		
		cardNumber1 = new JTextField();
		cardNumber1.setBounds(551, 11, 107, 20);
		panel2.add(cardNumber1);
		cardNumber1.setColumns(10);
		
		JButton btnCheckIn = new JButton("Check In");
		btnCheckIn.setBounds(474, 117, 121, 52);
		panel2.add(btnCheckIn);
		
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.setBounds(68, 114, 116, 52);
		panel2.add(btnCheckOut);
		
		JButton btnLoanHstry = new JButton("Loan History");
		
		btnLoanHstry.setBounds(247, 11, 150, 155);
		panel2.add(btnLoanHstry);
		
		JScrollPane scrollpane2 = new JScrollPane();
		scrollpane2.setBounds(38, 183, 673, 228);
		panel2.add(scrollpane2);
		
		table2 = new JTable();
		table2.setBounds(40, 247, 134, 20);
		scrollpane2.setViewportView(table2);
		
		JLabel lblMemberFname = new JLabel("Member First Name");
		lblMemberFname.setBounds(433, 48, 116, 14);
		panel2.add(lblMemberFname);
		
		mFname = new JTextField();
		mFname.setBounds(551, 45, 107, 20);
		panel2.add(mFname);
		mFname.setColumns(10);
		
		JLabel lblMemberLastName = new JLabel("Member Last Name");
		lblMemberLastName.setBounds(433, 81, 116, 14);
		panel2.add(lblMemberLastName);
		
		mLname = new JTextField();
		mLname.setBounds(551, 78, 107, 20);
		panel2.add(mLname);
		mLname.setColumns(10);

		JPanel panel3 = new JPanel();
		tabbedPane.addTab("Borrower Management", null, panel3, null);
		panel3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Borrower Name");
		lblNewLabel_3.setBounds(28, 26, 93, 24);
		panel3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(28, 61, 76, 14);
		panel3.add(lblNewLabel_4);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(28, 90, 84, 14);
		panel3.add(lblPhoneNumber);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(160, 11, 76, 14);
		panel3.add(lblFirstName);
		
		bfname = new JTextField();
		bfname.setBounds(124, 28, 134, 20);
		panel3.add(bfname);
		bfname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(321, 11, 84, 14);
		panel3.add(lblLastName);
		
		blname = new JTextField();
		blname.setBounds(278, 28, 127, 20);
		panel3.add(blname);
		blname.setColumns(10);
		
		baddress = new JTextField();
		baddress.setBounds(124, 58, 339, 20);
		panel3.add(baddress);
		baddress.setColumns(10);
		
		bphone = new JTextField();
		bphone.setBounds(124, 87, 134, 20);
		panel3.add(bphone);
		bphone.setColumns(10);
						
		JButton btnAddBorrower = new JButton("Add Borrower");
		
		btnAddBorrower.setBounds(517, 12, 134, 63);
		panel3.add(btnAddBorrower);
		
		JScrollPane scrollpane3 = new JScrollPane();
		scrollpane3.setBounds(10, 117, 748, 269);
		panel3.add(scrollpane3);
		
		table3 = new JTable();
		scrollpane3.setViewportView(table3);
		
		JPanel panel4 = new JPanel();
		tabbedPane.addTab("Fines", null, panel4, null);
		panel4.setLayout(null);
		
		JButton btnGetFinesbyCardNo = new JButton("Get Fines by Card Number");
		btnGetFinesbyCardNo.setBounds(497, 114, 184, 43);
		panel4.add(btnGetFinesbyCardNo);
		
		JScrollPane scrollPane4 = new JScrollPane();
		scrollPane4.setBounds(41, 178, 686, 232);
		panel4.add(scrollPane4);
		
		table4 = new JTable();
		scrollPane4.setViewportView(table4);
		
		JLabel lblLoanid = new JLabel("Loan_id");
		lblLoanid.setBounds(41, 79, 68, 14);
		panel4.add(lblLoanid);
		
		txtLoanId = new JTextField();
		txtLoanId.setBounds(145, 76, 100, 20);
		panel4.add(txtLoanId);
		txtLoanId.setColumns(10);
		
		JButton btnPayFines = new JButton("Pay Fine");
		btnPayFines.setBounds(62, 114, 184, 43);
		panel4.add(btnPayFines);
		
		JButton btnGetFinesByLoanId = new JButton("Get Fines by Loan_id");
		btnGetFinesByLoanId.setBounds(280, 114, 184, 43);
		panel4.add(btnGetFinesByLoanId);
		
		txtCardNumber = new JTextField();
		txtCardNumber.setBounds(145, 22, 100, 20);
		panel4.add(txtCardNumber);
		txtCardNumber.setColumns(10);
		
		JLabel lblCardNumber_1 = new JLabel("Card Number");
		lblCardNumber_1.setBounds(41, 25, 83, 14);
		panel4.add(lblCardNumber_1);
		
		JLabel lblFname = new JLabel("Fname");
		lblFname.setBounds(310, 28, 83, 14);
		panel4.add(lblFname);
		
		JLabel lblLname = new JLabel("Lname");
		lblLname.setBounds(310, 79, 83, 14);
		panel4.add(lblLname);
		
		txtFname = new JTextField();
		txtFname.setBounds(403, 22, 86, 20);
		panel4.add(txtFname);
		txtFname.setColumns(10);
		
		txtLname = new JTextField();
		txtLname.setBounds(403, 76, 86, 20);
		panel4.add(txtLname);
		txtLname.setColumns(10);
		
		btnShowBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "mysql");
					Statement stmt = conn.createStatement();
					stmt.execute("use library;");
					
					String get_books="select Book_Id, Title, Author_name, Branch_id, No_of_copies as Total_Copies, No_of_available_copies as Available_Copies" +
					" from table1 NATURAL JOIN table2 where book_id LIKE '%" + bookId.getText() + "%' AND title LIKE '%" + 
					bookName.getText() + "%' AND Author_name LIKE '%" + authorFname.getText() +	"%' ORDER BY Book_id" ;

					ResultSet rs = stmt.executeQuery(get_books);
					table1.setModel(DbUtils.resultSetToTableModel(rs));				
					rs.close();
					conn.close();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
		
		btnproc2Chkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String book_id = table1.getValueAt(table1.getSelectedRow(), 0).toString();
					String branch_id = table1.getValueAt(table1.getSelectedRow(),3).toString();					
					bookId1.setText(book_id);
					branchId1.setText(branch_id);
					tabbedPane.setSelectedIndex(1);
					JOptionPane.showMessageDialog(null, "Enter the card number");
					cardNumber1.requestFocus();
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Click on a valid cell" );
				}
			}
		});
		
		table2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				bookId1.setText(table2.getValueAt(table2.getSelectedRow(), 1).toString());
				branchId1.setText(table2.getValueAt(table2.getSelectedRow(), 4).toString());
				cardNumber1.setText(table2.getValueAt(table2.getSelectedRow(), 0).toString());
			}
		});
		
		table2.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				bookId1.setText(table2.getValueAt(table2.getSelectedRow(), 1).toString());
				branchId1.setText(table2.getValueAt(table2.getSelectedRow(), 4).toString());
				cardNumber1.setText(table2.getValueAt(table2.getSelectedRow(), 0).toString());
			}
		});
		
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "mysql");
					Statement stmt = conn.createStatement();
					stmt.execute("use library;");
					String getLoanId="SELECT Loan_id from book_loans where book_id = '" +
								bookId1.getText()+ "' AND card_no = '" +cardNumber1.getText() +"' AND Date_In IS NULL;";
					ResultSet rs = stmt.executeQuery(getLoanId);
					if(rs.next()) {
						String loan_id=rs.getString("Loan_id");
						stmt.execute("update book_loans set date_in=(select date(now())) where loan_id = '" + loan_id+"';");
						rs =stmt.executeQuery("Select 0.25*datediff(now(),due_date) from book_loans where loan_id='"+loan_id+"';");
						rs.next();
						String fines=rs.getString(1);
						if(Double.compare(Double.parseDouble(fines),0.0)>0) {
							stmt.execute("delete from fines where loan_id = '"+loan_id+"';");
							int n=JOptionPane.showConfirmDialog(null, "Would you like to pay the fine along with the check-in?","Say yes or no",JOptionPane.YES_NO_OPTION);
							if(n>0) {
								stmt.execute("insert into fines values ('"+loan_id+"','"+fines+"','0');");
							} else {
								stmt.execute("insert into fines values ('"+loan_id+"','"+fines+"','1');");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null,"No such booked checked-out for the given details");
					}
					String get_books="select Card_no, Book_Id, Title, Author_name, Branch_id, Due_date, Date_in, Fine_amt " +
							" from book NATURAL JOIN book_authors_all NATURAL JOIN Book_loans NATURAL JOIN BORROWER LEFT JOIN FINES USING (Loan_id)"
							+ " where card_no LIKE '%" + cardNumber1.getText() + "%' ORDER BY card_no;" ;

					rs = stmt.executeQuery(get_books);
					table2.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					conn.close();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
		
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "mysql");
					Statement stmt = conn.createStatement();
					stmt.execute("use library;");
					String q1="select count(*) from book_loans where card_no='" + cardNumber1.getText()+ "' AND Date_in IS NULL;";
					ResultSet rs = stmt.executeQuery(q1); 
					rs.next();
					int borrowed_books=Integer.parseInt(rs.getString(1));
					
					String q2="select no_of_available_copies from table2 where book_id LIKE '" + bookId1.getText()+ "' AND branch_id='"+ branchId1.getText() +"';";
					rs = stmt.executeQuery(q2);
					rs.next();
					int avl_books =Integer.parseInt(rs.getString(1));
					
					String q3="SELECT card_no, SUM(Fine_amt) from book_loans NATURAL JOIN Fines "
							+ "WHERE paid=0 AND card_no LIKE '%"+cardNumber1.getText() +"%' GROUP BY Fine_amt";
					rs = stmt.executeQuery(q3);
					rs.next();
					try {
						rs.getString(1);
						JOptionPane.showMessageDialog(null, "You have fines pending. Please clear that & checkout !!!");
					} catch (Exception ex) {
						if (borrowed_books>2) { 
							JOptionPane.showMessageDialog(null, "Book Limit of 3 books Reached !!!");
						} else if (avl_books < 1) {
							JOptionPane.showMessageDialog(null, "The Requested Book is not available in this branch.");
						} else {
							String q4="select Branch_id,Due_date from book NATURAL JOIN Book_loans " +
									" where book_id LIKE '%" + bookId1.getText() + "%' AND card_no LIKE '%" + cardNumber1.getText() + "%' AND Date_in is NULL ORDER BY card_no;";
							rs =stmt.executeQuery(q4);
							if (!rs.next()) {
								String q5="select max(loan_id) from book_loans";
								rs = stmt.executeQuery(q5);
								int l_id;
								try {
									rs.next();				
									l_id=Integer.parseInt(rs.getString(1))+1;
								} catch(Exception ex1) {
									l_id =1;
								}
								stmt.execute("Insert into book_loans values ('"+ l_id+"','"+bookId1.getText()+"','"+branchId1.getText()+"','"
									+cardNumber1.getText()+"',(select date(now())),(select adddate(date(now()) ,INTERVAL 14 DAY)),NULL);");
								String get_books1="select Card_no, Book_Id, Title, Author_name, Branch_id, Due_date, Date_in, Fine_amt " +
										" from book NATURAL JOIN book_authors_all NATURAL JOIN Book_loans NATURAL JOIN BORROWER LEFT JOIN FINES USING (Loan_id)"
										+ " where card_no LIKE '%" + cardNumber1.getText() + "%' AND Fname LIKE '%" + mFname.getText() + "%' AND "
										+ "Lname LIKE '%"+ mLname.getText() + "%' ORDER BY card_no;" ;
								rs=stmt.executeQuery(get_books1);
								table2.setModel(DbUtils.resultSetToTableModel(rs));
							} else {
								JOptionPane.showMessageDialog(null, "The Requested Book has already been taken by the account holder from branch "+rs.getString(1));
							}
						}
					}
					rs.close();
					conn.close();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null,"Error in connection:" + ex.getMessage());
				}				
			}
		});
		
		btnLoanHstry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "mysql");
					Statement stmt = conn.createStatement();
					Statement stmt1= conn.createStatement();
					stmt.execute("use library;");
					// Paid=Null => Data not in fines table. So Insert it to fines table.
					String q1 = "INSERT INTO Fines (select Loan_id,0.25*datediff(now(),due_date),0 "
							+ "from book_loans LEFT JOIN Fines USING (Loan_id) WHERE Date_in IS NULL AND PAID IS NULL AND now()>Due_date);" ;
					String q2 = "SELECT Loan_id, 0.25*datediff(now(),due_date),0 FROM book_loans WHERE date_in IS NULL AND now()>due_date;";
					stmt.execute(q1);
					ResultSet rs=stmt1.executeQuery(q2);
				    while(rs.next()) {
				    	String loan_id = rs.getString(1);
				    	String fine_amt = rs.getString(2);
				    	String update_fines = "UPDATE fines SET Fine_amt="+fine_amt+",paid=0 where loan_id ="+loan_id;
				    	stmt.execute(update_fines);
				    }
				    String get_books="select Card_no, Book_Id, Title, Author_name, Branch_id, Due_date, Date_in, Fine_amt " +
							" from book NATURAL JOIN book_authors_all NATURAL JOIN Book_loans NATURAL JOIN BORROWER LEFT JOIN FINES USING (Loan_id)"
							+ " where card_no LIKE '%" + cardNumber1.getText() + "%' AND Fname LIKE '%" + mFname.getText() + "%' AND "
							+ "Lname LIKE '%"+ mLname.getText() + "%' ORDER BY card_no;" ;
					rs = stmt.executeQuery(get_books);
					table2.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					conn.close();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
				
		btnAddBorrower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname = bfname.getText();
				String lname = blname.getText();
				String address = baddress.getText();
				String phone = bphone.getText();
				
				if (fname.equals("") || lname.equals("") || address.equals("")) {
					JOptionPane.showMessageDialog(null, "Enter a valid Name & Address");
				} else {
					ResultSet rs;
					try {
						conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "mysql");
						Statement stmt = conn.createStatement();
						stmt.execute("use library;");
						rs=stmt.executeQuery("select card_no from borrower where fname='"+ fname
								+"' AND lname='"+lname+"' AND address='"+address+"';");
						if(!rs.next()) {
							rs= stmt.executeQuery("select MAX(card_no) from borrower;");
							int b_id;
							try {
								rs.next();				
							    b_id=Integer.parseInt(rs.getString(1))+1;
							} catch(Exception ex1) {
								b_id =1;
							}
							stmt.execute("Insert into borrower values ('"+ b_id+"','"+fname+"','"+lname+"','"
								+address+"','"+phone+"');");
						} else {
							JOptionPane.showMessageDialog(null, "Duplicate Name & Address!!\nThis Member already has a card with number "+rs.getString(1));
						}
						rs = stmt.executeQuery("select * from borrower");
						table3.setModel(DbUtils.resultSetToTableModel(rs));				
					
						rs.close();
						conn.close();
					} catch(SQLException ex) {
						JOptionPane.showMessageDialog(null,ex.getMessage());
					}
				}
			}
		});	
		
		btnGetFinesbyCardNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "mysql");
					Statement stmt = conn.createStatement();
					stmt.execute("use library;");
					
					Statement stmt1= conn.createStatement();
					// Paid=Null => Data not in fines table. So Insert it to fines table.
					String q1 = "INSERT INTO Fines (select Loan_id,0.25*datediff(now(),due_date),0 "
							+ "from book_loans LEFT JOIN Fines USING (Loan_id) WHERE Date_in IS NULL AND PAID IS NULL AND now()>Due_date);" ;
					stmt.execute(q1);
					String q2 = "SELECT Loan_id, 0.25*datediff(now(),due_date),0 FROM book_loans WHERE date_in IS NULL AND now()>due_date;";
					ResultSet rs=stmt1.executeQuery(q2);
				    while(rs.next()) {
				    	String loan_id = rs.getString(1);
				    	String fine_amt = rs.getString(2);
				    	String update_fines = "UPDATE fines SET Fine_amt="+fine_amt+",paid=0 where loan_id ="+loan_id;
				    	stmt.execute(update_fines);
				    }
					
					String q3= "select Card_no,Fname,Lname,SUM(Fine_amt) Total_Fine"
							+ " from Fines NATURAL JOIN book_loans NATURAL JOIN borrower WHERE NOT Fine_amt IS NULL "
							+ "AND Paid = 0 AND card_no LIKE '%"+txtCardNumber.getText()+"%' AND Fname LIKE '%"
							+ txtFname.getText()+"%' AND Lname LIKE '%"+txtLname.getText()+"%' GROUP BY Card_no;";
					rs = stmt.executeQuery(q3);
					table4.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					conn.close();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
		
		btnGetFinesByLoanId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "mysql");
					Statement stmt = conn.createStatement();
					stmt.execute("use library;");
					
					Statement stmt1= conn.createStatement();
					// Paid=Null => Data not in fines table. So Insert it to fines table.
					String q1 = "INSERT INTO Fines (select Loan_id,0.25*datediff(now(),due_date),0 "
							+ "from book_loans LEFT JOIN Fines USING (Loan_id) WHERE Date_in IS NULL AND PAID IS NULL AND now()>Due_date);" ;
					stmt.execute(q1);
					String q2 = "SELECT Loan_id, 0.25*datediff(now(),due_date),0 FROM book_loans WHERE date_in IS NULL AND now()>due_date;";
					ResultSet rs=stmt1.executeQuery(q2);
				    while(rs.next()) {
				    	String loan_id = rs.getString(1);
				    	String fine_amt = rs.getString(2);
				    	String update_fines = "UPDATE fines SET Fine_amt="+fine_amt+",paid=0 where loan_id ="+loan_id;
				    	stmt.execute(update_fines);
				    }
					
					String q3= "select Card_no,Fname,Lname,Fine_amt, Loan_id"
							+ " from Fines NATURAL JOIN book_loans NATURAL JOIN borrower WHERE NOT Fine_amt IS NULL AND Paid = 0 "
							+ "AND Loan_id LIKE '%"+ txtLoanId.getText() +"%' ORDER BY Loan_id;";
					rs = stmt.executeQuery(q3);
					table4.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					conn.close();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
		
		btnPayFines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "mysql");
					Statement stmt = conn.createStatement();
					stmt.execute("use library;");
					
					String loan_id=txtLoanId.getText();
					if (!loan_id.equals("")) {
						String q0 = "update fines set paid=1 where loan_id = '"+loan_id+"'";
						stmt.execute(q0);
					}
					
					Statement stmt1= conn.createStatement();
					// Paid=Null => Data not in fines table. So Insert it to fines table.
					String q1 = "INSERT INTO Fines (select Loan_id,0.25*datediff(now(),due_date),0 "
							+ "from book_loans LEFT JOIN Fines USING (Loan_id) WHERE Date_in IS NULL AND PAID IS NULL AND now()>Due_date);" ;
					stmt.execute(q1);
					String q2 = "SELECT Loan_id, 0.25*datediff(now(),due_date),0 FROM book_loans WHERE date_in IS NULL AND now()>due_date;";
					ResultSet rs=stmt1.executeQuery(q2);
				    while(rs.next()) {
				    	String loan_id1 = rs.getString(1);
				    	String fine_amt = rs.getString(2);
				    	String update_fines = "UPDATE fines SET Fine_amt="+fine_amt+",paid=0 where loan_id ="+loan_id1;
				    	stmt.execute(update_fines);
				    }
					
					String q3= "select Card_no,Fname,Lname,Fine_amt, Loan_id"
							+ " from Fines NATURAL JOIN book_loans NATURAL JOIN borrower WHERE NOT Fine_amt IS NULL AND Paid = 0 "
							+ "AND Card_no LIKE '%"+ txtCardNumber.getText() +"%' ORDER BY Loan_id;";
					rs = stmt.executeQuery(q3);
					table4.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					conn.close();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
		
		table4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					txtCardNumber.setText(table4.getValueAt(table4.getSelectedRow(), 0).toString());
					txtFname.setText(table4.getValueAt(table4.getSelectedRow(), 1).toString());
					txtLname.setText(table4.getValueAt(table4.getSelectedRow(), 2).toString());					
					txtLoanId.setText(table4.getValueAt(table4.getSelectedRow(), 4).toString());
				} catch (Exception e) {
				}
			}
		});
		
		table4.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				try {
					txtCardNumber.setText(table4.getValueAt(table4.getSelectedRow(), 0).toString());
					txtFname.setText(table4.getValueAt(table4.getSelectedRow(), 1).toString());
					txtLname.setText(table4.getValueAt(table4.getSelectedRow(), 2).toString());
					txtLoanId.setText(table4.getValueAt(table4.getSelectedRow(), 4).toString());
				} catch (Exception e1) {
				}
			}
		});
	}
}