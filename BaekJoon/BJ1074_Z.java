package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ1074_Z {

	static String input1 = "2 3 1";
	static String input2 = "3 7 7";

	static int N, r, c;
	static int[][] arr;

	static int answer;

	static void solution(int size, int startX, int startY) {

		if (startX == r && startY == c) {
			System.out.println(answer);
			System.exit(0);
		}

		if (startX <= r && r < (startX + size) && startY <= c && c < (startY + size)) {
			solution(size / 2, startX, startY);
			solution(size / 2, startX, startY + size / 2);
			solution(size / 2, startX + size / 2, startY);
			solution(size / 2, startX + size / 2, startY + size / 2);
		} else {
			answer += size * size;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input2));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int size = (int) (Math.pow(2, N));

		solution(size, 0, 0);
	}

}
