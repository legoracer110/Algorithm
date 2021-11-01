package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ1149_RGBdistance {

	static String input = "3\r\n" + "26 40 83\r\n" + "49 60 57\r\n" + "13 89 99";

	static int answer;
	static int num;

	static int[][] houses;

	static int[] houseColor;

	static int R, G, B;

	static void dfs(int cnt, int pre, int sum) {
		if (num == cnt) {
//			System.out.println(sum);
			answer = Math.min(answer, sum);
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (i != pre) {
				dfs(cnt + 1, i, sum + houses[cnt][i]);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input));

		num = Integer.parseInt(in.readLine());

		houses = new int[num][3];
		houseColor = new int[num];

		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			houses[i][0] = Integer.parseInt(st.nextToken());
			houses[i][1] = Integer.parseInt(st.nextToken());
			houses[i][2] = Integer.parseInt(st.nextToken());
		}

//		R = houses[0][0];
//		G = houses[0][1];
//		B = houses[0][2];
//		
//		for(int i=0; i<num; i++) {
//			
//		}

		answer = Integer.MAX_VALUE;

		for (int i = 0; i < 3; i++)
			dfs(1, i, houses[0][i]);

		System.out.println(answer);

	}

}
