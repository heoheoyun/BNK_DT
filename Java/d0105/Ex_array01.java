package d0105;

import java.util.Random;

public class Ex_array01 {

	public static void main(String[] args) {
		// 배열 A와 배열 B를 배열 C에 규칙에 맞게 넣기
		int[] A = {1,3,5,7,9};
		
		int[] B = {2,4,6,8,10};
		
		int[] C = new int[10];
		
		/*
		for(int i=0; i<5; i++) {
			C[i*2] = A[i];
			C[i*2+1] = B[i];
		
			System.out.print(" " + C[2*i] + " " + C[2*i+1]);
		}	
		*/
		
		for(int i=0; i<10; i++) {
			if(i%2==0) {
				C[i] = A[i/2];
			} else {
				C[i] = B[i/2];
			}
		}

		
		
		//배열 C의 합 구하기
		int sum = 0;
		for(int i=0; i<C.length; i++) {
			sum = sum + C[i];
		}
		System.out.println("배열 C의 총합 : " + sum);

		
		//C 배열 출력용 : 마지막에 , 가 안나오게 출력
		for(int i=0; i<C.length; i++) {
			System.out.print(C[i]);
			if(i==(C.length-1)) {
				System.out.println();
				continue;
			}
			System.out.print(", ");
		}
		
		//주사위(1~6)를 10번 굴렸을 때 1~6까지 몇 번 나왔는지 나오게 출력하기
		
		int n = 10000;
		
		System.out.println("육면체 주사위 "+ n +"번 굴린 결과");
		
		Random rd = new Random();
		
		int rdNum = 0;
		
		int[] cntN = new int[6];
		
		for(int i=0; i<n; i++) {
			rdNum = rd.nextInt(6)+1;
			cntN[rdNum-1] ++;
		}
		
		for(int i=0; i<cntN.length;i++) {
			System.out.println(i+1 + "이 나온 횟수 : " + cntN[i]);
		}
		
//		double sumN = 0;
//		for(int i = 0; i < cntN.length; i++) {
//		    sumN += (i + 1) * cntN[i]; // (눈의 값 * 나온 횟수)
//		}
//		double avN = sumN/n;
//		double svN = 0;
//		for(int i=0; i<cntN.length; i++) {
//			double deviation = (i + 1) - avN;
//			svN = svN + (deviation * deviation * cntN[i]);
//			}
//		svN = svN / (n-1);
//		System.out.println("표본 분산 : "+ svN);
		
		//배열 C를 거꾸로 저장하기
//		int[] D = new int[C.length];
//		for(int i = 0; i<C.length; i++) {
//			D[i] = C[i];
//		}
//		for(int i = 0; i<C.length; i++) {
//			C[i] = D[D.length-1-i];
//		}

	}
}
