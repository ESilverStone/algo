import java.util.Scanner;
import java.util.Stack;

public class p5656_벽돌깨기 {
	
	public static int N;
	public static int W;
	public static int H;
	public static int min;
	public static int[][] map;
		
	public static void func(int cnt, int score) {
		// 탈출 조건
		if(cnt == N) {
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j] != 0) score++;
				}
			}

			if(min > score) min = score;
			
			return;
		}
		
		
		for(int j=0; j<W; j++) {
						
			int bombS = -1;
			
			// 해당 인덱스에서 세로로 검사를 한다. 
			for(int i=0; i<H; i++) {
				
				// 0이 아닌 지역 발견시 붐 시작 위치를 정한다.
				if(map[i][j] != 0) {
					bombS = i;
					break;
				}	
			}
			
			// 시작위치가 갱신되지 않았다면(다 0이라는 소리)해당 인덱스에 붐-!할 이유가 없다.
			if(bombS == -1) continue;
			
			// deep copy
			int[][] copy = deepcopy();
			
			// 붐붐붐
			bomb(bombS,j);
			// 중력 작업
			gravity(map);
					
			func(cnt+1,score);
					
			// 터트린거 복구
			map = copy;
		
		}	
	}
	
	public static int[][] deepcopy() {
		int[][] arr = new int[H][W];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				arr[i][j] = map[i][j];
			}
		}
		return arr;	
	}
	
	public static int[] vi = {-1,0,1,0};
	public static int[] vj = {0,1,0,-1};
		
	public static void bomb(int i, int j) {
		
		// 1. 해당 위치의 숫자를 파악
		int rng = map[i][j];
		
		// **바로 0으로 전환**
		map[i][j] = 0;
		
		// 2. 4방향으로 rng(범위)만큼 퍼져나간다.
		for(int v=0; v<4; v++) {
			
			for(int r=0; r<rng; r++) {
				
				int curI = i + vi[v] * r;
				int curJ = j + vj[v] * r;
				
				if(curI < 0 || curJ < 0 || curI >= H || curJ >= W) break;
				
				if(map[curI][curJ] == 0) continue;
				// 0이 아닌경우
				else {
					// 3. 해당 블록을 터트려 0으로 만들고 재귀를 돌린다. 
					bomb(curI, curJ);
				}	
			}	
		}	
	}
	
	// 중력의 히므로
	public static void gravity(int[][] map) {
		
		for(int j=0; j<W; j++) {
			
			for(int i=H-1; i>0; i--) {
			
				if(map[i][j] != 0) continue;
				
				for(int k=i-1; k>=0; k--) {
					if(map[k][j] != 0) {
						int temp = map[k][j];
						map[k][j] = map[i][j];
						map[i][j] = temp;
						
						break;						
					}
				}
			}	
		}
	}
	
	
//	public static i reset(int[][] temp, int[][] map) {
//		map = temp;
//		
////		for(int ii=0; ii<H; ii++) {
////			for(int jj=0; jj<W; jj++) {
////				System.out.print(map[ii][jj]+" ");
////			}
////			System.out.println();
////		}
////		System.out.println();
//	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			
			map = new int[H][W];
			
			// 입력
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			min = Integer.MAX_VALUE;		
			
			func(0, 0);
			if(min == Integer.MAX_VALUE) 	System.out.println("#"+t+" "+0);
			else 							System.out.println("#"+t+" "+min);
		}
		
	}
}
