package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ2563_ColoredPaper {

	static String input = "3\n" + "3 7\n" + "15 7\n" + "5 2";

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));
		boolean[][] paper = new boolean[101][101];
		int num = Integer.parseInt(in.readLine());

		int answer = 0;

		for (int p = 0; p < num; p++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int left = Integer.parseInt(st.nextToken());
			int bottom = Integer.parseInt(st.nextToken());

			for (int i = left; i < left + 10; i++) {
				for (int j = bottom; j < bottom + 10; j++) {
					if (!paper[i][j]) {
						paper[i][j] = true;
						answer++;
					}
				}
			}
		}

		System.out.println(answer);
	}

}
