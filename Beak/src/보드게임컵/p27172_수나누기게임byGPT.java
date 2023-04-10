package 보드게임컵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class p27172_수나누기게임byGPT {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());	// 인원수
		
		// 입력받은 값
		int[] arr = new int[n];	
		// 점수판
		int[] board = new int[n];
		
		// 0. 입력 및 최대값 설정
		int max = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		
		}
		
		// 1. 선택된 숫자들의 약수 계산 및 저장
        List<Integer>[] divisors = new List[n];
        for (int i = 0; i < n; i++) {
            divisors[i] = new ArrayList<>();
            for (int j = 1; j * j <= arr[i]; j++) {
                if (arr[i] % j == 0) {
                    divisors[i].add(j);
                    if (j != arr[i] / j) {
                        divisors[i].add(arr[i] / j);
                    }
                }
            }
        }

        // 2. 결투 및 점수 계산
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    for (int k : divisors[j]) {
                        if (k == arr[i]) {
                            scores[i]++;
                        }
                        if (k == arr[j]) {
                            scores[i]--;
                        }
                    }
                }
            }
        }
		
        // 3. 결과 출력
        for (int i = 0; i < n; i++) {
            System.out.println("Player " + arr[i] + " : " + scores[i] + " points");
        }
        
		StringBuilder sb = new StringBuilder();
		for(int i : scores) {
			sb.append(i+" ");
		}
		System.out.println(sb);
	}
}
