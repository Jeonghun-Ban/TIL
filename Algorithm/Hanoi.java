import java.util.Scanner;

public class Hanoi {

	public int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("���� ������ �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		Hanoi hanoi = new Hanoi();
		hanoi.move(n, "1", "2", "3");
		hanoi.showCount();
		
	}
	
	public void move(int n, String source, String auxiliary, String destination) {
		if (n==1) {
			System.out.println(n+" : "+source+" -> "+destination);
			++count;
		} else {
			move(n-1, source, destination, auxiliary); // �ҽ� ��� -> ���� ���
			System.out.println(n+" : "+source+" -> "+destination); // ������ ���� �������� �̵�(��ü ���Ǽ��� 1�� �ƴҶ�)
			++count;
			move(n-1, auxiliary, source, destination); // ���� ���-> ������ ���
		}
	}
	
	public void showCount() {
		System.out.println("�̵� Ƚ��: " + count);
	}
	
}
