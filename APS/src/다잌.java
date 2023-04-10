
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class �ٟ� {
	static class Node {
		int v, w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int V, E; //V : ���� , E: ����
	static List<Node>[] adjList; //��������Ʈ
	static int[] dist; //�ִ� ���̸� ������ �迭
	
	
	public static void main(String[] args) {
		Scanner sc  = new Scanner(input);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adjList = new ArrayList[V];
		for(int i = 0 ; i<V; i++)
			adjList[i] = new ArrayList<>();
		
		dist = new int[V];
		Arrays.fill(dist, INF);
		
		//�Է� �ޱ�
		for(int i = 0 ; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			//���� �׷�������.
			adjList[A].add(new Node(B, W)); //��������Ʈ ��� �߰�
			//�Ʒ��� ���� �ڵ尡 ���� 4���� Ŀ�������� �ͼ�ġ ���� ��Ȳ�̶�� �����Ұ�
//			adjList[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		
		dijkstra(0);
		
		System.out.println(Arrays.toString(dist));
	}
	
	
	private static void dijkstra(int start) {
		boolean[] visited = new boolean[V];
		
		dist[start] = 0; //���� �������� �Ÿ��� 0
		
		for(int i = 0 ; i< V-1; i++) {
			int min = INF;
			int idx = -1;
			
			//�������� ���� ���� �� dist�� ���� ª�� ���� ���
			for(int j = 0; j<V; j++) {
				if(!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			
			if(idx == -1) break; //������ ģ���� ����.
			
			visited[idx] = true; //����
			//������ �� ������ ����
			
//			�̹���� ���ݴ� ������ ����� ��
//			for(Node node : adjList[idx]) {
//				
//			}
			
			
			for(int j = 0 ; j< adjList[idx].size(); j++) {
				Node curr = adjList[idx].get(j);
				
				//�湮���� �ʾҰ�, ���ᵵ�Ǿ���(��������϶��� �ش��),
				//�̹� ������ �ִ� ������ �� ������ ���� �̚�� ����
				if(!visited[curr.v] && dist[curr.v]> dist[idx] + curr.w )
					dist[curr.v]= dist[idx] + curr.w; 
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


	static String input = "6 11\r\n" + "0 1 4\r\n" + "0 2 2\r\n" + "0 5 25\r\n" + "1 3 8\r\n" + "1 4 7\r\n"
			+ "2 1 1\r\n" + "2 4 4\r\n" + "3 0 3\r\n" + "3 5 6\r\n" + "4 3 5\r\n" + "4 5 12\r\n" + "";
}