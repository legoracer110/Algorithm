package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO1828_냉장고 {

	static class Chemicals implements Comparable<Chemicals> {
		int low;
		int high;

		public Chemicals(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(Chemicals c) {
			int value = this.high - c.high;

			if (value != 0)
				return value;

			return this.low - c.low;
		}

	}

	static int N;
	static Chemicals[] chemicals;

	static int answer;

	static void solution() {
		Arrays.sort(chemicals);

		int temp = chemicals[0].high;
		answer = 1;

		for (int i = 1; i < N; i++) {
			if (chemicals[i].low > temp) {
				temp = chemicals[i].high;
				answer++;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		chemicals = new Chemicals[N];
//		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int low = Integer.parseInt(st.nextToken());
			int high = Integer.parseInt(st.nextToken());
			Chemicals c = new Chemicals(low, high);
			chemicals[i] = c;
		}

		solution();

		System.out.println(answer);
	}

}
