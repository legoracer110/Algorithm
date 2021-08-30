package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA3499_PerfectShuffle {

	static String input = "3\r\n" + "6\r\n" + "A B C D E F\r\n" + "4\r\n" + "JACK QUEEN KING ACE\r\n" + "5\r\n"
			+ "ALAKIR ALEXSTRASZA DR-BOOM LORD-JARAXXUS AVIANA";

	private static String[] shuffled(String[] arr1, String[] arr2, int size) {
		String[] answer = new String[size];

		int index = 0;
		int index2 = 0;
		while (index < size) {
			if (index < arr1.length) {
				answer[index2] = arr1[index];
				index2++;
			}
			if (index < arr2.length) {
				answer[index2] = arr2[index];
				index2++;
			}
			index++;
		}

		return answer;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input));

		int tcn = Integer.parseInt(in.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= tcn; tc++) {
			sb.append("#").append(tc).append(" ");
			int num = Integer.parseInt(in.readLine());
			int tmp;
			if (num % 2 == 0) {
				// 카드 개수 짝수면
				tmp = num / 2;
			} else {
				tmp = num / 2 + 1;
			}

			String[] deck1 = new String[tmp];
			String[] deck2 = new String[num / 2];

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			for (int i = 0; i < tmp; i++) {
				// deck1 세팅
				deck1[i] = st.nextToken();
			}
			for (int i = 0; i < num / 2; i++) {
				// deck2 세팅
				deck2[i] = st.nextToken();
			}

			for (int i = 0; i < num; i++) {
				sb.append(shuffled(deck1, deck2, num)[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
