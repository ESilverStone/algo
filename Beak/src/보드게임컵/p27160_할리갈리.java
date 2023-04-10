package 보드게임컵;

import java.util.Scanner;

public class p27160_할리갈리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] hali = new int[4];
		
		for(int i=0; i<N; i++) {
			
			String fruit = sc.next();
			int num = sc.nextInt();
			int idx = 0;
			
			
			switch(fruit) {
			case "BANANA" :
				idx = 0;
				break;
			case "STRAWBERRY" :
				idx = 1;
				break;
			case "LIME" :
				idx = 2;
				break;
			case "PLUM" :
				idx = 3;
				break;
			}
			
			hali[idx] += num;	
		}
		
		boolean bell = false;
		
		for(int i : hali) {
			if(i == 5) bell = true;
		}
		
		if(bell) 	System.out.println("YES");
		else 		System.out.println("NO");		
	}
}
