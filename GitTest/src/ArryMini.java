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
			while(rs.next()) { //�����ͺ��̽����İ� java ������ �ٸ�.
				index = 1; 	//1���� ����
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
			System.out.println("����: "+model.getEng() +"�ѱ�: "+model.getKor());
		}

	






	}

}
