import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1267_�۾����� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// ���� ����� ���� sb
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<10; t++) {
				
			// �׽�Ʈ ���̽�
			sb.append("#"+(t+1)+" ");
			
			int v = sc.nextInt();
			int e = sc.nextInt();
			
			// ���������� ���� �迭
			int[] arr = new int[v+1];
			
			// ���� Ȯ���� ���� �迭
			int[][] beside = new int[v+1][v+1];
			
			// ���� ������ ���� ť
			Queue<Integer> que = new LinkedList<>();
					
			// �Է�
			for(int i=0; i<e; i++) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				
				// ���ԵǴ� �ѹ� ī����
				arr[n2]++;
				
				// ���� ���� üũ + ������ ���� n1 > n2
				beside[n1][n2] = 1;
			}
			
			// 1. indegree�� 0�� ��� ����
			for(int i=1; i<=v; i++) {
				if(arr[i] == 0) que.add(i);
			}
			
			// 2. bfs w que
			while(!que.isEmpty()) {
				
				int num = que.poll();
				sb.append(num+" ");
				
				for(int i=1; i<=v; i++) {
					
					// ������ ���鸸
					if(beside[num][i] != 1) continue;
					
					// �湮ó��
					arr[i]--;
					
					if(arr[i] == 0) que.add(i);
					
				}
			}
			sb.append("\n");
		}
		// ���
		System.out.println(sb);
	}
}
