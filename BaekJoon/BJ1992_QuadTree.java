package hwalgo12_서울_07반_문성환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ1992_QuadTree {

	static int N;
	static char[][] pic;

	static StringBuilder sb;

	static String input1 = "8\n" + "00000000\n" + "00000000\n" + "00001111\n" + "00001111\n" + "00011111\n"
			+ "00111111\n" + "00111111\n" + "00111111";

	static String input2 = "8\r\n" + "11110000\n" + "11110000\r\n" + "00011100\r\n" + "00011100\r\n" + "11110000\r\n"
			+ "11110000\r\n" + "11110011\r\n" + "11110011";

	static void solution(int size, int x, int y) {

//		sb.append("(");

		boolean check = false;
		char tmp = pic[x][y];

		if (size == 1) {
			sb.append(tmp);
			return;
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (pic[x + i][y + j] != tmp) {
					check = true;
					break;
				}
			}
			if (check)
				break;
		}

		if (!check) {
			sb.append(tmp);
		} else {
			sb.append("(");
			solution(size / 2, x, y); // 0
			solution(size / 2, x, y + size / 2);
			solution(size / 2, x + size / 2, y);
			solution(size / 2, x + size / 2, y + size / 2);
			sb.append(")");
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// in = new BufferedReader(new StringReader(input1)); // (0(0011)(0(0111)01)1)
		in = new BufferedReader(new StringReader(input2)); // ((110(0101))(0010)1(0001))

		N = Integer.parseInt(in.readLine());

		pic = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < N; j++) {
				pic[i][j] = (str.charAt(j));
//				System.out.print(pic[i][j] + " ");
			}
//			System.out.println();
		}

		sb = new StringBuilder();

		solution(N, 0, 0);

		System.out.println(sb.toString());
	}

}
