import java.util.Scanner;

public class p9663_NQueen {
	public static int N;
	public static int[][] arr;
	public static int cnt;
	
	public static void cal(int layer) {
		
		// 탈출 조건
		if(layer == N) {cnt++; return;}
		
		// 작업
		for(int i=0; i<N; i++) {
			
			if(check(layer,i)) continue;	// 작업중 조건을 거른다.
			
			arr[layer][i] = 1;				// 조건 통과 > 결과에 영향을 주는 행위를 한다.
			
			cal(layer+1);					// 다음 재귀로 넘어간다.
			
			arr[layer][i] = 0;				// 행위를 리셋한다. > 다른 layer에서 영향을 줄 수 있기에
		}
	}
	
	public static int[] vecJ = new int[] {-1,1,0};
	public static int[] vecI = new int[] {-1};
	
	
	public static boolean check(int layer, int idx) {
		
		int curI = 0;
		int curJ = 0;		
		
		for(int v=0; v<3; v++) {
			
			for(int n=0; n<N; n++) {
				
				curI = layer + vecI[0] * n;
				curJ = idx + vecJ[v] * n;
				
				if(curI < 0 || curI >= N || curJ < 0 || curJ >= N) break;
				
				if(arr[curI][curJ] == 1) return true;		
			}
		}
		return false;	
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 1;
		
		for(int t=0; t<T; t++) {
			
			N = sc.nextInt();
			arr = new int[N][N];
			cnt = 0;	
			
			cal(0);
			
			System.out.println(cnt);
			
		}
	}
}