import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Rank_test {

	public static void main(String[] args) {
		ArrayList<Answer> listhard = new ArrayList<Answer>();
		ArrayList<Answer> listeasy = new ArrayList<Answer>();
		ArrayList<Answer> listnomal = new ArrayList<Answer>();
		PreparedStatement psmt = null;
		Connection conn = null;
		ResultSet rs = null;
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "cgi_7_0516_5";
			String password = "smhrd5";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB connect");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Minicontroller mc = new Minicontroller(conn);
		int index = 1;
		try {
			String sqlhard = ("select * from hard");
			psmt = conn.prepareStatement(sqlhard);
			rs = psmt.executeQuery();
			while (rs.next()) {
				index = 1;
				String kor = rs.getString(index++);
				String eng = rs.getString(index++);
				listhard.add(new Answer(kor, eng));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			String sqleasy = ("select * from easy");
			psmt = conn.prepareStatement(sqleasy);
			rs = psmt.executeQuery();
			while (rs.next()) {
				index = 1;
				String kor = rs.getString(index++);
				String eng = rs.getString(index++);
				listeasy.add(new Answer(kor, eng));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			String sqlnomal = ("select * from nomal");
			psmt = conn.prepareStatement(sqlnomal);
			rs = psmt.executeQuery();
			while (rs.next()) {
				index = 1;
				String kor = rs.getString(index++);
				String eng = rs.getString(index++);
				listnomal.add(new Answer(kor, eng));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			mc.close();
		}
		for (int i = 0; i < listhard.size(); i++) {
			System.out.println(listhard.get(i).getKor() + listhard.get(i).getEng());
		}
		System.out.println("//");
//		for (int i = 0; i < listnomal.size(); i++) {
//			System.out.println(listnomal.get(i).getKor() + listnomal.get(i).getEng());
//		}
//		System.out.println("//");
//		for (int i = 0; i < listeasy.size(); i++) {
//			System.out.println(listeasy.get(i).getKor() + listeasy.get(i).getEng());
//		}
		int ac = rd.nextInt(99)+1;
		int ca = 0;
		int bb = 0;
		int cc = 0;
		String re = ""; 
		System.out.println("문제 출력 ↓");
		System.out.println(listhard.get(ac).getKor());
		System.out.println(listhard.get(ac).getEng());
		System.out.println("정답 입력 ↓");
		for (int i = 0; i < listhard.get(ac).getEng().length(); i++) {
			System.out.print("*");
		}
		System.out.println();
		re = sc.next();
		if(re.equals(listhard.get(ac).getEng())) {
			ca+=3;
			System.out.println("정답 + 3점");
		}else {
			System.out.println("힌트를 사용 하시겠습니까?");
			System.out.println("힌트를 사용하시게 되면 1점찍 감소하게 됩니다.");
			System.out.println("[1] 힌트를 사용한다  [2] 문제를 다시 도전하겠다.  [3] 다음으로 넘어가겠다.");
			bb = sc.nextInt();
			switch(bb) {
			case 1 : {
				switch(cc) {
				
				}
				
				System.out.print(listhard.get(ac).getEng().charAt(0));
				for (int i = 1; i < listhard.get(ac).getEng().length(); i++) {
					System.out.print("*");
				}
				System.out.println(listhard.get(ac).getEng().charAt(listhard.get(ac).getEng().length()-1));
			}
			}
		}
		System.out.println("오답 + 0점");
		System.out.println(ca);
		
		
		
		
		
		
	
	}

	
}
