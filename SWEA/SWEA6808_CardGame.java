package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA6808_CardGame {

	static String input = "4\r\n" + "1 3 5 7 9 11 13 15 17\r\n" + "18 16 14 12 10 8 6 4 2\r\n"
			+ "13 17 9 5 18 7 11 1 15\r\n" + "1 6 7 9 12 13 15 17 18";

	static int ky_win = 0;
	static int iy_win = 0;

	static void solution(int[] ky, int[] iy, boolean[] iy_visited, int ky_score, int iy_score, int round) {
		if (round == 9) {
			if (ky_score > iy_score)
				ky_win++;
			else if (ky_score < iy_score)
				iy_win++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			// 모든 경우의 수 방문
			if (iy_visited[i]) {
				continue;
			}

			iy_visited[i] = true;

			if (ky[round] > iy[i])
				solution(ky, iy, iy_visited, ky_score + ky[round] + iy[i], iy_score, round + 1);
			else if (ky[round] < iy[i])
				solution(ky, iy, iy_visited, ky_score, iy_score + ky[round] + iy[i], round + 1);

			iy_visited[i] = false;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

//		in = new BufferedReader(new StringReader(input));

		int testCase = Integer.parseInt(in.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= testCase; tc++) {
			sb.append("#").append(tc).append(" ");
			ky_win = 0;
			iy_win = 0;

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			int[] ky = new int[9];
			int[] iy = new int[9];

			boolean[] iy_visited = new boolean[9];

			int index = 0;

			for (int i = 0; i < 9; i++)
				ky[index++] = Integer.parseInt(st.nextToken());

			int[] ky_copy = ky.clone();
			Arrays.sort(ky_copy);

			index = 0;
			int index2 = 0;
			for (int i = 1; i <= 18; i++) {
				if (index >= 9 || ky_copy[index] != i) {
					iy[index2] = i;
					if (index2 < 8)
						index2++;
				} else {
					index++;
				}
			}
			solution(ky, iy, iy_visited, 0, 0, 0);

			sb.append(ky_win).append(" ").append(iy_win).append("\n");
		}
		System.out.println(sb.toString());
	}

}
