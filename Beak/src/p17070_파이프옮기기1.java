import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17070_파이프옮기기1 {
	
	public static int[][] map;
	public static int N;
	public static int cnt;
	
	// 가로 0 세로 1 대각선 2
	static int[] vi = {0,1,1};
	static int[] vj = {1,0,1};
	
	static boolean[] root;	// 가능한 루트는 true로 바꿀거임
	
	static void dfs(int startI, int startJ, int dirc) {
		
		// 탈출 조건
		if(startI == N && startJ == N) {
			cnt++;
			return;
		}

		for(int i=0; i<3; i++) {
			
			// 대각선 방향은 무조건 이전에 가로, 세로 방향으로 이동한 상태여야만 갈 수 있음
            if (dirc == 0 && i == 1 || dirc == 1 && i == 0) continue;
            
			// 갈 수 있다면 밀어
			int curI = startI + vi[i];
			int curJ = startJ + vj[i];
			
			// 벽이거나 범위를 벗어나는 경우
			if (curI > N || curJ > N || map[curI][curJ] == 1)  continue;
           
            // 대각선 방향은 주변에 벽이 있으면 이동할 수 없음
            if (i == 2 && (map[startI + 1][startJ] == 1 || map[startI][startJ + 1] == 1)) continue;
			
			dfs(curI, curJ, i);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = 0;
		root = new boolean[3];
		
		// 시작지점에서의 파이프의 끝 지점 + 처음 방향 가로(0)
		dfs(1,2,0);
		
		System.out.println(cnt);
	}
}
