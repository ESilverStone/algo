package 보드게임컵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p27163_벚꽃내리는시대에결투를 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 공격 수
		int A = Integer.parseInt(st.nextToken());	// 아머
		int L = Integer.parseInt(st.nextToken());	// 라이프
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int X = Integer.parseInt(st.nextToken());	
			int Y = Integer.parseInt(st.nextToken());
		}
		
	}
}
