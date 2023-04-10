import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2096_내려가기 {
	
	static int[][] map;
	static int N ;
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	static void dfs(int j, int layer, int sum) {
		
		// 탈출 조건
		if(layer == N) {
			if(max < sum) max = sum;
			if(min > sum) min = sum;

			return;
		}
		
		// 해당 숫자를 더한다.
		sum += map[layer][j];
		
		for(int k=-1; k<=1; k++) {
			
			int newJ = j + k;

			// 배열을 넘어간 경우
			if(newJ < 0 || newJ >= N) continue;
			
			dfs(newJ, layer+1, sum);	
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 스타트 장소만 main에서 정해서 보내기
		for(int i=0; i<N; i++) {
			dfs(i, 0, 0);
		}
		
		System.out.println(max +" "+ min);
	}
}
