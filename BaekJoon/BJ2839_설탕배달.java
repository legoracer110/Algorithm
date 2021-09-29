package com.ssafy.algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2839_설탕배달 {

	static int answer;

	static int weight;

	static void solution() {
		int three = 0;
		int five = 0;

		five = weight / 5;
		while (five >= 0) {
			int tmp = weight - five * 5;
			if (tmp % 3 == 0) {
				three = tmp / 3;
				answer = five + three;
				return;
			}
			five--;
		}

		answer = -1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		weight = Integer.parseInt(in.readLine());

		solution();

		System.out.println(answer);
	}

}
