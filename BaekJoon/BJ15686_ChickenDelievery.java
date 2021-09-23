package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ15686_ChickenDelievery {

	static String input1 = "5 3\r\n" + "0 0 1 0 0\r\n" + "0 0 2 0 1\r\n" + "0 1 2 0 0\r\n" + "0 0 1 0 0\r\n"
			+ "0 0 0 0 2";
	static String input2 = "5 2\r\n" + "0 2 0 1 0\r\n" + "1 0 1 0 0\r\n" + "0 0 0 0 0\r\n" + "2 0 0 1 1\r\n"
			+ "2 2 0 1 2";
	static String input3 = "5 1\r\n" + "1 2 0 0 0\r\n" + "1 2 0 0 0\r\n" + "1 2 0 0 0\r\n" + "1 2 0 0 0\r\n"
			+ "1 2 0 0 0";
	static String input4 = "5 1\r\n" + "1 2 0 2 1\r\n" + "1 2 0 2 1\r\n" + "1 2 0 2 1\r\n" + "1 2 0 2 1\r\n"
			+ "1 2 0 2 1";

	static int N, M;

	static int[][] map;

	static List<int[]> chickenHouse;
	static int[][] chickens;

	static int answer;

	static int getChickenDist(int[][] copy_map, int x, int y) {
		int dist = 0;

		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][N];
		q.add(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] currPos = q.poll();

			if (copy_map[currPos[0]][currPos[1]] == 2) {

				dist = Math.abs(currPos[0] - x) + Math.abs(currPos[1] - y);
//				System.out.println("(" + x + "," + y + ") 치킨dist = " + dist);
				return dist;
			}

			if (currPos[0] - 1 >= 0 && !visited[currPos[0] - 1][currPos[1]]) {
				visited[currPos[0] - 1][currPos[1]] = true;
				q.add(new int[] { currPos[0] - 1, currPos[1] });
			}
			if (currPos[0] + 1 < N && !visited[currPos[0] + 1][currPos[1]]) {
				visited[currPos[0] + 1][y] = true;
				q.add(new int[] { currPos[0] + 1, currPos[1] });
			}
			if (currPos[1] - 1 >= 0 && !visited[currPos[0]][currPos[1] - 1]) {
				visited[currPos[0]][currPos[1] - 1] = true;
				q.add(new int[] { currPos[0], currPos[1] - 1 });
			}
			if (currPos[1] + 1 < N && !visited[currPos[0]][currPos[1] + 1]) {
				visited[currPos[0]][currPos[1] + 1] = true;
				q.add(new int[] { currPos[0], currPos[1] + 1 });
			}
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (visited[i][j])
//					System.out.print("■");
//				else
//					System.out.print("□");
//			}
//			System.out.println();
//		}

		return dist;
	}

	static void showMap(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	static void comb(int start, int cnt) {
		if (cnt == M) {

//			System.out.println("!!");

			int[][] copy_map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0 || map[i][j] == 1) {
						copy_map[i][j] = map[i][j];
					} else {
						copy_map[i][j] = 0;
					}
				}
			}

			for (int i = 0; i < M; i++) {
				copy_map[chickens[i][0]][chickens[i][1]] = 2;
			}

//			showMap(copy_map);

			int tmpAnswer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (copy_map[i][j] == 1) {
						tmpAnswer += getChickenDist(copy_map, i, j);
					}
				}
			}
//			System.out.println(tmpAnswer + " / 현재까지 최소 : " + answer);
			answer = Math.min(answer, tmpAnswer);
			return;
		}

		for (int i = start; i < chickenHouse.size(); i++) {
			chickens[cnt][0] = chickenHouse.get(i)[0];
			chickens[cnt][1] = chickenHouse.get(i)[1];
			comb(i + 1, cnt + 1);
		}
	}

	static void solution() {

		chickens = new int[M][2];

		comb(0, 0);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input4));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		chickenHouse = new ArrayList<int[]>();

		answer = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					chickenHouse.add(new int[] { i, j });
				}
			}
		}

		solution();

		System.out.println(answer);
	}

}
