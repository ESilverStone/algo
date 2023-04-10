import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p1629_���� {
	public static long a;
	public static long c;
	
	// key : b, val : a�� b �����Ѱ�
	public static Map<Long, Long> map = new HashMap<>();
	
	public static long func(long b) {
			
		// Ű���� ����Ǿ� ������ �׿� �ش�Ǵ� ����� ���
		if(map.containsKey(b)) {
			return map.get(b);
		}
		
		long temp = func(b/2) % c;
			
		// b�� ¦���� ������ ������.
		if(b % 2 == 0) {
			long num1 = temp * temp % c;
			map.put(b, num1);
			return num1;
		} 
		// b�� Ȧ���� 1���� ������ ������.
		else {		
			long num2 = (temp * temp % c) * a;
			map.put(b, num2);
			return num2;
		}	
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		a = sc.nextLong();
		long b = sc.nextLong();
		c = sc.nextLong();
		
		a %= c;
		
		// a�� bȸ��ŭ ���� > c�� ������
		map.put((long) 1, a);
		
		long result = func(b);
		
		result %= c;
		
		System.out.println(result);	
	}
}
