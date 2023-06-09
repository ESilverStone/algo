import java.util.Scanner;

public class a형모의_수영장 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			int[] cost = new int[4];
			
			for(int i=0; i<4; i++) {
				cost[i] = sc.nextInt();
			}
			
			int[] month = new int[13];
			
			for(int i=1; i<=12; i++) {
				month[i] = sc.nextInt();		
			}
			
			
			int[] dp = new int[13];
			
			// dp?
			for(int i=1; i<=12; i++) {
				
				// 1달을 1일권으로만 보낼까 vs 1달 정기권 구매 
				// 모든 달에서 다 비교해야함
				dp[i] = Math.min(cost[0] * month[i], cost[1]) + dp[i-1];
				
				// 3달이상이면 3달치도 가능
				// 위에서 구한거 vs 3달치 계산
				if(3 <= i) {
					dp[i] = Math.min(dp[i], cost[2] + dp[i-3]);
				}
				
				// 1년 비교
				if(i == 12) {
					dp[i] = Math.min(dp[i], cost[3]);
				}	
			}		
			System.out.println("#"+(t+1)+" "+dp[12]);
		}	
	}
}
