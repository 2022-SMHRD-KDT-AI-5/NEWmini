import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class test11 {
	ArrayList<Answer> listhard = new ArrayList<Answer>();
	ArrayList<Answer> listeasy = new ArrayList<Answer>();
	ArrayList<Answer> listnomal = new ArrayList<Answer>();
	PreparedStatement psmt = null;
	Connection conn = null;
	ResultSet rs = null;
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);

	int ac = rd.nextInt(99) + 1;
	int ca = 0;
	int bb = 0;
	int cc = 0;
	int dd = 1;
	int ee = 0;
	int len = listhard.get(ac).getEng().length();
	int hint_index = len - 1;
	String re ="";
while(true){
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
		} else {
			System.out.println("오답 입니다.");
			System.out.println();
			System.out.println("힌트를 사용 하시겠습니까?");
			System.out.println("힌트를 사용하시게 되면 1점찍 감소하게 됩니다.");
			System.out.println("[1] 힌트를 사용한다  [2] 문제를 다시 도전하겠다.  [3] 다음으로 넘어가겠다.");
			bb = sc.nextInt();
			if (bb == 1) {
				System.out.println("사용할 힌트를 선택해주세요");
				System.out.println("[1] 첫글자를 보겠다.  [2] 마지막글자를 보겠다. [3] 정답 다시입력.");
				cc = sc.nextInt();
				if (cc == 1) {
					System.out.println("첫글자를 확인합니다.");
					for (int i = 0; i <= ee; i++) {
						System.out.print(listhard.get(ac).getEng().charAt(i));
					}
					ee += 1;
					ca -= 1;
				} else if (cc == 2) {
					System.out.println("마지막 글자를 확인합니다.");
					String[] split_letter = listhard.get(ac).getEng().split("");
					for (int i = 0; i < len; i++) {
						if (i < hint_index)
							System.out.print(" ");
						else
							System.out.print(split_letter[i]);
					}
					if (hint_index > 0) {
						hint_index -= 1;
					}
				} else if (cc == 3) {
					System.out.println("정답 다시 입력.");
					System.out.println("정답 입력 ↓");
					System.out.println();
					re = sc.next();
				} else {
					System.out.println("잘못 입력했습니다.");
					System.out.println("이전단계로 돌아갑니다.");
				}
			} else if (bb == 2) {
				System.out.println("다시 도전");
			} else if (bb == 3) {
				break;
			} else {
				System.out.println("잘못");
			}
		}
	}
}}