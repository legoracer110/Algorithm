package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA5215_HamburgerDiet {

	private static String input = "1\r\n" + "5 1000\r\n" + "100 200\r\n" + "300 500\r\n" + "250 300\r\n"
			+ "500 1000\r\n" + "400 400";

	static int solution(int[][] ing, boolean[] visited, int num, int limit, int cnt, int[] points) {
		int answer = points[0];

		if (points[1] > limit) {
			return -1; // 제한 칼로리 초과시 무효 return;
		}

		if (cnt == num) {
			return answer;
		}

		visited[cnt] = false;
		answer = solution(ing, visited, num, limit, cnt + 1, points);

		visited[cnt] = true;
		int[] addPoints = new int[2];
		addPoints[0] = points[0] + ing[cnt][0];
		addPoints[1] = points[1] + ing[cnt][1];
		int tmp = solution(ing, visited, num, limit, cnt + 1, addPoints);

		if (answer < tmp)
			answer = tmp;

		return answer;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input));

		int testCase = Integer.parseInt(in.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= testCase; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			int num = Integer.parseInt(st.nextToken()); // 재료 수
			int limit = Integer.parseInt(st.nextToken()); // 칼로리 제한

			int[][] ing = new int[num][2];
			boolean[] visited = new boolean[num];

			for (int i = 0; i < num; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				ing[i][0] = Integer.parseInt(st.nextToken()); // 맛 점수
				ing[i][1] = Integer.parseInt(st.nextToken()); // 칼로리 점수
			}

			int[] points = new int[2]; // 조합점수 (맛점수/칼로리합)

			sb.append(solution(ing, visited, num, limit, 0, points)).append("\n");

		}
		System.out.println(sb.toString());
	}

}
