import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Mini {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int row = 0;
		Minicontroller mc = new Minicontroller();
		
		while(true) {
			System.out.println("==============================================");
			System.out.print("1.게임시작  2.로그인  3.회원가입  4.랭킹보기 5.게임종료");
			System.out.println("==============================================");
			int menu = sc.nextInt();
			
			if(menu==1) {
			}
			
			else if(menu==2) {
				System.out.print("ID 입력 : ");
				String id = sc.next();
				System.out.println("PW 입력 : ");
				String pw = sc.next();
				MiniDTO mini = new MiniDTO(id,pw);
				mc.Login(null);
				if(row>0) {
					System.out.println("로그인되었습니다.");
				}
				else {
					System.out.println("비밀번호가 틀립니다.");
				}
			}
			
			else if(menu==3) {
				System.out.println("====회원 가입=====");
				System.out.println("가입할 ID 입력 :  ");
				String id = sc.next();
				System.out.println("패스워드 입력 : ");
				String pw = sc.next();
				MiniDTO mini = new MiniDTO(id,pw);
				row = mc.Signup(mini);
				
				if(row>0) {
					System.out.println("회원 가입 완료");
				}
				else {
					System.out.println("회원 가입 오류");
				}
			}
			else if(menu==4) {
				System.out.println("ID 입력 : ");
				String id = sc.next();
				MiniDTO minimo = new MiniDTO(id);
				minimo = mc.Rank(minimo);
				System.out.println(minimo.getName() + "/"+minimo. + "/" );
				
			}
			else if(menu==5) {
				System.out.println("게임 종료");
				break;
			}
		}
	}

}

