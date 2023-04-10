import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p1629_곱셈 {
	public static long a;
	public static long c;
	
	// key : b, val : a를 b 제곱한거
	public static Map<Long, Long> map = new HashMap<>();
	
	public static long func(long b) {
			
		// 키값이 저장되어 있으면 그에 해당되는 밸류값 사용
		if(map.containsKey(b)) {
			return map.get(b);
		}
		
		long temp = func(b/2) % c;
			
		// b가 짝수면 반으로 나눈다.
		if(b % 2 == 0) {
			long num1 = temp * temp % c;
			map.put(b, num1);
			return num1;
		} 
		// b가 홀수면 1때고 반으로 나눈다.
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
		
		// a를 b회만큼 제곱 > c로 나누기
		map.put((long) 1, a);
		
		long result = func(b);
		
		result %= c;
		
		System.out.println(result);	
	}
}
