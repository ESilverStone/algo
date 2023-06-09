import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1976_여행가자 {
	static int[] p; // 대표를 저장할 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); 
		int M = Integer.parseInt(br.readLine()); 
		
		int[][] arr = new int[N+1][N+1];
		int[] plan = new int[M];
			
		p = new int[N+1];
		
		// 1. make-set 하자. (나 자신을 대표로 초기화 하자.
		for(int i = 1 ; i<=N; i++) {
			makeset(i);	
		}
		
		// 2. 입력 받으면서 유니온
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(arr[i][j] == 1) {
					union(i,j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		boolean poss = true;
		
		// 3. 여행계획들의 findset이 일치하는지 판단
		for(int i=0; i<M; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
			
			if(i!=0) {
				if(findset(plan[i]) != findset(plan[i-1])) {
					poss = false;
					break;
				}
			}
		}
		
		if(poss) 	System.out.println("YES");
		else		System.out.println("NO");	
	}
	
	static int findset(int x) {
		if(x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		p[findset(y)] = findset(x); //rank 이런거 고려 안했고 그냥 y를 무조건 x밑으로
		//p[y] = x; 
	}
	
	static void makeset(int x) {
		p[x] = x;
	}
}
