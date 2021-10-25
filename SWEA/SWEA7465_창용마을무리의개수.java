package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA7465_창용마을무리의개수 {

	static String input = "2\r\n" + "6 5\r\n" + "1 2\r\n" + "2 5\r\n" + "5 1\r\n" + "3 4\r\n" + "4 6\r\n" + "6 8\r\n"
			+ "1 2\r\n" + "2 5\r\n" + "5 1\r\n" + "3 4\r\n" + "4 6\r\n" + "5 4\r\n" + "2 4\r\n" + "2 3";

	static int T;
	static int N, M;

	static int[] company;
	static int[] key;

	static int answer;

	static void relation(int person1, int person2) {
		int company1 = find(person1);
		int company2 = find(person2);

		company[company2] = company1;

	}

	static int find(int person) {
		if (person == company[person]) {
			return person;
		}
		return company[person] = find(company[person]);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input));

		T = Integer.parseInt(in.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			answer = 1;

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			company = new int[N];
			key = new int[N];

			for (int i = 0; i < N; i++) {
				company[i] = i;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int person1 = Integer.parseInt(st.nextToken()) - 1;
				int person2 = Integer.parseInt(st.nextToken()) - 1;
				relation(person1, person2);
			}

			for (int i = 0; i < N; i++) {
				key[i] = find(company[i]);
			}

			Arrays.sort(key);

			for (int i = 0; i < N - 1; i++) {
				if (key[i] != key[i + 1])
					answer++;
			}

			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
