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
			System.out.print("1.���ӽ���  2.�α���  3.ȸ������  4.��ŷ���� 5.��������");
			System.out.println("==============================================");
			int menu = sc.nextInt();
			
			if(menu==1) {
			}
			
			else if(menu==2) {
				System.out.print("ID �Է� : ");
				String id = sc.next();
				System.out.println("PW �Է� : ");
				String pw = sc.next();
				MiniDTO mini = new MiniDTO(id,pw);
				mc.Login(null);
				if(row>0) {
					System.out.println("�α��εǾ����ϴ�.");
				}
				else {
					System.out.println("��й�ȣ�� Ʋ���ϴ�.");
				}
			}
			
			else if(menu==3) {
				System.out.println("====ȸ�� ����=====");
				System.out.println("������ ID �Է� :  ");
				String id = sc.next();
				System.out.println("�н����� �Է� : ");
				String pw = sc.next();
				MiniDTO mini = new MiniDTO(id,pw);
				row = mc.Signup(mini);
				
				if(row>0) {
					System.out.println("ȸ�� ���� �Ϸ�");
				}
				else {
					System.out.println("ȸ�� ���� ����");
				}
			}
			else if(menu==4) {
				System.out.println("ID �Է� : ");
				String id = sc.next();
				MiniDTO minimo = new MiniDTO(id);
				minimo = mc.Rank(minimo);
				System.out.println(minimo.getName() + "/"+minimo. + "/" );
				
			}
			else if(menu==5) {
				System.out.println("���� ����");
				break;
			}
		}
	}

}

