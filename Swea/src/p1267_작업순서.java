import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1267_작업순서 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 정답 출력을 위한 sb
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<10; t++) {
				
			// 테스트 케이스
			sb.append("#"+(t+1)+" ");
			
			int v = sc.nextInt();
			int e = sc.nextInt();
			
			// 진입차수를 담을 배열
			int[] arr = new int[v+1];
			
			// 인접 확인을 위한 배열
			int[][] beside = new int[v+1][v+1];
			
			// 위상 정렬을 위한 큐
			Queue<Integer> que = new LinkedList<>();
					
			// 입력
			for(int i=0; i<e; i++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				
				// 진입되는 넘버 카운팅
				arr[n2]++;
				
				// 인접 노드들 체크 + 방향이 존재 n1 > n2
				beside[n1][n2] = 1;
			}
			
			// 1. indegree가 0인 노드 삽입
			for(int i=1; i<=v; i++) {
				if(arr[i] == 0) que.add(i);
			}
			
			// 2. bfs w que
			while(!que.isEmpty()) {
				
				int num = que.poll();
				sb.append(num+" ");
				
				for(int i=1; i<=v; i++) {
					
					// 인접한 노드들만
					if(beside[num][i] != 1) continue;
					
					// 방문처리
					arr[i]--;
					
					if(arr[i] == 0) que.add(i);
					
				}
			}
			sb.append("\n");
		}
		// 출력
		System.out.println(sb);
	}
}
