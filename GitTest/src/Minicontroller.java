import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Minicontroller {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int row = 0;
	
	public Minicontroller(Connection conn) {
		this.conn = conn;
	}
	
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "cgi_7_0516_5";
			String password = "smhrd5";
			conn = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(psmt != null) {
				psmt.close();
			}
			if(conn != null) {
				conn.close();
			}
			if(rs!=null) {
				rs.close();
			}
			
		} catch (SQLException e) {
			System.out.println("반납 오류");
			e.printStackTrace();
		}
	}
	
	public int Signup(MiniDTO minimo) {
		try {
			connect();
			String sql = "insert into us values(?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, minimo.getId());
			psmt.setString(2, minimo.getPw());
			Minicontroller mc = new Minicontroller();
			row = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DB 오류");
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		return row;
	}
	public int Login(MiniDTO minimo) {
		String sql = "select from us where user_id = ?";
		try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, );
		rs = psmt.executeQuery();
		if(rs.next()) {
			if(rs.getString(1).equals()) {
				return 1;
			}
			else {
				return 0;
			}
		}
		return -1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return row;
	}
	public MiniDTO Rank(MiniDTO minimo) {
		boolean result = false;
		try {
			connect();
			String sql = "select * from us where _id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, minimo.getId());
			rs=psmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString("_name");
				String score = rs.getString("_score");
				String rank = rs.getString("_rank");
				minimo = new MiniDTO(name, score, rank);
			}
		} catch (Exception e) {
			System.out.println("JDBC 오류");
			e.printStackTrace();
		}finally {
			close();
		}
		
		return minimo;
	}
}

