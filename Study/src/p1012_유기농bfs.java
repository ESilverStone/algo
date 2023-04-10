import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1012_유기농bfs {
	
	public static int[] vi = {-1,1,0,0};
	public static int[] vj = {0,0,-1,1};
	public static int n;
	public static int m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t= 0; t<T; t++) {
			
			n = sc.nextInt();		// 가로
			m = sc.nextInt();		// 세로
			int k = sc.nextInt();	// 배추배추
			
			map = new int[m][n];
			visit = new boolean[m][n];
			
			// 배추 입력
			for(int i=0; i<k; i++) {
				
				int k1 = sc.nextInt();
				int k2 = sc.nextInt();
				
				map[k2][k1] = 1;
			}	
			
			cnt = 0;
			
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
			
					bfs(i,j);
				}
			}
			
			System.out.println(cnt);
			
		}
	}
	
	
	public static int[][] map;
	public static boolean[][] visit;
	
	public static int cnt;
	
	
	public static void bfs(int i, int j) {
		
		// 방문한 구역이다 > 나가기
		if(visit[i][j]) return;
		
		// 0
		if(map[i][j] == 0) return;
		
		// 방문체크
		visit[i][j] = true;
		
		// 뀨
		Queue<int[]> que = new LinkedList<int[]>(); 
		que.add(new int[] {i,j});
		
		while(!que.isEmpty()) {
			
			int[] pos = que.poll();
			
			int posI = pos[0];
			int posJ = pos[1];
			
			for(int v=0; v<4; v++) {
				
				
				int curI = posI + vi[v];
				int curJ = posJ + vj[v];
				
				// 범위 밖
				if(curI < 0 || curJ < 0 || curI >= m || curJ >= n) continue;
				
				// 이미 방문했거나 0인 구역이면..
				if(visit[curI][curJ] || map[curI][curJ]==0) continue;
				
				// 방문처리
				visit[curI][curJ] = true;
				que.add(new int[] {curI, curJ});	// bfs의 과정
				
			}	
		}
		// 한 구역 카운팅
		cnt++;
	}
}