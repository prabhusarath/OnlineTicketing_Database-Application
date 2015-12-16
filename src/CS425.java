
import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

import static oracle.jdbc.OracleTypes.NULL;
import oracle.jdbc.pool.OracleDataSource;
import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;
import static java.lang.System.exit;

import java.lang.Thread.State;

public class CS425 {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.driver";
	static final String DB_URL = "JDBC Connection";
	static int userid = ThreadLocalRandom.current().nextInt(1000, 2000 + 1);
	static int guestid = ThreadLocalRandom.current().nextInt(9000, 10000 + 1);
	static int ticketid = ThreadLocalRandom.current().nextInt(6000, 70000 + 1);

	static final String username = "username";
	static final String password = "password";
	static final int TicketPrice = 10;

	Connection con;

	static Integer paymentID = ThreadLocalRandom.current().nextInt(3000, 5000 + 1);

	static int flag = 0;

	public static void main(String[] args) {
		int op, op1, op2;

		CS425 obj = new CS425();

		try {

			Connection con;
			OracleDataSource dataset = new OracleDataSource();

			con = DriverManager.getConnection("JDBC Connection", "username", "password");

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		Scanner inp0 = new Scanner(System.in);

		System.out.println("Hello Customer !!");
		System.out.println("Welcome to SPI Cinemas !!");
		System.out.println(" Press 1 - Log In As Customer!!");
		System.out.println(" Press 2 - Register As Customer!!");
		System.out.println(" Press 3 - Register As Guest !!");
		System.out.println(" Press 4 - Login as Owner or Staff !!");
		System.out.print(" Your Choice :");
		int option = inp0.nextInt();

		String mail = "";
		String pw = "";

		if (option == 1) {

			Scanner inpl = new Scanner(System.in);

			System.out.println("Hello Customer !!");
			System.out.println(" Welcome Back !! ");

			System.out.println("Enter User Email");
			mail = inpl.nextLine();
			System.out.println("Enter Password:");
			pw = inpl.nextLine();

			try {

				Connection con;
				OracleDataSource dataset = new OracleDataSource();
				con = DriverManager.getConnection("JDBC Connection", "username",
						"password");

				Statement stmt;
				// SELECT EMAIL_ID,PASSWORD FROM USERS;
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT EMAIL_ID AS M,PASSWORD AS P,USER_ID AS U FROM USERS WHERE EMAIL_ID='"+mail+"' AND PASSWORD='"+pw+"'");

				if (rs.next()) {

					String s = rs.getString("M");
					String p = rs.getString("P");
					int u = rs.getInt("U");

					if (s.equals(mail) && p.equals(pw)) {
						System.out.println("Hello Customer - Login Success");
					}

					System.out.println(" Hello Customer !! ");

					do {

						System.out.println(" 1 -  View Customer Information");
						System.out.println(" 2 - Purchase Ticket ");
						System.out.println(" 3 - Review a movie");
						System.out.println(" 4 - Review a Theatre");
						System.out.println(" 5 - Display Movie Reviews");
						System.out.println(" 6 - Display Theatre Reviews");
						System.out.println(" 7 - Create a thread");
						System.out.println(" 8 - Display Threads");
						System.out.println(" 9 - Logout");
						

						Scanner inpl1 = new Scanner(System.in);

						System.out.println("Enter Your Option");
						op = inpl1.nextInt();

						switch (op) {
						case 1:
							obj.userinfo(u);
							break;
						case 2:
							obj.ticket(u);
							break;
						case 3:
							op = 1;
							obj.movie_theatre_reviewthread(op,u);
							break;
						case 4:
							op = 2;
							obj.movie_theatre_reviewthread(op,u);
							break;
						case 5:
							op = 3;
							obj.movie_theatre_reviewthread(op,u);
							break;
						case 6:
							op = 4;
							obj.movie_theatre_reviewthread(op,u);
							break;
						case 7:
							op = 5;
							obj.movie_theatre_reviewthread(op,u);
							break;
						case 8:
							op =6;
							obj.movie_theatre_reviewthread(op,u);
							break;
						case 9:
						System.out.println(" Exit CS425 project. Good Bye! ");
                        exit(0);
                        break; 
							
						default:
							System.out.println("Invalid Selection");
						}
					} while (op <= 9);

				} else {
					System.out.println(" Wrong Log In Inforamtion ");
				}

			} catch (SQLException ex) {
				Logger.getLogger(CS425.class.getName()).log(Level.SEVERE, null, ex);
			}

		} else if (option == 2) {
			Scanner inp = new Scanner(System.in);

			System.out.println("Hello Customer !!");
			System.out.println("Please Enter Details For Successful Registration !!");

			System.out.println("Enter User_Name:");
			String name = inp.nextLine();
			System.out.println("Enter Password:");
			String pwd = inp.nextLine();
			System.out.println("Enter Email_Id:");
			String email = inp.nextLine();
			System.out.println("Enter Address :");
			String address = inp.nextLine();
			System.out.println("Enter Phone_Number : ");
			Integer phone = inp.nextInt();

			Integer role = 222;
			obj.user(userid, name, pwd, email, phone, address, role);

			obj.CreditCard(userid);

			System.out.println(" Hello Customer !! ");

			do {

						System.out.println(" 1 -  View Customer Information");
						System.out.println(" 2 - Purchase Ticket ");
						System.out.println(" 3 - Review a movie");
						System.out.println(" 4 - Review a Theatre");
						System.out.println(" 5 - Display Movie Reviews");
						System.out.println(" 6 - Display Theatre Reviews");
						System.out.println(" 7 - Create a thread");
						System.out.println(" 8 - Display Threads");
						System.out.println(" 9 - Logout");
				
				Scanner inpl1 = new Scanner(System.in);

				System.out.println("Enter Your Option");
				op1 = inpl1.nextInt();

				switch (op1) {
				case 1:
					obj.userinfo(userid);
					break;
				case 2:
					obj.ticket(userid);
					break;
				case 3:
					op1 = 1;
					obj.movie_theatre_reviewthread(op1,userid);
					break;
				case 4:
					op1 = 2;
					obj.movie_theatre_reviewthread(op1,userid);
					break;
				case 5:
					op1 = 3;
					obj.movie_theatre_reviewthread(op1,userid);
					break;
				case 6:
					op1 = 4;
					obj.movie_theatre_reviewthread(op1,userid);
					break;
				case 7:
					op1 = 5;
					obj.movie_theatre_reviewthread(op1,userid);
					break;
				case 8:
					op1 = 6;
					obj.movie_theatre_reviewthread(op1,userid);
					break;
				case 9:
				System.out.println(" Exit CS425 project. Good Bye! ");
                exit(0);
                break; 
							
				default:
				System.out.println("Invalid Selection");
						}
					} while (op1 <= 9);

		}

		else if(option==3)

		{

			Scanner inpg = new Scanner(System.in);

			System.out.println("Please Enter Guest Name:");
			String name = inpg.nextLine();

			obj.guest(guestid, name);

			flag = 1;
			obj.CreditCard(guestid);

			System.out.println(" Hello Guest !! ");

			do {

				System.out.println(" 1 -  View Guest Information");
				System.out.println(" 2 - Purchase Ticket ");;
				System.out.println(" 3 - Display Movie Reviews");
				System.out.println(" 4 - Display Theatre Reviews");
				System.out.println(" 5 - Display Threads");
				System.out.println(" 6 - Logout");

				Scanner inpl1 = new Scanner(System.in);

				System.out.println("Enter Your Option");
				op2 = inpl1.nextInt();
				switch (op2) {

				case 1:
					obj.guestinfo(guestid);
					break;
				case 2:
					obj.ticketguest(guestid);
					break;
				case 3:
					op2 = 3;
					obj.movie_theatre_reviewthread(op2,0);
					break;
				case 4:
					op2 = 4;
					obj.movie_theatre_reviewthread(op2,0);
					break;
				case 5:
					op2 = 6;
					obj.movie_theatre_reviewthread(op2,0);
					break;
				case 6:
				System.out.println(" Exit CS425 project. Good Bye! ");
                exit(0);
                break;

				default:
					System.out.println("Invalid Selection");
				}
			} while (op2 <= 6);

		}
		else if(option==4){
			staff();
		}

		System.out.println("End Of Program ");
	}

	public int CreditCard(int userid) {
		Scanner inp2 = new Scanner(System.in);

		System.out.println("Enter Credit Card Information to Purchase Ticket :");
		String credit1 = inp2.nextLine();

		if (credit1.isEmpty()) {
			System.out.println(" **** Please Provide Credit Card Number For Booking Tickets !! **** ");
		}

		else {
			Scanner inp1 = new Scanner(System.in);

			System.out.println("Enter Name in Credit Card :");
			String cardname = inp1.nextLine();
			System.out.println("Enter Expiry Month :");
			Integer expirym = inp1.nextInt();
			System.out.println("Enter Expiry Year : ");
			Integer expiryy = inp1.nextInt();

			Long credit = Long.valueOf(credit1);
			Credit(paymentID, userid, credit, cardname, expirym, expiryy);

		}

		return 0;
	}

	public void user(int userid, String name, String pwd, String email, Integer phone, String address, Integer roll) {

		try {
			Connection con;
			OracleDataSource dataset = new OracleDataSource();

			con = DriverManager.getConnection("JDBC Connection", "username", "password");

			// System.out.println("Checking befor inseering Value :"+userid);

			String sql = "INSERT INTO USERS(USER_ID,user_name,PASSWORD,email_id,phone_number,address,ROLL_NO,INSERTTIMESTAMP) values(?,?, ?, ?, ?, ?,?,?)";

			PreparedStatement pstmt = con.prepareStatement(sql);

			java.util.Date utilDate = new java.util.Date();
			java.sql.Timestamp sq_date = new java.sql.Timestamp(utilDate.getTime());

			pstmt.setInt(1, userid);
			pstmt.setString(2, name);
			pstmt.setString(3, pwd);
			pstmt.setString(4, email);
			pstmt.setInt(5, phone);
			pstmt.setString(6, address);
			pstmt.setInt(7, roll);
			pstmt.setTimestamp(8, sq_date);

			pstmt.executeQuery();

			System.out.println("User Successfully Registered");

			con.commit();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return 0 ;
	}

	public int guest(int guestid, String name) {
		try {
			Connection con;
			OracleDataSource dataset = new OracleDataSource();

			con = DriverManager.getConnection("JDBC Connection", "username", "password");

			String sql = "INSERT INTO GUEST(GUEST_ID,GUEST_NAME) values(?,?)";

			PreparedStatement pstmt = con.prepareStatement(sql);

			java.util.Date utilDate = new java.util.Date();
			java.sql.Timestamp sq_date = new java.sql.Timestamp(utilDate.getTime());

			pstmt.setInt(1, guestid);
			pstmt.setString(2, name);

			pstmt.executeQuery();

			System.out.println("Guest Successfully Registered");

			//con.commit();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int Credit(Integer paymentID, Integer userid, Long Cardno, String cardname, Integer expirym,
			Integer expiryy) {

		try {
			Connection con;
			OracleDataSource dataset = new OracleDataSource();

			con = DriverManager.getConnection("JDBC Connection", "username", "password");

			if (flag == 0) {

				String sql1 = "INSERT INTO PAYMENT(PAYMENT_ID,USER_ID,CARD_NUMBER,CARD_NAME,EXPIRY_MONTH,EXPIRY_YEAR) values(?,?,?,?,?,?)";

				PreparedStatement pstmt1 = con.prepareStatement(sql1);

				pstmt1.setInt(1, paymentID);
				pstmt1.setInt(2, userid);

				pstmt1.setLong(3, Cardno);
				pstmt1.setString(4, cardname);
				pstmt1.setInt(5, expirym);
				pstmt1.setInt(6, expiryy);

				pstmt1.executeQuery();

				Scanner inp2 = new Scanner(System.in);
				System.out.println("Enter Initial Amount to be Added to the Card: ");
				Integer Funds = inp2.nextInt();

				Statement stmt9 = con.createStatement();
				PreparedStatement pt9 = con.prepareStatement("SELECT BALANCE AS FUND FROM PAYMENT WHERE USER_ID=?");

				pt9.setInt(1, userid);

				ResultSet rs = pt9.executeQuery();

				while (rs.next()) {

					int Initial = rs.getInt(1);
					System.out.println("Default Amount in the Card :" + Initial);
                                         
					Funds = Funds + Initial;
					System.out.println("Total Amount :" + Funds);

					if (Funds > 20) {

						PreparedStatement ps10 = con.prepareStatement("UPDATE payment SET balance =? where USER_ID=? ");

						ps10.setInt(1, Funds);
						ps10.setInt(2, userid);

						ResultSet rs1 = ps10.executeQuery();

						System.out.println(
								"Proceed to Ticketing - Credit Card Successfully Registered with Sufficient Funds");
					} else {
						PreparedStatement ps11 = con.prepareStatement("UPDATE payment SET balance =? where USER_ID=? ");

						ps11.setInt(1, Funds);
						ps11.setInt(2, userid);

						ResultSet rs3 = ps11.executeQuery();

						System.out.println("Unsuccessful - Not Sufficient Funds");
					}

				}
			}

			else

			{

				String sql3 = "INSERT INTO PAYMENT(PAYMENT_ID,GUEST_ID,CARD_NUMBER,CARD_NAME,EXPIRY_MONTH,EXPIRY_YEAR) values(?,?,?,?,?,?)";

				PreparedStatement pstmt1 = con.prepareStatement(sql3);

				pstmt1.setInt(1, paymentID);
				pstmt1.setInt(2, userid);

				pstmt1.setLong(3, Cardno);
				pstmt1.setString(4, cardname);
				pstmt1.setInt(5, expirym);
				pstmt1.setInt(6, expiryy);

				pstmt1.executeQuery();

				Scanner inp2 = new Scanner(System.in);
				System.out.println("Enter Initial Amount to be Added to the Card: ");
				Integer Funds = inp2.nextInt();

				Statement stmt9 = con.createStatement();
				PreparedStatement pt9 = con.prepareStatement("SELECT BALANCE AS FUND FROM PAYMENT WHERE GUEST_ID=?");

				pt9.setInt(1, userid);

				ResultSet rs = pt9.executeQuery();

				while (rs.next()) {

					int Initial = rs.getInt(1);
					System.out.println("Default Amount in the Card :" + Initial);

					Funds = Funds + Initial;
					System.out.println("Total Amount :" + Funds);

					if (Funds > 20) {

						PreparedStatement ps10 = con
								.prepareStatement("UPDATE payment SET balance =? where GUEST_ID=? ");

						ps10.setInt(1, Funds);
						ps10.setInt(2, userid);

						ResultSet rs1 = ps10.executeQuery();

						System.out.println(
								"Proceed to Ticketing - Credit Card Successfully Registered with Sufficient Funds");
					} else {
						PreparedStatement ps11 = con
								.prepareStatement("UPDATE payment SET balance =? where GUEST_ID=? ");

						ps11.setInt(1, Funds);
						ps11.setInt(2, userid);

						ResultSet rs3 = ps11.executeQuery();

						System.out.println("Unsuccessful - Not Sufficient Funds");
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int ticket(int userid) {

		String time = "";
		int available;
		int screen = 0;
		int show = 0;
		int price = 0;
		int s = 0;
		Date De;

		Scanner inp = new Scanner(System.in);

		System.out.println(" Hello Customer !! Welcome to SPI Cinemas");

		try {

			Connection con;
			OracleDataSource dataset = new OracleDataSource();
			con = DriverManager.getConnection("JDBC Connection", "username", "password");

			Statement stmt;

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT THEATRE_ID AS M,NAME AS P,LOCATION AS U FROM theatre");

			while (rs.next()) {

				int g = rs.getInt("M");
				String p = rs.getString("P");
				String u = rs.getString("U");

				System.out.print(g);
				System.out.print("\t");
				System.out.print(p);
				System.out.print("\t");
				System.out.println(u);

			}
		} catch (SQLException ex) {
			Logger.getLogger(CS425.class.getName()).log(Level.SEVERE, null, ex);
		}

		System.out.println(" Please Select Theatre Location_ID ");
		int tid = inp.nextInt();

		System.out.println(" Available Movies in the Theatre , Please Select Movie_ID");

		try {

			Connection con;
			OracleDataSource dataset = new OracleDataSource();
			con = DriverManager.getConnection("JDBC Connection", "username", "password");

			Statement stmt;

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MOVIE_ID AS M,TITLE  AS P FROM MOVIE where movie_id not in 99");

			while (rs.next()) {

				int g = rs.getInt("M");
				String p = rs.getString("P");

				System.out.print(g);
				System.out.print("\t");
				System.out.print("-");
				System.out.print("\t");
				System.out.println(p);

			}
		} catch (SQLException ex) {
			Logger.getLogger(CS425.class.getName()).log(Level.SEVERE, null, ex);
		}

		System.out.println(" Please Select Movie");
		int mid = inp.nextInt();

		try {

			Connection con;
			OracleDataSource dataset = new OracleDataSource();
			con = DriverManager.getConnection("JDBC Connection", "username", "password");
			Statement stmt;

			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(
					"SELECT SHOW_ID AS SHOW,SHOW_TIME AS SHOWTIME,SCREEN_NUMBER AS SCREEN FROM SHOWS WHERE THEATRE_ID="
							+ tid + "AND MOVIE_ID=" + mid);

			while (rs.next()) {

				time = rs.getString("SHOWTIME");
				screen = rs.getInt("SCREEN");
				show = rs.getInt("SHOW");

				System.out.println(" Available Show Time For the Movie" + time);
				System.out.println(" Movie Shown In Screen Number :" + screen);
				System.out.println(" Show ID for the Movie:" + show);

			}
		} catch (SQLException ex) {
			Logger.getLogger(CS425.class.getName()).log(Level.SEVERE, null, ex);
		}

		System.out.println(" Please Enter Number Of tickets :");
		int tin = inp.nextInt();

		if (tin == 2) {

			System.out.println(" You Are Eligible For Deal - 201 - BUY 2 GET 25% OFF ");
			System.out.println(" Ticket Prices are Updated. ");

			price = TicketPrice * tin;

			price = price * (25 / 100);
		}

		else if (tin == 5) {

			System.out.println(" You Are Eligible For Deal - 501 - BUY 5 GET 1 FREE ");
			System.out.println(" Ticket Prices are Updated. ");

			price = TicketPrice * tin;

			price = price - (TicketPrice);

		} else if (tin == 10) {

			System.out.println(" You Are Eligible For Deal - 1002 - BUY 10 GET 2 FREE ");
			System.out.println(" Ticket Prices are Updated. ");

			price = TicketPrice * tin;

			price = price - (2 * TicketPrice);

		} else {

			price = TicketPrice * tin;
			System.out.println(" Sorry No Deals Enjoy the Movie !! ");

		}

		try {

			Connection con;
			OracleDataSource dataset = new OracleDataSource();
			con = DriverManager.getConnection("JDBC Connection", "username", "password");

			Statement stmt;

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MAX(Seat_Number) AS SEAT FROM ticket WHERE THEATRE_ID=" + tid
					+ "AND Screen_Number=" + screen);

			while (rs.next()) {

				s = rs.getInt("SEAT");

				s = s + tin;

				// stmt.executeQuery("update ticket set price="+s+" WHERE
				// THEATHREID="+tid+"AND MOVIE_ID="+mid+"AND
				// Screen_Number="+screen);
			}
		} catch (SQLException ex) {
			Logger.getLogger(CS425.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		try {
            
            Connection con;
	OracleDataSource dataset = new OracleDataSource();
	con = DriverManager.getConnection("JDBC Connection", "username", "password");
                
                
        Statement stmt;
        stmt = con.createStatement();
        ResultSet d= stmt.executeQuery("SELECT SCHEDULE_DATE AS DT FROM THEATER_SCHEDULE WHERE THEATRE_ID="
					+ tid + "AND MOVIE_ID=" + mid);
        while(d.next()) {
            
            De= d.getDate("DT");
                
        System.out.println(" Ticket Number : " + ticketid );
        System.out.println(" Theatre ID:"+ tid);
        System.out.println(" Screen Number:"+screen);
        System.out.println(" Show ID :"+show);
        System.out.println(" Show Time :"+time);
        System.out.println(" Show Date :"+ De );
        System.out.println(" Price: "+price);
        System.out.println(" UserID:"+userid);
         
        }
        }catch (SQLException ex) {
	Logger.getLogger(CS425.class.getName()).log(Level.SEVERE, null, ex);
}

		String sql = "INSERT INTO ticket(Ticket_Id,Theatre_Id,Screen_Number,Show_Id,Show_Time,Seat_Number,Price,User_Id,InsertTimestamp) values(?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt;
		try {

			Connection con;
			OracleDataSource dataset = new OracleDataSource();
			con = DriverManager.getConnection("JDBC Connection", "username", "password");

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, ticketid);
			pstmt.setInt(2, tid);
			pstmt.setInt(3, screen);
			pstmt.setInt(4, show);
			pstmt.setString(5, time);
			pstmt.setInt(6, s);
			pstmt.setInt(7, price);
			pstmt.setInt(8, userid);
			pstmt.setTimestamp(9, getCurrentTimeStamp());

			pstmt.executeUpdate();

			con.commit();
		} catch (SQLException ex) {
			Logger.getLogger(CS425.class.getName()).log(Level.SEVERE, null, ex);
		}

		System.out.println(" You Are Tickets Are Successfully Booked !! Go Enjoy !!");

		int points = 20;

		try {

			Connection con;
			OracleDataSource dataset = new OracleDataSource();
			con = DriverManager.getConnection("JDBC Connection", "username", "password");

			Statement stmt;
			stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT CREDIT_POINTS_EARNED AS P FROM User_Membership WHERE USER_ID=" + userid + "");

			if (rs.next()) {

				int po = rs.getInt("P");

				po = po + points;

				stmt.executeQuery("UPDATE User_Membership SET CREDIT_POINTS_EARNED=" + po + "WHERE USER_ID=" + userid);
			} else {
				String sql4 = "INSERT INTO User_Membership(USER_ID,MEMBERSHIP_STATUS ,CREDIT_POINTS_EARNED) values(?,?,?)";
				pstmt = con.prepareStatement(sql4);

				pstmt.setInt(1, userid);
				pstmt.setString(2, "REGULAR");
				pstmt.setInt(3, points);

				pstmt.executeUpdate();

				con.commit();
			}

		} catch (SQLException ex) {
			Logger.getLogger(CS425.class.getName()).log(Level.SEVERE, null, ex);
		}

		return 0;
	}

	public int userinfo(int userid) {

		try {

			Connection con;
			OracleDataSource dataset = new OracleDataSource();
			con = DriverManager.getConnection("JDBC Connection", "username", "password");
			Statement stmt;

			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(
					"SELECT USER_ID AS US,USER_NAME AS NA,PASSWORD AS PWD,EMAIL_ID AS MAIL,PHONE_NUMBER AS PHONE,ADDRESS AS AD FROM USERS WHERE USER_ID="
							+ userid);

			while (rs.next()) {

				int US = rs.getInt("US");
				String N = rs.getString("NA");
				String P = rs.getString("PWD");
				String D = rs.getString("MAIL");
				int PH = rs.getInt("PHONE");
				String AD = rs.getString("AD");

				System.out.println(" User ID " + US);
				System.out.println(" User Name :" + N);
				System.out.println(" User Password:" + P);
				System.out.println(" User EMail ID:" + D);
				System.out.println(" User Phone Number :" + PH);
				System.out.println(" User Address :" + AD);

			}
		} catch (SQLException ex) {
			Logger.getLogger(CS425.class.getName()).log(Level.SEVERE, null, ex);
		}

		try {
                
                Connection con;
		OracleDataSource dataset=new OracleDataSource();
                con=DriverManager.getConnection("JDBC Connection","username","password");
                Statement stmt;
                
                stmt = con.createStatement();
          
          ResultSet rs1 = stmt.executeQuery("SELECT MEMBERSHIP_STATUS AS NA,CREDIT_POINTS_EARNED AS PWD FROM User_Membership WHERE USER_ID="+userid);
            
          
          while(rs1.next()) {
             
             String N = rs1.getString("NA");
             int PH = rs1.getInt("PWD");
             
             System.out.println(" Membership Status :"+N);
             System.out.println(" Credit Points Earned :"+PH);
             
               
         }
          } 
            catch (SQLException ex) {
                Logger.getLogger(CS425.class.getName()).log(Level.SEVERE, null, ex);
            }

		Scanner inpu = new Scanner(System.in);

		System.out.println(" Do You Want to change the Contact Information");
		System.out.println(" Press 1 - Yes");
		System.out.println(" Press 2 - No!!");
		int uin = inpu.nextInt();

		if (uin == 1) {
			Scanner inpuu = new Scanner(System.in);

			System.out.println(" Please Provide the New Contact Inforamtion :");
			int phin = inpuu.nextInt();

			try {

				Connection con;
				OracleDataSource dataset = new OracleDataSource();
				con = DriverManager.getConnection("JDBC Connection", "username",
						"password");

				Statement stmt;

				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT PHONE_NUMBER AS PH FROM USERS WHERE USER_ID=" + userid);

				while (rs.next()) {

					int s = rs.getInt("PH");

					s = phin;

					stmt.executeQuery("update USERS set PHONE_NUMBER=" + s + " WHERE USER_ID=" + userid);
					System.out.println(" Contact Details Updated Successfully");

					con.commit();

				}
			} catch (SQLException ex) {
				Logger.getLogger(CS425.class.getName()).log(Level.SEVERE, null, ex);
			}

		} else {
			System.out.println(" Please Review the Details.");
		}

		return 0;
	}

	public int movie_theatre_reviewthread(int Option, int user_id) {
		try {
			int visits = 1;
			String review;
			
			Connection con;
			con = DriverManager.getConnection("JDBC Connection", "username", "password");
            Statement state = con.createStatement();            
            Scanner inp = new Scanner(System.in);
			if (user_id != 0) {
				if (Option == 1) {
					System.out.println("1.Based on the actor");
					System.out.println("2.Based on the director");
					System.out.println("3.Based on the Movie");
					int option_val = inp.nextInt();
					inp.nextLine();
					if (option_val == 1) {
						System.out.println("Actors are :");
						String sql_movie = "select distinct actor_name from movie_actors";
						ResultSet rs_movie = state.executeQuery(sql_movie);
						int i = 0;
						while (rs_movie.next()) {
							System.out.print(++i);
							System.out.print(".");
							System.out.println(rs_movie.getString(1));
						}
						System.out.println("Enter the actor name to review ");
						String act_name = inp.nextLine();
						String sql_movie_id = "Select actor_id from movie_actors where actor_name =" + "'" + act_name
								+ "'";
						rs_movie = state.executeQuery(sql_movie_id);
						if (rs_movie.next()) {
							/* Query again for different result set */
							sql_movie_id = "Select actor_id from movie_actors where actor_name =" + "'" + act_name
									+ "'";
							rs_movie = state.executeQuery(sql_movie_id);
							rs_movie.next();
							int act_id = rs_movie.getInt(1);
							sql_movie_id = "Select distinct title from movie,movie_actors where movie.movie_id = movie_actors.movie_id and actor_id = "
									+ act_id;
							rs_movie = state.executeQuery(sql_movie_id);
							i = 0;
							while (rs_movie.next()) {
								System.out.print(++i);
								System.out.print(".");
								System.out.println(rs_movie.getString(1));
							}
							rs_movie.close();
						} else {
							System.out.println("Invalid actor");
							System.exit(0);
						}
					} else if (option_val == 2) {
						System.out.println("Directors are :");
						String sql_movie = "select distinct director_name as director1_name from movie_directors";
						ResultSet rs_movie = state.executeQuery(sql_movie);
						int i = 0;
						while (rs_movie.next()) {
							System.out.print(++i);
							System.out.print(".");
							System.out.println(rs_movie.getString(1));
						}
						System.out.println("Enter the director name to review ");
						String act_name = inp.nextLine();
						String sql_movie_id = "Select director_id from movie_directors where director_name =" + "'"
								+ act_name + "'";
						rs_movie = state.executeQuery(sql_movie_id);
						if (rs_movie.next()) {
							/* Query again for different result set */
							sql_movie_id = "Select director_id from movie_directors where director_name =" + "'"
									+ act_name + "'";
							rs_movie = state.executeQuery(sql_movie_id);
							rs_movie.next();
							int act_id = rs_movie.getInt(1);
							sql_movie_id = "Select distinct title from movie,movie_directors where movie.movie_id = movie_directors.movie_id and director_id = "
									+ act_id;
							rs_movie = state.executeQuery(sql_movie_id);
							i = 0;
							while (rs_movie.next()) {
								System.out.print(++i);
								System.out.print(".");
								System.out.println(rs_movie.getString(1));
							}
							rs_movie.close();
						} else {
							System.out.println("Invalid director");
							System.exit(0);
						}
					}
					if (option_val == 3) {
						System.out.println("Movies are :");
						String sql_movie = "Select title from movie where movie_id not in 99";
						ResultSet rs_movie = state.executeQuery(sql_movie);
						int i = 0;
						while (rs_movie.next()) {
							System.out.print(++i);
							System.out.print(".");
							System.out.println(rs_movie.getString(1));
						}
					}
					System.out.println("Enter the movie name to review ");
					String movie_name = inp.nextLine();
					String sql_movie_id = "Select movie_id from movie where title =" + "'" + movie_name + "'";
					ResultSet rs_movie = state.executeQuery(sql_movie_id);
					if (rs_movie.next()) {
						int movie_id = rs_movie.getInt(1);
						java.util.Date utilDate = new java.util.Date();
						java.sql.Timestamp sql_date = new java.sql.Timestamp(utilDate.getTime());
						System.out.println("Enter the review");
						review = inp.nextLine();
						String sql_insert = "INSERT INTO movie_discussion(user_id,comments,movie_id,inserttimestamp) VALUES (?,?,?,?)";
						PreparedStatement update_p = con.prepareStatement(sql_insert);
						update_p.setInt(1, user_id);
						update_p.setString(2, review);
						update_p.setInt(3, movie_id);
						update_p.setTimestamp(4, sql_date);
						ResultSet rs_update = update_p.executeQuery();
					} else {
						System.out.println("No such movie");
					}
				}
				if (Option == 2) {
					System.out.println("Theatres are :");
					String sql_theatre = "Select name from Theatre";
					ResultSet rs_movie = state.executeQuery(sql_theatre);
					while (rs_movie.next()) {
						int i = 0;
						System.out.print(++i);
						System.out.print(".");
						System.out.println(rs_movie.getString(1));
					}
					System.out.println("Enter the Theatre which you want to review ");
					String theatre_name = inp.nextLine();
					String sql_movie_id = "Select theatre_id from theatre where name ='" + theatre_name + "'";
					rs_movie = state.executeQuery(sql_movie_id);
					if (rs_movie.next()) {
						int th_id = rs_movie.getInt(1);
						java.util.Date utilDate = new java.util.Date();
						java.sql.Timestamp sql_date = new java.sql.Timestamp(utilDate.getTime());
						System.out.println("Enter the rating in a scale of 1 - 10");
						int rating = inp.nextInt();
						inp.nextLine();
						System.out.println("Enter the review");
						review = inp.nextLine();
						String sql_insert = "INSERT INTO theatre_discussion(theatre_id,user_id,comments,review_rating,inserttimestamp) VALUES (?,?,?,?,?)";
						PreparedStatement update_p = con.prepareStatement(sql_insert);
						update_p.setInt(1, th_id);
						update_p.setInt(2, user_id);
						update_p.setString(3, review);
						update_p.setInt(4, rating);
						update_p.setTimestamp(5, sql_date);
						ResultSet rs_update = update_p.executeQuery();
					} else {
						System.out.println("No such Theatre Name");
					}
				}
			}
				if (Option == 3) {
					System.out.println("Movies are :");
					String sql_movie = "Select title from movie where movie_id not in 99";
					ResultSet rs_movie = state.executeQuery(sql_movie);
					int i = 0;
					while (rs_movie.next()) {
						System.out.print(++i);
						System.out.print(".");
						System.out.println(rs_movie.getString(1));
					}
					System.out.println("Enter the movie name to see the reviews ");
					String movie_name = inp.nextLine();
					String sql_movie_id = "Select movie_id from movie where title ='" + movie_name + "'";
					rs_movie = state.executeQuery(sql_movie_id);
					if (rs_movie.next()) {
						int mov_id = rs_movie.getInt(1);
						sql_movie_id = "Select users.user_name,comments,movie_discussion.inserttimestamp from movie_discussion,users where movie_discussion.movie_id = ? and movie_discussion.user_id = users.user_id";
						PreparedStatement p_mov = con.prepareStatement(sql_movie_id);
						p_mov.setInt(1, mov_id);
						rs_movie = p_mov.executeQuery();
						if (rs_movie.next()) {
							i = 0;
							sql_movie_id = "Select users.user_name,comments,movie_discussion.inserttimestamp from movie_discussion,users where movie_discussion.movie_id = ? and movie_discussion.user_id = users.user_id";
							p_mov = con.prepareStatement(sql_movie_id);
							p_mov.setInt(1, mov_id);
							rs_movie = p_mov.executeQuery();

							while (rs_movie.next()) {
								String user_name = rs_movie.getString(1);
								String review_mov = rs_movie.getString(2);
								java.sql.Timestamp time_stamp = rs_movie.getTimestamp(3);
								System.out.print(++i);
								System.out.print(".");
								System.out.println("user name =" + user_name);
								System.out.println("user reveiw =" + review_mov);
								System.out.println("Time =" + time_stamp);
								System.out.println(
										"-------------------------------------------------------------------------------------");
							}
						} else {
							System.out.println("No reviews");
						}
					} else {
						System.out.println("no such movie");
					}
				}
				if (Option == 4) {
					System.out.println("Theatres are :");
					String sql_movie = "Select name from theatre";
					ResultSet rs_movie = state.executeQuery(sql_movie);
					int i = 0;
					while (rs_movie.next()) {
						System.out.print(++i);
						System.out.print(".");
						System.out.println(rs_movie.getString(1));
					}
					System.out.println("Enter the Theatre name to see the reviews ");
					String th_name = inp.nextLine();
					String sql_th_id = "Select theatre_id from theatre where name ='" + th_name + "'";
					rs_movie = state.executeQuery(sql_th_id);
					if (rs_movie.next()) {
						int th_id = rs_movie.getInt(1);
						sql_th_id = "Select users.user_name,comments,review_rating,theatre_discussion.inserttimestamp from theatre_discussion,users where theatre_discussion.theatre_id = ? and theatre_discussion.user_id = users.user_id";
						PreparedStatement p_th = con.prepareStatement(sql_th_id);
						p_th.setInt(1, th_id);
						rs_movie = p_th.executeQuery();
						if (rs_movie.next()) {
							i = 0;
							sql_th_id = "Select users.user_name,comments,review_rating,theatre_discussion.inserttimestamp from theatre_discussion,users where theatre_discussion.theatre_id = ? and theatre_discussion.user_id = users.user_id";
							p_th = con.prepareStatement(sql_th_id);
							p_th.setInt(1, th_id);
							rs_movie = p_th.executeQuery();
							while (rs_movie.next()) {
								String user_name = rs_movie.getString(1);
								String review_th = rs_movie.getString(2);
								int rating_th = rs_movie.getInt(3);
								java.sql.Timestamp time_stamp = rs_movie.getTimestamp(4);
								System.out.print(++i);
								System.out.print(".");
								System.out.println("user name =" + user_name);
								System.out.println("user reveiw =" + review_th);
								System.out.println("Rating =" + rating_th);
								System.out.println("Time =" + time_stamp);
								System.out.println(
										"-------------------------------------------------------------------------------------");
							}
						} else {
							System.out.println("No reviews");
						}
					} else {
						System.out.println("no such Theatre");
					}
				}
				/* Thread */
				if (user_id != 0) {
				if (Option == 5) {
					System.out.println("1.Based on the actor");
					System.out.println("2.Based on the director");
					System.out.println("3.Based on the Movie");
					System.out.println("4.General Discussion Forum");
					int option_val = inp.nextInt();
					inp.nextLine();
					int mov_id = 99;
					if (option_val == 1) {
						System.out.println("Actors are :");
						String sql_movie = "select distinct actor_name from movie_actors";
						ResultSet rs_movie = state.executeQuery(sql_movie);
						int i = 0;
						while (rs_movie.next()) {
							System.out.print(++i);
							System.out.print(".");
							System.out.println(rs_movie.getString(1));
						}
						System.out.println("Enter the actor name to review ");
						String act_name = inp.nextLine();
						String sql_movie_id = "Select actor_id from movie_actors where actor_name =" + "'" + act_name
								+ "'";
						rs_movie = state.executeQuery(sql_movie_id);
						if (rs_movie.next()) {
							/* Query again for different result set */
							sql_movie_id = "Select actor_id from movie_actors where actor_name =" + "'" + act_name
									+ "'";
							rs_movie = state.executeQuery(sql_movie_id);
							rs_movie.next();
							int act_id = rs_movie.getInt(1);
							sql_movie_id = "Select distinct title from movie,movie_actors where movie.movie_id = movie_actors.movie_id and actor_id = "
									+ act_id;
							rs_movie = state.executeQuery(sql_movie_id);
							i = 0;
							while (rs_movie.next()) {
								System.out.print(++i);
								System.out.print(".");
								System.out.println(rs_movie.getString(1));
							}
							rs_movie.close();
						} else {
							System.out.println("Invalid actor");
							System.exit(0);
						}
					} else if (option_val == 2) {
						System.out.println("Directors are :");
						String sql_movie = "select distinct director_name as director1_name from movie_directors";
						ResultSet rs_movie = state.executeQuery(sql_movie);
						int i = 0;
						while (rs_movie.next()) {
							System.out.print(++i);
							System.out.print(".");
							System.out.println(rs_movie.getString(1));
						}
						System.out.println("Enter the director name to review ");
						String act_name = inp.nextLine();
						String sql_movie_id = "Select director_id from movie_directors where director_name =" + "'"
								+ act_name + "'";
						rs_movie = state.executeQuery(sql_movie_id);
						if (rs_movie.next()) {
							/* Query again for different result set */
							sql_movie_id = "Select director_id from movie_directors where director_name =" + "'"
									+ act_name + "'";
							rs_movie = state.executeQuery(sql_movie_id);
							rs_movie.next();
							int act_id = rs_movie.getInt(1);
							sql_movie_id = "Select distinct title from movie,movie_directors where movie.movie_id = movie_directors.movie_id and director_id = "
									+ act_id;
							rs_movie = state.executeQuery(sql_movie_id);
							i = 0;
							while (rs_movie.next()) {
								System.out.print(++i);
								System.out.print(".");
								System.out.println(rs_movie.getString(1));
							}
							rs_movie.close();
						} else {
							System.out.println("Invalid director");
							System.exit(0);
						}
					}
					if (option_val == 3) {
						System.out.println("Movies are :");
						String sql_movie = "Select title from movie where movie_id not in 99";
						ResultSet rs_movie = state.executeQuery(sql_movie);
						int i = 0;
						while (rs_movie.next()) {
							System.out.print(++i);
							System.out.print(".");
							System.out.println(rs_movie.getString(1));
						}
					}
					if (option_val == 3 || option_val == 2 || option_val == 1) {
					System.out.println("Enter the movie name for the thread ");
					String movie_name = inp.nextLine();
					String sql_movie_id = "Select movie_id from movie where title =" + "'" + movie_name + "'";
					ResultSet rs_movie_name_thread = state.executeQuery(sql_movie_id);
					if (rs_movie_name_thread.next()) {
						mov_id = rs_movie_name_thread.getInt(1);
					}
					}
					System.out.println("Enter the thread name");
					String thread_name = inp.nextLine();
					String sql_movie = "Select max(thread_id) from thread";
					ResultSet rs_movie = state.executeQuery(sql_movie);
					int th_id = 1;
					if (rs_movie.next()) {
						th_id = rs_movie.getInt(1);
						th_id++;
					}
					visits++;
					java.util.Date utilDate = new java.util.Date();
					java.sql.Timestamp sql_date = new java.sql.Timestamp(utilDate.getTime());
					String sql_thread = "INSERT INTO thread(thread_id,thread_subject,user_id,visits) VALUES (?,?,?,?)";
					PreparedStatement p_th = con.prepareStatement(sql_thread);
					p_th.setInt(1, th_id);
					p_th.setString(2, thread_name);
					p_th.setInt(3, user_id);
					p_th.setInt(4, visits);
					p_th.executeQuery();
					System.out.println("Enter the Comment to add in the thread ");
					String review_thread = inp.nextLine();
					sql_thread = "INSERT INTO movie_discussion(user_id,comments,movie_id,inserttimestamp,thread_id) VALUES (?,?,?,?,?)";
					PreparedStatement update_p = con.prepareStatement(sql_thread);
					update_p.setInt(1, user_id);
					update_p.setString(2, review_thread);
					update_p.setInt(3, mov_id);
					update_p.setTimestamp(4, sql_date);
					update_p.setInt(5, th_id);
					update_p.executeQuery();
					String sql_thread_commit = "commit";
					state.execute(sql_thread_commit);
				}
				}
				/* Display Thread */
				if (Option == 6) {
					System.out.println("1.View Threads");
					System.out.println("2.View recent thread");
					System.out.println("3.View recent comments for a specific thread");
					System.out.println("4.View least popular thread :");
					int option = inp.nextInt();
					inp.nextLine();
					if(option == 1)
					{
					System.out.println("Threads are :");
					String sql_movie = "Select thread_subject from thread";
					ResultSet rs_movie = state.executeQuery(sql_movie);
					int i = 0;
					while (rs_movie.next()) {
						System.out.print(++i);
						System.out.print(".");
						System.out.println(rs_movie.getString(1));
					}
					System.out.println("Enter the thread name to display comments");
					String thread_name = inp.nextLine();
					sql_movie = "Select thread_id from thread where thread_subject ='" + thread_name + "'";
					rs_movie = state.executeQuery(sql_movie);
					int th_id = 0;
					if (rs_movie.next()) {
						th_id = rs_movie.getInt(1);
					} else {
						System.out.println("No such thread");
						System.exit(0);
					}
					sql_movie = "Select visits from thread where thread_subject ='" + thread_name + "'";
					rs_movie = state.executeQuery(sql_movie);
					if (rs_movie.next()) {
						visits = rs_movie.getInt(1);
						visits++;
					}
					sql_movie = "Update thread set visits = " + visits + "where thread_subject ='" + thread_name + "'";
					state.executeQuery(sql_movie);
					java.util.Date utilDate = new java.util.Date();
					java.sql.Timestamp sql_date = new java.sql.Timestamp(utilDate.getTime());

					i = 0;
					String sql_movie_id = "Select distinct users.user_name,comments,movie_discussion.inserttimestamp from thread,movie_discussion,users where movie_discussion.thread_id = ? and movie_discussion.user_id = users.user_id";
					PreparedStatement p_mov = con.prepareStatement(sql_movie_id);
					p_mov.setInt(1, th_id);
					rs_movie = p_mov.executeQuery();

					while (rs_movie.next()) {
						String user_name = rs_movie.getString(1);
						String review_mov = rs_movie.getString(2);
						java.sql.Timestamp time_stamp = rs_movie.getTimestamp(3);
						System.out.print(++i);
						System.out.print(".");
						System.out.println("user name =" + user_name);
						System.out.println("user comment =" + review_mov);
						System.out.println("Time =" + time_stamp);
						System.out.println(
								"-------------------------------------------------------------------------------------");

					}
					if(user_id != 0)
					{
					System.out.print("Enter 1 to add a comment or 0 to Exit");
					int comment_val = inp.nextInt();
					inp.nextLine();
					if (comment_val == 1) {
						System.out.println("Enter the Comment to add in the thread ");
						String review_thread = inp.nextLine();
						String sql_thread_ins = "INSERT INTO movie_discussion(user_id,comments,movie_id,inserttimestamp,thread_id) VALUES (?,?,?,?,?)";
						PreparedStatement update_p = con.prepareStatement(sql_thread_ins);
						update_p.setInt(1, user_id);
						update_p.setString(2, review_thread);
						update_p.setInt(3, 99);
						update_p.setTimestamp(4, sql_date);
						update_p.setInt(5, th_id);
						update_p.executeQuery();
						String sql_thread_commit = "commit";
						state.execute(sql_thread_commit);
					} else {
						 return 0;
					}
					}
					}
					if(option == 2)
					{
						System.out.println("Recent Threads that was commented are :");
						String sql_movie = "select * from (select distinct thread_subject, inserttimestamp, comments from thread t, movie_discussion m where t.thread_id = m.thread_id)R1 order by R1.INSERTTIMESTAMP desc";
						ResultSet rs_movie = state.executeQuery(sql_movie);
						int i = 0;
						String movie = null;
						while (rs_movie.next() && i < 3) {
							{
							movie = rs_movie.getString(1);
							System.out.print(++i);
							System.out.print(".");
							System.out.println("Thread name = "+movie);
							System.out.println("user comment =" + rs_movie.getString(3));
							System.out.println("Time =" + rs_movie.getString(2));
							System.out.println();
							}
						}
					
					}
					if(option == 3)
					{
						System.out.println("Threads are :");
						String sql_movie = "Select thread_subject from thread";
						ResultSet rs_movie = state.executeQuery(sql_movie);
						int i = 0;
						while (rs_movie.next()) {
							System.out.print(++i);
							System.out.print(".");
							System.out.println(rs_movie.getString(1));
						}
						System.out.println("Enter the thread name to display comments");
						String thread_name = inp.nextLine();
						sql_movie = "Select thread_id from thread where thread_subject ='" + thread_name + "'";
						rs_movie = state.executeQuery(sql_movie);
						int th_id = 0;
						if (rs_movie.next()) {
							th_id = rs_movie.getInt(1);
						} else {
							System.out.println("No such thread");
							System.out.println();
							return 0;
						}
						sql_movie = "select comments,INSERTTIMESTAMP from movie_discussion where thread_id = "+th_id+" order by INSERTTIMESTAMP desc";
						rs_movie = state.executeQuery(sql_movie);
						i = 0;
						String movie = null;
						while (rs_movie.next() && i < 3) {
							{
							System.out.print(++i);
							System.out.print(".");
							System.out.println("user comment =" + rs_movie.getString(1));
							System.out.println("Time =" + rs_movie.getString(2));
							System.out.println();
							}
						}
					
					}
					if(option == 4)
					{
						System.out.println("1.least popular threads by visits");
						System.out.println("2.least popular threads by comments");
						System.out.println("Enter the option");
						int option_lt = inp.nextInt();
						inp.nextLine();
						if(option_lt == 1)
						{
							String sql_movie = "select thread_subject,visits from thread where visits in (select min(visits) from thread)";
							ResultSet rs_movie = state.executeQuery(sql_movie);
							System.out.println("Threads are :");
							int i = 0;
							while (rs_movie.next()) {
								{
								System.out.print(++i);
								System.out.print(".");
								System.out.println("Thread name =" + rs_movie.getString(1));
								System.out.println("No of Visits =" + rs_movie.getString(2));
								System.out.println();
								}
							}	
						}
						if(option_lt == 2)
						{
							String sql_movie = "select min(min) from (select thread_subject as ts, count(*) as min from thread, movie_discussion where thread.thread_id = movie_discussion.thread_id group by thread_subject)";
							ResultSet rs_movie = state.executeQuery(sql_movie);
							int i = 0;
							int count = 0;
							while(rs_movie.next())
							{
								count = rs_movie.getInt(1);
							}
							sql_movie = "select thread_subject,count(*) from thread, movie_discussion where thread.thread_id = movie_discussion.thread_id group by thread_subject having count(*) = "+count;
							rs_movie = state.executeQuery(sql_movie);
							while (rs_movie.next()) {
								{
								System.out.print(++i);
								System.out.print(".");
								System.out.println("Thread name =" + rs_movie.getString(1));
								System.out.println("No of comments =" + rs_movie.getInt(2));
								System.out.println();
								}
							}	
						}
					}
					return 0;
				}
				/* End Display thread */
		//	} else {
			//	System.out.println("Invalid Username");
			//}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error caught");
		}
		return 0;
	}

	public int guestinfo(int guestid) {

		try {

			Connection con;
			OracleDataSource dataset = new OracleDataSource();
			con = DriverManager.getConnection("JDBC Connection", "username", "password");
			Statement stmt;

			stmt = con.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT GUEST_ID AS G,GUEST_NAME AS GN FROM GUEST WHERE GUEST_ID=" + guestid);

			while (rs.next()) {

				int US = rs.getInt("G");
				String N = rs.getString("GN");

				System.out.println(" Guest ID " + US);
				System.out.println(" Guest Name :" + N);

			}
		} catch (SQLException ex) {
			Logger.getLogger(CS425.class.getName()).log(Level.SEVERE, null, ex);
		}

		return 0;
	}

	public int ticketguest(int guestid) {

		String time = "";
		int available;
		int screen = 0;
		int show = 0;
		int price = 0;
		int s = 0;
		Date De;

		Scanner inp = new Scanner(System.in);

		System.out.println(" Hello Customer !! Welcome to SPI Cinemas");

		try {

			Connection con;
			OracleDataSource dataset = new OracleDataSource();
			con = DriverManager.getConnection("JDBC Connection", "username", "password");

			Statement stmt;

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT THEATRE_ID AS M,NAME AS P,LOCATION AS U FROM theatre");

			while (rs.next()) {

				int g = rs.getInt("M");
				String p = rs.getString("P");
				String u = rs.getString("U");

				System.out.print(g);
				System.out.print("\t");
				System.out.print(p);
				System.out.print("\t");
				System.out.println(u);

			}
		} catch (SQLException ex) {
			Logger.getLogger(CS425.class.getName()).log(Level.SEVERE, null, ex);
		}

		System.out.println(" Please Select Theatre Location_ID");
		int tid = inp.nextInt();

		System.out.println(" Available Movies in the Theatre,Please Select Movie_ID");

		try {

			Connection con;
			OracleDataSource dataset = new OracleDataSource();
			con = DriverManager.getConnection("JDBC Connection", "username", "password");

			Statement stmt;

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MOVIE_ID AS M,TITLE  AS P FROM MOVIE where movie_id not in 99");

			while (rs.next()) {

				int g = rs.getInt("M");
				String p = rs.getString("P");

				System.out.print(g);
				System.out.print("\t");
				System.out.print("-");
				System.out.print("\t");
				System.out.println(p);

			}
		} catch (SQLException ex) {
			Logger.getLogger(CS425.class.getName()).log(Level.SEVERE, null, ex);
		}

		System.out.println(" Please Select Movie");
		int mid = inp.nextInt();

		try {

			Connection con;
			OracleDataSource dataset = new OracleDataSource();
			con = DriverManager.getConnection("JDBC Connection", "username", "password");
			Statement stmt;

			stmt = con.createStatement();

			// System.out.println(tid);
			// System.out.println(mid);

			ResultSet rs = stmt.executeQuery(
					"SELECT SHOW_ID AS SHOW,SHOW_TIME AS SHOWTIME,SCREEN_NUMBER AS SCREEN FROM SHOWS WHERE THEATRE_ID="
							+ tid + "AND MOVIE_ID=" + mid);

			while (rs.next()) {

				time = rs.getString("SHOWTIME");
				screen = rs.getInt("SCREEN");
				show = rs.getInt("SHOW");

				System.out.println(" Available Show Time For the Movie" + time);
				System.out.println(" Movie Shown In Screen Number :" + screen);
				System.out.println(" Show ID for the Movie:" + show);

			}
		} catch (SQLException ex) {
			Logger.getLogger(CS425.class.getName()).log(Level.SEVERE, null, ex);
		}

		System.out.println(" Please Enter Number Of tickets :");
		int tin = inp.nextInt();

		price = TicketPrice * tin;
		System.out.println(" Enjoy the Movie !! ");

		try {

			Connection con;
			OracleDataSource dataset = new OracleDataSource();
			con = DriverManager.getConnection("JDBC Connection", "username", "password");

			Statement stmt;

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MAX(Seat_Number) AS SEAT FROM ticket WHERE THEATRE_ID=" + tid
					+ "AND Screen_Number=" + screen);

			while (rs.next()) {

				s = rs.getInt("SEAT");

				s = s + tin;

				// stmt.executeQuery("update ticket set price="+s+" WHERE
				// THEATHREID="+tid+"AND MOVIE_ID="+mid+"AND
				// Screen_Number="+screen);
			}
		} catch (SQLException ex) {
			Logger.getLogger(CS425.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		try {
            
            Connection con;
	OracleDataSource dataset = new OracleDataSource();
	con = DriverManager.getConnection("JDBC Connection", "username", "password");
                
                
        Statement stmt;
        stmt = con.createStatement();
        ResultSet d= stmt.executeQuery("SELECT SCHEDULE_DATE AS DT FROM THEATER_SCHEDULE WHERE THEATRE_ID="
					+ tid + "AND MOVIE_ID=" + mid);
        while(d.next()) {
            
            De= d.getDate("DT");
                
        System.out.println(" Ticket Number : " + ticketid );
        System.out.println(" Theatre ID:"+ tid);
        System.out.println(" Screen Number:"+screen);
        System.out.println(" Show ID :"+show);
        System.out.println(" Show Time :"+time);
        System.out.println(" Show Date :"+ De );
        System.out.println(" Price: "+price);
        System.out.println(" GuestID:"+guestid);
         
        }
        }catch (SQLException ex) {
	Logger.getLogger(CS425.class.getName()).log(Level.SEVERE, null, ex);
}

		String sql = "INSERT INTO ticket(Ticket_Id,Theatre_Id,Screen_Number,Show_Id,Show_Time,Seat_Number,Price,Guest_Id,InsertTimestamp) values(?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt;
		try {

			Connection con;
			OracleDataSource dataset = new OracleDataSource();
			con = DriverManager.getConnection("JDBC Connection", "username", "password");

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, ticketid);
			pstmt.setInt(2, tid);
			pstmt.setInt(3, screen);
			pstmt.setInt(4, show);
			pstmt.setString(5, time);
			pstmt.setInt(6, s);
			pstmt.setInt(7, price);
			pstmt.setInt(8, guestid);
			pstmt.setTimestamp(9, getCurrentTimeStamp());

			pstmt.executeUpdate();

			con.commit();
		} catch (SQLException ex) {
			Logger.getLogger(CS425.class.getName()).log(Level.SEVERE, null, ex);
		}

		System.out.println(" You Are Tickets Are Successfully Booked !! Go Enjoy !!");

		return 0;
	}

	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
	
	public static void staff()
	{try
	{
        
        Connection con;
OracleDataSource dataset=new OracleDataSource();

dataset.setURL(DB_URL);
con=dataset.getConnection(username,password);
        
Scanner inp = new Scanner(System.in);
	System.out.println("Staff Email Id: ");
	String name = inp.nextLine();
	System.out.println("Password: ");
	String pass = inp.nextLine();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS COUNT,Staff_Id,STAFF_NAME,SSN,PHONE_NUMBER FROM STAFF WHERE Email_Id ='"+name+"' AND Password='"+pass+"' group by Staff_Id,STAFF_NAME,SSN,PHONE_NUMBER");
        System.out.println("");
		System.out.println("Connecting");
		System.out.println("");
		if(rs.next()) {

            String userName=rs.getString("STAFF_NAME");
            int StaffId=rs.getInt("Staff_Id");
            int ssn= rs.getInt("SSN");
            long ph=rs.getLong("PHONE_NUMBER");
        	System.out.println("Welcome "+userName);
        	System.out.println(StaffId);
        	System.out.println("1 - Personal details");
        	System.out.println("2 - Work details");
        	String manage="SELECT COUNT(*) AS COUNT1 FROM JOB_TYPES JT,STAFF_SCHED SS WHERE SS.JOB_TYPE=JT.JOB_TYPE AND JT.JOB_NAME='MANAGER' AND SS.STAFF_ID="+StaffId;
        	rs = stmt.executeQuery(manage);
        	if(rs.next()){
        		int count1 = rs.getInt("COUNT1");
        		if(count1==1){
        			System.out.println("3 - Check or modify Staff Schedules");
        			System.out.println("4 - Deals or Disounts to be offered");
        			System.out.println("5 - Points table");
        			String up="SELECT COUNT(*) AS COUNT2 FROM STAFF WHERE STAFF_ID="+StaffId+" AND Priv='Y'";
            		rs=stmt.executeQuery(up);
            		if(rs.next()){
            			int count2=rs.getInt("COUNT2");
            			if(count2==1){
            				System.out.println("6 - Update Movies and their show time");
            			}
        			Scanner inp1 = new Scanner(System.in);
                	Integer u = inp1.nextInt();
            		if(u==4){
            			System.out.println("Do you want add a new deal");
            			System.out.println("1 - YES");
            			System.out.println("2 - NO");
            			Scanner in= new Scanner(System.in);
            			Integer i=in.nextInt();
            			if(i==1){
            				String sql2 = "INSERT INTO DEALS(DEAL_ID,DEAL) values(?, ?)";

                            PreparedStatement pstmt2 = con.prepareStatement(sql2);
                            System.out.println("Enter the new deal id");
                            Integer j= in.nextInt();
                            Scanner scan= new Scanner(System.in);
                            System.out.println("Enter the new deal ");
                            String k=scan.nextLine();
                            pstmt2.setInt(1,j);
                            pstmt2.setString(2,k);

                            pstmt2.executeQuery();
                            
                            System.out.println("New Deal has Been Inserted Successfully");
                            System.exit(0);
            			}
            			else if(i==2){
            				System.out.println("End of Program");
            				System.exit(0);
            			}
            		}
                	if(u==5){
                		System.out.println("Do you wish to assign points to the customer: ");
                		System.out.println();
                		System.out.println("1 - YES");
                		System.out.println("2 - NO");
                		Scanner inp2 = new Scanner(System.in);
                    	Integer v = inp2.nextInt();
                    	if(v==1){
                    		updatePoints();
                    		System.exit(0);
                    	}
                	}
                		if (u==3){
                		System.out.println("Staff Schedule :");
                		String sqlstaff1="Select S.Staff_Id AS STAFF_ID, ST.STAFF_NAME AS STAFF_NAME ,JT.Job_Type AS JOB_TYPE, SS.Schedule_NAME AS SCHEDULE, T.NAME AS NAME FROM STAFF_SCHED S,STAFF ST,Theatre T,JOB_TYPES JT, STAFF_SCHEDULE SS WHERE S.STAFF_ID=ST.STAFF_ID AND S.THEATRE_ID=T.THEATRE_ID AND SS.SCHEDULE=S.SCHEDULE AND JT.JOB_TYPE=S.JOB_TYPE AND JT.JOB_TYPEIN('CLEANING STAFF','SECURITY GUARDS','TICKETING STAFF','SNACK SERVICE PROVIDERS')";
                		rs=stmt.executeQuery(sqlstaff1);
                		while(rs.next()){
                			Integer si=rs.getInt("STAFF_ID");
                			String sn=rs.getString("STAFF_NAME");
                			String jt= rs.getString("JOB_TYPE");
                            String sc=rs.getString("SCHEDULE");
                            String thid=rs.getString("NAME");
                            System.out.println("StaffId: "+si+"     Staff Name: "+sn+"     Job TYPE: "+jt+"      Job SCHEDULE: "+sc+"       Theatre Name: "+thid);

                		}
                		System.out.println("Do You Wish Modify The Schedule Of a Staff");
                		System.out.println("1 - YES");
                		System.out.println("2 - NO");
                		Scanner inp2 = new Scanner(System.in);
                    	Integer v = inp2.nextInt();
                    	if(v==1){
                    		UpdateSchedule();
                    		System.exit(0);
                    	}
                    	else if(v==2){
                    		System.out.println("OK");
                    		System.exit(0);
                    	}
                	}
        		

        			if(u==6){
        				String sh="SELECT m.movie_Id as mid,m.title as tit,s.Screen_Number as sn, s.Show_Time as st, s.Show_Id as sid,t.Theatre_Id as tid,t.Name as name FROM SHOWS s,Movie m,Theatre t where s.movie_id=m.movie_id and s.theatre_id=t.theatre_id";
                		rs=stmt.executeQuery(sh);
                		System.out.println("Shows:");
                		while(rs.next()){
                			Integer sid=rs.getInt("Sid");
                			Integer sn=rs.getInt("sn");
                			Integer mid=rs.getInt("mid");
                			Integer tid=rs.getInt("tid");
                			String tit=rs.getString("tit");
                			String st= rs.getString("st");
                			String na=rs.getString("name");
                			System.out.println("Show_Id "+sid+"  Movie_id "+mid+"  Movie_Name "+tit+"  Screen Number "+sn+"  Show Time "+st+"  Theatre_Id "+tid+" Theatre Name "+na);
                		}
        			System.out.println("Do you want to update the exisisting shows");
        			System.out.println();
        			System.out.println("1 - YES");
        			System.out.println("2 - NO");
        			Scanner inp3 = new Scanner(System.in);
        			Integer u3 = inp3.nextInt();
        			if(u3==1){
        			
        				String sql2 = "Insert into Shows values(?,?,?,?,?)";
        				System.out.println("Enter the movie id");
        				Integer sr = inp1.nextInt();
        				System.out.println("Enter the show id");
        				Integer sw = inp1.nextInt();
        				Scanner sc=new Scanner(System.in);
        				
        				System.out.println("Enter the new show time");
        				String sq1 = sc.nextLine();
        				System.out.println("Enter the screen number");
        				Integer sn = inp1.nextInt();
        				System.out.println("Enter the Thaetre id");
        				Integer ti = inp1.nextInt();
        			/*	String sql1="Update Ticket set show_time=? where show_id=? and show_time=? and screen_number=? and theatre_id=?" ;
        				 PreparedStatement pstmt1 = con.prepareStatement(sql1);
                         pstmt1.setInt(1,sw);
                         pstmt1.setString(2,sq);
                         pstmt1.setInt(3,sn);
                         pstmt1.setInt(4,ti);
                         pstmt1.executeQuery();
                         System.out.println("delete Successful");*/
        				PreparedStatement pstmt2 = con.prepareStatement(sql2);
                        pstmt2.setInt(2,sr);
                        pstmt2.setString(4,sq1);
                        pstmt2.setInt(1,sw);
                        pstmt2.setInt(3,sn);
                        pstmt2.setInt(5,ti);
                        pstmt2.executeQuery();
                        System.out.println("Update Successful");
                        System.exit(0);
        			}
        			else if(u3==2){
        				System.out.println("OK");
        				System.exit(0);
        			}
        			}
        		}
        	}
        	}
        	String owner="SELECT COUNT(*) AS COUNT1 FROM JOB_TYPES JT,STAFF_SCHED SS WHERE SS.JOB_TYPE=JT.JOB_TYPE AND JT.JOB_NAME='OWNER' AND SS.STAFF_ID="+StaffId;
        	rs = stmt.executeQuery(owner);
        	if(rs.next()){
        		int count1 = rs.getInt("COUNT1");
        		if(count1>0){
        			owner();
        		}
        	}
        	String web="SELECT COUNT(*) AS COUNT1 FROM JOB_TYPES JT,STAFF_SCHED SS WHERE SS.JOB_TYPE=JT.JOB_TYPE AND JT.JOB_NAME='WEB ADMIN' AND SS.STAFF_ID="+StaffId;
        	rs = stmt.executeQuery(web);
        	if(rs.next()){
        		int count1 = rs.getInt("COUNT1");
        		if(count1>0){
        			web_admin();
        		}
        	}
        			System.out.println("Press 1 for personal details ");
        			System.out.println("Press 2 for Work details ");
        			Scanner inp1 = new Scanner(System.in);
                	Integer u = inp1.nextInt();
        	
        	if( u==2) {
        		String sqlstaff1="SELECT JT.JOB_NAME AS JOB_TYPE,SS.SCHEDULE_NAME AS SCHEDULE,T.NAME AS NAME FROM STAFF_SCHED S,Theatre T,JOB_TYPES JT, STAFF_SCHEDULE SS WHERE S.THEATRE_ID=T.THEATRE_ID AND SS.SCHEDULE=S.SCHEDULE AND JT.JOB_TYPE=S.JOB_TYPE AND S.STAFF_ID ="+StaffId;
        		rs = stmt.executeQuery(sqlstaff1);
        		System.out.println("\n\n JOB DETAILS:");
        		while(rs.next()) {
                String jt= rs.getString("JOB_TYPE");
                String sc=rs.getString("SCHEDULE");
                String thid=rs.getString("NAME");
                System.out.println("StaffId: "+StaffId+"     Job TYPE: "+jt+"      Job SCHEDULE: "+sc+"       Theatre Name: "+thid);
               }
        		
        	}
        	 else if(u==1){
              	System.out.println("StaffId: "+StaffId+"     Staff Name: "+userName+ "     Email Id: "+name+"     Phone: "+ph+"     SSN: "+ssn);
              }
		
	
	
		}
		else
	        {
	        	System.out.println("Invalid UserId or Password ");
	        	con.close();
	        	System.exit(1);
	        }

	}
	

	
	catch (Exception e)
	{
		e.printStackTrace();
	}	
	}

	private static void UpdateSchedule() {
		// TODO Auto-generated method stub
		try
		{
	     Connection con;
					OracleDataSource dataset=new OracleDataSource();

					dataset.setURL(DB_URL);
					con=dataset.getConnection(username,password);
					Statement stmt = con.createStatement();
					Scanner inp = new Scanner(System.in);
					ResultSet rs = stmt.executeQuery("SELECT distinct S.STAFF_ID, S.STAFF_NAME FROM STAFF S,JOB_TYPES JT,STAFF_SCHED SS WHERE S.STAFF_ID=SS.STAFF_ID AND SS.JOB_TYPE=JT.JOB_TYPE AND JT.JOB_NAME IN('CLEANING STAFF','SECURITY GUARDS','TICKETING STAFF','SNACK SERVICE PROVIDERS')");
					System.out.println(" Staff members in theatres ");
					while(rs.next()){
		
		Integer staffid= rs.getInt("STAFF_ID");
		String staffName=rs.getString("STAFF_NAME");
		System.out.println(staffid+" - "+staffName);
					}
		System.out.println("Enter the Id of the Worker to add to the schedule :");
		String name = inp.nextLine();
                        
                        rs=stmt.executeQuery("SELECT JOB_TYPE,JOB_NAME FROM JOB_TYPES WHERE JOB_TYPE<2000");
                        System.out.println(" Different Type of Positions in theatre ");
                        while(rs.next()){
                    		
                    		Integer jobType= rs.getInt("JOB_TYPE");
                    		String jobName=rs.getString("JOB_NAME");
                    		System.out.println(jobType+" - "+jobName);
                        }
                        System.out.println("Enter the Position Id for the Worker :");
                        Integer  wid= inp.nextInt();
                        
                        rs=stmt.executeQuery("SELECT THEATRE_ID,LOCATION FROM THEATRE");
                        System.out.println(" Different Thethre Id for the Different theatre Locations ");
                        while(rs.next()){
                    		
                    		Integer thid= rs.getInt("THEATRE_ID");
                    		String thName=rs.getString("LOCATION");
                    		System.out.println(thid+" - "+thName);
                        }
                        
                        System.out.println("Enter the Theatre Id for the Worker :");
                        Integer  tid= inp.nextInt();
                        rs=stmt.executeQuery("SELECT SCHEDULE,SCHEDULE_NAME FROM STAFF_SCHEDULE");
                        System.out.println("Schedules  :");
                        while(rs.next()){
                    		
                    		Integer sch= rs.getInt("SCHEDULE");
                    		String schName=rs.getString("SCHEDULE_NAME");
                    		System.out.println(sch+" - "+schName);
                        }
                        System.out.println("Enter the Schedule Id for the Worker :");
                        Integer sid= inp.nextInt();
                        
                        System.out.println("DAYS OF A WEEK :");
                        System.out.println("SUNDAY");
                        System.out.println("MONDAY");
                        System.out.println("TUESDAY");
                        System.out.println("WEDNESDAY");
                        System.out.println("THURSDAY");
                        System.out.println("FRIDAY");
                        System.out.println("SATURDAY");
                        
                        System.out.println("Enter the day for the Workers");
                        String did=inp.next();
                        
                                

                                 rs = stmt.executeQuery("SELECT COUNT(*) AS COUNT FROM STAFF_SCHED WHERE THEATRE_ID="+tid+" AND SCHEDULE="+sid+" AND JOB_TYPE="+wid+" AND DAYOFWEEK='"+did+"'");
                                if(rs.next()) {
                                	int count = rs.getInt("COUNT");
                                	
                                    rs=stmt.executeQuery("SELECT COUNT(*) AS COUNT1 FROM STAFF_SCHED WHERE STAFF_ID="+name+" AND THEATRE_ID <>"+tid);
                                if(rs.next()) {
                                	int count1= rs.getInt("COUNT1");
                                	
                                 rs=stmt.executeQuery("SELECT COUNT(*) AS COUNT2 FROM STAFF_SCHED WHERE STAFF_ID="+name+" AND JOB_TYPE <>"+wid);
                                	       
                                	if(rs.next()) {
                                		int count2= rs.getInt("COUNT2");
                                		if(count2<1){
                                		if(count1<1){
                                if(count<1)
                                {
                                    String sql = "INSERT INTO STAFF_SCHED(STAFF_ID,JOB_TYPE,Schedule,THEATRE_ID,DAYOFWEEK) values(?, ?, ?,?,?)";
                                    
                                    PreparedStatement pstmt = con.prepareStatement(sql);

                                    pstmt.setString(1,name);
                                    pstmt.setInt(2,wid);
                                    pstmt.setInt(3,sid);
                                    pstmt.setInt(4,tid);
                                    pstmt.setString(5,did);
                        
         
                        pstmt.executeQuery();
                        
                        System.out.println("Staff Schedule has Been Added");
                                    
                                }
                                
                               /* else
                                    
                                {
                                    System.out.println(" Schedule is Already Assigned in the Table , Please Try Another");
                                    
                                    System.out.println(" Do You Want to Update the Schedule of the Worker With Current Inforamtion");
                                    
                                    System.out.println(" 1- YES ");
                                    System.out.println(" 2- NO ");
                                    
                                    Scanner inp1 = new Scanner(System.in);
                                    
                                    Integer u = inp1.nextInt();
                                    
                                    System.out.println(" Trying to Update Schedule for the worker ....");
                                    
                                    if(u == 1)
                                    {
                                    
                                    String sql1 = "DELETE FROM STAFF_SCHED WHERE THEATRE_ID="+tid+"AND SCHEDULE="+sid+"AND JOB_TYPE="+wid+" AND DAYOFWEEK='"+did+"'";

                                    PreparedStatement pstmt1 = con.prepareStatement(sql1);
                                    
                                    pstmt1.executeUpdate();
                                    
                                    String sql2 = "INSERT INTO STAFF_SCHED(STAFF_ID,JOB_TYPE,Schedule,THEATRE_ID,DAYOFWEEK) values(?, ?, ?,?,?)";

                                    PreparedStatement pstmt2 = con.prepareStatement(sql2);


                                    pstmt2.setString(1,name);
                                    pstmt2.setInt(2,wid);
                                    pstmt2.setInt(3,sid);
                                    pstmt2.setInt(4,tid);
                                    pstmt2.setString(5,did);
                                    
                  
                                    pstmt2.executeQuery();
                                    
                                    System.out.println("Staff Schedule has Been Updated Successfully");
                                    
                                    }
                                    
                                    else if (u == 2)
                                    {
                                        
                                    System.out.println(" Check other Schedule for the worker - selected schedule not Available");
                                        
                                    }*/
                                    else
                                    {
                                         System.out.println("Invalid Selection");
                                    }
                                  
                                    
                                //}
                                		}
                                		else{
                                			System.out.println(" Invalid Selection:Entered Staff Works for a different Theatre");
                                		}
                                		}
                                		else{
                                			System.out.println("Invalid Selection:Entered Staff Works in a different Position");
                                		}
                                		
                                }
                                }
                                
                                }
                                
                                System.out.println(" End of Program ");
		

	}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}

private static void updatePoints() {
	try{
		Connection con;
		OracleDataSource dataset=new OracleDataSource();

		dataset.setURL(DB_URL);
		con=dataset.getConnection(username,password);
		Statement stmt = con.createStatement();
		Scanner inp =new Scanner(System.in);
		System.out.println("Enter email_id:");
		String name = inp.nextLine();	
		System.out.println("Enter Points");
		Integer points = inp.nextInt();
					

		System.out.println("Connection Establishing.....");
		Statement state = con.createStatement();	
		state = con.createStatement();
		System.out.println("Connection Established");
		String sql = "Select user_id,membership_status from user_membership where user_id = (select user_id from users where email_id = ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,name);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
		//Retrieve by column name
		int user_id = rs.getInt(1);
		String mem_type = rs.getString(2);
		System.out.println("Member Type = "+mem_type);
		String sql_check = "Select distinct user_id from theatre_discussion where user_id ="+user_id+"union select distinct user_id from movie_discussion where user_id ="+user_id;
		ResultSet rs_check = state.executeQuery(sql_check);
		int user_id_check = 0;
		if(rs_check.next())
		user_id_check = rs_check.getInt(1);
		if(user_id_check != 0)
		{
		if(mem_type.equals("SILVER"))
		{
			if(points > 50)
			{
				System.out.println("Points more than 50 can't be given to silver member");
				con.close();
				System.exit(0);
			}
				//Check if value more than 50 points 
		String sql_cp = "Select credit_points_earned from user_membership where user_id = ?";
		PreparedStatement Credit_userid = con.prepareStatement(sql_cp);
		Credit_userid.setInt(1, user_id);
		ResultSet rs_cp = Credit_userid.executeQuery();
		if (rs_cp.next()){
		//update 
			int c_points = rs_cp.getInt(1);
			c_points = points + c_points;
			String sql_update = "UPDATE user_membership set credit_points_earned = ? where user_id = ?";
			PreparedStatement update_p = con.prepareStatement(sql_update);
			update_p.setInt(1, c_points);
			update_p.setInt(2, user_id);
			 update_p.executeQuery();
			System.out.println("Updated");
		}
		else
		{
			String sql_insert = "INSERT INTO user_membership(user_id,credit_points_earned) VALUES (?,?)";
			PreparedStatement update_p = con.prepareStatement(sql_insert);
			update_p.setInt(1, user_id);
			update_p.setInt(2, points);
			update_p.executeQuery();
			System.out.println("Inserted CP");
		}
		}
		if(mem_type.equals("GOLD"))
		{
			if(points > 100)
			{
				System.out.println("Points more than 100 can't be given to gold member");
				con.close();
				System.exit(0);
			}
				//Check if value more than 50 points 
		String sql_cp = "Select credit_points_earned from user_membership where user_id = ?";
		PreparedStatement Credit_userid = con.prepareStatement(sql_cp);
		Credit_userid.setInt(1, user_id);
		ResultSet rs_cp = Credit_userid.executeQuery();
		if (rs_cp.next()){
		//update 
			int c_points = rs_cp.getInt(1);
			c_points = points + c_points;
			String sql_update = "UPDATE user_membership set credit_points_earned = ? where user_id = ?";
			PreparedStatement update_p = con.prepareStatement(sql_update);
			update_p.setInt(1, c_points);
			update_p.setInt(2, user_id);
			update_p.executeQuery();
			System.out.println("Updated Credit Points");
		}
		else
		{ 
			String sql_insert = "INSERT INTO user_membership(user_id,credit_points_earned) VALUES (?,?)";
			PreparedStatement update_p = con.prepareStatement(sql_insert);
			update_p.setInt(1, user_id);
			update_p.setInt(2, points);
			 update_p.executeQuery();
			System.out.println("Inserted Credit Points");
		}
		}
		if(mem_type.equals("PLATINUM"))
		{
		//No Check if value is more or less 
		String sql_cp = "Select credit_points_earned from user_membership where user_id = ?";
		PreparedStatement Credit_userid = con.prepareStatement(sql_cp);
		Credit_userid.setInt(1, user_id);
		ResultSet rs_cp = Credit_userid.executeQuery();
		if (rs_cp.next()){
		//update 
			int c_points = rs_cp.getInt(1);
			c_points = points + c_points;
			String sql_update = "UPDATE user_membership set credit_points_earned = ? where user_id = ?";
			PreparedStatement update_p = con.prepareStatement(sql_update);
			update_p.setInt(1, c_points);
			update_p.setInt(2, user_id);
			 update_p.executeQuery();
			System.out.println("Updated");
		}
		else
		{ 
			String sql_insert = "INSERT INTO user_membership(user_id,credit_points_earned) VALUES (?,?)";
			PreparedStatement update_p = con.prepareStatement(sql_insert);
			update_p.setInt(1, user_id);
			update_p.setInt(2, points);
			 update_p.executeQuery();
			System.out.println("Inserted CP");
		}
		}
		}
		else
		{
			System.out.println("User has not given any review for a Movie or Theatre");
			con.close();
			System.exit(0);
		}
		}
		else
		{
			System.out.println("Incorrect user name");
			con.close();
			System.exit(0);
		}
}
catch (Exception e)
{
	e.printStackTrace();
	System.out.println("Error caught");
}

}
private static int owner(){
	try
	{
     Connection con;
				OracleDataSource dataset=new OracleDataSource();

				dataset.setURL(DB_URL);
				con=dataset.getConnection(username,password);
				Statement stmt = con.createStatement();
	System.out.println("3 - Check or modify Staff Schedules");
	System.out.println("4 - Deals or Disounts to be offered");
	System.out.println("5 - Points table");
	System.out.println("6 - Update Authorization/Privilege");
	System.out.println("7 - Insert/Update/Delete/Select tables");
	System.out.println("8 - View Guest Information");
	Scanner inp1 = new Scanner(System.in);
	Integer u = inp1.nextInt();
	
	
	if(u==5){
		System.out.println("Do you wish to assign points to the customer: ");
		System.out.println();
		System.out.println("1 - YES");
		System.out.println("2 - NO");
		Scanner inp2 = new Scanner(System.in);
    	Integer v = inp2.nextInt();
    	if(v==1){
    		updatePoints();
    	}
	}
		if (u==3){
		System.out.println("Staff Schedule :");
		String sqlstaff1="Select S.Staff_Id AS STAFF_ID, ST.STAFF_NAME AS STAFF_NAME ,JT.Job_Type AS JOB_TYPE, SS.Schedule_NAME AS SCHEDULE, T.NAME AS NAME FROM STAFF_SCHED S,STAFF ST,Theatre T,JOB_TYPES JT, STAFF_SCHEDULE SS WHERE S.STAFF_ID=ST.STAFF_ID AND S.THEATRE_ID=T.THEATRE_ID AND SS.SCHEDULE=S.SCHEDULE AND JT.JOB_TYPE=S.JOB_TYPE";
		ResultSet rs=stmt.executeQuery(sqlstaff1);
		while(rs.next()){
			Integer si=rs.getInt("STAFF_ID");
			String sn=rs.getString("STAFF_NAME");
			String jt= rs.getString("JOB_TYPE");
            String sc=rs.getString("SCHEDULE");
            String thid=rs.getString("NAME");
            System.out.println("StaffId: "+si+"     Staff Name: "+sn+"     Job TYPE: "+jt+"      Job SCHEDULE: "+sc+"       Theatre Name: "+thid);

		}
		System.out.println("Do You Wish Modify The Schedule Of a Staff");
		System.out.println("1 - YES");
		System.out.println("2 - NO");
		Scanner inp2 = new Scanner(System.in);
    	Integer v = inp2.nextInt();
    	if(v==1){
    		UpdateSchedule();
    	}
    	else if(v==2){
    		System.out.println("OK");
    	}
	}

		if(u==6){
			String sqlstaff1="Select m.Manager_id,m.Manager_Name from Manager m,Staff_sched ss,job_types jt where m.manager_id=ss.staff_id and ss.job_type=jt.job_type and jt.JOB_NAME='MANAGER'";
			ResultSet rs=stmt.executeQuery(sqlstaff1);
			System.out.println("Managers are:");
			while(rs.next()){
				Integer mid=rs.getInt("Manager_id");
				String name=rs.getString("Manager_Name");
				System.out.println(mid+" - "+name);
			}
			System.out.println("Do you want to authorize or revoke privilege");
			System.out.println("1 - Authorize");
			System.out.println("2 - Revoke");
			Scanner imp3= new Scanner(System.in);
			Integer in=imp3.nextInt();
			if(in==1){
			System.out.println("Update based on the above Id");
			String sqlstaff2="Update Staff set Priv='Y' where staff_id=?";
			Scanner inp2 = new Scanner(System.in);
	    	System.out.println("Enter the staffId");
			Integer sw = inp2.nextInt();
            PreparedStatement pstmt2 = con.prepareStatement(sqlstaff2);
            pstmt2.setInt(1,sw);
            pstmt2.executeQuery();
            System.out.println("Update Successful");
			}
			else if(in==2){
				System.out.println("Update based on the above Id");
				String sqlstaff2="Update Staff set Priv='N' where staff_id=?";
				Scanner inp2 = new Scanner(System.in);
		    	System.out.println("Enter the staffId");
				Integer sw = inp2.nextInt();
	            PreparedStatement pstmt2 = con.prepareStatement(sqlstaff2);
	            pstmt2.setInt(1,sw);
	            pstmt2.executeQuery();
	            System.out.println("Update Successful");
			}
			}
			
		if(u==7){
			System.out.println();
			Scanner inp2 = new Scanner(System.in);
			System.out.println("Enter the Operation you want to perform");
			System.out.println("1 - SELECT");
			System.out.println("2 - UPDATE");
			System.out.println("3 - INSERT");
			System.out.println("4 - DELETE");
			Integer sw = inp2.nextInt();
			if(sw==1){
				System.out.println("Enter the Select Statement:");
				System.out.println("Enter column_name(s): ");
				String s=inp2.next();
				System.out.println("Enter table_name(s): ");
				String s1=inp2.next();
				System.out.println("Enter condition(s), if not then enter(1=1) : ");
				String s2=inp2.next();
				System.out.println("Enter 2 condition(s), if not then enter(1=1) : ");
				String s3=inp2.next();
				System.out.println("Enter 3 condition(s), if not then enter(1=1) : ");
				String s4=inp2.next();
				System.out.println("Enter 4  condition(s), if not then enter(1=1) : ");
				String s5=inp2.next();


						ResultSet rs=stmt.executeQuery("SELECT "+s+"  FROM "+s1+" WHERE "+s2+" AND "+s3+" AND "+s4+" AND "+s5);	
						ResultSetMetaData rsmd = rs.getMetaData();
						int columnsNumber = rsmd.getColumnCount();
						while(rs.next()){
							System.out.println("\n");
							for (int i = 1; i <= columnsNumber; i++) {
						    //    if (i > 1) System.out.print(",  ");
						        Object columnValue = rs.getObject(i);
						        System.out.print(columnValue + " " );
						}
			}
			}
			else if(sw==3){
				System.out.println("Enter the table name ");
				String s=inp2.next();
				System.out.println("Enter the column names to which values are to be added");
				Object s1=inp2.next();
				System.out.println("Enter the values to be inserted");
				Object s2=inp2.next();
				ResultSet rs=stmt.executeQuery( "INSERT INTO "+s+"("+s1+") values("+s2+")");
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
				System.out.println(columnsNumber);
				
                 System.out.println("Staff Schedule has Been Updated Successfully");
			
		}
			else if(sw==2){
				System.out.println("Enter the table name ");
				String s=inp2.next();
				System.out.println("Enter the column name which is to be updated");
				Object s1=inp2.next();
				System.out.println("Enter the column value");
				Object s6=inp2.next();
				System.out.println("Enter the condition");
				Object s2=inp2.next();
				System.out.println("Enter 2 condition(s),if not then enter(1=1) : ");
				Object s3=inp2.next();
				System.out.println("Enter 3 condition(s),if not then enter(1=1) : ");
				Object s4=inp2.next();
				System.out.println("Enter 4  condition(s),if not then enter(1=1) : ");
				Object s5=inp2.next();
				ResultSet rs=stmt.executeQuery("Update "+s+" Set "+s1+" = '"+s6+"' where "+s2+" AND "+s3+" AND "+s4+" AND "+s5);
			System.out.println("Update Successfull");
			}
			else if(sw==4){
				System.out.println("Enter the table name ");
				String s=inp2.next();
				System.out.println("Enter the column name for the row to be deleted");
				Object s1=inp2.next();
				System.out.println("Enter the value to be deleted");
				Object s6=inp2.next();
				System.out.println("Enter 1 condition");
				Object s2=inp2.next();
				System.out.println("Enter 2 condition(s), if not then enter(1=1): ");
				Object s3=inp2.next();
				System.out.println("Enter 3 condition(s), if not then enter(1=1) : ");
				Object s4=inp2.next();
				System.out.println("Enter 4  condition(s),if not then enter(1=1) : ");
				Object s5=inp2.next();
				ResultSet rs=stmt.executeQuery("Delete from "+s+" where "+s1+" = '"+s6+"' AND "+s3+" AND "+s4+" AND "+s5);
			System.out.println("Delete Successfull");
			}
	}
		if(u==8){
			ResultSet rs=stmt.executeQuery("Select user_id,user_name from users ");
					System.out.println("Guest List");
					System.out.println("User_Id    User_name");
					while(rs.next()){
						System.out.println(rs.getObject(1)+"       "+rs.getObject(2));
						
					}
		System.out.println("Enter the User_id of the guest whose details you want to view");
		Scanner sc= new Scanner(System.in);
		Integer i1= sc.nextInt();
		ResultSet rs1=stmt.executeQuery("Select *from users where user_id= "+i1);
		ResultSetMetaData rsmd = rs1.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while(rs1.next()){
			for (int i = 1; i <= columnsNumber; i++) {
		    //    if (i > 1) System.out.print(",  ");
		        Object columnValue = rs1.getObject(i);
		        System.out.print(columnValue + " " );
		}
		}

		}
		if(u==4){
			System.out.println("Do you want add a new deal");
			System.out.println("1 - YES");
			System.out.println("2 - NO");
			Scanner in= new Scanner(System.in);
			Integer i=in.nextInt();
			if(i==1){
				String sql2 = "INSERT INTO DEALS(DEAL_ID,DEAL) values(?, ?)";

                PreparedStatement pstmt2 = con.prepareStatement(sql2);
                System.out.println("Enter the new deal id");
                Integer j= in.nextInt();
                Scanner scan= new Scanner(System.in);
                System.out.println("Enter the new deal ");
                String k=scan.nextLine();
                pstmt2.setInt(1,j);
                pstmt2.setString(2,k);

                pstmt2.executeQuery();
                
                System.out.println("New Deal has Been Inserted Successfully");
			}
			else if(i==2){
				System.out.println("End of Program");
			}
		}
		if(u<=2){
			return 0;
		}
	}
	catch (Exception e)
	{
		e.printStackTrace();
		System.out.println("Error caught");
	}
	System.exit(0);
	return 0;

}

private static int web_admin(){
	try
	{
     Connection con;
				OracleDataSource dataset=new OracleDataSource();

				dataset.setURL(DB_URL);
				con=dataset.getConnection(username,password);
				Statement stmt = con.createStatement();
	System.out.println("3 - Insert/Update/Delete/Select tables");
	System.out.println("4 - View Guest Information");
	Scanner inp1 = new Scanner(System.in);
	Integer u = inp1.nextInt();
	
		if(u==3){
			System.out.println();
			Scanner inp2 = new Scanner(System.in);
			System.out.println("Enter the Operation you want to perform");
			System.out.println("1 - SELECT");
			System.out.println("2 - UPDATE");
			System.out.println("3 - INSERT");
			System.out.println("4 - DELETE");
			Integer sw = inp2.nextInt();
			if(sw==1){
				System.out.println("Enter the Select Statement:");
				System.out.println("Enter column_name(s): ");
				String s=inp2.next();
				System.out.println("Enter table_name(s): ");
				String s1=inp2.next();
				System.out.println("Enter condition(s), if not then enter(1=1) : ");
				String s2=inp2.next();
				System.out.println("Enter 2 condition(s), if not then enter(1=1) : ");
				String s3=inp2.next();
				System.out.println("Enter 3 condition(s), if not then enter(1=1) : ");
				String s4=inp2.next();
				System.out.println("Enter 4  condition(s), if not then enter(1=1) : ");
				String s5=inp2.next();


						ResultSet rs=stmt.executeQuery("SELECT "+s+"  FROM "+s1+" WHERE "+s2+" AND "+s3+" AND "+s4+" AND "+s5);	
						ResultSetMetaData rsmd = rs.getMetaData();
						int columnsNumber = rsmd.getColumnCount();
						while(rs.next()){
							System.out.println("\n");
							for (int i = 1; i <= columnsNumber; i++) {
						    //    if (i > 1) System.out.print(",  ");
						        Object columnValue = rs.getObject(i);
						        System.out.print(columnValue + " " );
						}
			}
			}
			else if(sw==3){
				System.out.println("Enter the table name ");
				String s=inp2.next();
				System.out.println("Enter the column names to which values are to be added");
				Object s1=inp2.next();
				System.out.println("Enter the values to be inserted");
				Object s2=inp2.next();
				ResultSet rs=stmt.executeQuery( "INSERT INTO "+s+"("+s1+") values("+s2+")");
                 System.out.println("Staff Schedule has Been Inserted Successfully");
			
		}
			else if(sw==2){
				System.out.println("Enter the table name ");
				String s=inp2.next();
				System.out.println("Enter the column name which is to be updated");
				Object s1=inp2.next();
				System.out.println("Enter the value");
				Object s6=inp2.next();
				System.out.println("Enter the condition");
				Object s2=inp2.next();
				System.out.println("Enter 2 condition(s),if not then enter(1=1) : ");
				Object s3=inp2.next();
				System.out.println("Enter 3 condition(s),if not then enter(1=1) : ");
				Object s4=inp2.next();
				System.out.println("Enter 4  condition(s),if not then enter(1=1) : ");
				Object s5=inp2.next();
				ResultSet rs=stmt.executeQuery("Update "+s+" Set "+s1+" = '"+s6+"' where "+s2+" AND "+s3+" AND "+s4+" AND "+s5);
			System.out.println("Update Successfull");
			}
			else if(sw==4){
				System.out.println("Enter the table name ");
				String s=inp2.next();
				System.out.println("Enter the column name for the row to be deleted");
				Object s1=inp2.next();
				System.out.println("Enter the value to be deleted");
				Object s6=inp2.next();
				System.out.println("Enter 2 condition(s), if not then enter(1=1): ");
				Object s3=inp2.next();
				System.out.println("Enter 3 condition(s), if not then enter(1=1) : ");
				Object s4=inp2.next();
				System.out.println("Enter 4  condition(s),if not then enter(1=1) : ");
				Object s5=inp2.next();
				ResultSet rs=stmt.executeQuery("Delete from "+s+" where "+s1+" = '"+s6+"' AND "+s3+" AND "+s4+" AND "+s5);
			System.out.println("Delete Successfull");
			}
	}
		if(u==4){
			ResultSet rs=stmt.executeQuery("Select user_id,user_name from users ");
					System.out.println("Guest List");
					System.out.println("User_Id    User_name");
					while(rs.next()){
						System.out.println(rs.getObject(1)+"       "+rs.getObject(2));
						
					}
		System.out.println("Enter the User_id of the guest whose details you want to view");
		Scanner sc= new Scanner(System.in);
		Integer i1= sc.nextInt();
		ResultSet rs1=stmt.executeQuery("Select *from users where user_id= "+i1);
		ResultSetMetaData rsmd = rs1.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while(rs1.next()){
			for (int i = 1; i <= columnsNumber; i++) {
		    //    if (i > 1) System.out.print(",  ");
		        Object columnValue = rs1.getObject(i);
		        System.out.print(columnValue + " " );
		}
		}

		}
		if(u<=2){
			return 0;
		}
	}
	catch (Exception e)
	{
		e.printStackTrace();
		System.out.println("Error caught");
	}
	System.exit(0);
	return 0;


}

}
