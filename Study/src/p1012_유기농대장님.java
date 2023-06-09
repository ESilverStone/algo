

import java.util.Arrays;
import java.util.Scanner;

public class p1012_유기농대장님 {
	static int[] dy = {-1, 1,0,0};
	static int[] dx = {0,0,-1,1};
	static int M, N;
	static int[][] arr;
	static boolean[][] visited;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T= sc.nextInt();
				
		//테스트케이스 반복
		for (int tc=1; tc<=T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			int k = sc.nextInt();
			
			cnt = 0;
			arr = new int[N][M];
			visited = new boolean[N][M];
			
			for (int i=0; i<k; i++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				
				arr[Y][X] = 1;
			}
			
			//찾기
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (arr[i][j] ==1 && !visited[i][j] ) {
						cnt+=DFS(i, j);
					}
				}
			}

			System.out.println(cnt);
			
		}
	}
	
	
	static int DFS (int r, int c) {
		
//		if (arr[i][j] ==0) return 0;
//		&& !visited[i][j] ) {
		
		
		visited[r][c] = true;
		
		for (int i=0; i<4; i++) {
			int nr = r + dy[i];
			int nc = c + dx[i];
			
			if (nr>=0 && nr<N && nc>=0 && nc<M)
				if(!visited[nr][nc] && arr[nr][nc] !=0) {
				DFS(nr, nc);
			}
		}
		
		return 1;
	}
}