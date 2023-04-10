import java.util.Scanner;

public class p1012_유기농dfs {
	public static int[][] arr;
	public static int[][] visit;
	
	public static int[] vi = {1,0,-1,0};
	public static int[] vj = {0,-1,0,1};
	
	public static int M;
	public static int N;
	
	
	public static boolean dfs(int i, int j) {
		
		if(arr[i][j] == 0) return false;
		
		if(visit[i][j] == 1) return false;
		
		visit[i][j] = 1;
		
		for(int v=0; v<4; v++) {
			
			int setI = i + vi[v];
			int setJ = j + vj[v];
			
			if(setI < 0 || setJ < 0 || setI >= N || setJ >= M) continue;
			
			if(arr[setI][setJ] == 0) continue;
			
			if(visit[setI][setJ] == 1) continue;
			
			dfs(setI, setJ);
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			
			M = sc.nextInt();		// 가로
			N = sc.nextInt();		// 세로
			int K = sc.nextInt();		// 1의 개수
			
			arr = new int[N][M];
			visit = new int[N][M];
			
			
			for(int i=0; i<K; i++) {
				int n1 = sc.nextInt();
				int m1 = sc.nextInt();
				
				arr[m1][n1] = 1;
			}
			
			int cnt = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {	
					
					if(dfs(i,j)) cnt++;	
				}
			}
			
			System.out.println(cnt);
					
		}
	}
}