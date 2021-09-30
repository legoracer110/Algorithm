package com.algo.imtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ2578_Bingo {

	static String input = "11 12 2 24 10\r\n" + "16 1 13 3 25\r\n" + "6 20 5 21 17\r\n" + "19 4 8 14 9\r\n"
			+ "22 15 7 23 18\r\n" + "5 10 7 16 2\r\n" + "4 22 8 17 13\r\n" + "3 18 1 6 25\r\n" + "12 19 23 14 21\r\n"
			+ "11 24 9 20 15";

	static int[][] board;
	static boolean[][] visited;
	static int[] callNum;

	static int answer;

	static void play() {
		// 빙고 3개 이상이면 승리

		while (answer < 25) {

			int called = callNum[answer];
			int bingos = 0;

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (board[i][j] == called)
						visited[i][j] = true;
				}
			}

			bingos = checkBingos();
			if (bingos >= 3)
				return;

			answer++;
		}
	}

	static int checkBingos() {
		int bingos = 0;

		// 가로
		for (int i = 0; i < 5; i++) {
			int tmpCnt = 0;
			for (int j = 0; j < 5; j++) {
				if (visited[i][j] == true)
					tmpCnt++;
			}
			if (tmpCnt == 5) {
				bingos++;
			}
			tmpCnt = 0;
		}

		// 세로
		for (int i = 0; i < 5; i++) {
			int tmpCnt = 0;
			for (int j = 0; j < 5; j++) {
				if (visited[j][i] == true)
					tmpCnt++;
			}
			if (tmpCnt == 5) {
				bingos++;
			}
			tmpCnt = 0;
		}

		// 대각선
		if (visited[0][0] && visited[1][1] && visited[2][2] && visited[3][3] && visited[4][4])
			bingos++;
		if (visited[0][4] && visited[1][3] && visited[2][2] && visited[3][1] && visited[4][0])
			bingos++;

		return bingos;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input));

		board = new int[5][5];
		visited = new boolean[5][5];
		callNum = new int[25];

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int index = 0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				callNum[index++] = Integer.parseInt(st.nextToken());
			}
		}

		play();

		System.out.println(answer + 1);
	}

}
