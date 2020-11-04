package project1.ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnect {
	public Connection con;
	public PreparedStatement psmt;// 동적쿼리를 위한 객체
	public ResultSet rs;
	public Statement stmt;

	public DBConnect() {

		try {
			Class.forName("oracle.jdbc.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String userid = "KOSMO";
			String userpw = "1234";

			con = DriverManager.getConnection(url, userid, userpw);
			if (con != null) {
				System.out.println("Oracle DB 연결성공");

			}
		} catch (SQLException e) {
			System.out.println("SQLException 예외발생");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException 예외발생");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("DB연결시 예외발생");
			e.printStackTrace();
		}

	}

	public int dataInput(String name, String phoneNumber, String birthday) {

		String query = "INSERT INTO phonebook_tb VALUES (?,?,?,seq_phonebook.nextval)";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, name);
			psmt.setString(2, phoneNumber);
			psmt.setString(3, birthday);
			int affected = psmt.executeUpdate();
			System.out.println(affected + "행이 입력되었습니다.");
			return affected;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return -1;
	}

	public int dataSearch(String name) {
		try {
			int cnt = 0;
			String query = "SELECT * from phonebook_tb WHERE NAME like '%'||?||'%'";
			psmt = con.prepareStatement(query);
			psmt.setString(1, name);		
			rs = psmt.executeQuery();
			while(rs.next()) {
				
				String n = rs.getNString("name");
					String pn = rs.getNString("phoneNum");
					String bt = rs.getNString("birth");
					System.out.println("데이터 검색이 완료되었습니다.");
					System.out.println("name:"+n);
					System.out.println("phone:"+pn);
					System.out.println("birth:"+bt);
				cnt++;
			}
			return cnt;
		}	
			catch (Exception e) {
				e.printStackTrace();
			}
	return-1;
	}
	public PhoneInfo[] dataAllshow() {
		PhoneInfo[] registPhone = new PhoneInfo[100];
		try {
			int cnt = 0;
			String query = "SELECT * from phonebook_tb WHERE NAME";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				
				String n = rs.getNString("name");
					String pn = rs.getNString("phoneNum");
					String bt = rs.getNString("birth");
					registPhone[cnt].name=n;
					registPhone[cnt].phoneNumber=pn;
					registPhone[cnt].birthday=bt;
					
				cnt++;
			}
			return registPhone;
		}	
			catch (Exception e) {
				e.printStackTrace();
			}
	return null;
	}
	
	
	public int dataDelete(String name) {
		try {
			String query = "DELETE FROM phonebook_tb WHERE name=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, name);
			int p=psmt.executeUpdate();
			System.out.println(p+"행이 삭제되었습니다");
			return p;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return-1;
	}


}


