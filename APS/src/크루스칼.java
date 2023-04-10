import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ũ�罺Į {
	static int[] p; //��ǥ�� ������ �迭
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); //V : ������ ����, 0���� ���� �Ѵ�!
		int E = sc.nextInt(); //E : ������ ��
		
		
		//������ �����ϱ� ���ؼ� Ŭ������ ����� ���� ������
		//�迭�� �̿��ؼ� ������ �ϰڴ�. 0 : �������� / 1 : ������ / 2 : ����ġ
		int[][] edges = new int[E][3];
		
		for(int i = 0 ; i<E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}//�Է³�
		
		
		//ũ�罺Į 1�ܰ� : ������ �����Ѵ�. (��������)
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		//ũ�罺Į 2�ܰ� : V-1���� ������ �̴µ�, ����Ŭ�� �߻����ϴ� ģ����θ� �̴´�.
		p = new int[V];
		//make-set ����. (�� �ڽ��� ��ǥ�� �ʱ�ȭ ����.
		for(int i = 0 ; i<V; i++) {
//			makeset(i);
			p[i] = i;
		}//makeset ���߾�~
		
		int ans = 0; //�ּҺ���� ������ ģ��~~
		int pick = 0; //���� ���� ������ ��~~
		//��� ������ ��ȸ �ϸ鼭 �n
		//while�� �غ���
		for(int i = 0; i < E; i++) {
			//i��°�� ������ �̾� �� ������ ��ǥ�� Ȯ���ϰڴ�.
//			int x = edges[i][0];
//			int y = edges[i][1];
			int px = findset(edges[i][0]);
			int py = findset(edges[i][1]);
			
			//�̰� �����ǹ�?
//			if(findset(x) != findset(y)) {
			if(px!= py) {
//				union(x, y);
				union(px, py);
				ans += edges[i][2];
				pick++;
			}
			
			if(pick == (V-1)) break;
		}
		

		System.out.println(ans);
		
	}
	
	//��ǥ�� ��ȯ�ؾ� �ϹǷ�~~
	static int findset(int x) {
		//���� ���
//		if(x == p[x]) return x;
//		return findset(p[x]);
		//�о� ��������~~ ���� 
		if(x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
//		p[findset(y)] = findset(x); //rank �̷��� ��� ���߰� �׳� y�� ������ x������
		p[y] = x; //������ �ƴ����� �̹��������� ������ �κ�
		//�㳪 ���̷��� �ᵵ �Ǵ����� ����� �غ��� �˰� ��ߵǴ� �κ�
	}
	
	static void makeset(int x) {
		p[x] = x;
		//Rank�� ���� ���� �ʰڽ��ϴ�
	}
	
	
	static String input = "7 11\r\n" + 
			"0 1 32\r\n" + 
			"0 2 31\r\n" + 
			"0 5 60\r\n" + 
			"0 6 51\r\n" + 
			"1 2 21\r\n" + 
			"2 4 46\r\n" + 
			"2 6 25\r\n" + 
			"3 4 34\r\n" + 
			"3 5 18\r\n" + 
			"4 5 40\r\n" + 
			"4 6 51\r\n" + 
			"\r\n";
}
