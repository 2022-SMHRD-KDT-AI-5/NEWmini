import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
asd
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
		} catch (SQLException e) {
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
		} catch (SQLException e) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mc.close();
		}
		for (int i = 0; i < listhard.size(); i++) {
			System.out.println(listhard.get(i).getKor() + listhard.get(i).getEng());
		}
		System.out.println("//");
		
		int ac = rd.nextInt(99) + 1;
		int ca = 0;
		int bb = 0;
		int cc = 0;
		int dd = 1;
		int ee = 0;
        int len = listhard.get(ac).getEng().length();
		int hint_index = len-1;
		String re = "";
		int mo = 10;
		System.out.println("최초 실행시 점수 = 100" );
		while (true) {
			if(mo==0) {
				break;
			}
			System.out.println();
			System.out.println("문제 출력 ↓");
			System.out.println(listhard.get(ac).getKor());
			System.out.println("정답 수 ↓");
			for (int i = 0; i < listhard.get(ac).getEng().length(); i++) {
				System.out.print("*");
			}
			System.out.println();
			System.out.println("정답 입력 ↓");
			System.out.println();
			re = sc.next();
			if (re.equals(listhard.get(ac).getEng())) {
				ca += 3;
				System.out.println("정답 + 3점");
				ac = rd.nextInt(99) + 1;
		        len = listhard.get(ac).getEng().length();
				hint_index = len-1;
				System.out.println("점수" + ca);
			} else {
				System.out.println("오답 입니다.");
				mo-=1;
				System.out.println();
					System.out.println("힌트를 사용 하시겠습니까?");
					System.out.println("힌트를 사용하시게 되면 1점찍 감소하게 됩니다.");
					System.out.println("[1] 힌트를 사용한다  [2] 문제를 다시 도전하겠다.  [3] 다음으로 넘어가겠다.");
					bb = sc.nextInt();
					if(bb == 1) {
						System.out.println("사용할 힌트를 선택해주세요");
						System.out.println("[1] 첫글자를 보겠다.  [2] 마지막글자를 보겠다. [3] 정답 다시입력.");
						cc = sc.nextInt();
						if(cc == 1) {
							System.out.println("첫글자를 확인합니다.");
							for (int i = 0; i <= ee; i++) {
								System.out.print(listhard.get(ac).getEng().charAt(i));
							}
							System.out.println();
							ee += 1;
							ca -= 1;
							System.out.println("점수" + ca);
						}else if(cc == 2) {
							System.out.println("마지막 글자를 확인합니다.");
							String[] split_letter = listhard.get(ac).getEng().split("");
							for (int i=0; i<len; i++) {
								if(i < hint_index) System.out.print(" ");
								else System.out.print(split_letter[i]);
							}
							if (hint_index > 0) {
								hint_index -= 1;
							}
							ca-=1;
							System.out.println();
							System.out.println("점수" + ca);
						}else if(cc == 3) {
							System.out.println("정답 다시 입력.");
							System.out.println("문제 출력 ↓");
							System.out.println(listhard.get(ac).getKor());
							System.out.println("정답 입력 ↓");
							System.out.println();
							re = sc.next();
						}else{
							System.out.println("잘못 입력했습니다.");
							System.out.println("이전단계로 돌아갑니다.");
						}
					}else if (bb==2) {
						System.out.println("다시 도전");
					}
					else if (bb==3) {
						ac = rd.nextInt(99)+1;
						len = listhard.get(ac).getEng().length();
						hint_index = len-1;
						System.out.println("점수" + ca);
					}else {
						System.out.println("잘못");
					}
				}
			}



	}

}
