package com.algo.imtest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2605_LineUp {

	static String input = "5\r\n" + "0 1 1 3 2";

	static int size;
	static int[] tickets;

	static ArrayList<Integer> students;

	static void solution() {
		int index = 0;
		while (index < size) {

			int tmp = index;
			tmp -= tickets[index];
			students.add(tmp, index + 1);

			index++;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input));

		size = Integer.parseInt(in.readLine());
		tickets = new int[size];
		students = new ArrayList<Integer>();

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < size; i++) {
			tickets[i] = Integer.parseInt(st.nextToken());
		}

		solution();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < size; i++) {
			sb.append(students.get(i)).append(" ");
		}

		System.out.println(sb.toString());
	}

}
