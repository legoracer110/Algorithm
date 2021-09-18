package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ2961_DeliciousFood {

	static int answer = 1000000000;

	static String input1 = "1\r\n" + "3 10";

	static String input2 = "2\r\n" + "3 8\r\n" + "5 8";

	static String input3 = "4\r\n" + "1 7\r\n" + "2 6\r\n" + "3 8\r\n" + "4 9";

	static void solution(int[][] ing, int num) {

		int numOfIng = 1; // 사용할 재료의 개수

		while (numOfIng <= num) {
			int[] p = new int[num];

			int cnt = 0;

			while (++cnt <= numOfIng) {
				p[num - cnt] = 1;
			}

			do {
				int shin = 0; // 신맛 합계
				int ssun = 0; // 쓴맛 합계

				int diff = 0; // 신맛 쓴맛 차이

				for (int i = 0; i < num; i++) {
					if (p[i] == 1) {
						if (shin == 0)
							shin += ing[i][0];
						else
							shin *= ing[i][0];
						ssun += ing[i][1];

//						System.out.print((i + 1) + "번 ");
					}
				}

				diff = shin - ssun;
				if (diff < 0) {
					diff *= -1;
				}
//				System.out.println(" // 신맛 : " + shin + ", 쓴맛 : " + ssun + ", 차이 : " + diff);
				if (answer > diff)
					answer = diff;
			} while (np(p));

			numOfIng++;
		}
	}

	private static boolean np(int[] numbers) {
		int N = numbers.length;

		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i;
		if (i == 0)
			return false;

		int j = N - 1;
		while (numbers[i - 1] >= numbers[j])
			--j;
		swap(numbers, i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(numbers, i++, k--);
		}
		return true;
	}

	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input3));

		int num = Integer.parseInt(in.readLine());

		int[][] ing = new int[num][2]; // 0 : 신맛 1 : 쓴맛

		for (int i = 0; i < num; i++) {

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			int shin = Integer.parseInt(st.nextToken());
			int ssun = Integer.parseInt(st.nextToken());

			ing[i][0] = shin;
			ing[i][1] = ssun;
		}

		solution(ing, num);

		System.out.println(answer);
	}

}
