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
		System.out.println("���� ��� ��");
		System.out.println(listhard.get(ac).getKor());
		System.out.println("���� �� ��");
		for (int i = 0; i < listhard.get(ac).getEng().length(); i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println("���� �Է� ��");
		System.out.println();
		re = sc.next();
		if (re.equals(listhard.get(ac).getEng())) {
			ca += 3;
			System.out.println("���� + 3��");
		} else {
			System.out.println("���� �Դϴ�.");
			System.out.println();
			System.out.println("��Ʈ�� ��� �Ͻðڽ��ϱ�?");
			System.out.println("��Ʈ�� ����Ͻð� �Ǹ� 1���� �����ϰ� �˴ϴ�.");
			System.out.println("[1] ��Ʈ�� ����Ѵ�  [2] ������ �ٽ� �����ϰڴ�.  [3] �������� �Ѿ�ڴ�.");
			bb = sc.nextInt();
			if (bb == 1) {
				System.out.println("����� ��Ʈ�� �������ּ���");
				System.out.println("[1] ù���ڸ� ���ڴ�.  [2] ���������ڸ� ���ڴ�. [3] ���� �ٽ��Է�.");
				cc = sc.nextInt();
				if (cc == 1) {
					System.out.println("ù���ڸ� Ȯ���մϴ�.");
					for (int i = 0; i <= ee; i++) {
						System.out.print(listhard.get(ac).getEng().charAt(i));
					}
					ee += 1;
					ca -= 1;
				} else if (cc == 2) {
					System.out.println("������ ���ڸ� Ȯ���մϴ�.");
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
					System.out.println("���� �ٽ� �Է�.");
					System.out.println("���� �Է� ��");
					System.out.println();
					re = sc.next();
				} else {
					System.out.println("�߸� �Է��߽��ϴ�.");
					System.out.println("�����ܰ�� ���ư��ϴ�.");
				}
			} else if (bb == 2) {
				System.out.println("�ٽ� ����");
			} else if (bb == 3) {
				break;
			} else {
				System.out.println("�߸�");
			}
		}
	}
}}