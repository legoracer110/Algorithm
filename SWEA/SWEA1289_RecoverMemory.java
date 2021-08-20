package com.ssafy.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class SWEA1289_RecoverMemory {

	static String input = "10\r\n" + "01010101010101010101010101010101010101010101010101\r\n" + "01\r\n"
			+ "1000110010011111010110000100100000000001001\r\n" + "10011010001110111010111010001100101101\r\n"
			+ "00110101100001010000110010111\r\n" + "101111110101010100111100101111001\r\n" + "01110011110001110\r\n"
			+ "1010101001010101010101010100111111\r\n" + "01010100010100101100111010100010111111011001011000\r\n"
			+ "1111100101101110000";

	public static int solution(String str) {
		int answer = 0;

		int index = str.length() - 1;
		// System.out.println(str.charAt(index));
		for (int i = index; i > 0; i--) {
			if (str.charAt(i) != str.charAt(i - 1))
				answer++;
		}

		if (str.charAt(0) == '1')
			answer++;

		return answer;
	}

	public static void main(String[] args) {

//		Solution1 s = new Solution1();
//		try {
//			System.setIn(new FileInputStream(new File("input.txt")));
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input));

		int n = 0;
		try {
			n = Integer.parseInt(in.readLine());
			int index = 1;
			while (index - 1 < n) {
				String value = in.readLine();
				System.out.println("#" + index + " " + solution(value));
				index++;

			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * Solution1 s = new Solution1(); Scanner sc = new Scanner(System.in); int n =
		 * sc.nextInt(); int index = 0;
		 * 
		 * while(index<n) { String str = sc.next();
		 * 
		 * System.out.println("#1"+s.solution(str));
		 * 
		 * index++; }
		 */

	}

}
