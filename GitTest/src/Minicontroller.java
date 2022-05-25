import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Minicontroller {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);

	int row = 0;
	String id = ""; // 정보 유지를 위한 변수
	int index = 1;

	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "cgi_7_0516_5";
			String password = "smhrd5";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
			if (rs != null) {
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
			String sql = "insert into us values(?, ?, 0 , 0)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, minimo.getId());
			psmt.setString(2, minimo.getPw());

			row = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DB 오류");
			e.printStackTrace();
		} finally {
			close();
		}

		return row;
	}

	public String Login(MiniDTO minimo) {
		connect();
		String sql = "select user_pw from us where user_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, minimo.getId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(minimo.getPw())) {
					id = minimo.getId();

					System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⣪⡯⠿⣿⣿⢻⡏⣿⣿⡍⡋⢸⢸⣿⢻⡿⢹⢛⣿⣿⣿⣿⣿⠉⣿⠉⡿⠛⠋⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⣿⣿⣿⣾⣦⣿⣿⣿⣷⣾⣄⣿⣿⣾⣼⣥⣿⣿⣿⣿⣿⣬⣿⣬⣧⣀⣀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠋⠉⠉⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠙⣿⣿⣿⣿⠿⠿⠿⠿⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⠛⠙⠛⠻⢿⣿⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠙⠛⠿⣿⣿⠋⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠈⠉⠀⠀⣀⣤⡄⠀⠀⠀⠀⢿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⠚⠊⠀⢤⠖⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣶⣦⣄⣀⠀⣙⣛⣓⣶⣶⣆⠀⠀⠀⠀⣾⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠠⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⣀⣾⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⡀⠈⠀⠀⠄⠀⠐⣂⡀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠍⠀⠀⠀⠈⠀⠈⠁⠀⣀⠀⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢻⣿⣿⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠤⠤⡀⠀⠀⠀⠀⡀⠄⠂⠭⠕⠒⣚⠀⠉⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⠈⣿⣿⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⠟⠀⠀⠀⠀⢀⣈⠓⢄⠀⠀⠀⠀⢀⡀⠀⠀⠀⠀⠀⠀⠈⢛⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⢿⣿⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀⠀⠀⣈⣁⣠⣤⠀⠁⢠⠀⠠⠹⡍⠁⠀⣗⣂⣀⠐⠀⠁⠀⠀⠈⠛⣟⠛⠿⠿⠿⠿⠇⠀⠀⢸⣿⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⡏⠀⠀⠀⠐⠀⠻⠿⢤⣼⣷⣶⣾⡇⠀⠀⠀⠀⠀⠐⠁⠀⠲⣶⣶⡿⢦⣤⣀⣼⣇⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⠀⠀⣴⣶⣿⣿⣧⠀⠀⠀⠀⠉⠉⠀⠀⣀⣀⡀⠀⠀⠀⠀⠀⠛⠿⠷⠶⠿⠿⠿⠃⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⡄⠀⠈⠙⠛⠛⠉⠀⣀⠤⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣶⣶⣦⣄⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠈⠶⠊⠓⠖⠉⠀⠀⠀⠀⠀⠀⠀⣀⣠⡄⠀⠀⠀⠀⠘⠿⢿⣿⡿⠿⠃⠀⠀⠀⣸⣿⣿⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⡟⠣⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⢿⣿⣿⣿⠿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⡇⠀⠈⢢⠀⠀⠀⠀⢀⣀⠀⠠⠤⠤⠀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠙⠂⠀⠈⠁⠤⢄⣀⣀⠉⠀⠀⠀⠲⣶⣶⣒⣶⠿⠒⠒⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⣿⣿⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠤⠀⠀⢀⡐⠽⠿⠿⠷⠖⠀⠀⠠⠤⠄⠀⠤⠦⠤⠤⠤⠤⠶⠤⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿");
					System.out.println("⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⢘⠉⠀⠀⠀⠀⢀⣤⠄⠀⠀⢀⣀⡀⠠⠤⠤⠄⠀⠀⠀⠤⠤⠔⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿");

					System.out.println("로그인 성공");
				} else {
					System.out.println("로그인 실패");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}

	public MiniDTO Rank(MiniDTO minimo) {
		boolean result = false;
		try {
			connect();
			String sql = "select * from us where _id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, minimo.getId());
			rs = psmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("_name");
				String score = rs.getString("_score");
				String rank = rs.getString("_rank");
				minimo = new MiniDTO(score, rank);
			}
		} catch (Exception e) {
			System.out.println("JDBC 오류");
			e.printStackTrace();
		} finally {
			close();
		}

		return minimo;
	}

	public ArrayList<Answer> Hard() {
		connect();
		ArrayList<Answer> listhard = new ArrayList<Answer>();
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
		} finally {
			close();
		}
		return (listhard);
	}

	public ArrayList<Answer> Normal() {
		connect();
		ArrayList<Answer> listnormal = new ArrayList<Answer>();
		try {
			String sqlnormal = ("select * from nomal");
			psmt = conn.prepareStatement(sqlnormal);
			rs = psmt.executeQuery();
			while (rs.next()) {
				index = 1;
				String kor = rs.getString(index++);
				String eng = rs.getString(index++);
				listnormal.add(new Answer(kor, eng));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return (listnormal);
	}

	public ArrayList<Answer> Easy() {
		connect();
		ArrayList<Answer> listeasy = new ArrayList<Answer>();
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
		} finally {
			close();
		}
		return (listeasy);
	}
}