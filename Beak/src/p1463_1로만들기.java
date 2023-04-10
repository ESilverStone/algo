import java.util.Scanner;

public class p1463_1로만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		
		int[] dp = new int[x+1];
		
		// 1부터 시작해서 x를 완성해나간다.
		for(int i=1; i<=x; i++) {
			
			// 1. +1하는게 기본 base
			dp[i] = dp[i-1] + 1;
			
			// 2. i가 짝수이면 *2의 가능성이 있다.
			if(i%2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
			
			// 3. i가 3의배수이면 *3의 가능성이 있다.
			if(i%3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);		
		}
		
		System.out.println(dp[x]-1);	
	}
}
