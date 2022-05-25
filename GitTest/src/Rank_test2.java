import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Rank_test2 {

	public static void main(String[] args) {

		ArrayList<Answer> listhard = new ArrayList<Answer>();

		PreparedStatement psmt = null;
		Connection conn = null;
		ResultSet rs = null;
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		
		Minicontroller mc = new Minicontroller();
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
		int index = 1;
		// 하드 트라이
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
			// 여기까지
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 finally {
			mc.close();
		}

		int Random = rd.nextInt(99) + 1;
		int score = 0;
		int hintmenu = 0;
		int letter = 0;
		int Lindex = 0;
		String answer = "";
		String id2 = "";
		int row = 0;
		int Life = 10;

		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠴⠒⠉⠉⠙⠒⠢⢄⡀  ");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⢊⠤⠒⡲⠂⠀⠀⠀⠀⠀⠙⢦  ");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡜⠁⠚⠐⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⢣       즐거울뻔한 ");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡞⠀⠀⠀⠀⠀⠀⠠⢤⣀⡀⠀⠀⠀⠀⢸⠡⡀ ⠀  ⠀ ⠀⣀⣀⠀⠀⣀⠀⠀⠀⠀⠀⠀⢀⡀⠀⠀⠀⠀⠀⠀⢀⡀⠀⠀⠀⠀⣀⠀⣀⣀⠀⣀⠀⠀ ⠀⠀⠀⠀⢀⡀⠀⠀⠀⠀⠀⠀⣀⠀ ");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠁⠀⠀⠀⠀⠀⠀⠀⠒⠢⠉⠂⠀⠤⡀⡸⠑⠃   ⠀⣼⠋⠉⣿⡶⣿⠀⠀⣿⠛⠛⠁⢸⡇⠀⢠⡞⠛⢷⡀⢸⡇⠀⠀⠀⣿ ⣿⣿ ⣿⠀ ⠀⠀⣿⠀⠀⢸⡇⠀⠘⠛⠛⣿⠀⣿⠀");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⣀⠤⠁⠀⢸⠒⢠⠃⠀    ⠀⠘⠓⢞⣛⣛⡿⠀⠀⠻⠶⠶⠆⢸⡟⠁⢸⡇⠀⣸⠛⢻⡇⠀⠀⢀⣙⣛⣋⣙⣛⣋⡀ ⠀⣠⡿⣆⠀⢸⡇⠀⠀⢀⣼⠃⠀⣿⠀ ");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⡀⠀⢠⠊⢀⡀⠑⠤⢺⠀⡌⠀     ⠀⠀⢰⡟⠉⠉⣿⠀⠀⠀⣷⠀⠀⠘⠃⠀⠀⠙⠛⠋⠀⢸⡇⠀⠀⠀⠀⠀⠀⢹⡏⠀⠀ ⠀⠘⠋⠀⠙⠃⢸⡇⠀⠰⠛⠁⠀⠀⣿⠀ ");
		System.out.println("⠀⠀⠀⠀⢀⡀⠀⠀⠀⢸⠀⠀⠀⠀⡇⠀⠙⣞⠛⠽⣟⣶⠘⢠⠁   ⠀⠀⠀   ⠙⠛⠛⠉⠀⠀⠀⠛⠛⠛⠛⠃⠀⠀⠀⠀⠀⠀⠘⠃⠀⠀⠀⠀⠀⠀⠘⠃⠀ ⠀ ⠀⠀⠀⠀⠀⠀⠘⠃⠀⠀⠀⠀⠀⠀⠛⠀ ");
		System.out.println("⠀⣠⠖⠉⠉⠉⠉⠉⠒⠮⡀⠀⠀⢢⢠⢠⠈⢑⠒⠲⠃⢠⠃⠀ ");
		System.out.println("⡜⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢣⢯⢄⠀⠀ ⠀⠀⣴⡁⠀                                   (내가 부셔지기 전에...) ");
		System.out.println("⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠑⢅⡑⠂⢂⠜⠀⠈⠉⠉⠒⠢⢄⠀");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠀⢀⠖⠒⣲⣶⠃⢀⠆⠀");
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⡐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⡠⡴⠁⠀⠼⠟⠁⡠⠻⠀");
		System.out.println("⠀⠀⠀⠀⠀⠀⢠⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡰⠋⠀⠈⢉⣉⣉⣉⣒⣲⠁⠀⡇");
		System.out.println("⠀⠀⠀⠀⠀⠀⡎⠀⠀⠀⠀⠀⠀⠀⠀⢀⡠⠊⠀⠀⠀⠀⠀⠀⠤⠤⣒⠎⠀⠀⢷⠀⠀");
		System.out.println("⠀⠀⠀⠀⠀⡸⠀⠀⠀⣀⣠⠤⠔⠒⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⢒⡭⠋⠀⠀⠀⢸⠀⠀");
		System.out.println("⠀⠀⠀⢀⡰⠥⠒⠊⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠴⠒⠈⠁⠀⠀⠀⠀⠀⠸");

		System.out.println("점수는 0 점 부터 시작합니다.");
		System.out.println("게임 시작시 기회는 10번 주어집니다.");
		System.out.println("기회가 10번 종류 후 찬스 기회가 주어집니다.");
		System.out.println("모든 게임이 종료되면 점수합산하여 ID에 저장이 됩니다.");
		
		while (true) {
			System.out.println("==============================================");
			System.out.println("1.게임시작  2.로그인  3.회원가입  4.랭킹보기 5.게임종료");
			System.out.println("==============================================");
			System.out.print("메뉴를 입력 >> ");
			int menu = sc.nextInt();
			if (menu == 1) {

				System.out.println("   _________    __  _________   ______________    ____  ______");
				System.out.println("  / ____/   |  /  |/  / ____/  / ___/_  __/   |  / __ \\/_  __/");
				System.out.println(" / / __/ /| | / /|_/ / __/     \\__ \\ / / / /| | / /_/ / / / ");
				System.out.println("/ /_/ / ___ |/ /  / / /___    ___/ // / / ___ |/ _, _/ / /  ");
				System.out.println("\\____/_/  |_/_/  /_/_____/   /____//_/ /_/  |_/_/ |_| /_/  ");

				System.out.println("사용자 ID : " + id2);
				System.out.println("난이도 선택");
				System.out.println("1.EASY  2.NOMAL  3.HARD ");
				int lv = sc.nextInt();
				if (lv == 3) {
					int len = listhard.get(Random).getEng().length();
					int hint_index = len - 1;
					while (true) {
						if (Life == 0) {
							
							System.out.println("특별 기회가 주어집니다.");
							
							int count = 0;
							
							System.out.println("===============================");
							System.out.println("* * * * * * * * * * * * * * * *");
							System.out.println();
							System.out.println("        가위 바위 보 게임");
							System.out.println();
							System.out.println("  이기면 +1번의 기회! 틀리면 게임 끝!");
							System.out.println("* * * * * * * * * * * * * * * *");
							System.out.println("===============================");
							System.out.println();
							
						while(true) {
							System.out.println();
							System.out.println("    [1] 주먹 [2] 가위 [3] 보");
							System.out.println();
							System.out.print("    숫자를 선택해주세요! >> ");
							int user = sc.nextInt();
							
							int com = 0;
							com = rd.nextInt(3)+1;
							
							System.out.println("     사용자 :"+user+"번");
							System.out.println("     컴퓨터 :"+com+"번");
							
							if(user == 1) {
								System.out.println("⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀ ⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⣴⡿⠿⢿⣦⡀");
								System.out.println("⠀⠀⣿⡇⠀⠀⠀⣿⡇⠀ ⠀⠀⠀⠀ ⠀⠀⢠⡾⠛⢿⡿⠁⠀⠀⠙⢿⣄");
								System.out.println("⠀⠀⣿⡇⠀⠀⠀⣿⣧⣤⠀⠀⠀⠀⠀⣰⡾⢿⣿⠇⠀⠀⢁⣀⠀⠀⠀⠈⢿⡇⠀");
								System.out.println("⠀⠀⣿⣧⣤⣤⣤⣿⡇⠀⠀⠀⢀⣤⣴⡿⠀⠀⢁⠀⠀⠀⠈⠹⡄⠀⠀⠀⢈⠻⣷⣤⣄⡀⠀⠀");
								System.out.println("⠀⠀⠉⠉⠉⠉⠉⣿⡇⠀⠀⢰⡟⠉⠙⢁⠀⠀⠈⢳⠀⠀⠀⠀⢷⠀⠀⠀⠘⣇⣈⠉⠛⣿⠀⠀");
								System.out.println("          ⠀⢸⣇⠀⠀⠛⢧⠀⠀⠀⢧⠀⠀⠀⠘⣇⠀⠀⠀⢹⡟⠀⠀⣿⠀");
								System.out.println("⠀          ⠈⢿⡄⠀⠀⠈⣇⠀⠀⠘⡆⠀⠀⠀⢹⡄⠀⠀⠀⣷⠀⠀⣿⡄");
								System.out.println("⠀          ⠀⠘⣿⡄⠀⠀⠘⡆⠀⠀⠘⡀⠀⠀⠀⢷⣄⡠⠖⠃⠀⠀⣸⡇");
								System.out.println("⠀⠀          ⠀⠘⢿⡄⠀⠀⠹⡆⠀⠀⢱⣄⣀⣠⡞⢀⠄⣠⣴⠞⠛⠋⠀⠀");
								System.out.println("⠀⠀          ⠀⠀⠈⢿⣆⣀⣠⣿⣶⣶⡾⠛⣿⡀⠹⣻⡿⠋⠀⠀");
								System.out.println("⠀⠀⠀          ⠀⠀⠀⠙⠛⠋⠀⠀⠀⠀⠀⠙⠛⠛⠋⠀⠀");
								
								if(com==1) {
									System.out.println("           무승부!");
									System.out.println("⠀⢠⣤⣤⣤⣤⡄⢠⣶⠀⠀ ⠀ ⠀⠀⠀ ⠀⠀⠀⠀⠀⣴⡿⠿⢿⣦⡀");
									System.out.println("⠀⣬⣭⣭⣽⣿⣀⣸⣿⠀⠀⠀⠀   ⠀⠀⢠⡾⠛⢿⡿⠁⠀⠀⠙⢿⣄");
									System.out.println("⠀⣀⣴⡾⠟⠈⠉⢹⣿⠀⠀ ⠀⠀⠀⣰⡾⢿⣿⠇⠀⠀⢁⣀⠀⠀⠀⠈⢿⡇⠀");
									System.out.println("⠀⠈⠉⣶⣶⣶⣶⣶⣶⠀⠀⠀⢀⣤⣴⡿⠀⠀⢁⠀⠀⠀⠈⠹⡄⠀⠀⠀⢈⠻⣷⣤⣄⡀⠀⠀");
									System.out.println("⠀⠀⠀⣿⣤⣤⣤⣼⣿⠀⠀⢰⡟⠉⠙⢁⠀⠀⠈⢳⠀⠀⠀⠀⢷⠀⠀⠀⠘⣇⣈⠉⠛⣿⠀⠀");
									System.out.println("⠀⠀⠀⠉⠉⠉⠉⠉⠉⠀⠀⢸⣇⠀⠀⠛⢧⠀⠀⠀⢧⠀⠀⠀⠘⣇⠀⠀⠀⢹⡟⠀⠀⣿⠀");
									System.out.println("⠀          ⠈⢿⡄⠀⠀⠈⣇⠀⠀⠘⡆⠀⠀⠀⢹⡄⠀⠀⠀⣷⠀⠀⣿⡄");
									System.out.println("⠀          ⠀⠘⣿⡄⠀⠀⠘⡆⠀⠀⠘⡀⠀⠀⠀⢷⣄⡠⠖⠃⠀⠀⣸⡇");
									System.out.println("⠀⠀          ⠀⠘⢿⡄⠀⠀⠹⡆⠀⠀⢱⣄⣀⣠⡞⢀⠄⣠⣴⠞⠛⠋⠀⠀");
									System.out.println("⠀⠀          ⠀⠀⠈⢿⣆⣀⣠⣿⣶⣶⡾⠛⣿⡀⠹⣻⡿⠋⠀⠀");
									System.out.println("⠀⠀⠀          ⠀⠀⠀⠙⠛⠋⠀⠀⠀⠀⠀⠙⠛⠛⠋⠀⠀");
								}else if(com==2) {
									System.out.println("           오예 이겼당!!");
									System.out.println("⠀⢠⣤⣤⣤⣤⡄⢠⣶⠀⠀⠀⠀⠀    ⠀         ⠀⠀⠀⠀⢀⡖");
									System.out.println("⠀⣬⣭⣭⣽⣿⣀⣸⣿⠀⠀⠀⠀⠀⠀          ⠀⠀⠀⠀⠀⢀⢢⠁⠀");
									System.out.println("⠀⣀⣴⡾⠟⠈⠉⢹⣿⠀⠀ ⠀⠀           ⠀⠀⠀⢀⠂⡆⠀⠀⠀⢀⣠⠖");
									System.out.println("⠀⠈⠉⣶⣶⣶⣶⣶⣶⠀⠀⠀⠀ ⠀       ⠀⠀⠀⠀⢠⠃⠸⢀⡠⢐⡪⠛⠁⠀");
									System.out.println("⠀⠀⠀⣿⣤⣤⣤⣼⣿⠀⠀⠀⠀⠀⠀        ⠀⠀⠠⠃⢀⠏⣡⠔⠉");
									System.out.println("⠀⠀⠀⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⣀⣤⣴⣶⣶⣤⣤⣤⣤⣴⡾⣡⡀⡼⠊");
									System.out.println("⠀     ⠀⣠⡾⠛⠁⠀⠈⢹⣿⣿⣿⠟⠋⠙⣬⣴⠁");
									System.out.println("⠀    ⣼⡏⠀⠀⠀⣀⣴⡿⠟⠋⠀⠀⠀⢰⣿⣿⠀⠀⠀");
									System.out.println("⠀    ⠀⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⣾⡟⠛⢿⣿");
									System.out.println("⠀    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⡟⠀⠀⠀⣿⠀⠀");
									System.out.println("⠀⠀⠀⠀⠀   ⠀⠀⠀⠀⠀⠀⢰⣿⠁⠀⠀⣰⡟⠀");
									System.out.println("⠀⠀⠀⠀⠀⠀   ⠀⠀⠀⠀⠀⢿⣧⣀⣀⣴⠟⠀");
									System.out.println("⠀⠀⠀⠀⠀⠀     ⠀⠀⠀⠀⠙⠛⠋⠁⠀");
									count++;
								}else {
									System.out.println("           졌어요ㅠㅠ");
									System.out.println("⠀⢠⣤⣤⣤⣤⡄⢠⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⠀⠀⢀⡀⠀");			
									System.out.println("⠀⣬⣭⣭⣽⣿⣀⣸⣿ ⠀⠀⠀⠀⠀⠀⠀  ⣀⡀⠀⠀⢰⣿⣿⠀⠀⣤⣄⠀");			
									System.out.println("⠀⣀⣴⡾⠟⠈⠉⢹⣿⠀⠀ ⠀⠀⠀⠀ ⠀⢸⣿⣧⠀⠀⣼⣿⡿⠀⢸⣿⣿⠀⠀");			
									System.out.println("⠀⠈⠉⣶⣶⣶⣶⣶⣶⠀ ⠀⠀⠀⠀ ⠀⠀⢸⣿⣿⠀⠀⣿⣿⡇⠀⣸⣿⡟⠀⠀⢀⡀⠀⠀");			
									System.out.println("⠀⠀⠀⣿⣤⣤⣤⣼⣿⠀⠀⠀⠀⠀ ⠀⠀⠀⢸⣿⣿⡆⠀⣿⣿⡇⢠⣿⣿⠇⠀⣰⣿⡇⠀");			
									System.out.println("⠀⠀⠀⠉⠉⠉⠉⠉⠉      ⠀⠀⠸⣿⣿⣧⠀⣿⣿⡇⣾⣿⣿⠀⢠⣿⣿⠇⠀");			
									System.out.println("⠀⠀⠀⠀⠀⠀         ⠀⠀⠀⣿⣿⣿⡄⣿⣿⡇⣿⣿⡟⢀⣾⣿⡟⠀");			
									System.out.println("⠀        ⠀⣤⣤⣤⡀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣇⣾⣿⡟⠁");			
									System.out.println("⠀        ⠀⠻⣿⣿⣿⣆⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠀");			
									System.out.println("⠀⠀        ⠀⠈⢻⣿⣿⣧⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀");			
									System.out.println("⠀⠀⠀        ⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀");			
									System.out.println("⠀⠀⠀⠀        ⠀⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇");			
									System.out.println("⠀⠀⠀⠀        ⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀");			
									System.out.println("⠀⠀⠀⠀⠀⠀        ⠀⠀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀");			
									System.out.println("⠀⠀⠀⠀⠀⠀⠀        ⠀⠀⠀⠈⢻⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀");
									System.out.println("총 누적기회 : "+count);
									break;
								}
							}else if(user == 2) {
								System.out.println("⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀    ⠀  ⠀⠀⠀⠀⢀⡖");
								System.out.println("⠀⠀⣿⡇⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀   ⠀⠀⠀⠀⠀⢀⢢⠁⠀");
								System.out.println("⠀⠀⣿⡇⠀⠀⠀⣿⣧⣤⠀⠀⠀ ⠀⠀  ⠀⠀⠀⢀⠂⡆⠀⠀⠀⢀⣠⠖");
								System.out.println("⠀⠀⣿⣧⣤⣤⣤⣿⡇⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⢠⠃⠸⢀⡠⢐⡪⠛⠁⠀");
								System.out.println("⠀⠀⠉⠉⠉⠉⠉⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠠⠃⢀⠏⣡⠔⠉");
								System.out.println("⠀⠀⠀⠀⣀⣤⣴⣶⣶⣤⣤⣤⣤⣴⡾⣡⡀⡼⠊");
								System.out.println("⠀⠀⣠⡾⠛⠁⠀⠈⢹⣿⣿⣿⠟⠋⠙⣬⣴⠁");
								System.out.println("⠀⣼⡏⠀⠀⠀⣀⣴⡿⠟⠋⠀⠀⠀⢰⣿⣿⠀⠀⠀");
								System.out.println("⠀⠀⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⣾⡟⠛⢿⣿");
								System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⡟⠀⠀⠀⣿⠀⠀");
								System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⠁⠀⠀⣰⡟⠀");
								System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣧⣀⣀⣴⠟⠀");
								System.out.println("⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⠙⠛⠋⠁⠀");
								if(com==1) {
									System.out.println("           졌어요ㅠㅠ");
									System.out.println("⠀⢠⣤⣤⣤⣤⡄⢠⣶⠀⠀ ⠀ ⠀⠀⠀ ⠀⠀⠀⠀⠀⣴⡿⠿⢿⣦⡀");
									System.out.println("⠀⣬⣭⣭⣽⣿⣀⣸⣿⠀⠀⠀⠀   ⠀⠀⢠⡾⠛⢿⡿⠁⠀⠀⠙⢿⣄");
									System.out.println("⠀⣀⣴⡾⠟⠈⠉⢹⣿⠀⠀ ⠀⠀⠀⣰⡾⢿⣿⠇⠀⠀⢁⣀⠀⠀⠀⠈⢿⡇⠀");
									System.out.println("⠀⠈⠉⣶⣶⣶⣶⣶⣶⠀⠀⠀⢀⣤⣴⡿⠀⠀⢁⠀⠀⠀⠈⠹⡄⠀⠀⠀⢈⠻⣷⣤⣄⡀⠀⠀");
									System.out.println("⠀⠀⠀⣿⣤⣤⣤⣼⣿⠀⠀⢰⡟⠉⠙⢁⠀⠀⠈⢳⠀⠀⠀⠀⢷⠀⠀⠀⠘⣇⣈⠉⠛⣿⠀⠀");
									System.out.println("⠀⠀⠀⠉⠉⠉⠉⠉⠉⠀⠀⢸⣇⠀⠀⠛⢧⠀⠀⠀⢧⠀⠀⠀⠘⣇⠀⠀⠀⢹⡟⠀⠀⣿⠀");
									System.out.println("⠀          ⠈⢿⡄⠀⠀⠈⣇⠀⠀⠘⡆⠀⠀⠀⢹⡄⠀⠀⠀⣷⠀⠀⣿⡄");
									System.out.println("⠀          ⠀⠘⣿⡄⠀⠀⠘⡆⠀⠀⠘⡀⠀⠀⠀⢷⣄⡠⠖⠃⠀⠀⣸⡇");
									System.out.println("⠀⠀          ⠀⠘⢿⡄⠀⠀⠹⡆⠀⠀⢱⣄⣀⣠⡞⢀⠄⣠⣴⠞⠛⠋⠀⠀");
									System.out.println("⠀⠀          ⠀⠀⠈⢿⣆⣀⣠⣿⣶⣶⡾⠛⣿⡀⠹⣻⡿⠋⠀⠀");
									System.out.println("⠀⠀⠀          ⠀⠀⠀⠙⠛⠋⠀⠀⠀⠀⠀⠙⠛⠛⠋⠀⠀");
									System.out.println("총 누적기회 : "+count);
									break;
								}else if(com==2) {
									System.out.println("           무승부!");
									System.out.println("⠀⢠⣤⣤⣤⣤⡄⢠⣶⠀⠀⠀⠀⠀    ⠀         ⠀⠀⠀⠀⢀⡖");
									System.out.println("⠀⣬⣭⣭⣽⣿⣀⣸⣿⠀⠀⠀⠀⠀⠀          ⠀⠀⠀⠀⠀⢀⢢⠁⠀");
									System.out.println("⠀⣀⣴⡾⠟⠈⠉⢹⣿⠀⠀ ⠀⠀           ⠀⠀⠀⢀⠂⡆⠀⠀⠀⢀⣠⠖");
									System.out.println("⠀⠈⠉⣶⣶⣶⣶⣶⣶⠀⠀⠀⠀ ⠀       ⠀⠀⠀⠀⢠⠃⠸⢀⡠⢐⡪⠛⠁⠀");
									System.out.println("⠀⠀⠀⣿⣤⣤⣤⣼⣿⠀⠀⠀⠀⠀⠀        ⠀⠀⠠⠃⢀⠏⣡⠔⠉");
									System.out.println("⠀⠀⠀⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⣀⣤⣴⣶⣶⣤⣤⣤⣤⣴⡾⣡⡀⡼⠊");
									System.out.println("⠀     ⠀⣠⡾⠛⠁⠀⠈⢹⣿⣿⣿⠟⠋⠙⣬⣴⠁");
									System.out.println("⠀    ⣼⡏⠀⠀⠀⣀⣴⡿⠟⠋⠀⠀⠀⢰⣿⣿⠀⠀⠀");
									System.out.println("⠀    ⠀⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⣾⡟⠛⢿⣿");
									System.out.println("⠀    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⡟⠀⠀⠀⣿⠀⠀");
									System.out.println("⠀⠀⠀⠀⠀   ⠀⠀⠀⠀⠀⠀⢰⣿⠁⠀⠀⣰⡟⠀");
									System.out.println("⠀⠀⠀⠀⠀⠀   ⠀⠀⠀⠀⠀⢿⣧⣀⣀⣴⠟⠀");
									System.out.println("⠀⠀⠀⠀⠀⠀     ⠀⠀⠀⠀⠙⠛⠋⠁⠀");
								}else {
									System.out.println("           오예 이겼당!!");
									System.out.println("⠀⢠⣤⣤⣤⣤⡄⢠⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⠀⠀⢀⡀⠀");			
									System.out.println("⠀⣬⣭⣭⣽⣿⣀⣸⣿ ⠀⠀⠀⠀⠀⠀⠀  ⣀⡀⠀⠀⢰⣿⣿⠀⠀⣤⣄⠀");			
									System.out.println("⠀⣀⣴⡾⠟⠈⠉⢹⣿⠀⠀ ⠀⠀⠀⠀ ⠀⢸⣿⣧⠀⠀⣼⣿⡿⠀⢸⣿⣿⠀⠀");			
									System.out.println("⠀⠈⠉⣶⣶⣶⣶⣶⣶⠀ ⠀⠀⠀⠀ ⠀⠀⢸⣿⣿⠀⠀⣿⣿⡇⠀⣸⣿⡟⠀⠀⢀⡀⠀⠀");			
									System.out.println("⠀⠀⠀⣿⣤⣤⣤⣼⣿⠀⠀⠀⠀⠀ ⠀⠀⠀⢸⣿⣿⡆⠀⣿⣿⡇⢠⣿⣿⠇⠀⣰⣿⡇⠀");			
									System.out.println("⠀⠀⠀⠉⠉⠉⠉⠉⠉      ⠀⠀⠸⣿⣿⣧⠀⣿⣿⡇⣾⣿⣿⠀⢠⣿⣿⠇⠀");			
									System.out.println("⠀⠀⠀⠀⠀⠀         ⠀⠀⠀⣿⣿⣿⡄⣿⣿⡇⣿⣿⡟⢀⣾⣿⡟⠀");			
									System.out.println("⠀        ⠀⣤⣤⣤⡀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣇⣾⣿⡟⠁");			
									System.out.println("⠀        ⠀⠻⣿⣿⣿⣆⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠀");			
									System.out.println("⠀⠀        ⠀⠈⢻⣿⣿⣧⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀");			
									System.out.println("⠀⠀⠀        ⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀");			
									System.out.println("⠀⠀⠀⠀        ⠀⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇");			
									System.out.println("⠀⠀⠀⠀        ⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀");			
									System.out.println("⠀⠀⠀⠀⠀⠀        ⠀⠀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀");			
									System.out.println("⠀⠀⠀⠀⠀⠀⠀        ⠀⠀⠀⠈⢻⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀");
									count++;
								}
							}else if(user == 3) {
								System.out.println("⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠀");			
								System.out.println("⠀⠀⣿⡇⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⢰⣿⣿⠀⠀⣤⣄⠀");			
								System.out.println("⠀⠀⣿⡇⠀⠀⠀⣿⣧⣤⠀⠀⠀⠀⠀⠀⠀⢸⣿⣧⠀⠀⣼⣿⡿⠀⢸⣿⣿⠀⠀");			
								System.out.println("⠀⠀⣿⣧⣤⣤⣤⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⠀⠀⣿⣿⡇⠀⣸⣿⡟⠀⠀⢀⡀⠀⠀");			
								System.out.println("⠀⠀⠉⠉⠉⠉⠉⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⡆⠀⣿⣿⡇⢠⣿⣿⠇⠀⣰⣿⡇⠀");			
								System.out.println("⠀⠀⠀⠀⠀⠀         ⠀⠀⠸⣿⣿⣧⠀⣿⣿⡇⣾⣿⣿⠀⢠⣿⣿⠇⠀");			
								System.out.println("⠀⠀⠀⠀⠀⠀         ⠀⠀⠀⣿⣿⣿⡄⣿⣿⡇⣿⣿⡟⢀⣾⣿⡟⠀");			
								System.out.println("⠀        ⠀⣤⣤⣤⡀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣇⣾⣿⡟⠁");			
								System.out.println("⠀        ⠀⠻⣿⣿⣿⣆⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠀");			
								System.out.println("⠀⠀        ⠀⠈⢻⣿⣿⣧⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀");			
								System.out.println("⠀⠀⠀        ⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀");			
								System.out.println("⠀⠀⠀⠀        ⠀⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇");			
								System.out.println("⠀⠀⠀⠀        ⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀");			
								System.out.println("⠀⠀⠀⠀⠀⠀        ⠀⠀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀");			
								System.out.println("⠀⠀⠀⠀⠀⠀⠀        ⠀⠀⠀⠈⢻⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀");			
								if(com==1) {
									System.out.println("           오예 이겼당!!");
									System.out.println("⠀⢠⣤⣤⣤⣤⡄⢠⣶⠀⠀⠀  ⠀⠀⠀ ⠀⠀⠀⠀⠀⣴⡿⠿⢿⣦⡀");
									System.out.println("⠀⣬⣭⣭⣽⣿⣀⣸⣿⠀⠀⠀⠀   ⠀⠀⢠⡾⠛⢿⡿⠁⠀⠀⠙⢿⣄");
									System.out.println("⠀⣀⣴⡾⠟⠈⠉⢹⣿⠀⠀  ⠀⠀⣰⡾⢿⣿⠇⠀⠀⢁⣀⠀⠀⠀⠈⢿⡇⠀");
									System.out.println("⠀⠈⠉⣶⣶⣶⣶⣶⣶⠀⠀⠀⠀⣤⣴⡿⠀⠀⢁⠀⠀⠀⠈⠹⡄⠀⠀⠀⢈⠻⣷⣤⣄⡀⠀⠀");
									System.out.println("⠀⠀⠀⣿⣤⣤⣤⣼⣿⠀⠀⢰⡟⠉⠙⢁⠀⠀⠈⢳⠀⠀⠀⠀⢷⠀⠀⠀⠘⣇⣈⠉⠛⣿⠀⠀");
									System.out.println("⠀⠀⠀⠉⠉⠉⠉⠉⠉⠀⠀⢸⣇⠀⠀⠛⢧⠀⠀⠀⢧⠀⠀⠀⠘⣇⠀⠀⠀⢹⡟⠀⠀⣿⠀");
									System.out.println("⠀          ⠈⢿⡄⠀⠀⠈⣇⠀⠀⠘⡆⠀⠀⠀⢹⡄⠀⠀⠀⣷⠀⠀⣿⡄");
									System.out.println("⠀          ⠀⠘⣿⡄⠀⠀⠘⡆⠀⠀⠘⡀⠀⠀⠀⢷⣄⡠⠖⠃⠀⠀⣸⡇");
									System.out.println("⠀⠀          ⠀⠘⢿⡄⠀⠀⠹⡆⠀⠀⢱⣄⣀⣠⡞⢀⠄⣠⣴⠞⠛⠋⠀⠀");
									System.out.println("⠀⠀          ⠀⠀⠈⢿⣆⣀⣠⣿⣶⣶⡾⠛⣿⡀⠹⣻⡿⠋⠀⠀");
									System.out.println("⠀⠀⠀          ⠀⠀⠀⠙⠛⠋⠀⠀⠀⠀⠀⠙⠛⠛⠋⠀⠀");
									count++;
								}else if(com==2) {
									System.out.println("           졌어요ㅠㅠ");
									System.out.println("⠀⢠⣤⣤⣤⣤⡄⢠⣶⠀⠀⠀⠀⠀    ⠀         ⠀⠀⠀⠀⢀⡖");
									System.out.println("⠀⣬⣭⣭⣽⣿⣀⣸⣿⠀⠀⠀⠀⠀⠀          ⠀⠀⠀⠀⠀⢀⢢⠁⠀");
									System.out.println("⠀⣀⣴⡾⠟⠈⠉⢹⣿⠀⠀ ⠀⠀           ⠀⠀⠀⢀⠂⡆⠀⠀⠀⢀⣠⠖");
									System.out.println("⠀⠈⠉⣶⣶⣶⣶⣶⣶⠀⠀⠀⠀ ⠀       ⠀⠀⠀⠀⢠⠃⠸⢀⡠⢐⡪⠛⠁⠀");
									System.out.println("⠀⠀⠀⣿⣤⣤⣤⣼⣿⠀⠀⠀⠀⠀⠀        ⠀⠀⠠⠃⢀⠏⣡⠔⠉");
									System.out.println("⠀⠀⠀⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⣀⣤⣴⣶⣶⣤⣤⣤⣤⣴⡾⣡⡀⡼⠊");
									System.out.println("⠀     ⠀⣠⡾⠛⠁⠀⠈⢹⣿⣿⣿⠟⠋⠙⣬⣴⠁");
									System.out.println("⠀    ⣼⡏⠀⠀⠀⣀⣴⡿⠟⠋⠀⠀⠀⢰⣿⣿⠀⠀⠀");
									System.out.println("⠀    ⠀⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⣾⡟⠛⢿⣿");
									System.out.println("⠀    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⡟⠀⠀⠀⣿⠀⠀");
									System.out.println("⠀⠀⠀⠀⠀   ⠀⠀⠀⠀⠀⠀⢰⣿⠁⠀⠀⣰⡟⠀");
									System.out.println("⠀⠀⠀⠀⠀⠀   ⠀⠀⠀⠀⠀⢿⣧⣀⣀⣴⠟⠀");
									System.out.println("⠀⠀⠀⠀⠀⠀     ⠀⠀⠀⠀⠙⠛⠋⠁⠀");
									System.out.println("총 누적기회 : "+count);
									break;
								}else {
									System.out.println("           무승부!");
									System.out.println("⠀⢠⣤⣤⣤⣤⡄⢠⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⠀⠀⢀⡀⠀");			
									System.out.println("⠀⣬⣭⣭⣽⣿⣀⣸⣿ ⠀⠀⠀⠀⠀⠀⠀  ⣀⡀⠀⠀⢰⣿⣿⠀⠀⣤⣄⠀");			
									System.out.println("⠀⣀⣴⡾⠟⠈⠉⢹⣿⠀⠀ ⠀⠀⠀⠀ ⠀⢸⣿⣧⠀⠀⣼⣿⡿⠀⢸⣿⣿⠀⠀");			
									System.out.println("⠀⠈⠉⣶⣶⣶⣶⣶⣶⠀ ⠀⠀⠀⠀ ⠀⠀⢸⣿⣿⠀⠀⣿⣿⡇⠀⣸⣿⡟⠀⠀⢀⡀⠀⠀");			
									System.out.println("⠀⠀⠀⣿⣤⣤⣤⣼⣿⠀⠀⠀⠀⠀ ⠀⠀⠀⢸⣿⣿⡆⠀⣿⣿⡇⢠⣿⣿⠇⠀⣰⣿⡇⠀");			
									System.out.println("⠀⠀⠀⠉⠉⠉⠉⠉⠉      ⠀⠀⠸⣿⣿⣧⠀⣿⣿⡇⣾⣿⣿⠀⢠⣿⣿⠇⠀");			
									System.out.println("⠀⠀⠀⠀⠀⠀         ⠀⠀⠀⣿⣿⣿⡄⣿⣿⡇⣿⣿⡟⢀⣾⣿⡟⠀");			
									System.out.println("⠀        ⠀⣤⣤⣤⡀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣇⣾⣿⡟⠁");			
									System.out.println("⠀        ⠀⠻⣿⣿⣿⣆⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠀");			
									System.out.println("⠀⠀        ⠀⠈⢻⣿⣿⣧⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀");			
									System.out.println("⠀⠀⠀        ⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀");			
									System.out.println("⠀⠀⠀⠀        ⠀⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇");			
									System.out.println("⠀⠀⠀⠀        ⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀");			
									System.out.println("⠀⠀⠀⠀⠀⠀        ⠀⠀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀");			
									System.out.println("⠀⠀⠀⠀⠀⠀⠀        ⠀⠀⠀⠈⢻⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀");	
								}
							}else{
								System.out.println("다시 입력해주세요!!");
							}
						}
						
						Life = count;
						if(Life > 0) {
							
							continue;
							
						}else {
							
							System.out.println("                 ⠀⠀⠀⠀⠀⠀⣀⣀⣠⣤⣤⣤⣤⣤⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀");
							System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀       ⠀⠀⠀⢀⣠⣴⡶⠟⠛⠉⠉⠉⠉⠉⠉⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
							System.out.println(
									"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⣀⣤⠾⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⢸⣿⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⠀⠀");
							System.out.println(
									"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠿⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⢸⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⡿⠀");
							System.out.println(
									"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⡇⠀⠀⠀⠀");
							System.out.println(
									"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⠟⠁⠀⠀⠀⠀⠀⠀⠠⣿⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣿⣿⣿⣿⣇⣀⣀⣀⣀⣀⣀⣀⣀⣿⣿⣿⣿⣇⣀⣀⣀⡀⠀");
							System.out.println(
									"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇");
							System.out.println(
									"⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠇");
							System.out
							.println("⠀⠀⠀⠀⠀⠀⠀⠀⣸⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣄⠀");
							System.out.println("⠀⠀⠀⠀⠀⠀⠀⢠⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾ ⣿ ⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
							System.out
							.println("⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿ ⣿ ⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠀");
							System.out.println("⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⢠⣦⠀⠀⠀⠀⠘⠋⠉⠙⠻⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣦⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⡄");
							System.out.println(
									"⠀⠀⠀⠀⠀⠀⠀⠸⣇⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣶⣶⣦⣄⠀");
							System.out.println(
									"⠀⠀⠀⠀⠀⠀⠀⢀⣽⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⡆⠀");
							System.out.println(
									"⠀⠀⠀⠀⠀⢠⡾⠛⣩⣄⠀⣤⣤⣤⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⡆⠀⠀⠀⠀⠀⠀⠀⠘⢿⣿⣿⣿⠟⠁⠀");
							System.out.println(
									"⠀⠀⠀⠀⠀⢿⣥⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⠙⠛⠛⠳⠶⠶⠶⠀⠀⠰⠶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠁⠀⠀");
							System.out.println("⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠙⠛⠛⠛⠛⠛⠛⠻⠿⠿⠿⠿⠿⠿⠿⠿⠿⠂⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠁⠀");
						
							break;
						}
						}
						System.out.println();
						System.out.println("문제 출력 ↓");
						System.out.println(listhard.get(Random).getKor());
						System.out.println("정답 수 ↓");
						for (int i = 1; i <= listhard.get(Random).getEng().length(); i++) {
							System.out.print("□");
						}
						System.out.println();
						System.out.println("정답 입력 ↓");
						System.out.println();
						answer = sc.next();
						if (answer.equals(listhard.get(Random).getEng())) {
							score += 3;

							System.out.println("⠀⠀                     ⣀⣀⣀⣀⣀⡀");
							System.out.println("⣿⣿⣿⣿⣿⣿⣿             ⣶⣾⣿⣿⣿⣿⣿⣦⣵⣦          ⣿      ⣿");
							System.out.println("⣶⣿⣿⣿⣿⣿⣿⣿⣿          ⣿⠋⠉⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿  ⠀    ⣷⣿⣿⡀⠀⠀⠀   ⢀⠀");
							System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿      ⣿⠃⠀⠀⠀⢀⠈⢻⣿⣿⣿⣿⣿⣿⣿     ⣿⣿⣿⣿⣿⡇⠀⠀⠀  ⠀⡂⠀");
							System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠉⣟⠈⠀⠀⠀⣀⡀⠘⣿⣿⣿⣿⣿⣿⣿⣿ ⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀  ⢀⣷");
							System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠟⠛⠀⠀⠀⠛⠈⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿ ⣿⣿⡿⠋⠀⠀⠀⠀   ⠀⣰⣿⣿");
							System.out.println(
									"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⢀⡀⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⡿⠻⣯⠯⠛⠉⠀⠀⠀⠀⠀⠀   ⣰⣟⣻⠿ ⠀⠀⣤⣤⣤⣤⣤⣤⡄⠀⢰⣶⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⢠⣤⣤⣤⣤⣤⡄⠀⢰⣶⠀⠀⠀⣶⣶⣶⣶⣶⡆⠀⢰⣶⠀⠀⠀");
							System.out.println(
									"⣿⣿⣿⣿⣿⣿⡿⠁⠀  ⠀⠀⠀⠀⠂⠀⠀⡀⠈⠉⠁⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣇⠖⡁⠀⠀⣰⣦⠀⠀⠀  ⠀⢠⣿⣿⣿⣿⣿ ⠀ ⠀⠀⢸⣿⠁⠀⣤⣤⣼⣿⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⢨⣿⡅⠀⢠⣤⣼⣿⠀⠀⠀⣿⡇⠀⠀⠀⠀  ⢸⣿⣤⡄⠀⢸⣿");
							System.out.println(
									"⣿⣿⡿⠛⠉⠁⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⣽⣔⢿⣷⣶⣄⠀⠀⣿⣿⣿⣿⣿⡇⣀⠘⠁⠀⠀⣿⣿⡆⠀⠀ ⢠⣿⣿⣿⣿⣿⣿  ⠀⠀⢀⣴⡿⠛⢷⣄⡉⠉⢹⣿⠀⠀⠀⠀⠀ ⠀⠀⠀⢀⣠⡿⠛⢷⣤⡈⠉⢹⣿⠀⠀⠀⣿⣷⣶⣶⣶⠶⠀⢸⣿⠉⠁⠀ ⢸⣿⠀");
							System.out.println(
									"⠿⠛⠛⠃⠀⠀⠀⠀⢀⠀⡀⠀⠀⠀⣴⡀⠀⣰⣿⠿⠊⡇⠉⠉⡄⠀⣿⣿⡿⠿⣿⣿⡟⢻⣶⡄⢰⣿⣿⣿⣄⣰⣿⣿⣿⣿⣿⣿⣿ ⠀ ⠀⠙⠋⠀⢀⣀⣭⣥⣄⣘⠛⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠙⠋⠀⢀⣀⣬⣥⣄⣘⠛⠀⠀⠀⠀⢠⣤⠀⠀⠀⠀⢨⣭⠀⠀ ⠀⢸⣿⠀");
							System.out.println(
									"⣀⣀ ⠀⠀⠀⢀⣠⣾⣧⣿⣿⣿⢠⣿⣿⣿⣿⣿⣿⢀⣎⠲⠞⠁⣰⡏⠁⠀⠀⢈⣿⣣⣾⠟⣁⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿ ⠀⠀⠀⠀⢰⣿⠋⠉⠉⠉⢻⣷⠀⠀ ⢀⣀⠀⠀⣀⠀⠀⠀⠀⢰⣿⠋⠉⠉⠉⢹⣷⠀⠀⠀⠀⢸⣿⠶⠶⠶⠶⢾⣿⠀⠀⠀ ⢀⣀⠀");
							System.out.println(
									"⣿     ⣿⣿⣿⣿⣿⣷⠉⠛⠂⠀⣿⣿⣼⣿⣿⠠⣾⣿⣿⣿⣿⣿⣿⣿⡟⠁⣸⣿⣿⣿⣿⣿⣿⣿⡇⣿⣿⡉⠻⣿⣿⣿⠀⠀⠀  ⠀⠘⠿⣶⣤⣤⣴⡾⠋⠀⠀⠙⠟⠀⠘⠿⠃⠀⠀⠀⠈⠻⣶⣤⣤⣴⡾⠟⠀⠀⠀⠀⢸⣿⣤⣤⣤⣤⣼⣿⠀⠀⠀ ⠙⠟⠀");
							System.out.println("     ⣿⣿⣿⣿⣴⣿⣿⣿⡇⠀⠀⢀⣀⣾⣿⣿⣿⣿⣸⣿⡿⠟⣭⣿⡿⠋⣰⣿⣿⣿⣿⣿⣿⣿⣿⡟⢿⣿⣿⣿⣷⣼⣿⣿");
							System.out.println("   ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⠀⢀⠀⠛⢿⡿⠿⣿⠿⠟⣡⣶⣿⡿⠋⢀⣼⠟⣳⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿");
							System.out.println("⡿⣿⣿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠧⠤⠤⠤⠤⠀⣶⣿⣟⣁⣀⣀⠀⣀⣀⣤⣾⣿⣿⠿⣿⡿⣿⡇⣿⣿⣿⣿⣿⣿⣿⣿⣿");
							System.out.println("⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡁⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⣿⣿⣿⣿⣿⣿⣿⣿⣿");
							System.out.println("⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡁⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⣿⣿⣿⣿⣿⣿⣿⣿⣿");
							System.out.println("⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡁⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⣿⣿⣿⣿⣿⣿⣿⣿⣿");

							System.out.println("정답 + 3점");
							Random = rd.nextInt(99) + 1;
							len = listhard.get(Random).getEng().length();
							hint_index = len - 1;
							System.out.println("점수" + score);
							System.out.println("기회" + Life);
						} else {

							System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿   ⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿   ⠀⠀     ⠀ ⠀⠀⠀⠠⣤⡀");
							System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿  ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿  ⠀     ⠀⠀⢈⣷⠄⠀⢸⡇");
							System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿ ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠉⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿  ⠀    ⢀⡠⠟⠙⠷⠀⢸⠇");
							System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿ ⣿⣿⣿⣿⣿⣿⠿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿  ⠀ ⠀  ⠀ ⠀⠲⠶⠒⣺⠆");
							System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿ ⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⣿⣿⣿⣿⣿⡿⠛⠟⠻   ⠀  ⠀⠀⠀⠙⣟⣛⣋⡁");
							System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿ ⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⢿⣿⡟⠁⠀⠀⠀⢹   ⠀   ⠀⠀⠈⠩⣍⡁");
							System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿  ⡿⣿⡆⠀⠀⠀⠀⠀⠀⢠⣤⣶⠿⠛⠓⠀⠀⠀⠀⠀⠀⠈⢿⣧⠀⠈⠂⡀⠈    ⠀⣤⣤⣤⠙⣷⢸⡇");
							System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿   ⠻⣷⠀⣀⣤⣶⣀⡀⠀⢿⣠⣴⠲⠶⠒⠂⠀⠀⠀⠀⠀⠈⠉⠀⠀⡀⠀⢠    ⠀⢲⡆⣷⠀⣿⣼⡇");
							System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿   ⠀⠙⢷⠟⢉⣭⣭⣿⠀⠀⠙⠙⠐⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼   ⠀ ⠐⠾⠶⠓⠚⡟⢸⡇");
							System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿   ⠀⠀⠀⠰⠟⣙⣯⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠂⢸  ⠀⠀ ⠀   ⠀⠀⠀⠁⢸⡇");
							System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿   ⠀⠀⠀⠀⠀⠀⠘⠁⠀⠀⠀⠀⢰⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿  ⠀⠀  ⠀⠀⠀  ⠀⠀⠈⠀");
							System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿   ⠀⠀⠀⠀⠀⢠⣶⣷⣾⣄⣀⣤⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸            ");
							System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿   ⠀⠀⡄⢠⣌⠐⢸⣿⣿⣿⣭⣿⣿⣻⣦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻          ");
							System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿   ⠀⠀⠀⣩⠉⣶⣿⣿⣿⡿⠿⢿  ⣿⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠛⠋⠉⠉⠉⠉⠻⣿ ");
							System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠃⠀⠀⠀⢿⠀⠉⢻⣿⣿⣶⣶⡿⠿⡿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⣸⣿⣿⣿⣿");
							System.out.println("⣿⣿⣿⣿⣿⣿⠿⠛⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣷⣿ ⣿⣿⣧⠀⠀⢠⣤⣴⣶⣿⠿⠁⠀⠀⠀⠀⠀⠀⠀⣀⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
							System.out.println("⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠺⣿⣿⣿ ⣿⣿⣇⡀⠀⠙⣿⡿⠁⠀⠀⠀⠀⠀⠀⢀⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
							System.out.println("⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⢸⡄⠀⠀⠲⠿⢀⣠⠀⠀⣹⣟⣻⡿⠋⠉⠙⠛⠀⠀⢿⣇⠀⠀⠀⠀⠀⣠⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
							System.out.println("⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⢸⣷⡀⠀⣤⣤⣷⣾⣷⣿⣿⣿⣏⠀⠀⠀⠀⠀⠀⠀⠀⠻⠄⠀⠀⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
							System.out.println("오답 입니다.");

							Life -= 1;
							System.out.println();
							System.out.println("힌트를 사용 하시겠습니까?");
							System.out.println("힌트를 사용하시게 되면 1점찍 감소하게 됩니다.");
							System.out.println("[1] 힌트를 사용한다  [2] 문제를 다시 도전하겠다.  [3] 다음으로 넘어가겠다.");
							hintmenu = sc.nextInt();
							if (hintmenu == 1) {

								System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣻⣿⣿⣿⣿⠋⠉⠙⢧⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
								System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⡇⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
								System.out.println("⣿⣿⣿⣿⡟⠉⠉⠙⢆⣾⣿⣿⠿⠷⠒⠒⠒⠲⠷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
								System.out.println("⣿⣿⣿⣿⠀⠀⠀⠀⠈⡏⠁⠀⠀⠀⠀⠀⢠⡴⠶⣦⠀⠀⠀⠀⠟⠉⠉⣮⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
								System.out.println("⣿⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠏⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⢻⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
								System.out.println("⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⠒⠄⠀⠀⠀⡇⣈⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
								System.out.println("⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣤⡄⠀⠀⠛⠛⠉⠁⣾⣿⣆⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠟⠛⠛");
								System.out.println("⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠠⠂⠀⠀⠀⠀⠀⠀⠙⠻⠟⡇⣿⣿⡿⠿⠟⠛⠋⠉⠁⠀⠀⠀⠀⠀⢀⣾⣿");
								System.out.println("⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿");
								System.out.println("⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢻⣿⠄⠀⠀⠀⣤⠀⠀⣀⠀⠀⠀⠀⠀⣾⣿⣿⣿⣿");
								System.out.println("⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡠⠴⠊⢁⣾⠇⠀⠘⣛⣿⣛⠃⣿⠀⠀⠀⢀⣾⣿⣿⣿⣿");
								System.out.println("⣿⣿⣿⣿⣿⣿⢀⣀⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⡆⠀⢀⣾⡟⠀⠀ ⢯⣀⣼⠃⣿⠀⠀⠀⢺⣿⣿⣿⣿⣿");
								System.out.println("⣿⣿⣿⣿⣿⣿⣿⢀⣿⣧⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠋⠉⠉⢔⣱⣿⡟⠀⠀⠀ ⢰⣆⣀⣀⣛⠀⠀⢸⣿⣿⣿⣿⣿");
								System.out.println("⣿⣿⣿⣿⣿⣿⢀⣿⣿⣿⣿⣿⣿⣶⣶⣤⣄⣀⠀⠀⠀⠀⠀⠀⣀⡤⠔⣿⡿⠁⠓⠈⠁⢠⠉⠉⠉⠉⠁⠀⢀⣾⣿⣿⣿⣿");
								System.out.println("⣿⣿⣿⣿⣿⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣾⣭⣤⣤⣤⡿⠁⠀⠀⠀⠀⢀⣶⠶⠶⠶⠀⠀⢿⣿⣿⣿⣿⣿");
								System.out.println("⣿⣿⣿⣿⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠁⠀⠀⠀⠀⠀⠀⢀⣿⣛⣛⣛⣃⠀⠀⢸⣿⣿⣿⣿⣿");
								System.out.println("⣿⣿⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⠻⢿⣿⡿⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⢀ ⣉⣉⣉⣉⣉⠀⠀⠀⠈⣿⣿⣿⣿⣿");
								System.out.println("⣿⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠋⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀  ⠈⠉⠉⠉⠉⠉⠀⠀⠀⠸⣿⣿⣿⣿⣿");
								System.out.println("⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣴⣿⣿⣿⣿⣿");
								System.out.println("⣿⣿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⣿⣿⡇⠀⠀⠀⠀⠀⢀⣀⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿");
								System.out.println("⣿⣿⣿⣿⣿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣤⡀⠀⠀⠀⠀⢀⣤⣶⣿⣿⣿⣿⣿⣿⣀⣀⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");

								System.out.println("사용할 힌트를 선택해주세요");
								System.out.println("[1] 첫글자를 보겠다.  [2] 마지막글자를 보겠다. [3] 정답 다시입력.");
								letter = sc.nextInt();
								if (letter == 1) {
									System.out.println("첫글자를 확인합니다.");
									for (int i = 0; i <= Lindex; i++) {
										System.out.print(listhard.get(Random).getEng().charAt(i));
									}
									System.out.println();
									Lindex += 1;
									score -= 1;
									System.out.println("점수" + score);
									System.out.println("기회" + Life);
								} else if (letter == 2) {
									System.out.println("마지막 글자를 확인합니다.");
									String[] split_letter = listeasy.get(Random).getEng().split("");
									
									if (hint_index >= 1) {
										hint_index -= 1;
									}
									for (int i = 0; i < split_letter.length; i++) {
										if (i < hint_index)
											System.out.print("□");
										else
											System.out.print(split_letter[i]);
									}
									
									
									
									score -= 1;
									
									System.out.println();
									System.out.println("점수" + score);
									System.out.println("기회" + Life);
								} else if (letter == 3) {
									System.out.println("정답 다시 입력.");
									System.out.println("문제 출력 ↓");
									System.out.println(listhard.get(Random).getKor());
									System.out.println("정답 입력 ↓");
									System.out.println();
									answer = sc.next();
								} else {
									System.out.println("잘못 입력했습니다.");
									System.out.println("이전단계로 돌아갑니다.");
								}
							} else if (hintmenu == 2) {
								System.out.println("다시 도전");
							} else if (hintmenu == 3) {

								System.out.println("⠀⢰⣶⣶⣶⣦⣄⠀⠀⠀⢀⣶⣶⡀⠀⠀⠀⣠⣶⠶⠶⣶⠀⢀⣤⣶⠶⢶⡆⠀");
								System.out.println("⠀⢸⣿⡇⠀⠈⣿⡇⠀⠀⣼⡏⢻⣧⠀⠀⠰⣿⣇⠀⠀⠀⠀⢸⣿⡀⠀");
								System.out.println("⠀⢸⣿⣧⣤⣾⠿⠁⠀⣸⣿⠁⠈⣿⣆⠀⠀⠙⠻⢿⣶⣄⠀⠈⠛⠿⣷⣦⡀⠀");
								System.out.println("⠀⢸⣿⡇⠀⠀⠀⠀⢠⣿⠟⠛⠛⠻⣿⡄⢀⡀⠀⠀⢹⣿⠀⢀⠀⠀⠈⣿⡷");
								System.out.println("⠀⠘⠛⠃⠀⠀⠀⠀⠚⠛⠀⠀⠀⠀⠛⠓⠘⠛⠿⠿⠛⠋⠀⠘⠻⠿⠿⠛⠁⠀");
								System.out.println("⠀⠀⠀⠀           ⠀⠠⢇⢙⣦⡀⢀⣔⡀⠀⠀⠀⠀⠀⠀⠀⠈⠀");
								System.out.println("⠀⠀⠀      ⣤⣀⣀⣀⡞⣁⣰⣿⢸⠋⠀⢹⣿⣷⣆⣿⣿⠿⠿⠛⠋⠁⠀⠀⠀⠀⠀⠃⠀");
								System.out.println("⠀⠀⠀⠀⠀⣄⣀⣀⣀⣀⣹⣿⡇⠀⢳⣌⣭⣥⣽⣶⣾⣿⣧⣽⣿⣿⣿⣦⡀⢀⠀⠀⠀⠀⠀⠀⠘⠀⠀");
								System.out.println("⠀⠀⠀⠀⠀⠘⢿⣿⣿⣿⣿⡏⢹⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠀⠀⠀⠀⠀⠀⡆⠀");
								System.out.println("⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀");
								System.out.println("⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⠋⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣏⠀⠄⠀⠀⠠⠀⠘");
								System.out.println("⠀⠀⠀⢠⣿⠿⢛⣿⣿⣿⣿⣿⣿⣿⢿⣿⣿⠏⠀⠀⠛⠿⠗⠾⢯⢽⣿⣿⣿⣿⣿⣦⣀⠀⠀⢠⣠⣦⠀");
								System.out.println("⠀⠀⠀⠀⠁⠀⣿⣿⣿⣿⣿⣿⣿⠹⢂⡽⠿⠀⠀⠀⠀⠀⢣⣾⠀⠀⠘⣿⣿⣿⣿⣿⣿⡇⠀⠈⣿⣿⣆");
								System.out.println("⠀⠀⠀⠀⠀⠀⣿⣿⢿⣿⣿⣿⣿⡄⡎⢠⣴⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⣹⣿⣿⣿⣿⣿⠀⠀⢻⣿⣿");
								System.out.println("⠀⠀⠀⠀⠀⠀⠿⠏⠘⣿⣿⣿⣿⣿⡀⠀⠁⠀⠀⠀⢀⡀⠀⠀⠀⠀⢠⣶⣿⣿⣿⣿⣿⣿⠀⠀⠘⣿⣿");
								System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⡇⣿⣿⣧⡀⠀⠀⠀⠘⠉⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠹⣿");
								System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣦⣄⡀⠀⠀⠀⠀⠀⠀⠹⡿⠿⡿⠟⠛⠛⠛⠿⡇⠀⠀⠀⢻");
								System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⡆⣀⡠⠄⠔⠀⠀⠀⠀⠀⠀⠀⠀⠀⡃⠀⠀⠀⢸");
								System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⡟⠉⠀⠀⠀⠀⡀⠀⠀⠀⠀⣠⣾⣿⠟⢱⣄⠀⠀⢸");
								System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣧⢻⣿⣿⣿⣿⣿⠟⠀⠀⠀⠀⣰⣤⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣷⣶⣾");
								System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢿⡄⠙⠟⠉⢮⣄⠀⠀⠀⠀⠈⢹⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");

								Random = rd.nextInt(99) + 1;
								len = listhard.get(Random).getEng().length();
								hint_index = len - 1;
								System.out.println("점수" + score);
								System.out.println("기회" + Life);
							} else {
								System.out.println("잘못");
							}
						}
					}
				}

			} else if (menu == 2) {

				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⡴⠒⠚⣻⠇⠀⠀⠀⠀");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠓⠒⠒⠒⠒⢤⣤⠴⠚⠉⠀⡸⠁⣠⠞⠁⠀⠀⠀⠀⠀");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡆⠀⠀⣠⠖⠋⠀⠀⠀⠀⢀⡧⠞⠣⠤⣀⡀⠀⠀⠀⠀");
				System.out.println("⢀⣤⠔⠒⠚⣏⠉⠉⠉⠉⠉⠉⠉⠒⠒⠲⠤⠒⠋⠉⠉⠉⠉⠉⠒⠒⠻⢴⠋⠀⠀⠀⠀⠀⣠⠔⠋⠀⠀⠀⠀⠀⠉⠑⠲⢤⡀ ");
				System.out.println("⠈⠙⠒⠤⢄⣘⣦⡀⠀⠀⠀⠀⠀⠀⡔⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⠤⠖⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡼  ");
				System.out.println("⠀⠀⠀⠀⠀⠀⠈⢉⣿⣗⡒⠒⠒⡾⠁⣠⣶⠒⡆⠀⠀⠀⠀⠀⠀⠀⣀⣄⡀⠀⢳⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠞⠀");
				System.out.println("⠀⠀⠀⠀⠀⠀⢠⡎⠀⠀⠙⢦⣀⠇⠀⠻⣼⡿⠁⠀⠀⢠⡄⠀⠀⠸⣷⣼⣷⠀⢸⣆⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠋⠀⠀");
				System.out.println("⠀⠀⠀⠀⠀⠀⠈⣏⠀⠀⠀⠀⡿⠖⠲⣄⠀⠀⣤⡀⢀⣤⣀⠀⠀⢀⠈⠋⠁⠀⢸⣿⡉⠓⠦⣀⡀⠀⠀⠀⠀⢀⡴⠁⠀⠀⠀");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⢹⡀⠀⠀⠀⡇⠀⠀⣸⠀⠀⢸⣯⠟⠛⠛⢿⣿⠋⠀⢰⠟⠉⠹⡇⢷⠀⠀⠀⠉⠓⠦⣄⣠⠎⠀⠀⠀⠀⠀");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⣇⠀⠀⠀⠹⡦⠴⠋⠀⠀⠀⢹⡄⠀⢀⡼⠁⠀⠀⣇⠀⠀⢠⡇⣀⣧⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠸⡄⠀⠀⠀⠙⢆⠀⠀⠀⠀⠀⠹⠤⠋⠀⠀⠀⠀⠈⠓⡶⠋⠙⠳⠤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡄⠀⠀⠀⠀⠑⠶⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⠖⠋⠀⠀⠀⠀⠀⠀⠉⠲⢤⡀⠀⠀⠀⠀⠀⠀⠀⠀");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣶⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡀⠀⠀⠀⠀⠀⠀⢀⣷⠀⠀⠀⠀⠀⠀⠀⠀");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣧⠤⣤⠤⠴⠒⠒⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢧⡰⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⡆⢀⣠⠤⠒⠒⠒⠂⠀⠀⠐⠒⠒⠒⠒⠲⢦⡀⠀⠳⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⣿⡟⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠑⠒⠾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");

				System.out.print("ID 입력 : ");
				String id = sc.next();
				System.out.print("PW 입력 : ");
				String pw = sc.next();
				MiniDTO mini = new MiniDTO(id, pw);
				id2 = mc.Login(mini);

			} else if (menu == 3) {

				System.out.println("⣿⣿⣿⣿⣿⣿⣿⡿⠛⠉⠉⠉⠉⠛⠻⣿⣿⠿⠛⠛⠙⠛⠻⣿⣿⣿⣿⣿⣿⣿ ");
				System.out.println("⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⢀⣀⣀⡀⠀⠈⢄⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣿ ");
				System.out.println("⣿⣿⣿⣿⠏⠀⠀⠀⠔⠉⠁⠀⠀⠈⠉⠓⢼⡤⠔⠒⠀⠐⠒⠢⠌⠿⢿⣿⣿⣿ ");
				System.out.println("⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⢀⠤⣒⠶⠤⠭⠭⢝⡢⣄⢤⣄⣒⡶⠶⣶⣢⡝⢿⣿ ");
				System.out.println("⡿⠋⠁⠀⠀⠀⠀⣀⠲⠮⢕⣽⠖⢩⠉⠙⣷⣶⣮⡍⢉⣴⠆⣭⢉⠑⣶⣮⣅⢻ ");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠉⠒⠒⠻⣿⣄⠤⠘⢃⣿⣿⡿⠫⣿⣿⣄⠤⠘⢃⣿⣿⠿⣿ ");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠓⠤⠭⣥⣀⣉⡩⡥⠴⠃⠀⠈⠉⠁⠈⠉⠁⣴⣾⣿ ");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠤⠔⠊⠀⠀⠀⠓⠲⡤⠤⠖⠐⢿⣿⣿⣿ ");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⣠⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿  ");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⢸⣿⡻⢷⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣘⣿⣿  ");
				System.out.println("⠀⠀⠀⠀⠀⠠⡀⠀⠙⢿⣷⣽⣽⣛⣟⣻⠷⠶⢶⣦⣤⣤⣤⣤⣶⠾⠟⣯⣿⣿  ");
				System.out.println("⠀⠀⠀⠀⠀⠀⠉⠂⠀⠀⠀⠈⠉⠙⠛⠻⠿⠿⠿⠿⠶⠶⠶⠶⠾⣿⣟⣿⣿⣿   ");
				System.out.println("⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿  ");
				System.out.println("⣿⣿⣶⣤⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⣟⢿⣿⣿⣿⣿⣿⣿⣿  ");
				System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣶⣶⣶⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿  ");

				System.out.println("====회원 가입=====");
				System.out.println("가입할 ID 입력 :  ");
				String id = sc.next();
				System.out.println("패스워드 입력 : ");
				String pw = sc.next();
				MiniDTO mini = new MiniDTO(id, pw);
				row = mc.Signup(mini);

				if (row > 0) {
					System.out.println("회원 가입 완료");
				} else {
					System.out.println("회원 가입 오류");
				}
			} else if (menu == 4) {

			} else if (menu == 5) {

				System.out.println("⣿⣿⣿⣿⣿⣿⣿⠟⠋⠉⠁⠈⠉⠙⠻⢿⡿⠿⠛⠋⠉⠙⠛⢿⣿⣿⣿⣿⣿⣿");
				System.out.println("⣿⣿⣿⣿⣿⠟⠁⠀⠀⢀⣀⣀⣀⣀⡀⠀⢆⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣿");
				System.out.println("⣿⣿⣿⣿⠃⠀⠀⠠⠊⠁⠀⠀⠀⠀⠈⠑⠪⡖⠒⠒⠒⠒⠒⠒⠶⠛⠿⣿⣿⣿");
				System.out.println("⣿⣿⡿⡇⠀⠀⠀⠀⠀⠀⡠⢔⡢⠍⠉⠉⠩⠭⢑⣤⣔⠲⠤⠭⠭⠤⠴⢊⡻⣿");
				System.out.println("⡿⠁⢀⠇⠀⠀⠀⣤⠭⠓⠊⣁⣤⠂⠠⢀⡈⠱⣶⣆⣠⣴⡖⠁⠂⣀⠈⢷⣮⣹");
				System.out.println("⠁⠀⠀⠀⠀⠀⠀⠈⠉⢳⣿⣿⣿⡀⠀⠀⢀⣀⣿⡿⢿⣿⣇⣀⣥⣤⠤⢼⣿⣿");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡟⠑⠚⢹⡟⠉⣑⠒⢺⡇⡀⠀⡹⠀⠀⣀⣴⣽⣿⣿");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀⣿⠒⠉⠀⠀⢠⠃⠈⠙⠻⣍⠙⢻⡻⣿⣿⣿");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⣀⣘⡄⠀⠀⢸⡇⠀⠀⠀⠘⡇⠀⠀⠀⠘⡄⠀⢱⢸⣿⣿");
				System.out.println("⠀⠀⠀⠀⠠⡀⠀⠾⣟⣻⣛⠷⣶⣼⣥⣀⣀⣀⠀⢧⠀⠀⠀⠠⣧⣀⣼⣴⢽⣿");
				System.out.println("⠀⠀⠀⠀⠀⠈⠉⠁⠀⠹⡙⠛⠷⣿⣭⣯⣭⣟⣛⣿⣿⣿⣛⣛⣿⣭⣭⣾⣿⣿");
				System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⡀⠀⠀⣇⠀⠉⠉⠉⡏⠉⠙⠛⠛⡿⣻⣯⣷⣿⣿⣿");
				System.out.println("⣶⣤⣀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⢸⠀⠀⠀⡸⠁⣠⣴⣶⣿⣿⣿⣿⣿⣿⣿⣿");
				System.out.println("⣿⣿⣿⣿⣶⣶⣦⣤⣤⣤⣷⣤⣄⣈⣆⣤⣤⣧⣶⣷⣿⡻⣿⣿⣿⣿⣿⣿⣿⣿");
				System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⢿⣿⣿⣿⣿⣿⣿");

				System.out.println("게임 종료");
				break;
			}
		}
	

	}

}
