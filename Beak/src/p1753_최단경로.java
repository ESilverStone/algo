
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class p1753_최단경로 {
	
	static class Node {
		int v, w;	// 도착 지점과 가중치
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int v, e; 				//V : 정점 , E: 간선
	static List<Node>[] adjList; 	//인접리스트
	static int[] dist; 				//최단 길이를 저장할 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 노드와 간선
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		// 시작점
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		
		// 인접 리스트
		adjList = new ArrayList[v+1];
		for(int i = 0 ; i<v; i++)
			adjList[i+1] = new ArrayList<>();
		
		// 가중치를 보관할 배열 > 최소값을 보관하기 때문에 초기화를 최대값으로 해준다.
		dist = new int[v+1];
		Arrays.fill(dist, INF);		
		
		// 간선 입력
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[a].add(new Node(b, w));	// a에서 b로가는데 가중치는 w다.
		}
		
		dijkstra(start);
			
		for(int i = 0; i < v; i++) {
			if(dist[i+1] == INF) 	System.out.println("INF");		// 시작점에서 이동할 수 없다.
			else 					System.out.println(dist[i+1]);	
		}
	}
	
	public static void dijkstra(int start) {
		boolean[] visit = new boolean[v+1];
		
		dist[start] = 0;	// 시작점에서 시작점으로 가는거 0
		
		// 노드 수 - 1 만큼 반복문을 돈다.
		for(int i=1; i<v; i++) {
			int min = INF;
			int idx = -1;
			
			// 가중치가 저장된 배열 중에 최소값을 지닌 index로 이동
			// 단, 방문하지 않았어야 한다.
			// 처음에는 start 지점이 idx가 된다.
			for(int j=1; j<=v; j++) {
				if(!visit[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			
			// 더 이상 이동할 수 없다.
			if(idx == -1) break;
			// 방문처리
			visit[idx] = true;
			
			// 해당 인덱스에 해당하는 인접리스트에 각각 arrayList가 들어있다.
			// 그리고 그 arrayList엔 Node가 저장되어있다.
			for(int j = 0 ; j< adjList[idx].size(); j++) {
				Node curr = adjList[idx].get(j);
				
				//방문하지 않았고, 연결도되었고(인접행렬일때나 해당됨),
				//이미 가지고 있는 값보다 더 굉장한 값이 있으면 갱신
				if(!visit[curr.v] && dist[curr.v] > dist[idx] + curr.w )
					dist[curr.v] = dist[idx] + curr.w; 
			}
		}
	}	
}

