package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1225_PWGenerator {

	static String input = "1\r\n" + "9550 9556 9550 9553 9558 9551 9551 9551 \r\n" + "2\r\n"
			+ "2419 2418 2423 2415 2422 2419 2420 2415 \r\n" + "3\r\n" + "7834 7840 7840 7835 7841 7835 7835 7838 \r\n"
			+ "4\r\n" + "4088 4087 4090 4089 4093 4085 4090 4084 \r\n" + "5\r\n"
			+ "2945 2946 2950 2948 2942 2943 2948 2947 \r\n" + "6\r\n" + "670 667 669 671 670 670 668 671 \r\n"
			+ "7\r\n" + "8869 8869 8873 8875 8870 8872 8871 8873 \r\n" + "8\r\n"
			+ "1709 1707 1712 1712 1714 1710 1706 1712 \r\n" + "9\r\n"
			+ "10239 10248 10242 10240 10242 10242 10245 10235 \r\n" + "10\r\n"
			+ "6580 6579 6574 6580 6583 6580 6577 6581 \r\n" + "";

	static Queue<Integer> completedPW(int[] numbers) {
		Queue<Integer> pw = new LinkedList<Integer>();

		for (int i = 0; i < 8; i++) {
			pw.offer(numbers[i]);
		}

		int key = 1;

		while (true) {
//			for (int i = 0; i < 8; i++) {
//				int tmp = pw.poll();
//				System.out.print(tmp + " ");
//				pw.offer(tmp);
//			}
			key = 1;
			for (int i = 0; i < 5; i++) {
				if (pw.peek() - key <= 0) {
					System.out.println(pw.peek() + " / " + key);
					pw.remove();
					pw.offer(0);
					return pw;
				}

				int tmp = pw.poll() - key;
				pw.offer(tmp);

//				System.out.println("key값 : " + key);
//				System.out.println(pw.toString());

				key++;
			}
		}

//		return pw;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input));

		StringBuilder sb = new StringBuilder();

//		int index = 1;

		for (int i = 1; i <= 10; i++) {

			int tc = Integer.parseInt(in.readLine());

			sb.append("#").append(tc).append(" ");

			// System.out.println(tc);

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			int[] arr = new int[8];
			for (int j = 0; j < 8; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			Queue<Integer> pw = completedPW(arr);

			for (int j = 0; j < 8; j++) {
				sb.append(pw.poll()).append(" ");
			}

			sb.append("\n");

		}
		/*
		 * while (true) {
		 * 
		 * if (in.readLine() == null) break;
		 * 
		 * sb.append("#").append(" ");
		 * 
		 * int[] arr = new int[8]; for (int i = 0; i < 8; i++) { StringTokenizer st =
		 * new StringTokenizer(in.readLine(), " "); arr[i] =
		 * Integer.parseInt(st.nextToken()); }
		 * 
		 * Queue<Integer> pw = completedPW(arr);
		 * 
		 * for (int i = 0; i < 8; i++) { sb.append(pw.poll()).append(" "); }
		 * 
		 * sb.append("\n"); index++; }
		 */
		System.out.println(sb.toString());
	}

}
