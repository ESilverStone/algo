import java.util.Scanner;

public class p1949_등산로 {
	
	// 상 하 좌 우
	public static int[] vi = {-1,1,0,0};
	public static int[] vj = {0,0,-1,1};
	
	public static int[][] map;
	public static boolean[][] visit;
	
	public static boolean use;
	public static int N;
	public static int K;
	public static int max;
	
	public static void dfs(int i, int j, int cnt) {
		
		// 현재 높이
		int height = map[i][j];
		
		for(int v=0; v<4; v++) {
			int curI = i + vi[v];
			int curJ = j + vj[v];
			
			// 배열을 넘어갈 경우
			if(curI < 0 || curJ < 0 || curI >= N || curJ >= N) continue;
			
			// 이미 방문한 곳이라면
			if(visit[curI][curJ]) continue;
			
			// 검사. 즤이이이이잉
			// 현재 높이보다 낮다 > 즉 시 이 동
			if(map[curI][curJ] < height) {
				
				visit[curI][curJ] = true;
				dfs(curI, curJ, cnt+1);
				visit[curI][curJ] = false;
			}
			// 현재 높이보다 높거나 같다. > k 일단 써
			else {
				// k펀치를 아직 안썻다. 
				if(!use) {
					
					int temp = map[curI][curJ];
					
					// 헐 최대 k만큼이었음
					// 그럼 가능한 최소를 빼는게 좋다. 
					map[curI][curJ] = (map[curI][curJ] - K < height) ? height-1 : map[curI][curJ];
					
			
					// 이제야 더 낮아졌다면 이동한다.
					if(map[curI][curJ] < height) {
						
						use = true;					// 작업
						visit[curI][curJ] = true;
						
						dfs(curI, curJ, cnt+1);		// 재귀
						
						visit[curI][curJ] = false;	// 복구
						use = false;		
					}
					
					// 복구요 2
					map[curI][curJ] = temp;
				}
			}
		}
		if(max < cnt) max = cnt;	
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[N][N];
			int top = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					
					// 가장 높은 봉우리 찾기
					if(top < map[i][j]) top = map[i][j];
				}
			}
			
			// 방문 체크 용
			visit = new boolean[N][N];
			
			int result = -1;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					// 초기화
					visit[i][j] = true;
					use = false;
					max = Integer.MIN_VALUE;
					
					// 가장 높은 봉우리에서 dfs ㄱㄱ
					if(top == map[i][j]) {
						dfs(i,j,1);
						if(result < max) result = max;
					}
					
					visit[i][j] = false;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}	
}
