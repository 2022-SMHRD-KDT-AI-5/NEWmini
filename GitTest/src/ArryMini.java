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
		Minicontroller mc = new Minicontroller();
		int index = 1;
		
		try {
			mc.connect();
			String sql = ("select * from hard");
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) { //데이터베이스형식과 java 형식이 다름.
				index = 1; 	//1부터 시작
				String eng = rs.getString(index++);
				String kor = rs.getString(index++);
				list.add(new Answer(eng, kor));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				mc.close();
			}
		
		
		for(Answer model : list) {
			System.out.println("영어: "+model.getEng() +"한글: "+model.getKor());
		}

	






	}

}
