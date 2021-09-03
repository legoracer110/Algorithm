package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1158_Yosepus {

	static String input = "7 3";

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input));

		StringBuilder sb = new StringBuilder("<");

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int size = Integer.parseInt(st.nextToken());
		int index = Integer.parseInt(st.nextToken()) - 1;

		ArrayList<Integer> arr = new ArrayList<Integer>();

		for (int i = 1; i <= size; i++)
			arr.add(i);

		int index2 = index;

		while (arr.size() > 0) {
			sb.append(arr.get(index2)).append(", ");
			arr.remove(index2);
			if (arr.size() == 0)
				break;

			index2 += index;

			while (index2 >= arr.size()) {
				index2 -= arr.size();
			}
		}

		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb.toString());

	}

}
