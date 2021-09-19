package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ3040_SnowWhite {

	static String tc1 = "7\r\n" + "8\r\n" + "10\r\n" + "13\r\n" + "15\r\n" + "19\r\n" + "20\r\n" + "23\r\n" + "25";

	static String tc2 = "8\r\n" + "6\r\n" + "5\r\n" + "1\r\n" + "37\r\n" + "30\r\n" + "28\r\n" + "22\r\n" + "36";

	static int[] nanjang = new int[7];

	static void solution(int[] member, boolean[] check, int cnt, int total) {

		if (cnt == 2 && total == 100) {
			// 2마리 아닌 놈 적발 (아닌놈 check[i] = true)
			int index = 0;
			for (int i = 0; i < 9; i++) {
				if (!check[i]) {
					nanjang[index++] = member[i];
				}
			}
			return;
		}

		for (int i = 0; i < 9; i++) {

			if (check[i]) {
				continue;
			}

			check[i] = true;
			solution(member, check, cnt + 1, total - member[i]);
			check[i] = false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(tc2));

		StringBuilder sb = new StringBuilder();

		int[] members = new int[9];
		boolean[] check = new boolean[9];

		int total = 0;

		for (int i = 0; i < 9; i++) {
			members[i] = Integer.parseInt(in.readLine());
			total += members[i];
		}

		solution(members, check, 0, total);

		for (int i = 0; i < 7; i++) {
			sb.append(nanjang[i]).append("\n");
		}

		System.out.println(sb.toString());
	}

}
