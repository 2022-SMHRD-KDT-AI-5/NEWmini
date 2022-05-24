import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArryMini {
	
	public static void main(String[] args) {
		
		ArrayList<Answer> list = new ArrayList<Answer>();
		PreparedStatement psmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "cgi_7_0516_5";
			String password = "smhrd5";
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("DB connect");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Minicontroller mc = new Minicontroller(conn);
		int index = 1;
		
		try {
			String sql = ("select * from hard");
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) { //데이터베이스형식과 java 형식이 다름.
				index = 1; 	//1부터 시작
				String kor = rs.getString(index++);
				String eng = rs.getString(index++);
				list.add(new Answer(kor, eng));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				mc.close();
			}
		
		
		for(Answer model : list) {
			System.out.println(model.getEng() +model.getKor());
		}

	






	}

}
