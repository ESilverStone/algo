import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17144_미세먼지잘가고 {
	
	// 상 우 하 좌
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static int[][] map;
	static int[] cleaner;
	static int r;
	static int c;
	static int t;
	
	static void func(int time) {
		
		if(time == t) return;
		
		// 1. 먼지의 확산
		int[][] temp = spread();
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {			
				map[i][j] += temp[i][j];
			}
		}
		
		// 2. 바람 슈우웅해서 이동
		// 바람 역방향으로 돌면서 스왑해줌
		wind(cleaner[0]-1, cleaner[1], true);
		wind(cleaner[0], cleaner[1], false);

		// 3. 공기청정기로 들어온거 제거
		// 위에서 함
		
		// 4. t증가시켜서 사이클 돌림
		func(++time);	
		// func(time++)처럼 하면 안됨
	}
	
	static void wind(int i, int j, boolean clockwise) {
				
		// clockwise가 true면 시계방향으로 스왑해줄 것
		if(clockwise) {
			
			// 공기청정기로 들어오는 곳 0으로 전환
			map[i-1][j] = 0; 
			
			int curI = i - 1;
			int curJ = j;
			
			int nexI = i - 2;
			int nexJ = j;
			
			int dir = 0;
			
			while(!(nexI == i && nexJ == j)) {
			
				if(nexI < 0 || nexJ < 0 || nexI >= i+1 || nexJ >= c) {
					// 방향 전환
					dir++;
					dir %= 4;
					
					nexI = curI + dr[dir];
					nexJ = curJ + dc[dir];
				}
				swap(nexI, nexJ, curI, curJ);

				nexI += dr[dir];
				nexJ += dc[dir];
				curI += dr[dir];
				curJ += dc[dir];	
			}
			
		} else {
			
			// 공기청정기로 들어오는 곳 0으로 전환
			map[i+1][j] = 0; 
			
			int curI = i + 1;
			int curJ = j;
			
			int nexI = i + 2;
			int nexJ = j;
			
			
			int dir = 2;
			
			while(!(nexI == i && nexJ == j)) {
				

				if(nexI < i || nexJ < 0 || nexI >= r || nexJ >= c) {
					// 방향 전환
					dir += 3;
					dir %= 4;
					
					nexI = curI + dr[dir];
					nexJ = curJ + dc[dir];
				}
				
				swap(nexI, nexJ, curI, curJ);
				
				
				nexI += dr[dir];
				nexJ += dc[dir];
				
				curI += dr[dir];
				curJ += dc[dir];
	
			}	
		}	
	}
	
	static void swap(int nexI, int nexJ, int curI, int curJ) {
		
		int temp = map[nexI][nexJ];
		map[nexI][nexJ] = map[curI][curJ];
		map[curI][curJ] = temp;
	}

	static int[][] spread() {
		int[][] temp = new int[r][c];
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				
				if(map[i][j] == 0 || map[i][j] == -1) continue;
				
				int munG = map[i][j] / 5;
				
				if(munG == 0) continue;
				
				for(int k=0; k<4; k++) {
					
					int curI = i + dr[k];
					int curJ = j + dc[k];
					
					if(curI < 0 || curJ < 0 || curI >= r || curJ >= c || map[curI][curJ] == -1) continue;
					
					temp[curI][curJ] += munG;
					temp[i][j] -= munG;
					
					
				}
			}
		}
		
		return temp;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		cleaner = new int[2];
		
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// 공기청정기의 위치 저장 > 아래쪽 위치 저장될 것
				if(map[i][j] == -1) {
					cleaner[0] = i;
					cleaner[1] = j;
				}
			}
		}
		
		func(0);
		
		int sum = 0;
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {				
				sum += map[i][j];
			}
		}
		
		System.out.println(sum + 2);	
	}
}
