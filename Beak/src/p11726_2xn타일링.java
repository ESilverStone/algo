import java.util.Scanner;

public class p11726_2xnŸ�ϸ� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] dp = new int[n+1];
		
		dp[1] = 1;
		if(n>1) dp[2] = 2;
		
		for(int i=1; i<=n; i++) {
			
			if(i>2)
			dp[i] = (dp[i-1] + dp[i-2]) % 10007; 
		}
		
		System.out.println(dp[n]);	
	}
}	
