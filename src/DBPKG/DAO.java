package DBPKG;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import VO.MoneyVO;
import VO.UserVO;

public class DAO {
	
	//****
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	//시험지에 나온 연결코드
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","system","oracle");
		return con;
	}
	
	//신규 회원번호
	public int newSelectCustno() throws Exception{
		int custno = 0;
		try {
			conn=getConnection();
			String sql = "SELECT MAX(custno)+1 AS CUSTNO FROM member_tbl_02";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			custno = rs.getInt("CUSTNO");
			
			conn.close();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return custno;
	}
	
	public List<UserVO> SelectCustnoList() throws Exception{
		List<UserVO> memberList = new ArrayList<UserVO>();
		try {
			conn=getConnection();
			String sql = "SELECT * FROM member_tbl_02 ORDER BY custno";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				UserVO userVO =new UserVO();
				userVO.setCustno(rs.getInt("CUSTNO"));
				userVO.setCustname(rs.getString("CUSTNAME"));
				userVO.setPhone(rs.getString("PHONE"));
				userVO.setAddress(rs.getString("ADDRESS"));
				userVO.setJoindate(rs.getDate("JOINDATE"));
				userVO.setGrade(rs.getString("GRADE"));
				userVO.setCity(rs.getString("CITY"));
				memberList.add(userVO);
			}
			
			conn.close();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
	public List<MoneyVO> SelectMoneyList() throws Exception{
		List<MoneyVO> moneyList = new ArrayList<MoneyVO>();
		try {
			conn=getConnection();
			String sql = "SELECT A.custno, A.custname, A.grade, SUM(B.price) as PRICE"
						+" FROM member_tbl_02 A, money_tbl_02 B"
						+" WHERE A.custno = B.custno"
						+" GROUP BY A.custno, A.custname, A.grade"
						+" ORDER BY PRICE DESC";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MoneyVO moneyVO = new MoneyVO();
				moneyVO.setCustno(rs.getInt("CUSTNO"));
				moneyVO.setCustname(rs.getString("CUSTNAME"));
				moneyVO.setGrade(rs.getString("GRADE"));
				moneyVO.setPrice(rs.getInt("PRICE"));
				moneyList.add(moneyVO);
			}
			
			conn.close();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return moneyList;
	}
	
	public int insertCustno(UserVO userVO) throws Exception{
		int result = 0;
		try {
			conn=getConnection();
			String sql = "INSERT INTO member_tbl_02 VALUES(?,?,?,?,sysdate,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userVO.getCustno());
			pstmt.setString(2, userVO.getCustname());
			pstmt.setString(3, userVO.getPhone());
			pstmt.setString(4, userVO.getAddress());
			pstmt.setString(5, userVO.getGrade());
			pstmt.setString(6, userVO.getCity());
			result = pstmt.executeUpdate();
			
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public UserVO SelectOneCustno(int custno) throws Exception{
		UserVO userVO = new UserVO();
		try {
			conn=getConnection();
			String sql = "SELECT * FROM member_tbl_02 WHERE custno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custno);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			userVO.setCustno(rs.getInt("CUSTNO"));
			userVO.setCustname(rs.getString("CUSTNAME"));
			userVO.setPhone(rs.getString("PHONE"));
			userVO.setAddress(rs.getString("ADDRESS"));
			userVO.setJoindate(rs.getDate("JOINDATE"));
			userVO.setGrade(rs.getString("GRADE"));
			userVO.setCity(rs.getString("CITY"));
			
			conn.close();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userVO;
	}
	
	public int UpdateCustno(UserVO userVO) throws Exception{
		int result = 0;
		try {
			conn=getConnection();
			String sql = "UPDATE member_tbl_02 SET custname= ?, phone= ?, address= ?, grade= ?, city= ? WHERE custno= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userVO.getCustname());
			pstmt.setString(2, userVO.getPhone());
			pstmt.setString(3, userVO.getAddress());
			pstmt.setString(4, userVO.getGrade());
			pstmt.setString(5, userVO.getCity());
			pstmt.setInt(6, userVO.getCustno());
			result = pstmt.executeUpdate();
			
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
