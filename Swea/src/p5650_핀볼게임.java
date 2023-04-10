import java.util.Scanner;

public class p5650_핀볼게임 {
	
	public static int[][] map;
	
	// 아래/왼쪽/위/오른쪽
	public static int[] vi = {1,0,-1,0};
	public static int[] vj = {0,-1,0,1};
	
	public static int score;
	public static int max;
	public static int N;
	
	public static void func(int i, int j) {
		
		// 방향을 4방향으로 전부 검사
		for(int d=0; d<4; d++) {
			
			// 초기화
			score = 0;
			int dir = d;
			int curI = i;
			int curJ = j;
			
			while(true) {
				// 현재 좌표에서 한 칸 이동(방향이 영향을 준다.)
				curI += vi[dir];
				curJ += vj[dir];
				
				// 탈출 여건에 맞는지 검사
				if(curI==i && curJ==j) break;
				
				// 벽을 만났을 경우
				if(curI < 0 || curJ < 0 || curI >= N || curJ >= N) {
					dir = wall(curI, curJ, dir);
					score++;
				}
				
				
				
				// 해당 맵을 검사해서 블럭이 있는지 체크 및
				// 그 블럭의 종류를 검사
				else if(1<=map[curI][curJ] && map[curI][curJ] <=5) {
					
					// 방향 전환
					dir = block(map[curI][curJ], dir);
					
					// 점수 증가
					score++;
				}
				// 웜홀을 만난 경우
				else if(6<=map[curI][curJ] && map[curI][curJ] <=10){
					int idx = map[curI][curJ];
					
					// map을 쭉- 검사한 후 반대편 웜홀로 이동
					out :
					for(int y=0; y<N; y++) {
						for(int x=0; x<N; x++) {
							// 같은 번호의 웜홀 중
							if(map[y][x] == idx) {
								// 같은 좌표는 거르기
								if(x == curJ && y == curI) continue;
								
								// 좌표 재설정, 방향을 그대로
								curI = y;
								curJ = x;
								break out;	// 하나 찾으면 탈출
							}	
						}
					}
				}
				// 블랙홀
				else if(map[curI][curJ] == -1) {
					//System.out.println(score+" score "+d);
					break;
				}
					
			}
			// 반복문 끝
			
			// 점수 갱신
			if(max < score) max = score;	
		}	
	}
	
	// 방향 전환기 - 벽
	public static int wall(int curI, int curJ, int dir) {
		
		// 왼쪽 벽
		if(curJ < 0) {
			return 3;
		}
		// 오른쪽 벽
		else if(curJ >= N) {
			return 1;
		}
		// 위쪽 벽
		else if(curI < 0) {
			return 0;		
		}
		// 아래쪽 벽
		else if(curI >= N) {
			return 2;	
		}
		return -1;
	}
	
	// 방향 전환기 - 블럭
	public static int block(int which, int dir) {
		
		switch(which) {
		
		case 1:
			switch(dir) {
			
			case 0:
				return 3;
			case 1:
				return 2;
			case 2:
				return 0;
			case 3:
				return 1;
			}

		case 2:
			switch(dir) {
			
			case 0:
				return 2;
			case 1:
				return 0;
			case 2:
				return 3;
			case 3:
				return 1;
			}
			
		case 3:
			switch(dir) {
			
			case 0:
				return 2;
			case 1:
				return 3;
			case 2:
				return 1;
			case 3:
				return 0;
			}
			
		case 4:
			switch(dir) {
			
			case 0:
				return 1;
			case 1:
				return 3;
			case 2:
				return 0;
			case 3:
				return 2;
			}
			
		case 5:
			switch(dir) {
			
			case 0:
				return 2;
			case 1:
				return 3;
			case 2:
				return 0;
			case 3:
				return 1;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			
			N = sc.nextInt();
			map = new int[N][N];
			
			// 입력
			// -1 : 블랙홀, 0 : 빈공간
			// 1 : 상/우, 2 : 우/하, 3 : 좌/하, 4 : 좌/상, 5 : 사각
			// 6-10 : 왐훨
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			max = Integer.MIN_VALUE;
			
			// 0인 모든 지역에서 시작해봐야한다. 
			// 방향은 4방향 모두 따져야 할 거 같다.
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					if(map[i][j] == 0) func(i,j);
				}
			}
			// 출력
			System.out.println("#"+t+" "+max);
		}
	}
}
