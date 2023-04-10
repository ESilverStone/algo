import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class point {
	
	int idx;
	int time;
	
	public point(int idx, int time) {
		this.idx = idx;
		this.time = time;
	}
}

public class p1697_숨 {
	
	public static int n;
	public static int k;
	public static int cnt;
	public static int rstTime;
	public static int[] visit;
	
	public static void bfs(int pos) {
		
		Queue<point> que = new LinkedList<>();
		
		que.add(new point(pos,0));
		
		visit[n] = 1;
		
		while(!que.isEmpty()) {
			
			point curP = que.poll();

			int curIdx = curP.idx;
			int curTime = curP.time;

			if(curIdx == k) {
				rstTime = curTime;
				return;
			}
			
			// 앞으로 한칸 이동
			if(curIdx+1>=0 && curIdx+1<=200000) {
				
				// 방문하지 않았거나 || 건너갈 위치의 시간이 지금보다 클 때
				if(visit[curIdx+1] == 0 || visit[curIdx+1] == curTime+1) {
					visit[curIdx+1] = curTime+1;
					que.add(new point(curIdx + 1, curTime + 1));
					
				}	
			}
			
			
			// 뒤로 한칸 이동
			if(curIdx-1>=0 && curIdx-1<=200000) {
				
				// 방문하지 않았거나 || 건너갈 위치의 시간이 지금보다 클 때
				if(visit[curIdx-1] == 0 || visit[curIdx-1] == curTime+1) {
					visit[curIdx-1] = curTime+1;
					que.add(new point(curIdx - 1, curTime + 1));
					
				}	
			}
			 
			
			// 순간이동
			if(curIdx*2>=0 && curIdx*2<=200000) {
				
				// 방문하지 않았거나 || 건너갈 위치의 시간이 지금보다 클 때
				if(visit[curIdx*2] == 0 || visit[curIdx*2] == curTime+1) {
					visit[curIdx*2] = curTime+1;
					que.add(new point(curIdx * 2, curTime+1));
					
				}	
			}
		}	
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		visit = new int[200001];
		
		rstTime = Integer.MAX_VALUE;
		cnt = 0;
		
		bfs(n);
		
		System.out.println(rstTime);
	
	}
}